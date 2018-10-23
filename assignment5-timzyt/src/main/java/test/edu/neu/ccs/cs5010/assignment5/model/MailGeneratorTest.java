package test.edu.neu.ccs.cs5010.assignment5.model;

import edu.neu.ccs.cs5010.assignment5.model.MailGenerator;
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

  MailGenerator newMailGenerator = new MailGenerator();
  String emailTemplate = "letter-template.txt";
  String csvFileName = "insurance-company-members.csv";
  String outputDir = "email";
  String mailType = "email";

  @Before
  public void before() throws Exception {
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


} 
