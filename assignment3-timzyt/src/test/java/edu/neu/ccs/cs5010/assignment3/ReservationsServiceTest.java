package edu.neu.ccs.cs5010.assignment3;

import java.util.Arrays;
import java.util.HashSet;
import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.*;

/**
 * ReservationsService Tester.
 *
 * @author <timzyt>
 * @version 1.0
 * @since <pre>Oct 6, 2018</pre>
 */
public class ReservationsServiceTest {

  private String theaterName;
  private String clientName;
  private Integer nrow;
  private Integer nseat;
  private Integer rowNum;
  private Integer globalCounter;
  private Integer getNameInputCounter;
  private Integer groupSize;
  private Integer numOfTrial;
  private Boolean needChairAccessible;

  private HashSet<Integer> accessibility;
  private Theater newTheater;
  private ReservationsService newrs;

  @Before
  public void before() throws Exception {
    theaterName = "Roxy";
    clientName = "Tim Zhu";
    clientName = "Jack Ma";
    nrow = Integer.valueOf(7);
    nseat = Integer.valueOf(10);
    globalCounter = Integer.valueOf(0);
    getNameInputCounter = Integer.valueOf(0);
    groupSize = Integer.valueOf(3);
    numOfTrial = Integer.valueOf(3);

    accessibility = new HashSet<>(Arrays.asList(2, 5, 7));
    //    accessibility.add(2);
    //    accessibility.add(5);
    //    accessibility.add(9);
    needChairAccessible = true;
    newTheater = new Theater(theaterName, nrow, nseat, accessibility);
    newrs = new ReservationsService(newTheater);
  }


  /**
   * Method: findBestRow(Integer groupSize)
   */
  @Test(expected = InvalidConstructorArgumentException.class)
  public void testFindBestRow() throws Exception {
    assertEquals(Integer.valueOf(5), newrs.findBestRow(Integer.valueOf(-2), needChairAccessible));
  }

  @Test
  public void testFindBestRow2() throws Exception {
    assertEquals(Integer.valueOf(5), newrs.findBestRow(groupSize, needChairAccessible));
  }

  @Test
  public void testFindBestRow3() throws Exception {
    newrs.reserveSeats(clientName, newrs.findBestRow(groupSize, needChairAccessible), groupSize);
    assertEquals(Integer.valueOf(2), newrs.findBestRow(Integer.valueOf(8), needChairAccessible));
  }

  @Test
  public void testFindBestRow4() throws Exception {
    ReservationsService newrs2 = new ReservationsService(
        new Theater(theaterName, Integer.valueOf(8), nseat,
            accessibility));
    newrs2.reserveSeats(clientName, newrs2.findBestRow(groupSize, needChairAccessible), groupSize);
    newrs2.reserveSeats(clientName, newrs2.findBestRow(groupSize, needChairAccessible), groupSize);
    assertEquals(Integer.valueOf(2), newrs2.findBestRow(Integer.valueOf(6), needChairAccessible));
  }

  @Test
  public void testFindBestRow5() throws Exception {
    assertEquals(Integer.valueOf(5), newrs.findBestRow(groupSize, true));
  }

  @Test
  public void testFindBestRow6() throws Exception {
    newrs.reserveSeats(clientName, newrs.findBestRow(groupSize, true), groupSize);
    assertNull(newrs.findBestRow(13, true));
  }

  @Test
  public void testFindBestRow7() throws Exception {
    newrs.reserveSeats(clientName, newrs.findBestRow(6, false), 6);
    newrs.reserveSeats(clientName, newrs.findBestRow(9, false), 6);
    assertEquals(Integer.valueOf(6), newrs.findBestRow(8, false));
  }

  @Test
  public void testFindBestRow8() throws Exception {
    assertNull(newrs.findBestRow(31, true));
  }

  @Test
  public void testFindBestRow9() throws Exception {
    newrs.reserveSeats(clientName, newrs.findBestRow(6, true), 6);
    newrs.reserveSeats(clientName, newrs.findBestRow(9, true), 9);
    newrs.reserveSeats(clientName, newrs.findBestRow(9, true), 9);
    assertNull(clientName, newrs.findBestRow(9, true));
  }

  @Test
  public void testFindBestRow10() throws Exception {
    System.out.println(newrs.showMap());
    newrs.reserveSeats(clientName, newrs.findBestRow(6, true), 6);
    newrs.reserveSeats(clientName, newrs.findBestRow(7, true), 7);
    newrs.reserveSeats(clientName, newrs.findBestRow(8, false), 8);
    newrs.reserveSeats(clientName, newrs.findBestRow(9, false), 9);
    newrs.reserveSeats(clientName, newrs.findBestRow(9, false), 9);
    newrs.reserveSeats(clientName, newrs.findBestRow(9, false), 9);
    assertEquals(Integer.valueOf(7), newrs.findBestRow(5, false));
    newrs.reserveSeats(clientName, newrs.findBestRow(5, false), 5);
    System.out.println(newrs.showMap());
  }

