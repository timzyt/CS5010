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
    emailTemplate = "email-template.txt";
    csvFileName = "insurance-company-members_test.csv";
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
}
