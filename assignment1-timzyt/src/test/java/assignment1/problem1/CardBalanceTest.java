package assignment1.problem1;

import static org.junit.Assert.*;

import java.util.Objects;
import org.junit.Before;
import org.junit.Test;

public class CardBalanceTest {

  private Integer dollar = 10;
  private Integer dollar2 = -20;
  private Integer dollar3 = 10;
  private Integer cent = 123;
  private Integer cent2 = 25;
  private Integer cent3 = 123;
  private CardBalance cardBalance;
  private CardBalance cardBalance2;

  @Before
  public void setUp() throws Exception {
    cardBalance = new CardBalance(dollar, cent);
    cardBalance2 = new CardBalance(dollar3, cent3);
  }

  @Test
  public void setCent() {
    try {
      cardBalance.setCent(cent);
      assertEquals(cent, cardBalance.getCent());
    } catch (Exception e) {
      final String msg = "cent of card balance out of range";
      assertEquals(msg, e.getMessage());
      System.out.println(e.getMessage());
    }
  }

  @Test
  public void setCent2() {
    cardBalance.setCent(cent2);
    assertEquals(cent2, cardBalance.getCent());
  }

  @Test
  public void getCent() {
    assertEquals(cent, cardBalance.getCent());
  }

  @Test
  public void setDollar() {
    cardBalance.setDollar(dollar);
    assertEquals(dollar, cardBalance.getDollar());
  }

  @Test
  public void setDollar2() {
    try {
      cardBalance.setDollar(dollar2);
      assertEquals(dollar2, cardBalance.getDollar());
    } catch (Exception e) {
      final String msg = "dollar of card balance out of range";
      assertEquals(msg, e.getMessage());
      System.out.println(e.getMessage());
    }
  }

  @Test
  public void getDollar() {
    assertEquals(dollar, cardBalance.getDollar());
  }

  @Test
  public void testEqual() {
    assertTrue(cardBalance.equals(cardBalance));
    assertTrue(cardBalance.equals(cardBalance2));
    assertTrue(cardBalance.equals(null));
  }

  @Test
  public void testHashCode() {
    assertEquals(cardBalance.hashCode(), Objects.hash(dollar, cent));
  }
}