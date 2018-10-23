package test.edu.neu.ccs.cs5010.assignment5.model;

import edu.neu.ccs.cs5010.assignment5.model.LineParser;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * CsvReader Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Oct 23, 2018</pre>
 */
public class CsvReaderTest {

  ArrayList<String> readCsvByLine = new ArrayList<>();
  LineParser lineParser = new LineParser();
  String csvFileName = "insurance-company-members_test.csv";

  @Before
  public void before() throws Exception {
  }

  @After
  public void after() throws Exception {
  }

  /**
   * Method: getKeys(String csvFileName)
   */
  @Test
  public void testGetKeys() throws Exception {
    System.out.println(System.getProperty("user.dir"));

    try (BufferedReader inputFile = new BufferedReader(new FileReader(csvFileName))) {

      String line;

      if ((line = inputFile.readLine()) != null) {
        System.out.println("Current line is: " + line);
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
    System.out.println(readCsvByLine);
  }


} 
