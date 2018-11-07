package edu.neu.ccs.cs5010.assignment5.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * CsvProcessor Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Oct 23, 2018</pre>
 */
public class CsvProcessorTest {

  List<String> readCsvByLine;
  LineParser lineParser;
  String csvFileName;
  String badFileName;
  String testFileName;
  String nullLine;
  String csvFirstLine;
  CsvProcessor newCsvProcessor;
  List<String> nullOutput;


  @Before
  public void before() throws Exception {
    readCsvByLine = new ArrayList<>();
    lineParser = new LineParser();
    csvFileName = "insurance-company-members_test.csv";
    newCsvProcessor = new CsvProcessor();
    badFileName = "noSuchFile.csv";
    testFileName = "testFile.csv";
  }

  @After
  public void after() throws Exception {
  }

  /**
   * Method: loadCustomers(String templateFileName)
   */
  @Test
  public void testloadCustomers() throws Exception {
    System.getProperty("user.dir");
    try (BufferedReader inputFile = new BufferedReader(new FileReader(csvFileName))) {
      csvFirstLine = inputFile.readLine();
      readCsvByLine = lineParser.parse(csvFirstLine);
      assertEquals(readCsvByLine, newCsvProcessor.loadCustomers(csvFileName));
    } catch (Exception e) {

    }
    System.out.println(newCsvProcessor.loadCustomers(csvFileName));

  }

  /**
   * test when input file name does not exist.
   */
  @Test //(expected = FileNotFoundException.class)
  public void testFileNotFound() throws Exception {
    newCsvProcessor.loadCustomers(badFileName);
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
   */
  @Test //(expected = NullPointerException.class)
  public void testNullFile() throws Exception {

    System.getProperty("user.dir");
    FileWriter newFileWriter = new FileWriter(testFileName);
    newFileWriter.append(nullLine);
    newFileWriter.close();
    newCsvProcessor.loadCustomers(testFileName);
  //    assertNull(newCsvProcessor.loadCustomers(testFileName));
      System.out.println("contente is:" + newCsvProcessor.loadCustomers(testFileName).toString());
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
   */
  @Test //(expected = NullPointerException.class)
  public void testNullOutput() throws Exception {
    newCsvProcessor.loadCustomers(csvFileName);
    System.out.println(newCsvProcessor.loadCustomers(csvFileName));
  //    System.getProperty("user.dir");
  //    FileWriter newFileWriter = new FileWriter(nullLine);
  //    newFileWriter.append(nullLine);
  //    newFileWriter.close();
  //    newCsvProcessor.loadCustomers(testFileName);
  //    System.out.println("contente is:" + newCsvProcessor.loadCustomers(testFileName).toString());
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
   */
  @Test //(expected = IOException.class)
  public void testIOException() throws Exception {
    final RandomAccessFile raFile = new RandomAccessFile(csvFileName, "rw");
    raFile.getChannel().lock();
    newCsvProcessor.loadCustomers(csvFileName);
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
    assertTrue(newCsvProcessor.equals(new CsvProcessor()));
    assertTrue(newCsvProcessor.equals(newCsvProcessor));
    assertFalse(newCsvProcessor.equals(csvFileName));

  }

  /**
   * Method: hashCode()
   */
  @Test
  public void testHashCode() throws Exception {
    assertTrue(newCsvProcessor.hashCode() == (new CsvProcessor().hashCode()));
  }
} 
