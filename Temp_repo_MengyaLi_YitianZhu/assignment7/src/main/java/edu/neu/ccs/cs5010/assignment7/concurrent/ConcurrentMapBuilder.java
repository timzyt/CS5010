package edu.neu.ccs.cs5010.assignment7.concurrent;

import edu.neu.ccs.cs5010.assignment7.javautil.LineParserUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * The ConcurrentMapBuilder class.
 */
public class ConcurrentMapBuilder {

  /**
   * the index of latency count in the arrayList.
   */
  public static final Integer INDEX_OF_TIMESTAMP = 0;

  /**
   * the index of mean latency in the arrayList.
   */
  public static final Integer INDEX_OF_LATENCY = 1;

  public static final Integer VALUE_ARRAY_SIZE = 2;
  public static final Integer MILL_SEC_TO_SECOND = 1000;
  private LineParserUtil lpu;
  private Long[] extractedDataList;
  private Long currValue;
  private Long currKey;
  private List<Long> latencyList;
  private ConcurrentNavigableMap<Long, ArrayList<Long>> timestampMap
      = new ConcurrentSkipListMap<>();
  private ConcurrentNavigableMap<Long, Integer> latencyMap = new ConcurrentSkipListMap<>();

  /**
   * Get the timestamp map.
   *
   * @return ConcurrentNavigableMap.
   */
  public ConcurrentNavigableMap<Long, ArrayList<Long>> getTimestampMap() {
    return timestampMap;
  }

  /**
   * Get the latency map.
   *
   * @return ConcurrentNavigableMap.
   */
  public ConcurrentNavigableMap<Long, Integer> getLatencyMap() {
    return latencyMap;
  }

  /**
   * Process data method. Given the input list of Strings, aggregate the data by latency in
   * seconds.
   *
   * @param newDataList the ArrayList of String as loaded from the input file
   * @return the ConcurrentNavigableMap
   * @throws Exception the exception
   */
  public ConcurrentNavigableMap<Long, Integer> buildLatencyMap(List<String> newDataList)
      throws Exception {
    lpu = new LineParserUtil();
    //Iterate through the parsed data array
    for (int i = 0; i < newDataList.size(); i++) {
      extractedDataList = new Long[VALUE_ARRAY_SIZE];
      extractedDataList = lpu.parseLine(newDataList.get(i));
      currKey = extractedDataList[INDEX_OF_LATENCY];
      //The latencyMap has key of latency (in seconds).
      //and the value being the count of request with the same latency.
      if (!latencyMap.containsKey(currKey)) {
        latencyMap.put(currKey, 1);
      } else {
        latencyMap.put(currKey, latencyMap.get(currKey) + 1);
      }
    }
    return latencyMap;
  }

  /**
   * Process data method. Given the input list of Strings, aggregate the data by timestamp in
   * seconds.
   *
   * @param newDataList the ArrayList of String as loaded from the input file
   * @return the ConcurrentNavigableMap
   * @throws Exception the exception
   */
  public ConcurrentNavigableMap<Long, ArrayList<Long>> buildThroughputMap(List<String> newDataList)
      throws Exception {
    lpu = new LineParserUtil();

    //Iterate through the parsed data array
    for (int i = 0; i < newDataList.size(); i++) {

      //instantiate new Long list to store the parsed and extract data.
      //each extractedDataList contains "startTime" and "latency".
      extractedDataList = new Long[VALUE_ARRAY_SIZE];

      //get value from parsed string list from input.
      extractedDataList = lpu.parseLine(newDataList.get(i));

      //calculate the key for this set of map entry
      //rounding the millisecond into second
      currKey = extractedDataList[INDEX_OF_TIMESTAMP] / MILL_SEC_TO_SECOND;
      currValue = extractedDataList[INDEX_OF_LATENCY];

      //retrieve the Map from the MapProcessor and addThroughputPartition entries into it.
      //first check whether this map contains the second as key
      if (!timestampMap.containsKey(currKey)) {
        //if the map doesn't contain current "second"
        //for the value of this entry, list of latency.
        latencyList = new ArrayList<>();
        latencyList.add(currValue);
        timestampMap.put(currKey, (ArrayList<Long>) latencyList);
        //else the Map already contains the key for this "second"
      } else {
        //append currValue to this map if it contains currKey
        timestampMap.get(currKey).add(currValue);
      }
    }
    return timestampMap;
  }

}