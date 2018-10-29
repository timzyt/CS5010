package edu.neu.ccs.cs5010.assignment5.model;

import static org.junit.Assert.assertEquals;

import edu.neu.ccs.cs5010.assignment5.model.MailGenerator;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * MailGenerator Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Oct 22, 2018</pre>
 */
public class MailGeneratorTest {

  MailGenerator newMailGenerator;
  String emailTemplate;
  String csvFileName;
  String outputDir;
  String mailType;
  String badFileName;

  @Before
  public void before() throws Exception {
    newMailGenerator = new MailGenerator();
    emailTemplate = "letter-template.txt";
    csvFileName = "insurance-company-members.csv";
    outputDir = "email";
    mailType = "email";
    badFileName = "noSuchFile.csv";
  }

  @After
  public void after() throws Exception {
  }

  /**
   * Method: run(String templateName, String templateFileName, String outputDir)
   */
  @Test
  public void testRun() throws Exception {
    newMailGenerator.run(mailType, emailTemplate, csvFileName, outputDir);
  }

  @Test
  public void testFNFE() throws Exception {
    newMailGenerator.run(mailType, emailTemplate, badFileName, outputDir);
//    FileWriter newFileWriter = new FileWriter("testFile.csv");
//    newFileWriter.close();
//    try {
//
//    } catch (FileNotFoundException fnfe) {
//      String message = "Index: 0, Size: 0";
//      System.out.println("fnfe exception message is " + fnfe.toString());
//
//      //assertEquals(message, e.getMessage());
//    } catch (IOException ioe) {
//      System.out.println("ioe exception message is " + ioe.toString());
//    } catch (Exception e) {
//      System.out.println("general exception message is " + e.toString());
//    }
  }

  @Test
  public void testIOException() throws Exception {
    final RandomAccessFile raFile =  new RandomAccessFile(csvFileName, "rw");
    raFile.getChannel().lock();
    newMailGenerator.run(mailType, emailTemplate, csvFileName, outputDir);
//    try {
//      newMailGenerator.run(mailType, emailTemplate, badFileName, outputDir);
//    } catch (FileNotFoundException fnfe) {
//      String message = "Index: 0, Size: 0";
//      System.out.println("fnfe exception message is " + fnfe.toString());
//
//      //assertEquals(message, e.getMessage());
//    } catch (IOException ioe) {
//      System.out.println("ioe exception message is " + ioe.toString());
//    } catch (Exception e) {
//      System.out.println("general exception message is " + e.toString());
//    }
  }



} 
