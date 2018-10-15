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
import java.util.Objects;


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
    if (firstName == null) {
      throw new InvalidConstructorArgumentException();
    }
    if (lastName == null) {
      throw new InvalidConstructorArgumentException();
    }
    this.driver.setName(firstName, lastName);
  }

  /**
   * Sets driver birthday.
   *
   * @param date the date
   */
  public void setDriverBirthday(LocalDate date) throws Exception {
    if (date == null) {
      throw new InvalidConstructorArgumentException();
    }
    this.driver.setBirthday(date);
  }

  /**
   * Sets driver license.
   *
   * @param license the license
   */
  public void setDriverLicense(License license) throws Exception {
    if (license == null) {
      throw new InvalidConstructorArgumentException();
    }
    this.driver.setLicense(license);
  }

  /**
   * Sets insurance.
   *
   * @param insurance the insurance
   */
  public void setInsurance(Insurance insurance) throws Exception {
    if (insurance == null) {
      throw new InvalidConstructorArgumentException();
    }
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

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Registration that = (Registration) obj;
    return Objects.equals(driver, that.driver)
        && Objects.equals(vehicle, that.vehicle)
        && Objects.equals(insurance, that.insurance);
  }

  @Override
  public int hashCode() {
    return Objects
        .hash(driver, vehicle, insurance);
  }


  @Override
  public String toString() {
    return "new registration{"
        + "\nowner = " + driver.getName().getFirstName() + " " + driver.getName().getLastName()
        + ",\nvehicle = " + vehicle.getColor() + " " + vehicle.getYear() + " " + vehicle.getMake()
        + " " + vehicle.getModel()
        + ",\ninsurance = expiration date: " + insurance.getExpirationDate()
        + " }";
  }
}
