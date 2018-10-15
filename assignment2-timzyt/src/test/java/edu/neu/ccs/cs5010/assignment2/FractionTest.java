package edu.neu.ccs.cs5010.assignment2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FractionTest {

  private Integer wNum1 = 2;
  private Integer wNum2 = 1;
  private Integer wNum3 = -2;
  private Integer wNum4 = 0;
  private Integer nume1 = 4;
  private Integer nume2 = 5;
  private Integer nume3 = -3;
  private Integer nume4 = 0;
  private Integer deno1 = 11;
  private Integer deno2 = 13;
  private Integer deno3 = -4;
  private Integer deno4 = 0;
  private Integer deno5 = 1;
  private Integer deno6 = 4;
  private Fraction fraction1;
  private Fraction fraction2;
  private Fraction fraction14;
  private String testString = "123";
  private String zero = "0";
  private String wNum1Str = "2";
  private String fraction1Str = "2 4/11";

  @Before
  public void setUp() throws Exception {
    fraction1 = new Fraction(wNum1, nume1, deno1);
    fraction2 = new Fraction(wNum2, nume2, deno2);

  }

  @Test(expected = InvalidConstructorArgumentsException.class)
  public void testConstructor() throws Exception {
    Fraction fraction3 = new Fraction(wNum3, nume1, deno1);
    Fraction fraction4 = new Fraction(wNum1, nume3, deno1);
    Fraction fraction5 = new Fraction(wNum1, nume1, deno3);
    Fraction fraction6 = new Fraction(wNum1, nume1, deno4);
    Fraction fraction7 = new Fraction(wNum1, nume4, deno1);
    Fraction fraction8 = new Fraction(wNum1, nume2, deno5);
    Fraction fraction9 = new Fraction(wNum1, nume3, deno3);
    Fraction fraction10 = new Fraction(wNum3, nume3, deno3);
    Fraction fraction11 = new Fraction(wNum3, nume3, deno1);
    Fraction fraction12 = new Fraction(wNum3, nume1, deno3);
    Fraction fraction13 = new Fraction(wNum1, nume2, deno6);
    Fraction fraction14 = new Fraction(wNum3, nume1, deno4);
    Fraction fraction15 = new Fraction(wNum3, nume4, deno1);
    fraction8.frac2Str();
    fraction13.frac2Str();
  }

  @Test
  public void getNumerator() {
  }

  @Test
  public void setNumerator() {
  }

  @Test
  public void getDenominator() {
  }

  @Test
  public void setDenominator() {
  }

  @Test
  public void testFrac2Str() {
    fraction1.frac2Str();
  }

  @Test
  public void testFrac2Str2() {
    Fraction fraction10 = new Fraction(wNum4, nume4, deno4);
    assertEquals(zero, fraction10.frac2Str());
    assertEquals(fraction1Str, fraction1.frac2Str());
  }

  @Test
  public void testFrac2Str3() {
    Fraction fraction11 = new Fraction(wNum1, nume4, deno4);
    assertEquals(wNum1.toString(), fraction11.frac2Str());
  }

  @Test
  public void testEquals() {
    System.out.println(fraction1.frac2Str());
    assertTrue(fraction1.equals(fraction1));
    assertFalse(fraction1.equals(testString));
    assertTrue(fraction1.equals(new Fraction(wNum1, nume1, deno1)));
    assertFalse(fraction1.equals(new Fraction(wNum2, nume1, deno1)));
    assertFalse(fraction1.equals(new Fraction(wNum1, nume2, deno1)));
    assertFalse(fraction1.equals(new Fraction(wNum1, nume1, deno2)));
    assertFalse(fraction1.equals(fraction2));
  }

  @Test
  public void testHashCode() {
    assertEquals(fraction1.hashCode(), fraction1.hashCode());

  }
}