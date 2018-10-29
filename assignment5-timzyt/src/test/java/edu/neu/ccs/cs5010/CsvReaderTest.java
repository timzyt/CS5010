package edu.neu.ccs.cs5010;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import edu.neu.ccs.cs5010.assignment5.model.CsvReader;
import edu.neu.ccs.cs5010.assignment5.model.LineParser;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Rule;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.rules.ExpectedException;

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
  String badFileName;
  String csvFirstLine;
  CsvReader newCsvReader;
  List<String> CsvReadResult;

  @Before
  public void before() throws Exception {
    lineParser = new LineParser();
    csvFileName = "insurance-company-members_test.csv";
    newCsvReader = new CsvReader();
    badFileName = "noSuchFile.csv";
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
//@Rule
//public ExpectedException expectedEx = ExpectedException.none();

  @Test //(expected = FileNotFoundException.class)
  public void testFileNotFound() throws Exception {
    try (BufferedReader inputFile = new BufferedReader(new FileReader(badFileName))) {
      csvFirstLine = inputFile.readLine();
      readCsvByLine = lineParser.parse(badFileName);
    } catch (FileNotFoundException fnfe) {
      String message = "noSuchFile.csv (The system cannot find the file specified)";
      assertEquals(message, fnfe.getMessage());
    }

//      expectedEx.expect(FileNotFoundException.class);
//      expectedEx.expectMessage();

    String exceptionMsg = "*** OUPS! A file was not found : ";
//    } catch (FileNotFoundException fnfe) {
//      System.out.println("*** OUPS! A file was not found : " + fnfe.getMessage());
//      assertEquals("noSuchFile.csv (The system cannot find the file specified)",fnfe.getMessage());
//      fnfe.printStackTrace();
//    }
  }


  /**
   * Method: equals(Object obj)
   */
  @Test
  public void testEquals() throws Exception {
    assertTrue(newCsvReader.equals(new CsvReader()));
    assertTrue(newCsvReader.equals(newCsvReader));
    assertFalse(newCsvReader.equals(csvFileName));

  }

  /**
   * Method: hashCode()
   */
  @Test
  public void testHashCode() throws Exception {
    assertTrue(newCsvReader.hashCode() == (new CsvReader().hashCode()));
  }
} 
