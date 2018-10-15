package edu.neu.ccs.cs5010.assignment2;

import static org.junit.Assert.*;

import edu.neu.ccs.cs5010.assignment2.*;
import org.junit.Before;
import org.junit.Test;

public class MeasurementTest {

  private Integer value1 = 200;
  private Integer value2 = 400;
  private Integer zero = 0;
  private SystemOfMeasurement som1 = SystemOfMeasurement.Metric;
  private SystemOfMeasurement som2 = SystemOfMeasurement.Inch;
  private Measurement mea1;
  private Measurement mea2;
  private Measurement mea3;
  private String mea1Str = "200mm";
  private String mea2Str = "200\"";

  @Before
  public void setUp() throws Exception {
    mea1 = new Measurement(new Fraction(value1,zero, zero ), som1);
    mea2 = new Measurement(new Fraction(value1,zero, zero ), som2);
  }

  @Test
  public void printMeasurement() {
    assertEquals(mea1Str, mea1.printMeasurement());
    assertEquals(mea2Str, mea2.printMeasurement());
  }

  @Test
  public void getValue1() {
    mea1.getValue();
  }

  @Test(expected = NullValueException.class)
  public void getValue2() {
    new Measurement(null, som1).getValue();
    new Measurement(new Fraction(value1,zero, zero ), null).getValue();
  }

  @Test
  public void setValue1() throws Exception {
    mea1.setValue(new Fraction(value2, zero, zero));
  }

  @Test(expected = NullValueException.class)
  public void setValue3() throws Exception {
    mea1.setValue(null);
  }

  @Test
  public void getSom() {
    mea1.getSom();
  }

  @Test
  public void setSom1() throws Exception {
    mea1.setSom(som2);
  }

  @Test(expected = NullValueException.class)
  public void setSom2() throws Exception {
    mea1.setSom(null);
  }

  @Test
  public void equals() {
    mea1.equals(mea1);
    mea1.equals(mea2);
    mea1.equals(null);
    assertEquals(false, mea1.equals(null));
  }

  @Test
  public void testHashCode() {
    mea1.hashCode();
  }
}