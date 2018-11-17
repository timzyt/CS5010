package edu.neu.ccs.cs5010.assignment6.concurrent;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ExecutionException;

public class ConcurrentFileWriter implements FileWriterInterface {

  /**
   * The directory name.
   */
  private String dirName;

  /**
   * the index of latency count in the arrayList.
   */
  public static final Integer INDEX_OF_COUNT = 0;

  /**
   * the index of mean latency in the arrayList.
   */
  public static final Integer INDEX_OF_MEAN = 1;

  /**
   * Constructor of ConcurrentFileWriter with parameters.
   *
   * @param dirName name of the directory.
   */
  public ConcurrentFileWriter(String dirName) {
    this.dirName = dirName;
  }

  /**
   * Write file.
   */
  public void writeFile(String inputFileName)
      throws InterruptedException, ExecutionException, IOException {

    ConcurrentProcess concurrentProcess = new ConcurrentProcess(inputFileName);
    ConcurrentOutputObject corpus = concurrentProcess.multiThreadProcess();
    corpus.processAll();
    TreeMap<Long, ArrayList<Long>> summaries = corpus.getResult();

    String outName = this.dirName + "/" + inputFileName.replace("raw", "_result");
    writer(summaries, corpus, outName);
  }


  /**
   * Write file for threshold result from POST.
   */
  public void writeFileThreshold(String inputFileName, Long threshold)
      throws Exception {

    ConcurrentProcess concurrentProcess = new ConcurrentProcess(inputFileName);
    ConcurrentOutputObject corpus = concurrentProcess.multiThreadProcess();
    corpus.processAll();
    TreeMap<Long, ArrayList<Long>> thresholdSummaries
        = new TreeMap<>(corpus.getThresholdResult(threshold));
    corpus.processThresholdResult(thresholdSummaries);
    String outName = this.dirName + "/" + inputFileName.replace("raw", "_ThresholdResult");
    writer(thresholdSummaries, corpus, outName);
  }

  @Override
  public void mergeFile(String inputFileNameGet, String inputFileNamePost)
      throws IOException, ExecutionException, InterruptedException {

    ConcurrentProcess concurrentProcessGet = new ConcurrentProcess(inputFileNameGet);
    ConcurrentOutputObject corpusGet = concurrentProcessGet.multiThreadProcess();
    corpusGet.processAll();
    TreeMap<Long, ArrayList<Long>> getMap = corpusGet.getResult();

    ConcurrentProcess concurrentProcessPost = new ConcurrentProcess(inputFileNamePost);
    ConcurrentOutputObject corpusPost = concurrentProcessPost.multiThreadProcess();
    corpusPost.processAll();
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

  @Override
  public void writer(TreeMap<Long, ArrayList<Long>> summaries, ConcurrentOutputObject corpus,
      String outName) {
    try {
      OutputStreamWriter outputFile = new OutputStreamWriter(new FileOutputStream(outName),
          "UTF-8");
      Iterator<Map.Entry<Long, ArrayList<Long>>> setIt = summaries.entrySet().iterator();
      while (setIt.hasNext()) {
        Map.Entry<Long, ArrayList<Long>> pair = setIt.next();
        Long key = pair.getKey();
        ArrayList<Long> value = pair.getValue();
        String outLine = String
            .format("%-13d%-5d%-10d%n", key, value.get(INDEX_OF_COUNT), value.get(INDEX_OF_MEAN));
        outputFile.write(outLine);
      }
      outputFile.write("------------------------------\n");
      if (outName.contains("ThresholdResult")) {
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
}
