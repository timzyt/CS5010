package edu.neu.ccs.cs5010.assignment3;

import java.util.Arrays;
import java.util.HashSet;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

/**
 * Theater Tester.
 *
 * @author <timzyt>
 * @version 1.0
 * @since <pre>Oct 5, 2018</pre>
 */
public class TheaterTest {
  private String name;
  private Integer numOfRow;
  private Integer numOfSeat;
  private Boolean needChairAccessible;
  private HashSet<Integer> needAccessible;
  private Theater newTheater;

  @Before
  public void before() throws Exception {
    name = "Majestic Bay";
    numOfRow = 15;
    numOfSeat = 25;
    needAccessible = new HashSet<>(Arrays.asList(2, 5, 9));
    newTheater = new Theater(name, numOfRow, numOfSeat, needAccessible);
  }

  @Test(expected = NullValueException.class)
  public void testTheaterConstructor() throws Exception {
    newTheater = new Theater(null, numOfRow, numOfSeat, needAccessible);
    newTheater = new Theater(name, null, numOfSeat, needAccessible);
    newTheater = new Theater(name, numOfRow, null, needAccessible);
    newTheater = new Theater(name, null, null, needAccessible);
    newTheater = new Theater(null, numOfRow, null, needAccessible);
    newTheater = new Theater(null, null, numOfSeat, needAccessible);
    newTheater = new Theater(null, null, null, needAccessible);
  }

  @Test(expected = InvalidConstructorArgumentException.class)
  public void testTheaterConstructor2() throws Exception {
    newTheater = new Theater("", numOfRow, numOfSeat, needAccessible);
    newTheater = new Theater(name, -2, numOfSeat, needAccessible);
    newTheater = new Theater(name, 0, numOfSeat, needAccessible);
    newTheater = new Theater(name, numOfRow, -3, needAccessible);
    newTheater = new Theater(name, numOfRow, 0, needAccessible);
    newTheater = new Theater(name, -2, -3, needAccessible);
    newTheater = new Theater(name, 0, -3, needAccessible);
    newTheater = new Theater(name, -2, 0, needAccessible);
    newTheater = new Theater(name, 0, 0, needAccessible);
    newTheater = new Theater("", numOfRow, -3, needAccessible);
    newTheater = new Theater("", -2, numOfSeat, needAccessible);
    newTheater = new Theater("", -2, -3, needAccessible);
    newTheater = new Theater("", numOfRow, 0, needAccessible);
    newTheater = new Theater("", 0, numOfSeat, needAccessible);
    newTheater = new Theater("", 0, -3, needAccessible);
    newTheater = new Theater("", 0, 0, needAccessible);
    newTheater = new Theater("", 0, 0, needAccessible);
  }

  @Test(expected = InvalidConstructorArgumentException.class)
  public void testTheaterConstructor3() throws Exception {
    needAccessible = new HashSet<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16));
    newTheater = new Theater(name, numOfRow, numOfSeat, needAccessible);
  }

  @Test(expected = InvalidConstructorArgumentException.class)
  public void testTheaterConstructor4() throws Exception {
    needAccessible = new HashSet<>(Arrays.asList(1,3,5,22));
    newTheater = new Theater(name, numOfRow, numOfSeat, needAccessible);
  }


  @Test
  public void testTheaterConstructor5() throws Exception {
    newTheater = new Theater(name, numOfRow, numOfSeat, needAccessible);
  }

  /**
   * Method: getName()
   */
  @Test
  public void testGetName() throws Exception {
    assertEquals(name, newTheater.getName());
  }

  /**
   * Method: getNumOfRow()
   */
  @Test
  public void testGetNumOfRow() throws Exception {
    assertEquals(numOfRow, newTheater.getNumOfRow());
  }

  /**
   * Method: getTheaterMap()
   */
  @Test
  public void testGetTheaterMap() throws Exception {
    newTheater.getTheaterMap();
  }
} 
