package edu.neu.ccs.cs5010.assignment3;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import javax.print.DocFlavor.BYTE_ARRAY;
import org.junit.Rule;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

/**
 * ReservationSystem Tester.
 *
 * @author <Timzyt>
 * @version 1.0
 * @since <pre>Oct 6, 2018</pre>
 */
public class ReservationSystemTest {

  private String reserveInput;
  private String reserveInput2;
  private String reserveInput3;
  private String reserveInput4;
  private String reserveInput5;
  private String[] args;
  private Integer counter;
  private ByteArrayInputStream inContent;
  private ReservationsService newrs;
  private ReservationSystem newRevSys;
  private InputStream originalIn;


  @Before
  public void before() throws Exception {
    counter = Integer.valueOf(0);
    reserveInput = "reserve 8\r\nyes\r\nTim\r\nshow\r\ndone\r\n";
    reserveInput2 = "reserve 22\r\nyes\r\nreserve 8\r\nTim\r\nshow\r\ndone\r\n";
    reserveInput3 = "132\r\n[;[\r\n1sv\r\n";
    reserveInput4 = "reserve 8\r\nyes\r\n123\r\n';[\r\n1'p\r\n";
    reserveInput5 = "reserve eight\r\nreserve 8\r\nyes\r\n123\r\n';[\r\n1'p\r\n";
  }

  @After
  public void restoreStreams() {
    System.setIn(originalIn);
  }

  @Rule
  public final ExpectedSystemExit exit = ExpectedSystemExit.none();

  /**
   * Method: main(String[] args)
   */
  @Test
  public void testMain() throws Exception {
    exit.expectSystemExit();
    inContent = new ByteArrayInputStream(reserveInput.getBytes());
    InputStream savedUserInput1 = System.in;
    System.setIn(inContent);
    newRevSys.main(args);
    System.setIn(savedUserInput1);
  }

  @Test
  public void testMain2() throws Exception {
    exit.expectSystemExit();
    inContent = new ByteArrayInputStream(reserveInput2.getBytes());
    InputStream savedUserInput1 = System.in;
    System.setIn(inContent);
    newRevSys.main(args);
    System.setIn(savedUserInput1);
  }

  @Test
  public void testMain3() throws Exception {
    exit.expectSystemExit();
    inContent = new ByteArrayInputStream(reserveInput3.getBytes());
    InputStream savedUserInput1 = System.in;
    System.setIn(inContent);
    newRevSys.main(args);
    System.setIn(savedUserInput1);
  }

  @Test
  public void testMain4() throws Exception {
    exit.expectSystemExit();
    inContent = new ByteArrayInputStream(reserveInput4.getBytes());
    InputStream savedUserInput1 = System.in;
    System.setIn(inContent);
    newRevSys.main(args);
    System.setIn(savedUserInput1);
  }

  @Test
  public void testMain5() throws Exception {
    exit.expectSystemExit();
    inContent = new ByteArrayInputStream(reserveInput5.getBytes());
    InputStream savedUserInput1 = System.in;
    System.setIn(inContent);
    newRevSys.main(args);
    System.setIn(savedUserInput1);
  }
}
