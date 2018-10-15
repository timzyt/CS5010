package edu.neu.ccs.cs5010.assignment3;

import java.util.ArrayList;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;


/**
 * Row Tester.
 *
 * @author <timzyt>
 * @version 1.0
 * @since <pre>Oct 5, 2018</pre>
 */
public class RowTest {

  private Integer rowNum;
  private Integer numOfSeat;

  private Row newRow;

  @Before
  public void before() throws Exception {
    rowNum = 15;
    numOfSeat = 20;
    newRow = new Row(rowNum, numOfSeat);

  }

  @Test(expected = NullValueException.class)
  public void testRowConstructor() throws Exception {
    new Row(null, numOfSeat);
    new Row(rowNum, null);
    new Row(null, null);
  }

  @Test(expected = InvalidConstructorArgumentException.class)
  public void testRowConstructor2() throws Exception {
    new Row(0, numOfSeat);
    new Row(rowNum, 0);
    new Row(0, 0);
  }

  @Test
  public void testRowConstructor3() throws Exception {
    new Row(rowNum, numOfSeat);
  }

  /**
   * Method: getRowMap()
   */
  @Test
  public void testGetRowMap() throws Exception {
    newRow.getRowMap();
  }

  /**
   * Method: getRowNumber()
   */
  @Test
  public void testGetRowNumber() throws Exception {
    assertEquals(rowNum, newRow.getRowNumber());
  }

  /**
   * Method: getNumOfSeat()
   */
  @Test
  public void testGetNumOfSeat() throws Exception {
    assertEquals(numOfSeat,newRow.getNumOfSeat());
  }

  /**
   * Method: getEmptySeat()
   */
  @Test
  public void testGetEmptySeat() throws Exception {
    assertEquals(numOfSeat,newRow.getEmptySeat());
  }

  @Test
  public void testGetIsAccessible() {
    newRow.setIsAccessible(false);
    assertFalse(newRow.getIsAccessible());
  }


} 
