package edu.neu.ccs.cs5010.assignment5.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CsvReader {

  ArrayList<String> readCsvByLine = new ArrayList<>();
  LineParser lineParser = new LineParser();

  public CsvReader() {

  }

  public ArrayList<String> getKeys(String csvFileName) {
    System.out.println(System.getProperty("user.dir"));

    try (BufferedReader inputFile = new BufferedReader(new FileReader(csvFileName))) {

      String line;

      if ((line = inputFile.readLine()) != null) {
        System.out.println("Read : " + line);
        readCsvByLine = lineParser.parse(line);
      }



    } catch (FileNotFoundException fnfe) {
      System.out.println("*** OUPS! A file was not found : " + fnfe.getMessage());
      fnfe.printStackTrace();
    } catch (IOException ioe) {
      System.out.println("Something went wrong! : " + ioe.getMessage());
      ioe.printStackTrace();
    }
    return readCsvByLine;
  }

}