  @Test
  public void testFindBestRow11() throws Exception {
    ReservationsService newrs3 = new ReservationsService(
        new Theater(theaterName, Integer.valueOf(8), nseat,
            accessibility));
    System.out.println(newrs3.showMap());
    newrs3.reserveSeats(clientName, newrs3.findBestRow(6, true), 6);
    newrs3.reserveSeats(clientName, newrs3.findBestRow(7, true), 7);
    newrs3.reserveSeats(clientName, newrs3.findBestRow(8, false), 8);
    newrs3.reserveSeats(clientName, newrs3.findBestRow(9, false), 9);
    newrs3.reserveSeats(clientName, newrs3.findBestRow(9, false), 9);
    newrs3.reserveSeats(clientName, newrs3.findBestRow(9, false), 9);
    assertEquals(Integer.valueOf(8), newrs3.findBestRow(8, false));
    newrs3.reserveSeats(clientName, newrs3.findBestRow(8, false), 8);
    newrs3.reserveSeats(clientName, newrs3.findBestRow(5, false), 5);
    System.out.println(newrs3.showMap());
  }

  @Test
  public void testFindBestRow12() throws Exception {
    ReservationsService newrs3 = new ReservationsService(
        new Theater(theaterName, Integer.valueOf(8), nseat,
            accessibility));
    System.out.println(newrs3.showMap());
    newrs3.reserveSeats(clientName, newrs3.findBestRow(6, true), 6);
    newrs3.reserveSeats(clientName, newrs3.findBestRow(7, true), 7);
    newrs3.reserveSeats(clientName, newrs3.findBestRow(8, false), 8);
    newrs3.reserveSeats(clientName, newrs3.findBestRow(9, false), 9);
    newrs3.reserveSeats(clientName, newrs3.findBestRow(9, false), 9);
    newrs3.reserveSeats(clientName, newrs3.findBestRow(9, false), 9);
    assertEquals(Integer.valueOf(8), newrs3.findBestRow(8, false));
    newrs3.reserveSeats(clientName, newrs3.findBestRow(8, false), 8);
    newrs3.reserveSeats(clientName, newrs3.findBestRow(5, false), 5);
    assertNull(newrs3.findBestRow(9, false));
    System.out.println(newrs3.showMap());
  }

  @Test
  public void testFindBestRow13() throws Exception {
    accessibility = new HashSet<Integer>(Arrays.asList(1, 4));
    ReservationsService newrs3 = new ReservationsService(
        new Theater(theaterName, nrow, nseat, accessibility));
    System.out.println(newrs3.showMap());
    newrs3.reserveSeats(clientName, newrs3.findBestRow(6, true), 6);
    System.out.println(newrs3.showMap());
  }

  @Test
  public void testFindBestRow14() throws Exception {
    accessibility = new HashSet<Integer>(Arrays.asList(4));
    ReservationsService newrs3 = new ReservationsService(
        new Theater(theaterName, 8, nseat, accessibility));
    System.out.println(newrs3.showMap());
    newrs3.reserveSeats(clientName, newrs3.findBestRow(6, false), 6);
    newrs3.reserveSeats(clientName, newrs3.findBestRow(6, false), 6);
    newrs3.reserveSeats(clientName, newrs3.findBestRow(6, false), 6);
    newrs3.reserveSeats(clientName, newrs3.findBestRow(6, false), 6);
    newrs3.reserveSeats(clientName, newrs3.findBestRow(6, false), 6);
    newrs3.reserveSeats(clientName, newrs3.findBestRow(6, false), 6);
    newrs3.reserveSeats(clientName, newrs3.findBestRow(6, false), 6);
    newrs3.reserveSeats(clientName, newrs3.findBestRow(8, false), 8);
    System.out.println(newrs3.showMap());
  }

  @Test
  public void testFindBestRow15() throws Exception {
    accessibility = new HashSet<Integer>(Arrays.asList(1, 4));
    ReservationsService newrs3 = new ReservationsService(
        new Theater(theaterName, nrow, nseat, accessibility));
    System.out.println(newrs3.showMap());
    newrs3.reserveSeats(clientName, newrs3.findBestRow(10, false), 10);
    newrs3.reserveSeats(clientName, newrs3.findBestRow(10, false), 10);
    newrs3.reserveSeats(clientName, newrs3.findBestRow(10, false), 10);
    newrs3.reserveSeats(clientName, newrs3.findBestRow(10, false), 10);
    newrs3.reserveSeats(clientName, newrs3.findBestRow(10, false), 10);
    newrs3.reserveSeats(clientName, newrs3.findBestRow(10, false), 10);
    newrs3.reserveSeats(clientName, newrs3.findBestRow(7, true), 7);
    assertNull(newrs3.findBestRow(8, false));
    System.out.println(newrs3.showMap());
  }

  /**
   * Method: reserveSeats(String clientName, Integer foundRowNum, Integer groupSize)
   */
  @Test
  public void testReserveSeats() throws Exception {
    newrs.reserveSeats(clientName, newrs.findBestRow(groupSize, true), groupSize);
  }

  /**
   * Method: showMap()
   */
  @Test
  public void testShowMap() throws Exception {
    ReservationsService newrs2 = new ReservationsService(
        new Theater(theaterName, Integer.valueOf(14), nseat,
            accessibility));
    newrs2.reserveSeats(clientName, newrs2.findBestRow(groupSize, true), groupSize);
    newrs2.reserveSeats(clientName, newrs2.findBestRow(groupSize, true), groupSize);
    assertEquals(Integer.valueOf(7), newrs2.findBestRow(Integer.valueOf(4), true));
    newrs2.showMap();
  }

  @Test
  public void testShowMap2() throws Exception {
    newrs.showMap();
  }

} 
