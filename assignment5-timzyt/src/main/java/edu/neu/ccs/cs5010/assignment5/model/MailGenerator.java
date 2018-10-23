package edu.neu.ccs.cs5010.assignment5.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MailGenerator {

  CsvReader newCsvReader = new CsvReader();
  TemplateReader newTemplateReader = new TemplateReader();
  LineParser newLineParser = new LineParser();
  ArrayList<String> keys;
  ArrayList<String> currCsvLine;

  public MailGenerator() {

  }

  public void run(String mailType, String templateName, String csvFileName, String outputDir) throws IOException {
//    String cachedTemplate = newTemplateReader.run(templateName);
//    System.out.println(cachedTemplate);
    keys = newCsvReader.getKeys(csvFileName);
    System.out.println(keys.get(0));
    System.out.println(System.getProperty("user.dir"));
    BufferedReader inputFile = null;
    try {
      inputFile = new BufferedReader(new FileReader(csvFileName));

      String csvLine;
      inputFile.readLine();

      while ((csvLine = inputFile.readLine()) != null) {
        System.out.println("Read : " + csvLine);
        currCsvLine = newLineParser.parse(csvLine);

//          for (String value : currCsvLine) {
//            System.out.println("value in currVsvLine is: " + value);
//          }
        // reset outputFileName to the base case
        String outputFileName = mailType;
        StringBuilder group0 = new StringBuilder();
        Pattern re0;
        String template = newTemplateReader.run(templateName);

        for (int i = 0; i < keys.size(); i++) {
          group0.append("\\[\\[").append(keys.get(i).replace("\"", "")).append("\\]\\]");
          re0 = Pattern.compile(group0.toString());
          Matcher m = re0.matcher(template);
          if (m.find()) {
            template = template.replace(m.group(),
                currCsvLine.get(i).replace("\"", ""));
          }
          group0.setLength(0);
        }
        System.out.println("template after replacement is: \r\n" + template);
        System.out.println(currCsvLine.get(0));
        outputFileName = outputFileName + "_"
            + currCsvLine.get(0).replace("\"", "") + " "
            + currCsvLine.get(1).replace("\"", "") + ".txt";

        BufferedWriter outputFile = new BufferedWriter(
            new FileWriter(outputDir + "\\" + outputFileName));
        outputFile.write(template);
        outputFile.flush();
        outputFile.close();
      }


    } catch (FileNotFoundException fnfe) {
      System.out.println("*** OUPS! A file was not found : " + fnfe.getMessage());
      fnfe.printStackTrace();
    } catch (IOException ioe) {
      System.out.println("Something went wrong! : " + ioe.getMessage());
      ioe.printStackTrace();
    }
  }

}
