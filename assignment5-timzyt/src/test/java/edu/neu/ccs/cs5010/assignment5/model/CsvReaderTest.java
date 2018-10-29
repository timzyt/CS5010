package edu.neu.ccs.cs5010.assignment5.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import edu.neu.ccs.cs5010.assignment5.model.CsvReader;
import edu.neu.ccs.cs5010.assignment5.model.LineParser;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.io.Reader;
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

  List<String> readCsvByLine;
  LineParser lineParser;
  String csvFileName;
  String badFileName;
  String testFileName;
  String nullLine;
  String csvFirstLine;
  CsvReader newCsvReader;
  List<String> nullOutput;



  @Before
  public void before() throws Exception {
    readCsvByLine = new ArrayList<>();
    lineParser = new LineParser();
    csvFileName = "insurance-company-members_test.csv";
    newCsvReader = new CsvReader();
    badFileName = "noSuchFile.csv";
    testFileName = "testFile.csv";
  }

  @After
  public void after() throws Exception {
  }

  /**
   * Method: getKeys(String templateFileName)
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

  }

  /**
   * test when input file name does not exist.
   * @throws FileNotFoundException
   */
  @Test //(expected = FileNotFoundException.class)
  public void testFileNotFound() throws Exception {
    newCsvReader.getKeys(badFileName);
//    try (BufferedReader inputFile = new BufferedReader(new FileReader(badFileName))) {
//      csvFirstLine = inputFile.readLine();
//      readCsvByLine = lineParser.parse(badFileName);
//    } catch (FileNotFoundException fnfe) {
//      String message = "noSuchFile.csv (The system cannot find the file specified)";
//      //fnfe.printStackTrace();
//      assertEquals(message, fnfe.getMessage());
//    }
  }

  /**
   * test when input file is null.
   * @throws Exception
   */
  @Test //(expected = NullPointerException.class)
  public void testNullFile() throws Exception {

    System.getProperty("user.dir");
    FileWriter newFileWriter = new FileWriter(testFileName);
    newFileWriter.append(nullLine);
    newFileWriter.close();
    newCsvReader.getKeys(testFileName);
//    assertNull(newCsvReader.getKeys(testFileName));
    System.out.println("contente is:" + newCsvReader.getKeys(testFileName).toString());
//    try (BufferedReader inputFile = new BufferedReader(new FileReader("testFile.csv"))) {
//      csvFirstLine = inputFile.readLine();
//      readCsvByLine = lineParser.parse("testFile.csv");
//    } catch (FileNotFoundException fnfe) {
//      String message = "noSuchFile.csv (The system cannot find the file specified)";
//      //System.out.println("asdfasc" + fnfe.getMessage());
//      assertEquals(message, fnfe.getMessage());
//
//    }
  }

  /**
   * test when input file is null.
   * @throws Exception
   */
  @Test //(expected = NullPointerException.class)
  public void testNullOutput() throws Exception {
    newCsvReader.readCsvByLine = nullOutput;
    newCsvReader.getKeys(badFileName);
//    System.getProperty("user.dir");
//    FileWriter newFileWriter = new FileWriter(nullLine);
//    newFileWriter.append(nullLine);
//    newFileWriter.close();
//    newCsvReader.getKeys(testFileName);
//    System.out.println("contente is:" + newCsvReader.getKeys(testFileName).toString());
//    try (BufferedReader inputFile = new BufferedReader(new FileReader("testFile.csv"))) {
//      csvFirstLine = inputFile.readLine();
//      readCsvByLine = lineParser.parse("testFile.csv");
//    } catch (FileNotFoundException fnfe) {
//      String message = "noSuchFile.csv (The system cannot find the file specified)";
//      //System.out.println("asdfasc" + fnfe.getMessage());
//      assertEquals(message, fnfe.getMessage());
//
//    }
  }

  /**
   * test when the input file is locked.
   * @throws Exception
   */
  @Test //(expected = IOException.class)
  public void testIOException() throws Exception {
    final RandomAccessFile raFile =  new RandomAccessFile(csvFileName, "rw");
    raFile.getChannel().lock();
    newCsvReader.getKeys(csvFileName);
    //   raFile.getChannel().lock().close();
    //    try (BufferedReader inputFile = new BufferedReader(new FileReader(csvFileName))) {
    //      final RandomAccessFile raFile =  new RandomAccessFile(csvFileName, "rw");
    //      raFile.getChannel().lock();
    //      csvFirstLine = inputFile.readLine();
    //      readCsvByLine = lineParser.parse(csvFileName);
    //    } catch (IOException ioe) {
    //      String message = "The process cannot access the file because another process has locked a portion of the file";
    //      assertEquals(message, ioe.getMessage());
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
