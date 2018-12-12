package edu.neu.ccs.cs5010.assignment7.concurrent;

import static edu.neu.ccs.cs5010.assignment7.concurrent.ConcurrentFileReader.waitTime;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;

public class ConcurrentConsumer implements Callable {

  private ConcurrentBroker broker;
  private ConcurrentNavigableMap<Long, ArrayList<Long>> conMapThroughput;
  private ConcurrentNavigableMap<Long, Integer> conMapLatency;
  private ConcurrentMap<Integer, ConcurrentNavigableMap> conMap;
  private boolean latency;


  /**
   * Constructor of ConcurrentConsumer.
   * @param newBroker the broker.
   * @param latency the boolean type of latency.
   */
  public ConcurrentConsumer(ConcurrentBroker newBroker, boolean latency) {
    this.broker = newBroker;
    this.latency = latency;
    this.conMap = new ConcurrentHashMap<>();
  }

  @Override
  public ConcurrentMap<Integer, ConcurrentNavigableMap> call() throws Exception {
    try {
      List<String> lines = broker.get();
      if (lines == null) {
        Thread.sleep(waitTime);
      } else {
        ConcurrentMapBuilder conMapBuilder = new ConcurrentMapBuilder();
        conMapBuilder.buildThroughputMap(lines);
        conMapThroughput = conMapBuilder.getTimestampMap();
        conMap.putIfAbsent(0, conMapThroughput);
        if (latency) {
          conMapBuilder.buildLatencyMap(lines);
          conMapLatency = conMapBuilder.getLatencyMap();
          conMap.putIfAbsent(1, conMapLatency);
        }
      }
    } catch (InterruptedException ex) {
      ex.printStackTrace();
    }
    return conMap;
  }
}
