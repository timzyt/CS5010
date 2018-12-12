package edu.neu.ccs.cs5010.assignment7.sequential.exception;

import java.io.IOException;

public class IllegalThresholdException extends IOException {

  public IllegalThresholdException(String message) {
    super(message);
  }
}
