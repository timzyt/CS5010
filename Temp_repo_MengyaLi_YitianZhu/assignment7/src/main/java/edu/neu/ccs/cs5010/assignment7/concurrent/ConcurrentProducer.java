package edu.neu.ccs.cs5010.assignment7.concurrent;

import static edu.neu.ccs.cs5010.assignment7.concurrent.ConcurrentFileReader.waitTime;

import java.util.List;

public class ConcurrentProducer implements Runnable {

  private List<String> lines;
  private ConcurrentBroker broker;

  public ConcurrentProducer(List<String> lines, ConcurrentBroker newBroker) {
    this.lines = lines;
    this.broker = newBroker;
  }

  @Override
  public void run() {
    try {
      if (lines == null) {
        Thread.sleep(waitTime);
      } else {
        broker.put(lines);
      }
    } catch (InterruptedException ex) {
      ex.printStackTrace();
    }

  }
}