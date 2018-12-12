package edu.neu.ccs.cs5010.assignment7.sequential.pojo;

import edu.neu.ccs.cs5010.assignment7.javautil.BufferedReaderUtil;
import edu.neu.ccs.cs5010.assignment7.sequential.exception.NullArgumentException;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class FileWriter {

  public static final String MAIN_DIR = "user.dir";
  /**
   * The constant SEC_TO_MILISEC.
   */
  public static final Integer SEC_TO_MILISEC = 1000;
  /**
   * The constant 99.
   */
  public static final Integer NINTYNIE = 99;
  /**
   * the index of latency count in the arrayList.
   */
  public static final Integer INDEX_OF_COUNT = 0;
  /**
   * the index of mean latency in the arrayList.
   */
  public static final Integer INDEX_OF_MEAN = 1;
  private final long startTime = System.nanoTime();
  private String outName;
  private String outLine;
  private Map<Long, List<Long>> dataMapGet;
  private Map<Long, List<Long>> dataMapPost;
  private Long postTestLength;
  private Long getTestLength;

  private Long peakThroughput;
  private Long totalThroughput;

  private BufferedReaderUtil bru = new BufferedReaderUtil();
  private MapBuilder mapBdr;

  /**
   * Write single file method. Process a single input file per the requirement of the assignment,
   * and write it into the output directory.
   *
   * @param inName input file name
   * @param outputDir output directory
   * @throws Exception Exceptions
   */
  public void writeSingleFile(String inName, String outputDir) throws Exception {
    System.getProperty(MAIN_DIR);
    mapBdr = bru.read(inName);
    if (mapBdr.getDataMap().size() == 0) {
      throw new NullArgumentException("dataMap is empty.");
    }

    Map<Long, List<Long>> resultMap = new TreeMap<>(mapBdr.getDataMap());
    outName = inName.replace("raw", "result");

    try {
      BufferedWriter outFile = new BufferedWriter(
          new OutputStreamWriter(
              new FileOutputStream(outputDir + File.separator + outName), "UTF8"));
      //use iterator to be more efficient

      Iterator<Map.Entry<Long, List<Long>>> setIt = resultMap.entrySet().iterator();
      while (setIt.hasNext()) {
        Map.Entry<Long, List<Long>> pair = setIt.next();
        Long key = pair.getKey();
        List<Long> value = pair.getValue();
        outLine = String.format("%-13d%-5d%-10d%n",
            key, value.get(INDEX_OF_COUNT), value.get(INDEX_OF_MEAN));
        outFile.write(outLine);
      }
      //
      //      for (Long key : resultMap.keySet()) {
      //        outLine = String.format("%-13d%-5d%-10d%n",
      //            key, resultMap.get(key)[0], resultMap.get(key)[1]);
      //        outFile.write(outLine);
      //      }
      outFile.write("------------------------------\n");
      outFile.write(
          "Test length: " + (mapBdr.getEndTime() - mapBdr.getStartTime()) / SEC_TO_MILISEC + "\n");
      outFile.write("Mean latency: " + mapBdr.getLatencySum() / mapBdr.getLatencyCount() + "\n");
      outFile.write("The 99th percentile latency: " + mapBdr.getPercentile(NINTYNIE) + "\n");
      outFile
          .write("Total Throughput: "
              + mapBdr.getLatencySum() / ((mapBdr.getEndTime() - mapBdr.getStartTime())
              / SEC_TO_MILISEC) + "\n");
      outFile.flush();
      outFile.close();
    } catch (IOException ioe) {
      System.out.println("Something went wrong! : " + ioe.getMessage());
      ioe.printStackTrace();
    } finally {
      System.out.println((System.nanoTime() - startTime) / 1000000 + "ms");
      System.out.println("Job done.");
    }

  }

  /**
   * Merge two written files into one.
   *
   * @param inGetFileName input file name, GET type of data
   * @param inPostFileName input file name, POST type of data
   * @param outputDir output directory.
   * @throws Exception Exception
   */
  public void mergeFiles(String inGetFileName, String inPostFileName, String outputDir)
      throws Exception {
    //    System.getProperty(MAIN_DIR);
    String outName = inPostFileName.replace("raw", "_GET_Combined");
    MapBuilder mapBdrGet = bru.read(inGetFileName);
    MapBuilder mapBdrPost = bru.read(inPostFileName);

    dataMapGet = new TreeMap<>(mapBdrGet.getDataMap());
    dataMapPost = new TreeMap<>(mapBdrPost.getDataMap());
    if (dataMapGet.size() == 0 || dataMapPost.size() == 0) {
      throw new NullArgumentException("dataMap is empty.");
    }

    getTestLength = (mapBdrGet.getEndTime() - mapBdrGet.getStartTime()) / SEC_TO_MILISEC;
    postTestLength = (mapBdrPost.getEndTime() - mapBdrPost.getStartTime()) / SEC_TO_MILISEC;

    //instantiate peakThroughput
    peakThroughput = Long.MIN_VALUE;
    totalThroughput = (mapBdrPost.getLatencyCount() / getTestLength)
        + (mapBdrGet.getLatencyCount() / postTestLength);

    try {

      BufferedWriter outFile = new BufferedWriter(
          new OutputStreamWriter(
              new FileOutputStream(outputDir + File.separator + outName), "UTF8"));
      outLine = String.format("%-28s%-28s%-10s%n", "POST", "GET", "TOTAL");
      outFile.write(outLine);
      //use iterator to be more efficient
      Iterator<Map.Entry<Long, List<Long>>> setIt = dataMapPost.entrySet().iterator();
      while (setIt.hasNext()) {
        Map.Entry<Long, List<Long>> pair = setIt.next();
        Long postKey = pair.getKey();
        List<Long> postValue = pair.getValue();
        if (dataMapGet.keySet().contains(postKey)) {
          outLine = String.format("%-13d%-5d%-10d%-13d%-5d%-10d%-10d%n",
              postKey, postValue.get(INDEX_OF_COUNT), postValue.get(INDEX_OF_MEAN),
              postKey, dataMapGet.get(postKey).get(INDEX_OF_COUNT),
              dataMapGet.get(postKey).get(INDEX_OF_MEAN),
              dataMapPost.get(postKey).get(INDEX_OF_COUNT) + dataMapGet.get(postKey)
                  .get(INDEX_OF_COUNT));
          //System.out.println(outLine);
          peakThroughput = Math
              .max(peakThroughput,
                  postValue.get(INDEX_OF_COUNT) + dataMapGet.get(postKey).get(INDEX_OF_COUNT));
        } else {
          outLine = String.format("%-13d%-5d%-10d%-13s%-5s%-10s%-10d%n",
              postKey, postValue.get(INDEX_OF_COUNT), postValue.get(INDEX_OF_MEAN),
              "", "", "",
              postValue.get(INDEX_OF_COUNT));
          peakThroughput = Math.max(peakThroughput, postValue.get(INDEX_OF_COUNT));
        }
        outFile.write(outLine);
      }

      outFile.write("----------------------------------------------------------------------\n");
      outFile.write("Overall throughput for the test is: "
          + totalThroughput + " requests per second\n");
      outFile.write("Peak throughput for the test is: " + peakThroughput);

      outFile.flush();
      outFile.close();
    } catch (IOException ioe) {
      System.out.println("Something went wrong! : " + ioe.getMessage());
      ioe.printStackTrace();
    } finally {
      System.out.println((System.nanoTime() - startTime) / 1000000 + "ms");
      System.out.println("Job done.");
    }
  }
}
