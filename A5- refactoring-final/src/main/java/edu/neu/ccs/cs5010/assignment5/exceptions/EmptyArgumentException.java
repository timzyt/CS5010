package edu.neu.ccs.cs5010.assignment5.exceptions;

public class EmptyArgumentException extends RuntimeException {
  public EmptyArgumentException(String message) {
    super(message);
  }
}
