package edu.neu.ccs.cs5010.assignment3;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

/**
 * Seat Tester.
 *
 * @author <timzyt>
 * @version 1.0
 * @since <pre>Oct 5, 2018</pre>
 */
public class SeatTest {

  private Integer seatIndex1;
  private Integer invalidSeatIndex;
  private String seatName1;
  private String seatName2;
  private String reservedFor1;
  private String reservedFor2;
  private String reservedFor3;
  private  Seat seat1;

  @Before
  public void before() throws Exception {
    seatIndex1 = 2;
    invalidSeatIndex = 27;
    seatName1 = "B";
    seatName2 = "C";
    reservedFor1 = "Tim Zhu";
    reservedFor2 = "Jack Ma";
    reservedFor3 = "";
    seat1 = new Seat(seatName1, reservedFor1);
  }


  @Test
  public void getSeatName() {
    assertEquals(seatName1,seat1.getSeatName());
  }

  /**
   * Method: setSeatName(Integer i)
   */
  @Test
  public void testSetSeatName() throws Exception {
    seat1.setSeatName(seatIndex1);
    assertEquals(seatName2,seat1.getSeatName());
  }

  /**
   * Method: setSeatName(Integer i)
   */
  @Test (expected = InvalidNumberOfSeatException.class)
  public void testSetSeatName2() throws Exception {
    seat1.setSeatName(invalidSeatIndex);
  }

  /**
   * Method: setReservedFor(String aPerson)
   */
  @Test
  public void testSetReservedFor() throws Exception {
    seat1.setReservedFor(reservedFor2);
    assertEquals(reservedFor2,seat1.getReservedFor());
  }

  /**
   * Method: setReservedFor(String aPerson)
   */
  @Test(expected = InvalidConstructorArgumentException.class)
  public void testSetReservedFor2() throws Exception {
    seat1.setReservedFor(reservedFor3);
  }

  /**
   * Method: setReservedFor(String aPerson)
   */
  @Test(expected = NullValueException.class)
  public void testSetReservedFor3() throws Exception {
    seat1.setReservedFor(null);
  }

  @Test(expected = InvalidUserInputException.class)
  public void testSetReservedFor4() throws Exception {
    seat1.setReservedFor("123");
  }

  /**
   * Method: getReservedFor()
   */
  @Test
  public void testGetReservedFor() throws Exception {
    assertEquals(reservedFor1,seat1.getReservedFor());
  }
}
