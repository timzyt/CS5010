package edu.neu.ccs.cs5010.assignment5.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The type Mail generator.
 */
public class MailGenerator {

  /**
   * The New csv reader.
   */
  CsvReader newCsvReader = new CsvReader();
  /**
   * The New template reader.
   */
  TemplateReader newTemplateReader = new TemplateReader();
  /**
   * The New line parser.
   */
  LineParser newLineParser = new LineParser();
  /**
   * The Keys.
   */
  List<String> keys;
  /**
   * The Curr csv line.
   */
  List<String> currCsvLine;

  /**
   * Instantiates a new Mail generator.
   */
  public MailGenerator() {

  }

  /**
   * Run.
   *
   * @param mailType the mail type
   * @param templateName the template name
   * @param csvFileName the csv file name
   * @param outputDir the output dir
   * @throws IOException the io exception
   */
  public void run(String mailType, String templateName, String csvFileName, String outputDir)
      throws Exception {
    //    String cachedTemplate = newTemplateReader.run(templateName);
    //    System.out.println(cachedTemplate);

    try {
      keys = newCsvReader.getKeys(csvFileName);
      //System.out.println(keys.get(0));
      System.out.println(System.getProperty("user.dir"));
      BufferedReader inputFile = null;
      inputFile = new BufferedReader(
          new InputStreamReader(new FileInputStream(csvFileName), "UTF8"));

      String csvLine;
      inputFile.readLine();

      while ((csvLine = inputFile.readLine()) != null) {
        System.out.println("Read : " + csvLine);
        currCsvLine = newLineParser.parse(csvLine);

        //          for (String value : currCsvLine) {
        //            System.out.println("value in currVsvLine is: " + value);
        //          }
        // reset outputFileName to the base case

        StringBuilder group0 = new StringBuilder();
        Pattern re0;
        String template = newTemplateReader.run(templateName);

        for (int i = 0; i < keys.size(); i++) {
          group0.append("\\[\\[").append(keys.get(i).replace("\"", "")).append("\\]\\]");
          re0 = Pattern.compile(group0.toString());
          Matcher newMatcher = re0.matcher(template);
          if (newMatcher.find()) {
            template = template.replace(newMatcher.group(),
                currCsvLine.get(i).replace("\"", ""));
          }
          group0.setLength(0);
        }
        //System.out.println("template after replacement is: \r\n" + template);
        //System.out.println(currCsvLine.get(0));
        String outputFileName = mailType;
        outputFileName = outputFileName + "_"
            + currCsvLine.get(0).replace("\"", "") + " "
            + currCsvLine.get(1).replace("\"", "") + ".txt";
        BufferedWriter outputFile = new BufferedWriter(
            new OutputStreamWriter(
                new FileOutputStream(outputDir + File.separator + outputFileName), "UTF8"));
        outputFile.write(template);
        outputFile.flush();
        outputFile.close();
      }
      inputFile.close();

    } catch (FileNotFoundException fnfe) {
      System.out.println("*** OUPS! A file was not found : " + fnfe.getMessage());
      fnfe.printStackTrace();
    } catch (IOException ioe) {
      System.out.println("Something went wrong! : " + ioe.getMessage());
      ioe.printStackTrace();
    } finally {

      System.out.println("Job done.");
    }
  }

}
