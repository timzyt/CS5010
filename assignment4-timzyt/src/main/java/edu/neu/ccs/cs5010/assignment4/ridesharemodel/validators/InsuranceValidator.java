package edu.neu.ccs.cs5010.assignment4.ridesharemodel.validators;


import edu.neu.ccs.cs5010.assignment4.ridesharemodel.Registration;

/**
 * The insurance validator class.
 */
public class InsuranceValidator implements MasterValidator {

  private Registration registration;
  private TimeCalculator timeCalculator;

  /**
   * Instantiates a new Insurance validator.
   *
   * @param registration the registration
   */
  public InsuranceValidator(Registration registration) {
    this.registration = registration;
    timeCalculator = new TimeCalculator();
  }

  /**
   * Validate whether the driver is the official owner or being an insured driver.If yes, return
   * true, otherwise return false.
   *
   * @param registration the registration
   * @return the boolean
   */
  public Boolean validateInsuredOwner(Registration registration) {
    return registration.getDriver().equals(registration.getInsurance().getOwner())
        || registration.getInsurance().getInsuredDrivers().contains(registration.getDriver());
  }

  /**
   * Validate whether the insurance is expired.Returns true if the insurance is NOT expired,
   * otherwise return false.
   *
   * @param registration the registration
   * @return the boolean
   */
  public Boolean validateInsuranceExpiration(Registration registration) {
    return this.timeCalculator
        .notPast(registration.getInsurance().getExpirationDate());
  }

  @Override
  public boolean masterValidator(Registration registration) {
    return this.validateInsuredOwner(this.registration)
        && this.validateInsuranceExpiration(this.registration);
  }
}
