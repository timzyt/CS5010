package edu.neu.ccs.cs5010.assignment6.concurrent;

import edu.neu.ccs.cs5010.assignment6.sequential.javautil.CommandLineProcessor;

public class SystemService {

  /**
   * Run the System.
   * @param args args read from commandLine.
   * @throws Exception throws Exception when necessary.
   */
  public static void main(String[] args)
      throws Exception {
    CommandLineProcessor commandLineProcessor = new CommandLineProcessor(args);
    commandLineProcessor.commandlineProcess();

  }
}