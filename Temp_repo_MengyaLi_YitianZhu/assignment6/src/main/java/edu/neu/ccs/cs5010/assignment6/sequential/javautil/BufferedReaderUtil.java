package edu.neu.ccs.cs5010.assignment6.sequential.javautil;

import edu.neu.ccs.cs5010.assignment6.sequential.pojo.MapBuilder;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * The Buffered Reader Utility class.
 */
public class BufferedReaderUtil {

  /**
   * The Encoding.
   */
  public static final String ENCODING = "UTF8";

  /**
   * The main directory for file r/w.
   */
  public static final String MAIN_DIR = "user.dir";

  /**
   * The LineParser class.
   */
  private LineParserUtil lpu = new LineParserUtil();

  /**
   * The MapBuilder class.
   */
  private MapBuilder mapBdr;
  /**
   * Read provided file and output as a list of strings.
   *
   * @param fileName the file name.
   * @return List a list of strings.
   * @throws IOException IOExceptions
   */
  public MapBuilder read(String fileName) throws IOException {
    System.getProperty(MAIN_DIR);
    mapBdr = new MapBuilder();
    try {

      BufferedReader inputFile = new BufferedReader(
          new InputStreamReader(new FileInputStream(fileName), ENCODING));

      String line;

      while ((line = inputFile.readLine()) != null) {
        mapBdr.buildMapFromRaw(lpu.parseLine(line));
      }

      inputFile.close();
    } catch (FileNotFoundException fnfe) {
      System.out.println("*** OUPS! A file was not found : " + fnfe.getMessage());
      fnfe.printStackTrace();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return this.mapBdr;
  }
}