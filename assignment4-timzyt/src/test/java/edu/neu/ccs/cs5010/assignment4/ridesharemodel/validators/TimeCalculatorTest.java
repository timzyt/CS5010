package edu.neu.ccs.cs5010.assignment4.ridesharemodel.driver.ridersharemodel.validators;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import edu.neu.ccs.cs5010.assignment4.ridesharemodel.validators.TimeCalculator;
import java.time.LocalDate;
import org.junit.Test;
import org.junit.Before;

/**
 * TimeCalculator Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Oct 13, 2018</pre>
 */
public class TimeCalculatorTest {
  private LocalDate birthday;
  private LocalDate startDate;
  private LocalDate expirationDate;
  private LocalDate expirationDate2;
  private Integer age;
  private Integer month;

  private TimeCalculator timeCalculator;


  @Before
  public void before() throws Exception {
    birthday = LocalDate.of(1988,04,23);
    startDate = LocalDate.of(2018,01,01);
    expirationDate = LocalDate.of(2020,01,01);
    expirationDate2 = LocalDate.of(2008, 01,01);
    age = 30;
    month = 9;

    timeCalculator = new TimeCalculator();
  }

  /**
   * Method: calculateYear(LocalDate date)
   */
  @Test
  public void testCalculateAge() throws Exception {
    assertTrue(age.equals(timeCalculator.calculateYear(birthday)));
  }

  /**
   * Method: calculateMonth(LocalDate date)
   */
  @Test
  public void testCalculateMonth() throws Exception {
    assertTrue(month.equals(timeCalculator.calculateMonth(startDate)));
  }

  /**
   * Method: notPast(LocalDate date)
   */
  @Test
  public void testNotPast() throws Exception {
    assertTrue(timeCalculator.notPast(expirationDate));
    assertFalse(timeCalculator.notPast(expirationDate2));
  }


} 
