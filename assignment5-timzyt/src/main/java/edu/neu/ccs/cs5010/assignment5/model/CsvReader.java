package edu.neu.ccs.cs5010.assignment5.model;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * The csv reader class.
 */
public class CsvReader {

  /**
   * The list to store splitted one line from the csv file.
   */
  List<String> readCsvByLine = new ArrayList<>();
  /**
   * The Line parser.
   */
  LineParser lineParser = new LineParser();

  /**
   * Instantiates a new Csv reader.
   */
  public CsvReader() {

  }

  /**
   * Gets keys.
   *
   * @param csvFileName the csv file name
   * @return the keys
   */
  public List<String> getKeys(String csvFileName) {
    System.out.println(System.getProperty("user.dir"));

    try (BufferedReader inputFile = new BufferedReader(
        new InputStreamReader(new FileInputStream(csvFileName), "UTF8"))) {

      String line;

      if ((line = inputFile.readLine()) != null) {
        readCsvByLine = lineParser.parse(line);
      }
      //line = inputFile.readLine();
    } catch (FileNotFoundException fnfe) {
      System.out.println("*** OUPS! A file was not found : " + fnfe.getMessage());
      fnfe.printStackTrace();
    } catch (IOException ioe) {
      System.out.println("Something went wrong! : " + ioe.getMessage());
      ioe.printStackTrace();
    }
    return readCsvByLine;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof CsvReader)) {
      return false;
    }
    CsvReader csvReader = (CsvReader) obj;
    return Objects.equals(readCsvByLine, csvReader.readCsvByLine);
  }

  @Override
  public int hashCode() {
    return Objects.hash(readCsvByLine);
  }


}
