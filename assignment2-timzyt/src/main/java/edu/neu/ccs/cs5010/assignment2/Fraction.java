package edu.neu.ccs.cs5010.assignment2;

import java.util.Objects;

/**
 * The class Fraction.
 *
 * @author timzyt. created on 2018/09/21.
 */
public class Fraction {

  private int wholeNumber;
  private int numerator;
  private int denominator;

  /**
   * Constructs and instantiates a fraction.
   *
   * @param wnum whole number of a fraction.
   * @param nume numerator of a fraction.
   * @param deno denominator of a fraction.
   */
  public Fraction(int wnum, int nume, int deno) {
    if (wnum < 0 || deno < 0 || nume < 0 || (deno != 0 && nume == 0) || (deno == 0 && nume != 0)
        || (deno != 0 && nume != 0 && deno <= nume)) {
      throw new InvalidConstructorArgumentsException("Provided fraction input is invalid..");
    } else {
      this.wholeNumber = wnum;
      this.numerator = nume;
      this.denominator = deno;
    }
  }

  /**
   * get the numerator for this fraction.
   *
   * @return the numerator for this fraction.
   */
  public int getWholeNumber() {
    return this.wholeNumber;
  }

  /**
   * get the numerator for this fraction.
   *
   * @return the numerator for this fraction.
   */
  public int getNumerator() {
    return this.numerator;
  }

  /**
   * get the denominator for this fraction.
   *
   * @return the denominator for this fraction.
   */
  public int getDenominator() {
    return this.denominator;
  }

  /**
   * Frac 2 str string.
   *
   * @return the string
   */
  public String frac2Str() {
    StringBuffer printFraction = new StringBuffer();
    if (this.wholeNumber == 0 & this.numerator == 0 & this.denominator == 0) {
      return "0";
    } else if (this.wholeNumber != 0 & (this.numerator == 0 & this.denominator == 0)) {
      printFraction.append(this.wholeNumber);
    } else {
      printFraction.append(this.wholeNumber).append(" ").append(this.numerator).append("/")
          .append(this.denominator);
    }
    return printFraction.toString();
  }

  /***************************************************************************************
   * equals and hashCode methods.
   *
   * @param obj object.
   * @return boolean.
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof Fraction)) {
      return false;
    }
    Fraction fraction = (Fraction) obj;
    return getWholeNumber() == fraction.getWholeNumber()
        && getNumerator() == fraction.getNumerator()
        && getDenominator() == fraction.getDenominator();
  }

  @Override
  public int hashCode() {
    return Objects.hash(getWholeNumber(), getNumerator(), getDenominator());
  }
}

