package edu.neu.ccs.cs5010.assignment4.ridesharemodel.validators;

import edu.neu.ccs.cs5010.assignment4.ridesharemodel.Registration;

/**
 * The interface master validator.
 */
public interface MasterValidator {

  /**
   * Master validator method, validates based on a given registration.
   *
   * @param registration the registration
   * @return the boolean
   */
  boolean masterValidator(Registration registration);
}
