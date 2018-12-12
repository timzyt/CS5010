package edu.neu.ccs.cs5010.assignment7.concurrent;

import edu.neu.ccs.cs5010.assignment7.javautil.CommandLineProcesserUtil;

public class SystemService {

  /**
   * Run the System.
   *
   * @param args args read from commandLine.
   * @throws Exception throws Exception when necessary.
   */
  public static void main(String[] args)
      throws Exception {
    CommandLineProcesserUtil commandLineProcesserUtil = new CommandLineProcesserUtil(args);
    commandLineProcesserUtil.commandlineProcess();

  }
}