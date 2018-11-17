package edu.neu.ccs.cs5010.assignment6.concurrent;

import edu.neu.ccs.cs5010.assignment6.sequential.exception.IllegalThresholdException;

import edu.neu.ccs.cs5010.assignment6.sequential.pojo.GetPercentile;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * The type Concurrent output object.
 */
public class ConcurrentOutputObject {

  /**
   * the index of latency count in the arrayList.
   */
  public static final Integer INDEX_OF_COUNT = 0;

  /**
   * the index of mean latency in the arrayList.
   */
  public static final Integer INDEX_OF_MEAN = 1;

  public static final Integer FIFTH_PERCENTILE = 5;
  public static final Integer NINTYNINE_PERCENTILE = 9;

  //Key: second
  //Value: List of latencies
  private ConcurrentNavigableMap<Long, ArrayList<Long>> concurrentMap
      = new ConcurrentSkipListMap<>();

  //Key: second
  //Value: List of #latencies and mean latency, only two values.
  private TreeMap<Long, ArrayList<Long>> result = new TreeMap<Long, ArrayList<Long>>();

  private Map<Long, ArrayList<Long>> thresholdResult = new TreeMap<>();

  private Long maxSec = Long.MIN_VALUE;
  private Long minSec = Long.MAX_VALUE;
  //mark the key of the start of peak phase, inclusive
  private Long peakStartKey;
  //mark the index of the end of peak phase, exclusive
  private Long peakEndKey;

  private Long thresholdThroughputSum = 0L;
  private Long thresholdLatencySum = 0L;
  private Long thresholdMeanThroughput = 0L;
  private Long thresholdMeanLatency = 0L;
  private Long thresholdPeakThroughput = Long.MIN_VALUE;
  private Long fifthPctThroughput;
  private Long nintyniePctLatency;

  private Long totalNumLatency = 0L;
  private Long totalSumLatency = 0L;
  private Long meanLatency = 0L;
  private int percentile = 99;
  private Long percentileResult;

  /**
   * Gets concurrent map.
   *
   * @return the concurrent map
   */
  public ConcurrentNavigableMap<Long, ArrayList<Long>> getConcurrentMap() {
    return concurrentMap;
  }

  /**
   * Gets result.
   *
   * @return the result
   */
  public TreeMap<Long, ArrayList<Long>> getResult() {
    return result;
  }

  /**
   * Gets threshold result.
   *
   * @param threshold the threshold
   * @return the threshold result
   * @throws Exception IllegalThresholdException
   */
  public Map<Long, ArrayList<Long>> getThresholdResult(Long threshold) throws Exception {
    Iterator<Map.Entry<Long, ArrayList<Long>>> setIt = result.entrySet().iterator();
    while (setIt.hasNext()) {
      Map.Entry<Long, ArrayList<Long>> pair = setIt.next();
      ArrayList<Long> currValue = pair.getValue();
      if (currValue.get(INDEX_OF_COUNT) >= threshold) {
        peakStartKey = pair.getKey();
        break;
      }
    }
    if (peakStartKey == null) {
      System.out.println("peakStartKey is null.");
      throw new IllegalThresholdException("Provided threshold is too high.");
    }

    Iterator<Map.Entry<Long, ArrayList<Long>>> setIt2 = result.descendingMap().entrySet()
        .iterator();
    while (setIt2.hasNext()) {
      Map.Entry<Long, ArrayList<Long>> pair = setIt2.next();
      ArrayList<Long> currValue = pair.getValue();
      if (currValue.get(INDEX_OF_COUNT) >= threshold) {
        peakEndKey = result.lowerKey(pair.getKey());
        break;
      }
    }
    //    for (Long key : result.descendingKeySet()) {
    //      if (result.get(key).get(TIMESTAMP_COL) >= threshold) {
    //        peakEndKey = result.lowerKey(key);
    //        break;
    //      }
    //    }
    Map<Long, ArrayList<Long>> subResult = result.subMap(peakStartKey, peakEndKey);
    this.thresholdResult = subResult;
    return thresholdResult;
  }


  /**
   * Add.
   *
   * @param partition the partition
   */
  public void add(ConcurrentNavigableMap partition) {
    Iterator<Long> iter = partition.keySet().iterator();
    while (iter.hasNext()) {
      Long key = iter.next();
      ArrayList<Long> value = (ArrayList<Long>) partition.get(key);
      if (this.concurrentMap.containsKey(key)) {
        this.concurrentMap.get(key).addAll(value);
      } else {
        this.concurrentMap.put(key, value);
      }
    }
  }

