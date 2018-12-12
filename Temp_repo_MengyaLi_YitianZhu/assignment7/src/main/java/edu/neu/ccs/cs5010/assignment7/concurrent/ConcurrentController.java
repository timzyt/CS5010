package edu.neu.ccs.cs5010.assignment7.concurrent;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * The multiTread process class.
 */
public class ConcurrentController {

  public static final Integer MAX_THREAD = 10;
  public static final Integer ONE = 1;

  private String inputFileName;
  private int count;
  private ConcurrentOutputObject corpusThroughput = new ConcurrentOutputObject();
  private ConcurrentOutputObject corpusLatency = new ConcurrentOutputObject();

  public ConcurrentController(String inputFileName, int count) {
    this.inputFileName = inputFileName;
    this.count = count;
  }

  public ConcurrentOutputObject getCorpusThroughput() {
    return corpusThroughput;
  }

  public ConcurrentOutputObject getCorpusLatency() {
    return corpusLatency;
  }

  /**
   * Calculate Corpus.
   * @param latency boolean type
   * @throws IOException throws IOException when necessary.
   * @throws ExecutionException throws ExecutionException when necessary.
   * @throws InterruptedException throws InterruptedException when necessary.
   */
  public void calculateCorpus(boolean latency)
      throws IOException, ExecutionException, InterruptedException {
    List<String> newParts = multiThreadProcess();
    for (String part : newParts) {
      ConcurrentFileReader cfr = new ConcurrentFileReader(part, latency);
      cfr.readMap();
      this.corpusThroughput.addThroughputPartition(cfr.getCorpusThroughput().getThroughputMap());
      if (latency) {
        this.corpusLatency.addLatencyPartition(cfr.getCorpusLatency().getLatencyMap());
      }
    }
  }


  /**
   * The main class to split the input file into N parts. Then process each part using
   * Producer-Consumer pattern.
   *
   * @return the ConcurrentOutputObject corpus.
   * @throws IOException throws IOException when necessary.
   */
  public List<String> multiThreadProcess()
      throws IOException {
    List<String> parts = new ArrayList<>();
    try {

      FileSplit fileSplit = new FileSplit();

      if (this.count == ONE) {
        parts.add(this.inputFileName);
      } else {
        parts = fileSplit.splitByCount(inputFileName, this.count);
      }

    } catch (InterruptedException ex) {
      Thread.currentThread().interrupt();
    } catch (FileNotFoundException e) {
      e.printStackTrace();

    }
    return parts;
  }
}