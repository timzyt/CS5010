package edu.neu.ccs.cs5010.assignment2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SprocketForMetricRollerChainTest {

  private String sku1 = "2302K113";
  private String sku2 = "1482K11";
  private String usd = "$";
  private Integer priceInCent1 = 6653;
  private Integer priceInCent2 = 6887;
  private Integer numOfTh1 = 27;
  private SystemOfMeasurement metric = SystemOfMeasurement.Metric;
  private SystemOfMeasurement inch = SystemOfMeasurement.Inch;
  private String Metric = "Metric";
  private String category = "Sprockets for Metric Roller Chain";
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
  private SprocketForMetricRollerChain sprocketMetric1;
  private RotaryShaft RotaryShaft1;
  private RotaryShaft RotaryShaft2;


  @Before
  public void setUp() throws Exception {
    diameter1 = new Measurement(new Fraction(diaValue1, zero, zero), metric);
    length1 = new Measurement(new Fraction(lenValue1, zero, zero), metric);
    forShftDia1 = new Measurement(new Fraction(diaValue1, zero, zero), metric);
    price1 = new Price(usd, priceInCent1);
    sprocketMetric1 = new SprocketForMetricRollerChain(sku1, priceInCent1, Metric, numOfTh1,
        forShftDia1);
    RotaryShaft1 = new RotaryShaft(sku2, priceInCent2, Metric, length1, diameter1);
  }

  @Test
  public void getCategory() {
    assertEquals(category, sprocketMetric1.getCategory());
  }

  @Test
  public void getShaft() {
    assertEquals(forShftDia1, sprocketMetric1.getShaft());
  }
}