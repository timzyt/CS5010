package edu.neu.ccs.cs5010.assignment2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PrecisionBallBearingTest {
  private String sku1 = "6661K13";
  private String sku2 = "1482K11";
  private String usd = "$";
  private Integer priceInCent1 = 1598;
  private Integer priceInCent2 = 768;
  private SystemOfMeasurement metric = SystemOfMeasurement.Metric;
  private String Metric = "Metric";
  private String shielded = "Shielded";
  private String sealed = "Sealed";
  private Integer zero = 0;
  private Integer diaValue1 = 10;
  private Integer diaValue2 = 8;
  private Integer lenValue1 = 200;
  private Integer widthValue1 = 8;
  private Integer widthValue2 = 10;
  private Measurement diameter1;
  private Measurement diameter2;
  private Measurement length1;
  private Measurement width1;
  private Measurement width2;
  private Measurement forShftDia1;
  private Measurement forShftDia2;
  private Price price1;
  private Price price2;
  private RotaryShaft rotaryShaft1;
  private AbstractBallBearing ballBearing1;
  private AbstractBallBearing ballBearing2;

  @Before
  public void setUp() throws Exception {
    diameter1 = new Measurement(new Fraction(diaValue1, zero, zero), metric);
    diameter2 = new Measurement(new Fraction(diaValue2, zero, zero), metric);
    length1 = new Measurement(new Fraction(lenValue1, zero, zero), metric);
    width1 = new Measurement(new Fraction(widthValue1, zero, zero), metric);
    width2 = new Measurement(new Fraction(widthValue2, zero, zero), metric);
    forShftDia1 = new Measurement(new Fraction(diaValue1, zero, zero), metric);
    forShftDia2 = new Measurement(new Fraction(diaValue2,zero, zero), metric);
    price1 = new Price(usd, priceInCent1);
    price2 = new Price(usd, priceInCent2);
    ballBearing1 = new PrecisionBallBearing(sku1, priceInCent1, Metric, shielded, width1, forShftDia1);
    ballBearing2 = new PrecisionBallBearing(sku1, priceInCent1, Metric, shielded, width1, forShftDia2);
    rotaryShaft1 = new RotaryShaft(sku2, priceInCent2, Metric, length1, diameter2);
  }

  @Test(expected = NullValueException.class)
  public void setSom() throws Exception {
    ballBearing1.setSom(null);
  }

  @Test(expected = InvalidConstructorArgumentsException.class)
  public void setSom2() throws Exception {
    ballBearing1.setSom("");
  }

  @Test
  public void setSom3() throws Exception{
    ballBearing1.setSom(Metric);
  }


  @Test
  public void getCategory() {
    assertTrue(ballBearing1.getCategory().contentEquals("Precision Ball Bearing"));
  }

  @Test
  public void getSealType() {
    ballBearing1.getSealType();
  }

  @Test
  public void getWidth() {
    ballBearing1.getWidth();
  }

  @Test
  public void testGetForShaftDiameter() {
    assertEquals(forShftDia1,ballBearing1.getForShaftDiameter());
  }

  @Test (expected = NullPointerException.class)
  public void testFitsShaft1() throws Exception {
    ballBearing1.fitsShaft(null);
  }

  @Test
  public void testFitsShaft2() {
    assertTrue(ballBearing2.fitsShaft(rotaryShaft1));
  }

  @Test
  public void testFitsShaft3() {
    assertFalse(ballBearing1.fitsShaft(rotaryShaft1));
  }

  @Test
  public void getShaft() {
    assertEquals(forShftDia1, ballBearing1.getShaft());
  }
}