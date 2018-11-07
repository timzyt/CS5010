package edu.neu.ccs.cs5010.assignment5.model;

import edu.neu.ccs.cs5010.assignment5.util.FileCombineUtil;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The type Mail generator.
 */
public class MailGenerator {

  FileCombineUtil newFileCombine = new FileCombineUtil();
  /**
   * The New csv reader.
   */
  CsvProcessor newCsvProcessor = new CsvProcessor();
  /**
   * The New template reader.
   */
  TemplateProcessor newTemplateProcessor = new TemplateProcessor();
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
  String baseOutputFileName;
  String outputSuffixKey = "\\[\\[email\\]\\]";
  Set<Map<String, String>> customerSet;
  Map<Integer, String> wholeParsedTemplate;
  Set<Integer> placeholderKeys;

  Map<Integer, String> updatedTemplateMap;
  String updatedTemplate;

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

    customerSet = newCsvProcessor.loadCustomers(csvFileName);
    wholeParsedTemplate = newTemplateProcessor.getWholeParsedTemplate(templateName);
    placeholderKeys = newTemplateProcessor.getPlaceholderKeys(templateName);
    baseOutputFileName = mailType;
    System.getProperty("user.dir");

    for (Map<String, String> customerMap : customerSet) {
      for (Integer index : placeholderKeys) {
        updatedTemplateMap = new HashMap<>(wholeParsedTemplate);
        String currPlaceholder = updatedTemplateMap.get(index);
        updatedTemplateMap.put(index, customerMap.get(currPlaceholder));
      }
      updatedTemplate = newFileCombine.combineStringMap(updatedTemplateMap);
      String outputFileName = mailType + "_" + customerMap.get(outputSuffixKey);
      BufferedWriter outputFile = new BufferedWriter(
          new OutputStreamWriter(
              new FileOutputStream(outputDir + File.separator + outputFileName), "UTF8"));
      outputFile.write(updatedTemplate);
      outputFile.flush();
      outputFile.close();
    }
  }

}
