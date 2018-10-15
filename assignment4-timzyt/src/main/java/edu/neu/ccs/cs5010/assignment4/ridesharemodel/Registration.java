package edu.neu.ccs.cs5010.assignment4.ridesharemodel;

import edu.neu.ccs.cs5010.assignment4.exceptions.InvalidConstructorArgumentException;
import edu.neu.ccs.cs5010.assignment4.ridesharemodel.driver.Driver;
import edu.neu.ccs.cs5010.assignment4.ridesharemodel.driver.License;
import edu.neu.ccs.cs5010.assignment4.ridesharemodel.insurance.Insurance;
import edu.neu.ccs.cs5010.assignment4.ridesharemodel.validators.DriverValidator;
import edu.neu.ccs.cs5010.assignment4.ridesharemodel.validators.HistoryValidator;
import edu.neu.ccs.cs5010.assignment4.ridesharemodel.validators.InsuranceValidator;
import edu.neu.ccs.cs5010.assignment4.ridesharemodel.validators.VehicleValidator;
import edu.neu.ccs.cs5010.assignment4.ridesharemodel.vehicle.Vehicle;

import java.time.LocalDate;


/**
 * The Registration class. Serves as one of the ridershare models.
 */
public class Registration {

  private Driver driver;
  private Vehicle vehicle;
  private Insurance insurance;
  private DriverValidator driverValidator;
  private VehicleValidator vehicleValidator;
  private InsuranceValidator insuranceValidator;
  private HistoryValidator historyValidator;

  /**
   * Instantiates a new Registration.
   *
   * @param driver the driver
   * @param insurance the insurance
   * @param vehicle the vehicle
   */
  public Registration(Driver driver, Insurance insurance, Vehicle vehicle) throws Exception {
    if (driver == null) {
      throw new InvalidConstructorArgumentException();
    }
    if (insurance == null) {
      throw new InvalidConstructorArgumentException();
    }
    this.driver = driver;
    this.insurance = insurance;
    this.vehicle = vehicle;
    this.driverValidator = new DriverValidator(this);
    this.vehicleValidator = new VehicleValidator(this);
    this.insuranceValidator = new InsuranceValidator(this);
    this.historyValidator = new HistoryValidator(new DmvRecords(), this);
  }

  /**
   * Sets driver name.
   *
   * @param firstName the first name
   * @param lastName the last name
   */
  public void setDriverName(String firstName, String lastName) throws Exception {
    this.driver.setName(firstName, lastName);
  }

  /**
   * Sets driver birthday.
   *
   * @param date the date
   */
  public void setDriverBirthday(LocalDate date) throws Exception {
    this.driver.setBirthday(date);
  }

  /**
   * Sets driver license.
   *
   * @param license the license
   */
  public void setDriverLicense(License license) throws Exception {
    this.driver.setLicense(license);
  }

  /**
   * Sets insurance.
   *
   * @param insurance the insurance
   */
  public void setInsurance(Insurance insurance) {
    this.insurance = insurance;
  }

  /**
   * Sets vehicle.
   *
   * @param vehicle the vehicle
   */
  public void setVehicle(Vehicle vehicle) {
    this.vehicle = vehicle;
  }

  /**
   * Sets the person in driver seat.
   *
   * @param newDriver the new driver
   */
  public void setPersonInDriverSeat(Driver newDriver) {
    this.vehicle.setPersonInDriverSeat(newDriver);
  }

  /**
   * Gets driver.
   *
   * @return the driver
   */
  public Driver getDriver() {
    return driver;
  }

  /**
   * Gets insurance.
   *
   * @return the insurance
   */
  public Insurance getInsurance() {
    return insurance;
  }

  /**
   * Gets vehicle.
   *
   * @return the vehicle
   */
  public Vehicle getVehicle() {
    return vehicle;
  }

  /**
   * Concludes all the validation results for this registration, returns true if all validations are
   * passes, return false if otherwise.
   *
   * @return the boolean
   */
  public Boolean validateRegistration() {
    if (driverValidator.masterValidator(this)
        && vehicleValidator.masterValidator(this)
        && insuranceValidator.masterValidator(this)
        && historyValidator.masterValidator(this)) {
      return true;
    } else {
      return false;
    }
  }

}
