package edu.neu.ccs.cs5010.assignment4.ridesharemodel.driver.ridersharemodel.driver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import edu.neu.ccs.cs5010.assignment4.ridesharemodel.driver.Country;
import org.junit.Test;
import org.junit.Before;

/**
 * Country Tester.
 *
 * @author timzyt
 * @version 1.0
 * @since <pre>Oct 14, 2018</pre>
 */
public class CountryTest {

  private String strUS;
  private Country us;

  @Before
  public void before() throws Exception {
    strUS = "US";
    us = Country.US;

  }

  @Test
  public void testValuesOf() {
    assertEquals(us, Country.valueOf(strUS));
  }

  @Test
  public void testValue() {
    Country countries[] = Country.values();
    assertEquals(2, countries.length);
  }

}
