package edu.neu.ccs.cs5010.assignment7.concurrent;

import edu.neu.ccs.cs5010.assignment7.javautil.PlotterUtil;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class ConcurrentFileWriter {

  public static final String THROUGHPUT_CHART_TITLE = "Throughput per Second Bucket";
  public static final String THROUGHPUT_X_TITLE = "Second Bucket";
  public static final String THROUGHPUT_Y_TITLE = "Total Throughput per Time Interval";
  public static final String LATENCY_CHART_TITLE = "Latency per Second Bucket";
  public static final String LATENCY_X_TITLE = "Latency";
  public static final String LATENCY_Y_TITLE = "Frequency";
  /**
   * the index of latency count in the arrayList.
   */
  public static final Integer INDEX_OF_COUNT = 0;
  /**
   * the index of mean latency in the arrayList.
   */
  public static final Integer INDEX_OF_MEAN = 1;
  /**
   * The directory name.
   */
  private String dirName;
  private int count;
  private ConcurrentOutputObject corpusThroughput = new ConcurrentOutputObject();


  /**
   * Constructor of ConcurrentFileWriter with parameters.
   *
   * @param dirName name of the directory.
   */
  public ConcurrentFileWriter(String dirName, int count) {
    this.dirName = dirName;
    this.count = count;
  }

  /**
   * Get corpusThroughput.
   * @return corpusThroughput
   */
  public ConcurrentOutputObject getCorpusThroughput() {
    return corpusThroughput;
  }

  /**
   * Write Files with provided parameters.
   * @param inputFileName the input file name
   * @param latency the boolean type of latency
   * @param threshold the value of threshold
   * @throws Exception throw exception
   */
  public void writeFile(String inputFileName, boolean latency, Long threshold)
      throws Exception {

    ConcurrentController concurrentController = new ConcurrentController(inputFileName, count);
    concurrentController.calculateCorpus(latency);
    this.corpusThroughput = concurrentController.getCorpusThroughput();
    this.corpusThroughput.analyzeAllData();
    TreeMap<Long, ArrayList<Long>> summaries = this.corpusThroughput.getResult();

    String outName = this.dirName + "/" + inputFileName.replace("raw", "_result");
    throughputWriter(summaries, corpusThroughput, outName);
    if (inputFileName.contains("POST")) {
      String chartName = outName.replace("_result.csv", "_throughput_plot");
      throughputPlotter(chartName, summaries);
    }
    if (latency) {
      ConcurrentOutputObject corpusLatency = concurrentController.getCorpusLatency();
      Map<Long, Integer> latencySummaries
          = new TreeMap<>(corpusLatency.getLatencyMap());
      String outNameLatency = this.dirName + "/" + inputFileName.replace("raw", "_Latency");
      latencyWriter(latencySummaries, outNameLatency);
      String chartNameLatency = outNameLatency.replace("_Latency.csv", "_Latency_plot");
      latencyPlotter(chartNameLatency, latencySummaries);
    }
    if (inputFileName.contains("POST") && threshold != 0L) {
      TreeMap<Long, ArrayList<Long>> thresholdSummaries
          = new TreeMap<>(this.corpusThroughput.findPeakPhase(threshold));
      this.corpusThroughput.analyzePeakPhase(thresholdSummaries);
      String outNameThreshold = this.dirName + "/" + inputFileName.replace("raw", "_Peak");
      throughputWriter(thresholdSummaries, corpusThroughput, outNameThreshold);
      String chartNameThreshold = outNameThreshold.replace("_Peak.csv", "_Peak_plot");
      throughputPlotter(chartNameThreshold, thresholdSummaries);
    }
  }

  /**
   * Merge Files.
   * @param inputFileNamePost input file name.
   * @param corpusGet ConcurrentOutputObject type
   * @param corpusPost ConcurrentOutputObject type
   */
  public void mergeFile(String inputFileNamePost, ConcurrentOutputObject corpusGet,
      ConcurrentOutputObject corpusPost) {

    corpusGet.analyzeAllData();
    TreeMap<Long, ArrayList<Long>> getMap = corpusGet.getResult();

    corpusPost.analyzeAllData();
    TreeMap<Long, ArrayList<Long>> postMap = corpusPost.getResult();

    String outName = this.dirName + "/" + inputFileNamePost.replace("raw", "_GET_Combined");

    Long peakThroughPut = Long.MIN_VALUE;
    Long totalThroughPut = corpusGet.getTotalThroughput() + corpusPost.getTotalThroughput();

    try {

      OutputStreamWriter outFile = new OutputStreamWriter(new FileOutputStream(outName),
          "UTF-8");
      String outLine = String.format("%-28s%-28s%-10s%n", "POST", "GET", "TOTAL");
      outFile.write(outLine);
      //use iterator to be more efficient
      Iterator<Map.Entry<Long, ArrayList<Long>>> setIt = postMap.entrySet().iterator();
      while (setIt.hasNext()) {
        Map.Entry<Long, ArrayList<Long>> pair = setIt.next();
        Long postKey = pair.getKey();
        ArrayList<Long> postValue = pair.getValue();
        if (getMap.keySet().contains(postKey)) {
          outLine = String.format("%-13d%-5d%-10d%-13d%-5d%-10d%-10d%n",
              postKey, postValue.get(INDEX_OF_COUNT), postValue.get(INDEX_OF_MEAN),
              postKey, getMap.get(postKey).get(INDEX_OF_COUNT), getMap.get(postKey).get(
                  INDEX_OF_MEAN),
              postMap.get(postKey).get(INDEX_OF_COUNT) + getMap.get(postKey).get(INDEX_OF_COUNT));
          //System.out.println(outLine);
          peakThroughPut = Math
              .max(peakThroughPut,
                  postValue.get(INDEX_OF_COUNT) + getMap.get(postKey).get(INDEX_OF_COUNT));
        } else {
          outLine = String.format("%-13d%-5d%-10d%-13s%-5s%-10s%-10d%n",
              postKey, postValue.get(INDEX_OF_COUNT), postValue.get(INDEX_OF_MEAN),
              "", "", "",
              postValue.get(INDEX_OF_COUNT));
          peakThroughPut = Math.max(peakThroughPut, postValue.get(INDEX_OF_COUNT));
        }
        outFile.write(outLine);
      }

      outFile.write("----------------------------------------------------------------------\n");
      outFile.write("Overall throughput for the test is: "
          + totalThroughPut + " requests per second\n");
      outFile.write("Peak throughput for the test is: " + peakThroughPut);

      outFile.flush();
      outFile.close();
    } catch (IOException ioe) {
      System.out.println("Something went wrong! : " + ioe.getMessage());
      ioe.printStackTrace();
    } finally {
      System.out.println("Job done.");
    }
  }

  /**
   * Define throughputWriter function.
   *
   * @param summaries input map
   * @param corpus concurrent output object
   * @param outName output file name
   */
  public void throughputWriter(Map<Long, ArrayList<Long>> summaries, ConcurrentOutputObject corpus,
      String outName) {
    try {
      OutputStreamWriter outputFile = new OutputStreamWriter(new FileOutputStream(outName),
          "UTF-8");
      String outLine = String
          .format("%-13s%-12s%-10s%n", "Timestamp/s", "Throughput", "Mean Latency/ms");
      outputFile.write(outLine);
      Iterator<Map.Entry<Long, ArrayList<Long>>> setIt = summaries.entrySet().iterator();
      while (setIt.hasNext()) {
        Map.Entry<Long, ArrayList<Long>> pair = setIt.next();
        Long key = pair.getKey();
        ArrayList<Long> value = pair.getValue();
        outLine = String
            .format("%-13d%-12d%-10d%n", key, value.get(INDEX_OF_COUNT), value.get(INDEX_OF_MEAN));
        outputFile.write(outLine);
      }
      outputFile.write("------------------------------\n");
      if (outName.contains("Peak")) {
        outputFile.write("Duration of the peak phase in seconds: "
            + (corpus.getPeakEndKey() - corpus.getPeakStartKey()) + "\n");
        outputFile.write("Mean Throughput: " + corpus.getThresholdMeanThroughput() + "\n");
        outputFile.write("Highest interval throughput: "
            + corpus.getThresholdPeakThroughput() + "\n");
        outputFile.write("5th Percentile throughput: " + corpus.getFifthPctThroughput() + "\n");
        outputFile.write("Mean Latency: " + corpus.getThresholdMeanLatency() + "\n");
        outputFile.write("99th Percentile latency: " + corpus.getNintyniePctLatency() + "\n");
      } else {
        outputFile.write("Test length: " + corpus.getTestLength() + "\n");
        outputFile.write("Mean latency: " + corpus.getMeanLatency() + "\n");
        outputFile.write("The 99th percentile latency: " + corpus.getPercentileResult() + "\n");
        outputFile
            .write(
                "Total Throughput: " + corpus.getTotalThroughput() + "\n");
      }
      outputFile.flush();
      outputFile.close();
    } catch (IOException ioe) {
      System.out.println("Something went wrong! : " + ioe.getMessage());
      ioe.printStackTrace();
    } finally {
      System.out.println("Job done.");
    }
  }

  /**
   * Define latencyWriter function.
   *
   * @param summaries input map
   * @param outName output file name
   */
  public void latencyWriter(Map<Long, Integer> summaries, String outName) {
    try {
      OutputStreamWriter outputFile = new OutputStreamWriter(new FileOutputStream(outName),
          "UTF-8");
      String outLine = String.format("%-13s%-10s%n", "Latency/ms", "Frequency");
      outputFile.write(outLine);
      Iterator<Map.Entry<Long, Integer>> setIt = summaries.entrySet().iterator();
      while (setIt.hasNext()) {
        Map.Entry<Long, Integer> pair = setIt.next();
        Long key = pair.getKey();
        Integer value = pair.getValue();
        outLine = String
            .format("%-13d%-10d%n", key, value);
        outputFile.write(outLine);
      }
      outputFile.flush();
      outputFile.close();
    } catch (IOException ioe) {
      System.out.println("Something went wrong! : " + ioe.getMessage());
      ioe.printStackTrace();
    } finally {
      System.out.println("Job done.");
    }
  }

  /**
   * Plot the throughput graph based on processed data.
   *
   * @param chartName output file name.
   * @param inputMap input map.
   */
  public void throughputPlotter(String chartName, Map<Long, ArrayList<Long>> inputMap)
      throws IOException {
    PlotterUtil ptu = new PlotterUtil();
    ptu.plotThroughput(chartName, inputMap, THROUGHPUT_CHART_TITLE, THROUGHPUT_X_TITLE,
        THROUGHPUT_Y_TITLE);
  }

  /**
   * Plot the latency graph based on processed data.
   *
   * @param chartName output file name.
   * @param inputMap input map.
   */
  public void latencyPlotter(String chartName, Map<Long, Integer> inputMap) throws IOException {
    PlotterUtil ptu = new PlotterUtil();
    ptu.plotLatency(chartName, inputMap, LATENCY_CHART_TITLE, LATENCY_X_TITLE, LATENCY_Y_TITLE);
  }

}
