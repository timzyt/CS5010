package edu.neu.ccs.cs5010.assignment4.exceptions;

public class InvalidConstructorArgumentException extends RuntimeException{
  public InvalidConstructorArgumentException() {
    super("Provided input is invalid.");
  }
}
