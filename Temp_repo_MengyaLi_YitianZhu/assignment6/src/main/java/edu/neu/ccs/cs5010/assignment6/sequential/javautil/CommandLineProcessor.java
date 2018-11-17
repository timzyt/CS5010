package edu.neu.ccs.cs5010.assignment6.sequential.javautil;

import edu.neu.ccs.cs5010.assignment6.concurrent.ConcurrentFileWriter;
import edu.neu.ccs.cs5010.assignment6.sequential.pojo.FileWriter;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import java.util.Arrays;

public class CommandLineProcessor {

  public static final Integer SEC_TO_MILI_SEC = 1000;
  private String[] args;

  /**
   * Constructor of CommandLineProcessor with parameters.
   *
   * @param args input argument
   */
  public CommandLineProcessor(String[] args) {
    this.args = args.clone();
  }

  /**
   * Process the commandline args.
   *
   * @throws Exception exceptions.
   */
  public void commandlineProcess() throws Exception {
    final long start = System.currentTimeMillis();
    Options options = new Options();

    Option concurrent = new Option(null, "concurrent", false, "Concurrent or not");
    concurrent.setRequired(false);
    options.addOption(concurrent);

    Option inputFileGet = new Option(null, "inputFileGet", true, "The input fileName");
    inputFileGet.setRequired(false);
    options.addOption(inputFileGet);

    Option inputFilePost = new Option(null, "inputFilePost", true, "The input fileName");
    inputFilePost.setRequired(false);
    options.addOption(inputFilePost);

    Option outputsDir = new Option(null, "output-dir", true,
        "accept the name of a folder, all output is placed in this folder");
    outputsDir.setRequired(true);
    options.addOption(outputsDir);

    Option threshold = new Option(null, "threshold", true,
        "The threshold is a value that the user wants to use to identify the PEAK test load period,"
            + " when the client load is at its highest.");
    threshold.setRequired(false);
    options.addOption(threshold);

    Option combined = new Option(null, "combined", false,
        "combined POST file and GET file or not");
    combined.setRequired(false);
    options.addOption(combined);

    CommandLineParser parser = new DefaultParser();
    HelpFormatter formatter = new HelpFormatter();

    CommandLine cmd;

    System.out.println(Arrays.toString(this.args));

    try {
      cmd = parser.parse(options, this.args);

      String inputFileGetName = cmd.getOptionValue("inputFileGet");
      String inputFilePostName = cmd.getOptionValue("inputFilePost");
      String outputDir = cmd.getOptionValue("output-dir");
      String thresholdValue = cmd.getOptionValue("threshold");

      if (cmd.hasOption("combined")) {
        if ((!cmd.hasOption("inputFileGet") || !cmd.hasOption("inputFilePost"))) {
          String errorMsg = "Error: no inputFileGet or inputFilePost was given.";
          System.out.println(errorMsg);
          formatter.printHelp("utility-name", options);
          throw new Exception(errorMsg);
        } else {
          if (cmd.hasOption("concurrent")) {
            ConcurrentFileWriter conFileWriter = new ConcurrentFileWriter(outputDir);
            conFileWriter.mergeFile(inputFileGetName, inputFilePostName);
          } else {
            FileWriter fileWriter = new FileWriter();
            fileWriter.mergeFiles(inputFileGetName, inputFilePostName, outputDir);
          }
        }
      }
      if (cmd.hasOption("inputFileGet")) {
        if (cmd.hasOption("concurrent")) {
          ConcurrentFileWriter conFileWriter = new ConcurrentFileWriter(outputDir);
          conFileWriter.writeFile(inputFileGetName);
        } else {
          FileWriter fileWriter = new FileWriter();
          fileWriter.writeSingleFile(inputFileGetName, outputDir);
        }
      }
      if (cmd.hasOption("inputFilePost")) {
        if (cmd.hasOption("concurrent")) {
          ConcurrentFileWriter conFileWriter = new ConcurrentFileWriter(outputDir);
          conFileWriter.writeFile(inputFilePostName);
        } else {
          FileWriter fileWriter = new FileWriter();
          fileWriter.writeSingleFile(inputFilePostName, outputDir);
        }
      }
      if (cmd.hasOption("threshold")) {
        if (cmd.hasOption("concurrent")) {
          ConcurrentFileWriter conFileWriter = new ConcurrentFileWriter(outputDir);
          conFileWriter.writeFileThreshold(inputFilePostName, Long.valueOf(thresholdValue));
        } else {
          System.out.println("Sorry, this task cannot be done non-concurrently.");
        }
      }
    } catch (ParseException e) {
      System.out.println(e.getMessage());
      formatter.printHelp("utility-name", options);
      throw new Exception(e.getMessage());
    }

    final long end = System.currentTimeMillis();
    long durationInMillis = end - start;
    long second = durationInMillis / SEC_TO_MILI_SEC;
    System.out.println(second + " seconds");
  }
}