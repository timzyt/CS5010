package edu.neu.ccs.cs5010.assignment4.ridesharemodel.validators;

import edu.neu.ccs.cs5010.assignment4.ridesharemodel.Registration;
import edu.neu.ccs.cs5010.assignment4.ridesharemodel.driver.Country;


/**
 * The driver validator class.
 */
public class DriverValidator implements MasterValidator {

  private Registration registration;
  private TimeCalculator timeCalculator;
  private Integer legalDrivingAge;
  private Integer legalLicenseMonth;
  private Integer zero = 0;

  /**
   * Instantiates a new driver validator.
   *
   * @param registration the registration
   */
  public DriverValidator(Registration registration) {
    this.registration = registration;
    timeCalculator = new TimeCalculator();
    legalDrivingAge = 21;
    legalLicenseMonth = 6;
  }

  /**
   * Validates whether the prospective driver is over legal age (older than 21). If not, the
   * prospective driver should not be accepted as a driver.
   *
   * @param registration the registration
   * @return the boolean
   */
  public Boolean validateAge(Registration registration) {
    return this.timeCalculator.calculateYear(registration.getDriver().getBirthday())
        >= legalDrivingAge;
  }

  /**
   * Validates whether the prospective driver's name matches the name on the license. If not, the
   * prospective driver should not be accepted as a driver.
   *
   * @param registration the registration.
   * @return the boolean
   */
  public Boolean validateName(Registration registration) {
    return registration.getDriver().getName()
        .equals(registration.getDriver().getLicense().getName());
  }

  /**
   * Validates whether the prospective driver's birthday matches the birthday on the license. If
   * not, the prospective driver should not be accepted as a driver.
   *
   * @param registration the registration
   * @return the boolean
   */
  public Boolean validateBirthday(Registration registration) {
    return registration.getDriver().getBirthday()
        .equals(registration.getDriver().getLicense().getBirthday());
  }

  /**
   * Validates if the country of issuance on the prospective driver's license is either US or
   * Canada.If not, the prospective driver should not be accepted as a driver.
   *
   * @param registration the registration
   * @return the boolean
   */
  public Boolean validateCountryOfIssuance(Registration registration) {
    Country issueCountry = registration.getDriver().getLicense().getIssueCountry();
    return issueCountry.equals(Country.Canada) || issueCountry.equals(Country.US);
  }

  /**
   * Validates if the prospective driver's license is issued within 6 months. If yes, the
   * prospective driver should not be accepted as a driver
   *
   * @param registration the registration
   * @return the boolean
   */
  public Boolean validateLicenseDateOfIssuance(Registration registration) {
    if (this.timeCalculator.calculateYear(registration.getDriver().getLicense().getIssueDate())
        == zero) {
      return
          this.timeCalculator.calculateMonth(registration.getDriver().getLicense().getIssueDate())
              >= legalLicenseMonth;
    } else {
      return true;
    }
  }

  /**
   * Validates whether the prospective driver's license is expired. If yes, the prospective driver
   * should not be accepted as a driver.
   *
   * @param registration the registration
   * @return the boolean
   */
  public Boolean vaidateLicenseExpiration(Registration registration) {
    return this.timeCalculator
        .notPast(registration.getDriver().getLicense().getExpirationDate());
  }


  /**
   * Performs overall validation for the prospective driver. If fails, the prospective driver should
   * not be accepted as a driver.
   *
   * @return boolean value of the validation.
   */
  @Override
  public boolean masterValidator(Registration registration) {
    return this.validateAge(this.registration)
        && this.validateName(this.registration)
        && this.validateBirthday(this.registration)
        && this.validateCountryOfIssuance(this.registration)
        && this.validateLicenseDateOfIssuance(this.registration)
        && this.vaidateLicenseExpiration(this.registration);
  }
}
