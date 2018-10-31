package edu.neu.ccs.cs5010.simpleCalculator.Exceptions;

public class InvalidDenominatorException extends RuntimeException{
  public InvalidDenominatorException() {
    super("Denominator cannot be zero!");
  }
}
