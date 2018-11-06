package edu.neu.ccs.cs5010.simplecalculator.exceptions;

public class InvalidDenominatorException extends RuntimeException{
  public InvalidDenominatorException() {
    super("Denominator cannot be zero!");
  }
}
