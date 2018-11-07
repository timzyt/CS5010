//package edu.neu.ccs.cs5010.assignment5.model;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertTrue;
//
//import edu.neu.ccs.cs5010.assignment5.controller.UserController;
//import java.io.ByteArrayInputStream;
//import java.io.ByteArrayOutputStream;
//import java.io.InputStream;
//import java.io.PrintStream;
//import org.junit.Rule;
//import org.junit.contrib.java.lang.system.ExpectedSystemExit;
//
//import org.junit.Test;
//import org.junit.Before;
//import org.junit.After;
//
///**
// * UserController Tester.
// *
// * @author <Authors name>
// * @version 1.0
// * @since <pre>Oct 29, 2018</pre>
// */
//public class UserControllerTest {
//
//  private String correctInput;
//  private String noDirInput;
//  private String noCsvInput;
//  private String noEmailLetterInput;
//  private String noMissEmailOrLetterInput;
//  private PrintStream originalOut = System.out;
//  private PrintStream originalErr = System.err;
//
//  private String[] args;
//  private ByteArrayInputStream inContent;
//  private InputStream originalIn;
//  private UserController newUserController;
//
//  @Before
//  public void before() throws Exception {
//
//    correctInput = "--email --email-template email-template.txt --output-dir email --csv-file insurance-company-members_test.csv";
//    noDirInput = "--email --email-template email-template.txt --csv-file insurance-company-members_test.csv";
//    noCsvInput = "--email --email-template email-template.txt --output-dir email";
//    noEmailLetterInput = "--output-dir email --csv-file insurance-company-members_test.csv";
//    noMissEmailOrLetterInput = "--email --letter-template email-template.txt --output-dir email --csv-file insurance-company-members_test.csv";
//  }
//
//  @After
//  public void after() throws Exception {
//    System.setOut(originalOut);
//    System.setIn(originalIn);
//  }
//
//  @Rule
//  public final ExpectedSystemExit exit = ExpectedSystemExit.none();
//
//  /**
//   * test success main method
//   */
//  @Test
//  public void testSuccessfulMain() throws Exception {
//    inContent = new ByteArrayInputStream(correctInput.getBytes());
//    //InputStream savedUserInput1 = System.in;
//    System.setIn(inContent);
//    newUserController.main(args);
//    //System.setIn(savedUserInput1);
//  }
//
//  /**
//   * test no directory main method
//   */
//  @Test
//  public void testNoDirMain() throws Exception {
//    exit.expectSystemExitWithStatus(0);
//    inContent = new ByteArrayInputStream(noDirInput.getBytes());
//    //InputStream savedUserInput1 = System.in;
//    System.setIn(inContent);
//    newUserController.main(args);
//  }
//
//  @Test
//  public void testNoCsvInput() throws Exception {
//    exit.expectSystemExitWithStatus(0);
//    inContent = new ByteArrayInputStream(noCsvInput.getBytes());
//    //InputStream savedUserInput1 = System.in;
//    System.setIn(inContent);
//    newUserController.main(args);
//  }
//
//  @Test
//  public void testNoEmailLetterInput() throws Exception {
//    exit.expectSystemExitWithStatus(0);
//    inContent = new ByteArrayInputStream(noEmailLetterInput.getBytes());
//    //InputStream savedUserInput1 = System.in;
//    System.setIn(inContent);
//    newUserController.main(args);
//  }
//
//  @Test
//  public void testnoMissEmailOrLetterInput() throws Exception {
//    exit.expectSystemExitWithStatus(0);
//    inContent = new ByteArrayInputStream(noMissEmailOrLetterInput.getBytes());
//    //InputStream savedUserInput1 = System.in;
//    System.setIn(inContent);
//    newUserController.main(args);
//  }
//
//
//}
