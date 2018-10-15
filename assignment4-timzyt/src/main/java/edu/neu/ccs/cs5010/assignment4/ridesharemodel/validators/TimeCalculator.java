package edu.neu.ccs.cs5010.assignment4.ridesharemodel.validators;

import java.time.LocalDate;
import java.time.Period;


/**
 * The type Time calculator.
 */
public class TimeCalculator {


  /**
   * Instantiates a new Time calculator.
   */
  public TimeCalculator() {

  }

  /**
   * Calculate age based on the given date.
   *
   * @param date the date
   * @return age number
   */
  public int calculateYear(LocalDate date) {
    LocalDate now = LocalDate.now();
    LocalDate targetDate = LocalDate.of(date.getYear(), date.getMonth(), date.getDayOfMonth());
    return Period.between(targetDate, now).getYears();
  }

  /**
   * Calculate month based on the given date.
   *
   * @param date the date
   * @return number of month
   */
  public int calculateMonth(LocalDate date) {
    LocalDate now = LocalDate.now();
    LocalDate targetDate = LocalDate.of(date.getYear(), date.getMonth(), date.getDayOfMonth());
    return Period.between(targetDate, now).getMonths();
  }

  /**
   * Check whether it has passed the expiration date, returns true if the expiration date has NOT
   * been passed, returns false if otherwise.
   *
   * @param date the date
   * @return the boolean
   */
  public boolean notPast(LocalDate date) {
    LocalDate now = LocalDate.now();
    LocalDate targetDate = LocalDate.of(date.getYear(), date.getMonth(), date.getDayOfMonth());
    return targetDate.isAfter(now);
  }
}
