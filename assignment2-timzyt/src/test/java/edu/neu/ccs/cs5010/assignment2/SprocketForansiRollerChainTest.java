package edu.neu.ccs.cs5010.assignment2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SprocketForansiRollerChainTest {

  private String sku1 = "2302K113";
  private String sku2 = "1482K11";
  private String usd = "$";
  private Integer priceInCent1 = 6653;
  private Integer priceInCent2 = 6887;
  private Integer numOfTh1 = 27;
  private SystemOfMeasurement metric = SystemOfMeasurement.Metric;
  private SystemOfMeasurement inch = SystemOfMeasurement.Inch;
  private String Inch = "Inch";
  private Integer diaValue1 = 10;
  private Integer diaValue2 = 8;
  private Integer lenValue1 = 200;
  private Integer zero = 0;
  private Measurement diameter1;
  private Measurement diameter2;
  private Measurement length1;
  private Measurement forShftDia1;
  private Measurement forShftDia2;
  private Price price1;
  private Price price2;
  private SprocketForansiRollerChain sprocketANSI1;
  private RotaryShaft RotaryShaft1;
  private RotaryShaft RotaryShaft2;

  @Before
  public void setUp() throws Exception {
    diameter1 = new Measurement(new Fraction(diaValue1, zero, zero), inch);
    diameter2 = new Measurement(new Fraction(diaValue2, zero, zero), inch);
    length1 = new Measurement(new Fraction(lenValue1, zero, zero), inch);
    forShftDia1 = new Measurement(new Fraction(diaValue1, zero, zero), inch);
    forShftDia2 = new Measurement(new Fraction(diaValue2, zero, zero), metric);
    price1 = new Price(usd, priceInCent1);
    price2 = new Price(usd, priceInCent2);
    sprocketANSI1 = new SprocketForansiRollerChain(sku1, priceInCent1, Inch, numOfTh1,
        forShftDia1);
    RotaryShaft1 = new RotaryShaft(sku2, priceInCent2, Inch, length1, diameter1);
    RotaryShaft2 = new RotaryShaft(sku2, priceInCent2, Inch, length1, diameter2);
  }

  @Test
  public void getCategory() {
    assertTrue(sprocketANSI1.getCategory().contentEquals("Sprockets for ANSI Roller Chain"));
  }

  @Test
  public void getNumOfTeeth() {
    sprocketANSI1.getNumOfTeeth();
  }

  @Test
  public void getForShaftDiameter() {
    sprocketANSI1.getForShaftDiameter();
  }


  @Test
  public void fitsShaft1() {
    sprocketANSI1.fitsShaft(RotaryShaft1);
    assertEquals(false, sprocketANSI1.fitsShaft(RotaryShaft2));
  }

  @Test(expected = NullValueException.class)
  public void fitsShaft2() throws Exception {
    sprocketANSI1.fitsShaft(null);
  }

  @Test
  public void getShaft() {
    assertEquals(forShftDia1, sprocketANSI1.getShaft());
  }
}