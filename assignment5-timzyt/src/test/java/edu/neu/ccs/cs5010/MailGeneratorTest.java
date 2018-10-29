package edu.neu.ccs.cs5010;

import static org.junit.Assert.assertEquals;

import edu.neu.ccs.cs5010.assignment5.model.MailGenerator;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
   * Method: run(String templateName, String csvFileName, String outputDir)
   */
  @Test
  public void testRun() throws Exception {
    newMailGenerator.run(mailType, emailTemplate, csvFileName, outputDir);
  }

  @Test
  public void testFNFE() throws Exception {
    try {
      newMailGenerator.run(mailType, emailTemplate, badFileName, outputDir);
    } catch (Exception e) {
      String message = e.getMessage();
      assertEquals(message, e.getMessage());
    }
  }


} 
