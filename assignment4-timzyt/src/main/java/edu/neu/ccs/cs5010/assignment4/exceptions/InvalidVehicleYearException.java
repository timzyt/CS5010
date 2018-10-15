package edu.neu.ccs.cs5010.assignment4.exceptions;

public class InvalidVehicleYearException extends RuntimeException{
  public InvalidVehicleYearException() {
    super("Provided vehicle year is invalid.");
  }
}
