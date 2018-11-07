package edu.neu.ccs.cs5010.assignment5.model;

import edu.neu.ccs.cs5010.assignment5.util.FileCombineUtil;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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

  String outputSuffixKey = "[[email]]";
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
    System.getProperty("user.dir");
    customerSet = new HashSet<>();
    wholeParsedTemplate = new HashMap<>();
    placeholderKeys = new HashSet<>();

    customerSet = newCsvProcessor.loadCustomers(csvFileName);
    wholeParsedTemplate = newTemplateProcessor.getWholeParsedTemplate(templateName);
    placeholderKeys = newTemplateProcessor.getPlaceholderKeys(templateName);

    for (Map<String, String> customerMap : customerSet) {
      updatedTemplateMap = new HashMap<>(wholeParsedTemplate);
      for (Integer index : placeholderKeys) {
        String currPlaceholder = updatedTemplateMap.get(index);
        updatedTemplateMap.put(index, customerMap.get(currPlaceholder));
      }
      updatedTemplate = newFileCombine.combineStringMap(updatedTemplateMap);
      String outputFileName = mailType + "_" + customerMap.get(outputSuffixKey)
          + ".txt";
      BufferedWriter outputFile = new BufferedWriter(
          new OutputStreamWriter(
              new FileOutputStream(outputDir + File.separator + outputFileName), "UTF8"));
      outputFile.write(updatedTemplate);
      outputFile.flush();
      outputFile.close();
    }
  }

}
