package edu.neu.ccs.cs5010.assignment6.concurrent;

import edu.neu.ccs.cs5010.assignment6.sequential.javautil.LineParserUtil;

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
  public static final Integer INDEX_OF_COUNT = 0;

  /**
   * the index of mean latency in the arrayList.
   */
  public static final Integer INDEX_OF_MEAN = 1;

  public static final Integer VALUE_ARRAY_SIZE = 2;
  public static final Integer MILL_SEC_TO_SECOND = 1000;
  private LineParserUtil lpu;
  private Long[] extractedDataList;
  private Long currValue;
  private Long currKey;
  private List<Long> latencyList;
  private ConcurrentNavigableMap<Long, ArrayList<Long>> dataMap = new ConcurrentSkipListMap<>();

  /**
   * Get the ConcurrentNavigableMap.
   *
   * @return ConcurrentNavigableMap.
   */
  public ConcurrentNavigableMap<Long, ArrayList<Long>> getDataMap() {
    return dataMap;
  }

  /**
   * Process data method. Given the input file, do calculations and return an outputObject.
   *
   * @param newDataList the ArrayList of String as loaded from the input file
   * @return the ConcurrentNavigableMap
   * @throws Exception the exception
   */
  public ConcurrentNavigableMap<Long, ArrayList<Long>> buildMap(List<String> newDataList)
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
      currKey = extractedDataList[INDEX_OF_COUNT] / MILL_SEC_TO_SECOND;
      currValue = extractedDataList[INDEX_OF_MEAN];

      //retrieve the Map from the MapProcessor and add entries into it.
      //first check whether this map contains the second as key
      if (!dataMap.containsKey(currKey)) {
        //if the map doesn't contain current "second"
        //for the value of this entry, list of latency.
        latencyList = new ArrayList<Long>();
        latencyList.add(currValue);
        dataMap.put(currKey, (ArrayList<Long>) latencyList);
        //else the Map already contains the key for this "second"
      } else {
        //append currValue to this map if it contains currKey
        dataMap.get(currKey).add(currValue);
      }
    }
    return dataMap;
  }
}