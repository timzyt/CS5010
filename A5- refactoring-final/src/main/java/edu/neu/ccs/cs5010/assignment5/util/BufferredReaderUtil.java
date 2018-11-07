package edu.neu.ccs.cs5010.assignment5.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * BufferedReader utility class.
 */
public class BufferredReaderUtil {

  /**
   * Result List.
   */
  List<String> result;

  /**
   * Read provided file and output as a list of strings.
   *
   * @param fileName the file name.
   * @return List a list of strings.
   */
  public List<String> read(String fileName) {
    System.getProperty("user.dir");
    result = new ArrayList<>();
    try (BufferedReader inputFile = new BufferedReader(
        new InputStreamReader(new FileInputStream(fileName), "UTF8"))) {

      String line;

      while ((line = inputFile.readLine()) != null) {
        result.add(line);
      }
    } catch (FileNotFoundException fnfe) {
      System.out.println("*** OUPS! A file was not found : " + fnfe.getMessage());
      fnfe.printStackTrace();
    } catch (IOException ioe) {
      System.out.println("Something went wrong! : " + ioe.getMessage());
      ioe.printStackTrace();
    }
    return result;
  }
}
