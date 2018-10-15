package edu.neu.ccs.cs5010.assignment2;

import edu.neu.ccs.cs5010.assignment2.InvalidConstructorArgumentsException;
import edu.neu.ccs.cs5010.assignment2.NullValueException;
import edu.neu.ccs.cs5010.assignment2.Price;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class PriceTest {

  private String usd = "$";
  private String rmb = "￥";
  private String crcy = "";
  private String price1Str = "$27.89";
  private Integer priceInCent1 = 2789;
  private Integer priceInCent2 = 5644;
  private Integer priceInCent3 = -3423;
  private Price price1;

  @Before
  public void setUp() throws Exception {
    price1 = new Price(usd, priceInCent1);
  }

  @Test(expected = NullValueException.class)
  public void testPrice1() throws Exception {
    new Price(null, priceInCent1);
    new Price(usd, null);
  }

  @Test(expected = InvalidConstructorArgumentsException.class)
  public void testPrice2() throws Exception {
    new Price(crcy, priceInCent1);
    new Price(usd, priceInCent3);
  }

  @Test
  public void printPrice() {
    //assertEquals(price1Str, price1.printPrice());
    price1.printPrice();
  }


  @Test
  public void getCurrency() {
    price1.getCurrency();
  }

  @Test
  public void setCurrency1() {
    price1.setCurrency(rmb);
  }

  @Test(expected = NullValueException.class)
  public void setCurrency2() {
    price1.setCurrency(null);
  }

  @Test(expected = InvalidConstructorArgumentsException.class)
  public void setCurrency3() {
    price1.setCurrency(crcy);
  }

  @Test
  public void getPriceInCent() throws Exception {
    price1.getPriceInCent();
  }

  //  @Test(expected = InvalidConstructorArgumentsException.class)
  //  public void setPriceInCent2() throws Exception {
  //    price1.setPriceInCent(priceInCent3);
  //  }
  //
  //  @Test(expected = NullValueException.class)
  //  public void setPriceInCent1() throws Exception {
  //    price1.setPriceInCent(null);
  //  }
}