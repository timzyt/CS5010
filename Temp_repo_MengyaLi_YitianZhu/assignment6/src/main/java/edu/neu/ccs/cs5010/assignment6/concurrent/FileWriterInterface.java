package edu.neu.ccs.cs5010.assignment6.concurrent;

import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.concurrent.ExecutionException;

public interface FileWriterInterface {

  /**
   * Define writeFile function.
   *
   * @param inputFileName input file name
   * @throws IOException IOException
   * @throws InterruptedException InterruptedException
   * @throws ExecutionException ExecutionException
   */
  void writeFile(String inputFileName) throws IOException, InterruptedException, ExecutionException;

  /**
   * Define writeFileThreshold function.
   *
   * @param inputFileName input file name
   * @param threshold threshold
   * @throws Exception Exception
   */
  void writeFileThreshold(String inputFileName, Long threshold) throws Exception;

  /**
   * Define mergeFile function.
   *
   * @param inputFileName1 input file name 2
   * @param inputFileName2 input file name 2
   * @throws IOException IOException
   * @throws InterruptedException InterruptedException
   * @throws ExecutionException ExecutionException
   *
   */
  void mergeFile(String inputFileName1, String inputFileName2)
      throws IOException, ExecutionException, InterruptedException;

  /**
   * Define writer function.
   *
   * @param inputMap input map
   * @param corpus concurrent output object
   * @param outName output file name
   */
  void writer(TreeMap<Long, ArrayList<Long>> inputMap, ConcurrentOutputObject corpus,
      String outName);

}