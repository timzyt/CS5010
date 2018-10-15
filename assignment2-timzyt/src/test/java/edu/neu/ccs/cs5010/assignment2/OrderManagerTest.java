package edu.neu.ccs.cs5010.assignment2;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;

public class OrderManagerTest {

  private OrderManager om;
  private OrderManager om2;
  private OrderManager om3;
  private OrderManager om4;
  private HashMap<String, Integer> newOrder;
  private HashMap<String, Integer> nullOrder;
  private HashMap<String, Integer> emptyOrder;
  private StockService ss;
  private HashMap<String, AbstractStockItem> newStock;
  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
  private final PrintStream originalOut = System.out;

  private String sku0;
  private String sku00 = "";
  private String sku1 = "2302K85";
  private String sku2 = "1482K17";
  private String sku3 = "2302K86";
  private String sku4 = "6280K443";
  private String sku5 = "2302K67";
  private String sku6 = "6280K525";
  private String sku7 = "1482K17";
  private Integer one = 1;
  private Integer two = 2;

  @Before
  public void setUpStreams() {
    System.setOut(new PrintStream(outContent));
  }

  @Before
  public void setUp() throws Exception {

    newStock = new HashMap<String, AbstractStockItem>();
    newStock.put("2302K85", new SprocketForMetricRollerChain("2302K85", 2916, "Metric", 40,
        new Measurement(new Fraction(10, 0, 0), SystemOfMeasurement.Metric)));
    newStock.put("2302K67", new SprocketForMetricRollerChain("2302K67", 939, "Metric", 8,
        new Measurement(new Fraction(5, 0, 0), SystemOfMeasurement.Metric)));
    newStock.put("6280K443", new SprocketForansiRollerChain("6280K443", 2492, "Inch", 22,
        new Measurement(new Fraction(1, 0, 0), SystemOfMeasurement.Inch)));
    newStock.put("6280K524", new SprocketForansiRollerChain("6280K524", 2654, "Inch", 23,
        new Measurement(new Fraction(0, 1, 2), SystemOfMeasurement.Inch)));
    newStock.put("6661K13", new PrecisionBallBearing("6661K13", 1598, "Metric", "Shielded",
        new Measurement(new Fraction(8, 0, 0), SystemOfMeasurement.Metric),
        new Measurement(new Fraction(1, 0, 0), SystemOfMeasurement.Metric)));
    newStock.put("1482K17", new RotaryShaft("1482K17", 3572, "Metric",
        new Measurement(new Fraction(2000, 0, 0), SystemOfMeasurement.Metric),
        new Measurement(new Fraction(10, 0, 0), SystemOfMeasurement.Metric)));

    ss = new StockService();
    ss.setStock(newStock);
    newOrder = new HashMap<String, Integer>();
    emptyOrder = new HashMap<>();
    om = new OrderManager();
    om2 = new OrderManager();
    om3 = new OrderManager();
    om4 = new OrderManager();
    om.setOrder(newOrder);
    om.setStockService(ss);
    om.setOrder(newOrder);

  }

  @After
  public void restoreStreams() {
    System.setOut(originalOut);
  }

  @Test(expected = NullValueException.class)
  public void addToOrder() {
    om.addToOrder(sku0);
  }

  @Test(expected = InvalidConstructorArgumentsException.class)
  public void addToOrder2() {
    om2.addToOrder(sku00);
  }

  @Test
  public void addToOrder3() {
    om.addToOrder(sku2);
    assertEquals(one, om.getOrder().get(sku2));
  }

  @Test
  public void addToOrder4() {
    om.addToOrder(sku1);
    om.addToOrder(sku1);
    assertEquals(two, om.getOrder().get(sku1));
  }

  @Test
  public void addToOrder5() {
    om.addToOrder(sku3);
  }

  @Test(expected = NullValueException.class)
  public void removeOneFromOrder2() {
    om.removeOneFromOrder(sku0);
  }

  @Test(expected = InvalidConstructorArgumentsException.class)
  public void removeOneFromOrder3() {
    om.removeOneFromOrder(sku00);
  }

  @Test
  public void removeOneFromOrder4() {
    om.removeOneFromOrder(sku1);
  }

  @Test
  public void removeOneFromOrder5() {
    om.addToOrder(sku1);
    om.removeOneFromOrder(sku1);
    om.getOrder().get(sku1);
  }

  @Test(expected = NullValueException.class)
  public void validateMeasurementSystem() {
    om3.setOrder(nullOrder);
    om3.validateMeasurementSystem();
  }

  @Test(expected = InvalidHashMapKeyException.class)
  public void validateMeasurementSystem2() {
    om.validateMeasurementSystem();
  }

  @Test
  public void validateMeasurementSystem3() {
    om.addToOrder(sku1);
    om.addToOrder(sku2);
    om.addToOrder(sku4);
    System.out.println(om.validateMeasurementSystem());
  }

  @Test
  public void validateMeasurementSystem4() {
    om.addToOrder(sku1);
    om.addToOrder(sku2);
    System.out.println(om.validateMeasurementSystem());
  }

