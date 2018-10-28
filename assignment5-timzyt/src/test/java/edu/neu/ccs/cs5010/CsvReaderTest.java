package edu.neu.ccs.cs5010;

import static org.junit.Assert.assertEquals;

import edu.neu.ccs.cs5010.assignment5.model.CsvReader;
import edu.neu.ccs.cs5010.assignment5.model.LineParser;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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

  List<String> readCsvByLine = new ArrayList<>();
  LineParser lineParser;
  String csvFileName;
  String csvFirstLine;
  CsvReader newCsvReader;
  List<String> CsvReadResult;

  @Before
  public void before() throws Exception {
    lineParser = new LineParser();
    csvFileName = "insurance-company-members_test.csv";
    newCsvReader = new CsvReader();
//    CsvReadResult = new ArrayList<String>();
//    CsvReadResult.add("first_name");
//    CsvReadResult.add("last_name");
//    CsvReadResult.add("company_name");
//    CsvReadResult.add("address");
//    CsvReadResult.add("city");
//    CsvReadResult.add("county");
//    CsvReadResult.add("state");
//    CsvReadResult.add("zip");
//    CsvReadResult.add("phone1");
//    CsvReadResult.add("phone2");
//    CsvReadResult.add("email");
//    CsvReadResult.add("web");

  }

  @After
  public void after() throws Exception {
  }

  /**
   * Method: getKeys(String csvFileName)
   */
  @Test
  public void testGetKeys() throws Exception {
    System.getProperty("user.dir");
    try (BufferedReader inputFile = new BufferedReader(new FileReader(csvFileName))) {
      csvFirstLine = inputFile.readLine();
      readCsvByLine = lineParser.parse(csvFirstLine);
      assertEquals(readCsvByLine, newCsvReader.getKeys(csvFileName));
    } catch (Exception e) {

    }
    System.out.println(newCsvReader.getKeys(csvFileName));


  //    System.out.println(System.getProperty("user.dir"));
  //
  //    try () {
  //
  //      String line;
  //
  //      if ((line = inputFile.readLine()) != null) {
  //        readCsvByLine = lineParser.parse(line);
  //      }
  //    } catch (FileNotFoundException fnfe) {
  //      System.out.println("*** OUPS! A file was not found : " + fnfe.getMessage());
  //      fnfe.printStackTrace();
  //    } catch (IOException ioe) {
  //      System.out.println("Something went wrong! : " + ioe.getMessage());
  //      ioe.printStackTrace();
  //    }
  //    System.out.println(readCsvByLine);
  }


} 
