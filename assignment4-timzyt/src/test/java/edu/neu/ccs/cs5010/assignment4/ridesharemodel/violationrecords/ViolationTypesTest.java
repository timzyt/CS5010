package edu.neu.ccs.cs5010.assignment4.ridesharemodel.driver.ridersharemodel.violationrecords;

import static org.junit.Assert.assertEquals;

import edu.neu.ccs.cs5010.assignment4.ridesharemodel.violationrecords.ViolationTypes;
import org.junit.Test;
import org.junit.Before;

/**
 * ViolationTypes Tester.
 *
 * @author timyzt
 * @version 1.0
 * @since <pre>Oct 14, 2018</pre>
 */
public class ViolationTypesTest {

  private String violationType;
  private ViolationTypes Distracted_driving;

  @Before
  public void before() throws Exception {

    violationType = "Distracted_driving";
    Distracted_driving = ViolationTypes.Distracted_driving;
  }


  @Test
  public void testValuesOf() {
    assertEquals(Distracted_driving, ViolationTypes.valueOf(violationType));
  }

  @Test
  public void testValue() {
    ViolationTypes violationTypes[] = ViolationTypes.values();
    assertEquals(9, violationTypes.length);
  }

  /**
   * Method: toString()
   */
  @Test
  public void testToString() throws Exception {
    ViolationTypes violationTypes[] = ViolationTypes.values();
    for (ViolationTypes violationType : violationTypes) {
      System.out.println(violationType.toString());
    }

  }


} 