  @Test(expected = NullValueException.class)
  public void validateMeasurementSystem5() {
    om.addToOrder(sku0);
    om.addToOrder(sku0);
    System.out.println(om.validateMeasurementSystem());
  }

  @Test(expected = NullValueException.class)
  public void filterByMeasurementSystem() {
    om3.setOrder(nullOrder);
    om3.filterByMeasurementSystem("Metric");
  }

  @Test(expected = NullValueException.class)
  public void filterByMeasurementSystem2() {
    om.addToOrder(sku1);
    om.addToOrder(sku2);
    om.filterByMeasurementSystem(null);
  }

  @Test(expected = InvalidConstructorArgumentsException.class)
  public void filterByMeasurementSystem3() {
    om.filterByMeasurementSystem("");
  }

  @Test
  public void filterByMeasurementSystem5() {
    om.addToOrder(sku1);
    om.addToOrder(sku2);
    om.filterByMeasurementSystem("Metric");
  }

  @Test
  public void filterByMeasurementSystem6() {
    om.addToOrder(sku1);
    om.addToOrder(sku2);
    om.addToOrder(sku4);
    om.filterByMeasurementSystem("Metric");
  }

  @Test(expected = NullValueException.class)
  public void orderCategory() {
    om3.setOrder(nullOrder);
    om3.orderCategory();
  }

  @Test(expected = InvalidHashMapKeyException.class)
  public void orderCategory2() {
    om.orderCategory();
  }

  @Test
  public void orderCategory3() {
    om.addToOrder(sku1);
    om.addToOrder(sku2);
    String result = om.orderCategory();
    System.out.println(om.getOrder().size());
    System.out.println(result);
  }

  @Test
  public void orderCategory4() {
    om.addToOrder(sku1);
    om.addToOrder(sku5);
    String result = om.orderCategory();
  }

  @Test(expected = NullValueException.class)
  public void printDocket() {
    om3.setOrder(nullOrder);
    om3.printDocket();
  }

  @Test(expected = InvalidHashMapKeyException.class)
  public void printDocket2() {
    om.printDocket();
  }

  @Test
  public void printDocket3() {
    om.addToOrder(sku1);
    om.addToOrder(sku2);
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    om.printDocket();
    String expectedOutput = "Rotary Shaft 1482K17 $35.72\r\nSprockets for Metric Roller Chain 2302K85 $29.16\r\n$64.88";
    assertEquals(expectedOutput, outContent.toString());
  }

  @Test(expected = NullValueException.class)
  public void checkFit() {
    om.checkFit(sku0, sku0);
  }

  @Test(expected = InvalidConstructorArgumentsException.class)
  public void checkFit2() {
    om.checkFit(sku00, sku00);
  }

  @Test
  public void checkFit3() {
    om.checkFit(sku1, sku3);
    String expectedOutput = "No item in the stock matches provided SKU# 2302K86.\r\n";
    assertEquals(expectedOutput, outContent.toString());
  }

  @Test
  public void checkFit4() {
    om.checkFit(sku3, sku1);
    String expectedOutput = "No item in the stock matches provided SKU# 2302K86.\r\n";
    assertEquals(expectedOutput, outContent.toString());
  }

  @Test
  public void checkFit5() {
    om.checkFit(sku3, sku6);
    String expectedOutput = "No item in the stock matches provided SKU# 2302K86 and 6280K525.\r\n";
    assertEquals(expectedOutput, outContent.toString());
  }

  @Test
  public void checkFit6() {
    om.checkFit(sku7, sku7);
    String expectedOutput = "Not a shaft/shaft-mounted pair.\r\n";
    assertEquals(expectedOutput, outContent.toString());
  }

  @Test
  public void checkFit7() {
    om.checkFit(sku4, sku5);
    String expectedOutput = "Not a shaft/shaft-mounted pair.\r\n";
    assertEquals(expectedOutput, outContent.toString());
  }

  @Test
  public void checkFit8() {
    om.checkFit(sku7, sku1);
    assertEquals(ss.getStock().get(sku1).getShaft(),ss.getStock().get(sku7).getShaft());
  }

  @Test
  public void checkFit9() {
    om.checkFit(sku7, sku5);
    String expectedOutput = "Sprockets for Metric Roller Chain SKU# 2302K67 for 5mm shaft does not fit on Rotary Shafts SKU# 1482K17\r\n";
    assertEquals(expectedOutput, outContent.toString());
  }

  @Test
  public void checkFit10() {
    om.checkFit(sku7, sku4);
    String expectedOutput = "System of Measurement don't match.\r\n";
    assertEquals(expectedOutput, outContent.toString());
  }

  @Test(expected = NullValueException.class)
  public void checkFit11() {
    om.checkFit(sku0, sku1);
  }

  @Test(expected = NullValueException.class)
  public void checkFit12() {
    om.checkFit(sku1, sku0);
  }

  @Test(expected = InvalidConstructorArgumentsException.class)
  public void checkFit14() {
    om.checkFit(sku1, sku00);
  }

  @Test(expected = InvalidConstructorArgumentsException.class)
  public void checkFit15() {
    om.checkFit(sku00, sku1);
  }

}