  /**
   * Process threshold result.
   *
   * @param thresholdResult the threshold result
   */
  public void processThresholdResult(Map<Long, ArrayList<Long>> thresholdResult) {
    TreeMap<Long, ArrayList<Long>> copyMap = new TreeMap<>(thresholdResult);
    GetPercentile getThroughputPct = new GetPercentile((long) copyMap.size(), FIFTH_PERCENTILE);
    GetPercentile getLatencyPct = new GetPercentile((long) copyMap.size(), NINTYNINE_PERCENTILE);
    Iterator<Map.Entry<Long, ArrayList<Long>>> setIt = copyMap.entrySet().iterator();
    while (setIt.hasNext()) {
      Map.Entry<Long, ArrayList<Long>> pair = setIt.next();
      ArrayList<Long> value = pair.getValue();
      Long currThroughput = value.get(INDEX_OF_COUNT);
      Long currLatency = value.get(INDEX_OF_MEAN);
      thresholdThroughputSum += currThroughput;
      thresholdLatencySum += currLatency;
      thresholdPeakThroughput = Math.max(thresholdPeakThroughput, currThroughput);
      getThroughputPct.add(currThroughput);
      getLatencyPct.add(currThroughput);
    }
    thresholdMeanThroughput = thresholdThroughputSum / this.thresholdResult.size();
    thresholdMeanLatency = thresholdLatencySum / this.thresholdResult.size();
    fifthPctThroughput = getThroughputPct.getPercentile();
    nintyniePctLatency = getLatencyPct.getPercentile();
  }


  /**
   * Process all.
   */
  public void processAll() {

    //this.concurrentMap = this.concurrentMap.descendingMap();
    //calculate percentile
    Long mapSize = Long.valueOf(concurrentMap.size());
    //construct the percentile calculation object based on the bucket results
    GetPercentile getPct = new GetPercentile(mapSize, percentile);

    Iterator<Map.Entry<Long, ArrayList<Long>>> setIt = this.concurrentMap.entrySet().iterator();
    while (setIt.hasNext()) {
      Map.Entry<Long, ArrayList<Long>> pair = setIt.next();
      Long key = pair.getKey();
      ArrayList<Long> value = pair.getValue();
      this.maxSec = Long.max(key, this.maxSec);
      this.minSec = Long.min(key, this.minSec);
      Long numLatency = Long.valueOf(value.size());
      Long sumLatency = 0L;
      for (Long d : value) {
        sumLatency += d;
        getPct.add(d);
      }
      ArrayList<Long> newValue = new ArrayList<Long>();
      newValue.add(numLatency);
      newValue.add(sumLatency / numLatency);
      this.totalNumLatency += numLatency;
      this.totalSumLatency += sumLatency;
      this.meanLatency = this.totalSumLatency / this.totalNumLatency;
      this.result.put(key, newValue);
    }

    this.percentileResult = getPct.getPercentile();
  }

  /**
   * Gets threshold mean throughput.
   *
   * @return the threshold mean throughput
   */
  public Long getThresholdMeanThroughput() {

    return thresholdMeanThroughput;
  }

  /**
   * Gets threshold mean latency.
   *
   * @return the threshold mean latency
   */
  public Long getThresholdMeanLatency() {
    return thresholdMeanLatency;
  }

  /**
   * Gets threshold peak throughput.
   *
   * @return the threshold peak throughput
   */
  public Long getThresholdPeakThroughput() {
    return thresholdPeakThroughput;
  }

  /**
   * Gets threshold 5th percentile throughput.
   *
   * @return the threshold 5th percentile throughput
   */
  public Long getFifthPctThroughput() {
    return fifthPctThroughput;
  }

  /**
   * Gets threshold 99th percentile latency.
   *
   * @return threshold 99th percentil latency
   */
  public Long getNintyniePctLatency() {
    return nintyniePctLatency;
  }

  /**
   * Gets the peak phase start key.
   *
   * @return Long value of the peakStartKey
   */
  public Long getPeakStartKey() {
    return peakStartKey;
  }

  /**
   * Gets the peak phase end key.
   *
   * @return Long value of the peakEndKey
   */
  public Long getPeakEndKey() {
    return peakEndKey;
  }

  /**
   * Gets test length.
   *
   * @return the test length
   */
  public Long getTestLength() {
    return this.maxSec - this.minSec;
  }

  public Long getMaxSec() {
    return this.maxSec;
  }

  public Long getMinSec() {
    return this.minSec;
  }

  public Long getTotalNumLatency() {
    return this.totalNumLatency;
  }

  public Long getTotalSumLatency() {
    return this.totalSumLatency;
  }

  public Long getMeanLatency() {
    return this.meanLatency;
  }

  /**
   * Gets percentile result.
   *
   * @return the percentile result
   */
  public Long getPercentileResult() {
    return percentileResult;
  }

  public Long getTotalThroughput() {
    return this.getTotalNumLatency() / this.getTestLength();
  }
}