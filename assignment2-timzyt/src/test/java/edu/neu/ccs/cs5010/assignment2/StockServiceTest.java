package edu.neu.ccs.cs5010.assignment2;

import java.util.HashMap;
import org.junit.Before;
import org.junit.Test;

public class StockServiceTest {
  private HashMap<String, AbstractStockItem> stock;
  private StockService ss1 = new StockService();

  public StockServiceTest() throws Exception {
  }

  @Before
  public void setUp() throws Exception {
    stock = new HashMap<String, AbstractStockItem>();

    stock.put("2302K53", new SprocketForMetricRollerChain("2302K53", 3111, "Metric", 30,
        new Measurement(new Fraction(8, 0, 0), SystemOfMeasurement.Metric)));
    stock.put("6280K443", new SprocketForansiRollerChain("6280K443", 2492, "Inch", 22,
        new Measurement(new Fraction(1, 0, 0), SystemOfMeasurement.Inch)));
    stock.put("6280K524", new SprocketForansiRollerChain("6280K524", 2654, "Inch", 23,
        new Measurement(new Fraction(0, 1, 2), SystemOfMeasurement.Inch)));
    stock.put("6661K13", new PrecisionBallBearing("6661K13", 1598, "Metric", "Shielded",
        new Measurement(new Fraction(8, 0, 0), SystemOfMeasurement.Metric),
        new Measurement(new Fraction(1, 0, 0), SystemOfMeasurement.Metric)));
    stock.put("1482K17", new RotaryShaft("1482K17", 3572, "Metric",
        new Measurement(new Fraction(2000, 0, 0), SystemOfMeasurement.Metric),
        new Measurement(new Fraction(10, 0, 0), SystemOfMeasurement.Metric)));
  }

  @Test
  public void getStock() {
    ss1.getStock();
  }
}