package edu.neu.ccs.cs5010.assignment7.sequential.pojo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * The MapBuilder class.
 */
public class MapBuilder {

  /**
   * the index of timestamp in the input arrayList.
   */
  public static final Integer TIMESTAMP_COL = 0;

  /**
   * the index of latency in the input arrayList.
   */
  public static final Integer LATENCY_COL = 1;

  /**
   * the index of latency count in the arrayList.
   */
  public static final Integer LAT_COUNT_COL = 0;

  /**
   * the index of mean latency in the arrayList.
   */
  public static final Integer MEAN_LAT_COL = 1;

  /**
   * The constant SEC_TO_MILISEC.
   */
  public static final Integer SEC_TO_MILISEC = 1000;

  /**
   * One Hundred.
   */
  public static final double HUNDRED = 100.00;

  /**
   * One.
   */
  public static final double ONE = 1.00;

  /**
   * The start time of the test.
   */
  private Long startTime = Long.MAX_VALUE;

  /**
   * The end time of the test.
   */
  private Long endTime = Long.MIN_VALUE;

  /**
   * The sum of all latency.
   */
  private Long latencySum = 0L;

  /**
   * The count of all latency.
   */
  private Long latencyCount = 0L;

  /**
   * The current count of latency in this second bucket.
   */
  private Long currCount;

  /**
   * The current mean of latency in this second bucket.
   */
  private Long currMeanLatency;

  /**
   * The updated count of request in this second bucket.
   */
  private Long newRequestCount;

  /**
   * The updated mean of latency in this second bucket.
   */
  private Long newMeanLatency;

  /**
   * The second bucket.
   */
  private Long secBucket;

  /**
   * The current mean of all latency in this second bucket.
   */

  /**
   * The List of all latency.
   */
  private List<Long> latencyList = new ArrayList<>();

  /**
   * The GetPercentile class.
   */
  private GetPercentile newGetPct;

  /**
   * The Data map.
   */
  private Map<Long, List<Long>> dataMap = new TreeMap<>();

  /**
   * Process data method. Given the input file, do calculations and return an outputObject.
   *
   * @param newLine a new parsed line read from the input file.
   */
  public void buildMapFromRaw(Long[] newLine) {
    secBucket = newLine[TIMESTAMP_COL] / SEC_TO_MILISEC;

    startTime = Math.min(startTime, newLine[TIMESTAMP_COL]);

    endTime = Math.max(endTime, newLine[TIMESTAMP_COL]);

    latencySum += newLine[LATENCY_COL];

    latencyCount++;

    latencyList.add(newLine[LATENCY_COL]);

    if (dataMap.containsKey(secBucket)) {
      currCount = dataMap.get(secBucket).get(LAT_COUNT_COL);
      currMeanLatency = dataMap.get(secBucket).get(MEAN_LAT_COL);
      newRequestCount = currCount + 1L;
      newMeanLatency = (currCount * currMeanLatency + newLine[LATENCY_COL]) / newRequestCount;

      List<Long> currList = new ArrayList<>();
      currList.add(newRequestCount);
      currList.add(newMeanLatency);
      dataMap.put(secBucket, currList);
    } else {
      List<Long> currList = new ArrayList<>();
      currList.add(1L);
      currList.add(newLine[LATENCY_COL]);
      dataMap.put(secBucket, currList);
    }
  }

  public Long getStartTime() {
    return startTime;
  }

  public Long getEndTime() {
    return endTime;
  }

  public Long getLatencySum() {
    return latencySum;
  }

  public Long getLatencyCount() {
    return latencyCount;
  }

  public List<Long> getLatencyList() {
    return latencyList;
  }

  /**
   * Gets percentile.
   *
   * @param percentile nth percentile
   * @return Long value of latency.
   */
  public Long getPercentile(Integer percentile) {
    Long mapSize = Long.valueOf((int) (this.latencyCount * (ONE - (percentile / HUNDRED))));
    newGetPct = new GetPercentile(mapSize, percentile);
    for (Long latency : this.latencyList) {
      newGetPct.add(latency);
    }
    return newGetPct.getPercentile();
  }


  /**
   * Gets data map.
   *
   * @return data map
   */
  public Map<Long, List<Long>> getDataMap() {
    return dataMap;
  }
}
