package edu.neu.ccs.cs5010.assignment7.concurrent;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class ConcurrentBroker {

  private int queueSize = 1000;

  public ArrayBlockingQueue<List<String>> queue = new ArrayBlockingQueue<>(queueSize);

  public void put(List<String> lines) throws InterruptedException {
    this.queue.put(lines);
  }

  public List<String> get() throws InterruptedException {
    return this.queue.poll(1, TimeUnit.SECONDS);
  }
}
