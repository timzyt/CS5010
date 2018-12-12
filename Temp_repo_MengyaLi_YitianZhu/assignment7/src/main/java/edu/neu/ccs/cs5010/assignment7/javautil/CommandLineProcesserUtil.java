package edu.neu.ccs.cs5010.assignment7.javautil;

import edu.neu.ccs.cs5010.assignment7.concurrent.ConcurrentFileWriter;
import edu.neu.ccs.cs5010.assignment7.concurrent.ConcurrentOutputObject;
import edu.neu.ccs.cs5010.assignment7.sequential.pojo.FileWriter;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import java.util.Arrays;

public class CommandLineProcesserUtil {

  private String[] args;

  /**
   * Constructor of CommandLineProcesserUtil with parameters.
   *
   * @param args input argument
   */
  public CommandLineProcesserUtil(String[] args) {
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

    Option latency = new Option(null, "latency", false,
        "analyze input file to calculate the frequency of requests with the same latency");
    latency.setRequired(false);
    options.addOption(latency);

    Option splitNumber = new Option(null, "splitNumber", true,
        "the number of file segments to process");
    splitNumber.setRequired(false);
    options.addOption(splitNumber);

    CommandLineParser parser = new DefaultParser();
    HelpFormatter formatter = new HelpFormatter();

    CommandLine cmd;

    System.out.println(Arrays.toString(this.args));

    try {
      cmd = parser.parse(options, this.args);

      String outputDir = cmd.getOptionValue("output-dir");
      boolean latencyFlag = false;
      Long thresholdValueFlag = 0L;

      if (!cmd.hasOption("inputFileGet") && !cmd.hasOption("inputFilePost")) {
        String errorMsg = "Error: no input file was given.";
        System.out.println(errorMsg);
        formatter.printHelp("utility-name", options);
        throw new Exception(errorMsg);
      } else {
        String inputFileGetName = cmd.getOptionValue("inputFileGet");
        String inputFilePostName = cmd.getOptionValue("inputFilePost");

        String thresholdValue = cmd.getOptionValue("threshold");

        if (cmd.hasOption("concurrent")) {
          if (cmd.hasOption("splitNumber")) {
            String splitValue = cmd.getOptionValue("splitNumber");
            int count = Integer.parseInt(splitValue);
            ConcurrentFileWriter conFileWriter = new ConcurrentFileWriter(outputDir, count);
            ConcurrentOutputObject corpusGet = new ConcurrentOutputObject();
            ConcurrentOutputObject corpusPost = new ConcurrentOutputObject();
            if (cmd.hasOption("inputFileGet")) {
              //conFileWriter.writeFileThroughput(inputFileGetName);
              if (cmd.hasOption("latency")) {
                //conFileWriter.writeFileLatency(inputFileGetName);
                latencyFlag = true;
              }
              if (cmd.hasOption("threshold")) {
                //conFileWriter.writeFilePeakPhase(inputFilePostName, Long.valueOf(thresholdValue));
                thresholdValueFlag = Long.valueOf(thresholdValue);
              }
              conFileWriter.writeFile(inputFileGetName, latencyFlag, thresholdValueFlag);
              corpusGet = conFileWriter.getCorpusThroughput();
            }
            if (cmd.hasOption("inputFilePost")) {
              //conFileWriter.writeFileThroughput(inputFilePostName);
              if (cmd.hasOption("latency")) {
                //conFileWriter.writeFileLatency(inputFilePostName);
                latencyFlag = true;
              }
              if (cmd.hasOption("threshold")) {
                //conFileWriter.writeFilePeakPhase(inputFilePostName, Long.valueOf(thresholdValue));
                thresholdValueFlag = Long.valueOf(thresholdValue);
              }
              conFileWriter.writeFile(inputFilePostName, latencyFlag, thresholdValueFlag);
              corpusPost = conFileWriter.getCorpusThroughput();
            }
            if (cmd.hasOption("combined")) {
              if ((!cmd.hasOption("inputFileGet")) || (!cmd.hasOption("inputFilePost"))) {
                String errorMsg = "Error: no inputFileGet or inputFilePost was given.";
                System.out.println(errorMsg);
                formatter.printHelp("utility-name", options);
                throw new Exception(errorMsg);
              } else {
                conFileWriter.mergeFile(inputFilePostName, corpusGet, corpusPost);
              }
            }
            // interpret command line argument to find peak phase from the input data.
          } else {
            String errorMsg = "Error: please provide number of parts to split.";
            System.out.println(errorMsg);
            formatter.printHelp("utility-name", options);
          }

        } else {
          FileWriter fileWriter = new FileWriter();
          if (cmd.hasOption("combined")) {
            if ((!cmd.hasOption("inputFileGet") || !cmd.hasOption("inputFilePost"))) {
              String errorMsg = "Error: no inputFileGet or inputFilePost was given.";
              System.out.println(errorMsg);
              formatter.printHelp("utility-name", options);
              throw new Exception(errorMsg);
            } else {
              fileWriter.mergeFiles(inputFileGetName, inputFilePostName, outputDir);
            }
          }
          if (cmd.hasOption("inputFileGet")) {
            fileWriter.writeSingleFile(inputFileGetName, outputDir);
          }
          if (cmd.hasOption("inputFilePost")) {
            fileWriter.writeSingleFile(inputFilePostName, outputDir);
          }
          if (cmd.hasOption("threshold")) {
            System.out.println("Sorry, this task cannot be done non-concurrently.");
          }
        }
      }

    } catch (ParseException e) {
      System.out.println(e.getMessage());
      formatter.printHelp("utility-name", options);
      throw new Exception(e.getMessage());
    }

    final long end = System.currentTimeMillis();
    long durationInMillis = end - start;
    long second = durationInMillis;
    System.out.println(second + " milliseconds");
  }
}