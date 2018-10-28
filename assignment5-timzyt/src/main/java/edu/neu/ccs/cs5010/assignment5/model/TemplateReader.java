package edu.neu.ccs.cs5010.assignment5.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * The type Template reader.
 */
public class TemplateReader {


  /**
   * The Cached template.
   */
  StringBuilder cachedTemplate = new StringBuilder();

  /**
   * Instantiates a new Template reader.
   */
  public TemplateReader() {

  }

  /**
   * Run string.
   *
   * @param templateName the template name
   * @return the string
   */
  public String run(String templateName) {
    System.out.println(System.getProperty("user.dir"));

    try (BufferedReader inputFile = new BufferedReader(new FileReader(templateName))) {

      String line;
      cachedTemplate.setLength(0);
      while ((line = inputFile.readLine()) != null) {
        //need to flush the StringBuilder object cachedTemplate

        cachedTemplate.append(line).append("\r\n");
        System.out.println("Read : " + line);
      }

    } catch (FileNotFoundException fnfe) {
      System.out.println("*** OUPS! A file was not found : " + fnfe.getMessage());
      fnfe.printStackTrace();
    } catch (IOException ioe) {
      System.out.println("Something went wrong! : " + ioe.getMessage());
      ioe.printStackTrace();
    }

    while (cachedTemplate.charAt(cachedTemplate.length() - 1) == ' ') {
      cachedTemplate.deleteCharAt(cachedTemplate.length() - 1);
    }
    return cachedTemplate.toString();
  }
}

