package edu.neu.ccs.cs5010.assignment7.concurrent;


import static edu.neu.ccs.cs5010.assignment7.concurrent.ConcurrentController.MAX_THREAD;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ConcurrentFileReader {

  public static final Integer LINES_IN_BATCH = 10000;
  public static final int waitTime = 100;
  public static final Integer ZERO = 0;
  private BufferedReader bufferedReader;
  private String part;
  private List<Future> futures;
  private boolean latency;
  private ConcurrentOutputObject corpusThroughput = new ConcurrentOutputObject();
  private ConcurrentOutputObject corpusLatency = new ConcurrentOutputObject();

  public ConcurrentFileReader(String part, boolean latency) {
    this.latency = latency;
    this.part = part;
  }

  public ConcurrentOutputObject getCorpusThroughput() {
    return corpusThroughput;
  }

  public ConcurrentOutputObject getCorpusLatency() {
    return corpusLatency;
  }

  public void readMap()
      throws ExecutionException, IOException, InterruptedException {
    mergeMap(readFile());
  }

  /**
   * Merge throughput map.
   * @param futures list of future.
   * @throws ExecutionException throws ExecutionException when necessary.
   */
  public void mergeMap(List<Future> futures)
      throws ExecutionException {

    try {
      for (Future<ConcurrentMap<Integer, ConcurrentNavigableMap>> f : futures) {
        // Aggregate
        ConcurrentNavigableMap<Long, ArrayList<Long>> mapThroughput = f.get().get(0);
        this.corpusThroughput.addThroughputPartition(mapThroughput);
        if (this.latency) {
          ConcurrentNavigableMap<Long, ArrayList<Long>> mapLatency = f.get().get(1);
          this.corpusLatency.addLatencyPartition(mapLatency);
        }
      }
    } catch (InterruptedException ex) {
      Thread.currentThread().interrupt();
    }
  }

  /**
   * Read file to throughput.
   * @return list of future.
   * @throws IOException throws IOException when necessary.
   */
  public List<Future> readFile()
      throws IOException {
    ExecutorService executorService = Executors.newFixedThreadPool(MAX_THREAD);
    futures = new ArrayList<>();
    try {

      ConcurrentBroker broker = new ConcurrentBroker();
      bufferedReader = new BufferedReader(
          new InputStreamReader(new FileInputStream(this.part), "UTF-8"));
      String line;
      List<String> lines = new ArrayList<>();
      int lineCount = ZERO;
      while ((line = bufferedReader.readLine()) != null) {
        lineCount++;
        if (lineCount % LINES_IN_BATCH != ZERO) {
          lines.add(line);
        } else {

          if (lines.size() != ZERO) {
            executorService.submit(
                new ConcurrentProducer(lines, broker));
            Future consumerFuture
                = executorService.submit(
                new ConcurrentConsumer(broker, this.latency));
            futures.add(consumerFuture);
          }
          lines = new ArrayList<>();
          lines.add(line);
        }
      }
      if (lines.size() != ZERO) {
        executorService.submit(
            new ConcurrentProducer(lines, broker));
        Future consumerFuture
            = executorService.submit(
            new ConcurrentConsumer(broker, this.latency));
        futures.add(consumerFuture);
      }
      bufferedReader.close();
      executorService.shutdown();

    } catch (FileNotFoundException e) {
      e.printStackTrace();
      Thread.currentThread().interrupt();
    }
    return futures;
  }
}

