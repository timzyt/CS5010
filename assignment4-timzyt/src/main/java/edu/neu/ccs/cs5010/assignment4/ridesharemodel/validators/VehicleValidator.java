package edu.neu.ccs.cs5010.assignment4.ridesharemodel.validators;


import edu.neu.ccs.cs5010.assignment4.ridesharemodel.Registration;

import java.time.LocalDate;

/**
 * The type Vehicle validator.
 */
public class VehicleValidator implements MasterValidator {

  private Registration registration;
  private Integer legalVehicleAge;

  /**
   * Instantiates a new Vehicle validator.
   *
   * @param registration the registration
   */
  public VehicleValidator(Registration registration) {
    this.registration = registration;
    legalVehicleAge = 15;
  }


  /**
   * Validate whether the vehicle is older than 15 years. If yes,the prospective driver should not
   * be accepted as a driver. this method returns true if the vehicle is less than 15 years old.
   * otherwise returns false.
   *
   * @param registration the registration
   * @return the boolean
   */
  public Boolean validateVehicleAge(Registration registration) {
    Integer diff = LocalDate.now().getYear() - registration.getVehicle().getYear();
    if (diff <= this.legalVehicleAge) {
      return true;
    } else {
      return false;
    }
  }


  @Override
  public boolean masterValidator(Registration registration) {
    return this.validateVehicleAge(this.registration);
  }
}
