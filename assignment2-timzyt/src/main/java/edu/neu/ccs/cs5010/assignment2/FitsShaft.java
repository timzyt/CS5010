package edu.neu.ccs.cs5010.assignment2;

/**
 * Represents a Stork Item in this program.
 */
public interface FitsShaft {

  /**
   * Evaluations if a given shaft exactly matches this shaft-mounted part with its "for shaft
   * diameter" value.
   *
   * @return boolean.
   */
  boolean fitsShaft(AbstractRotaryShaft abstractRotaryShaft);
}
