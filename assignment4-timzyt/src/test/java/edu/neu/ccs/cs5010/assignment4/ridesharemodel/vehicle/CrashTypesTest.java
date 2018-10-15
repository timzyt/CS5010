package edu.neu.ccs.cs5010.assignment4.ridesharemodel.driver.ridersharemodel.vehicle;

import static org.junit.Assert.assertEquals;

import edu.neu.ccs.cs5010.assignment4.ridesharemodel.vehicle.CrashTypes;
import org.junit.Test;
import org.junit.Before;

/**
 * CrashTypes Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Oct 14, 2018</pre>
 */
public class CrashTypesTest {

  private String crashType;
  private CrashTypes Fender_bender;


  @Before
  public void before() throws Exception {
    crashType = "Fender_bender";
    Fender_bender = CrashTypes.Fender_bender;
  }

  @Test
  public void testValuesOf() {
    assertEquals(Fender_bender, CrashTypes.valueOf(crashType));
  }

  @Test
  public void testValue() {
    CrashTypes crashTypes[] = CrashTypes.values();
    assertEquals(3, crashTypes.length);
  }

  @Test
  public void testToString() {
    CrashTypes crashTypes[] = CrashTypes.values();
    for (CrashTypes violationType : crashTypes) {
      System.out.println(violationType.toString());
    }

  }
}
