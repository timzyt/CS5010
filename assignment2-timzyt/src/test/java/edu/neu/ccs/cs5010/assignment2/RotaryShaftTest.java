package edu.neu.ccs.cs5010.assignment2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class RotaryShaftTest {

  private String sku1 = "1482K11";
  private String sku2 = "1482K12";
  private String sku3 = "";
  private String usd = "$";
  private String crcy = "";
  private Integer priceInCent1 = 768;
  private Integer priceInCent2 = 858;
  private Integer priceInCent3 = -1023;
  private SealType sealed = SealType.Sealed;
  private SystemOfMeasurement metric = SystemOfMeasurement.Metric;
  private SystemOfMeasurement inch = SystemOfMeasurement.Inch;
  private String Metric = "Metric";
  private Integer zero = 0;
  private Integer diaValue1 = 10;
  private Integer lenValue1 = 200;
  private Integer diaValue2 = 10;
  private Integer lenValue2 = 400;
  private Measurement diameter1;
  private Measurement diameter2;
  private Measurement diameter3;
  private Measurement diameter4;
  private Measurement length1;
  private Measurement length2;
  private Measurement length3;
  private Measurement length4;
  private Price price1;
  private Price price2;
  private RotaryShaft rotaryShaft1;
  private RotaryShaft rotaryShaft2;

  @Before
  public void setUp() throws Exception {
    diameter1 = new Measurement(new Fraction(diaValue1, zero, zero), metric);
    diameter2 = new Measurement(new Fraction(diaValue2, zero, zero), metric);
    diameter3 = new Measurement(new Fraction(diaValue1, zero, zero), inch);
    diameter4 = null;
    length1 = new Measurement(new Fraction(lenValue1, zero, zero), metric);
    length2 = new Measurement(new Fraction(lenValue2, zero, zero), metric);
    length3 = new Measurement(new Fraction(lenValue2, zero, zero), inch);
    length4 = null;
    price1 = new Price(usd, priceInCent1);
    price2 = new Price(usd, priceInCent2);
    rotaryShaft1 = new RotaryShaft(sku1, priceInCent1, Metric, length1, diameter1);
    rotaryShaft2 = new RotaryShaft(sku1, priceInCent1, Metric, length2, diameter2);
  }

  @Test
  public void getCategory() {
    assertTrue(rotaryShaft1.getCategory().contentEquals("Rotary Shaft"));
  }

  @Test(expected = InvalidConstructorArgumentsException.class)
  public void testRotaryShaftConstructor1() {
    assertEquals(length1,
        new RotaryShaft(sku2, priceInCent1, Metric, length1, diameter1).getLength());
    assertEquals(length1,
        new RotaryShaft(sku3, priceInCent1, Metric, length1, diameter1).getLength());
  }

  @Test(expected = NullValueException.class)
  public void testRotaryShaftConstructor2() {
    assertEquals(length1,
        new RotaryShaft(sku3, priceInCent1, null, length1, diameter1).getLength());
    assertEquals(length1,
        new RotaryShaft(null, priceInCent1, Metric, length1, diameter1).getLength());
    assertEquals(length1,
        new RotaryShaft(sku1, priceInCent1, Metric, length1, diameter1).getLength());
  }

  @Test
  public void getSku() {
    rotaryShaft1.getSku();
  }

  @Test
  public void getPrice() {
    rotaryShaft1.getPrice();
  }

  @Test
  public void getLength() {
    assertEquals(length1, rotaryShaft1.getLength());
  }


  @Test
  public void getDiameter() {
    assertEquals(diameter1, rotaryShaft1.getDiameter());
  }


  @Test
  public void getSom() {
    assertEquals(metric, rotaryShaft1.getSom());
  }

  @Test
  public void getShaft() {
    assertEquals(diameter1, rotaryShaft1.getShaft());
  }
}