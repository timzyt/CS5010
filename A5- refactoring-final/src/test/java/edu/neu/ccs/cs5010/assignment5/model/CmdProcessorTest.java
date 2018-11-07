//package edu.neu.ccs.cs5010.assignment5.model;
//
//
//import static org.junit.Assert.assertEquals;
//
//import java.io.FileWriter;
//import java.io.IOException;
//import org.junit.Test;
//import org.junit.Before;
//
//public class CmdProcessorTest {
//  boolean createEmail;
//  boolean createLetter;
//  String testEmailTemplate;
//  String testLetterTemplate;
//  String testCsvFile;
//  String emailOutputDir;
//  String letterOutputDir;
//  CmdProcessor newCmdProcessor;
//
//  @Before
//  public void setUp() throws Exception {
//    createEmail = true;
//    createLetter = true;
//    testEmailTemplate = "email-template.txt";
//    testLetterTemplate = "letter-template.txt";
//    testCsvFile = "insurance-company-members_test.csv";
//    emailOutputDir = "email";
//    letterOutputDir = "letter";
//    newCmdProcessor = new CmdProcessor();
//  }
//
//  /**
//   * test successfully generate emails
//   */
//  @Test
//  public void testGenerateEmail() throws IOException {
//    newCmdProcessor.createEmail = createEmail;
//    newCmdProcessor.emailTemplate = testEmailTemplate;
//    newCmdProcessor.csvFile = testCsvFile;
//    newCmdProcessor.outputDir = emailOutputDir;
//    newCmdProcessor.runMailGenerator();
//
//  }
//
//  /**
//   * test successfully generate letters
//   */
//  @Test
//  public void testGenerateLetter() throws IOException {
//    newCmdProcessor.createLetter = createLetter;
//    newCmdProcessor.letterTemplate = testLetterTemplate;
//    newCmdProcessor.csvFile = testCsvFile;
//    newCmdProcessor.outputDir = emailOutputDir;
//    newCmdProcessor.runMailGenerator();
//
//  }
//
//
//  /**
//   * test successfully generate letters
//   */
//  @Test
//  public void testIOException() throws IOException {
//    System.getProperty("user.dir");
//    FileWriter newFileWriter = new FileWriter("testTemplate.csv");
//    newFileWriter.close();
//    newCmdProcessor.createLetter = createLetter;
//    newCmdProcessor.letterTemplate = "testTemplate.csv";
//    newCmdProcessor.csvFile = testCsvFile;
//    newCmdProcessor.outputDir = emailOutputDir;
//    try {
//      if (createLetter) {
//        MailGenerator newMailGenerator = new MailGenerator();
//        newMailGenerator.run("letter", newCmdProcessor.letterTemplate, newCmdProcessor.csvFile, newCmdProcessor.outputDir);
//      }
//    } catch (Exception e) {
//      String message = "String index out of range: -1";
//      assertEquals(message, e.getMessage());
//      e.printStackTrace();
//    }
//
//
//
//  }
//
//}