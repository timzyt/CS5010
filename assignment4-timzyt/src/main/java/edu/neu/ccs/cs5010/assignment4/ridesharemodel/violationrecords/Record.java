package edu.neu.ccs.cs5010.assignment4.ridesharemodel.violationrecords;

import edu.neu.ccs.cs5010.assignment4.exceptions.InvalidConstructorArgumentException;
import edu.neu.ccs.cs5010.assignment4.ridesharemodel.driver.Driver;
import edu.neu.ccs.cs5010.assignment4.ridesharemodel.vehicle.CrashTypes;
import edu.neu.ccs.cs5010.assignment4.ridesharemodel.vehicle.Vehicle;

import java.time.LocalDate;
import java.util.Objects;

/**
 * The Record class.
 */
public class Record {

  private Integer recordId;
  private Driver driver;
  private Vehicle vehicle;
  private ViolationTypes violationType;
  private boolean isMovingViolation;
  private CrashTypes crashType;
  private LocalDate date;
  private Integer zero = 0;

  /**
   * Instantiates a new Record.
   *
   * @param recordid the Record id
   * @param vehicle the vehicle
   * @param driver the driver
   * @param violationType the violation type
   * @param crashType the crash type
   * @param date the date
   */
  public Record(Integer recordid, Vehicle vehicle, Driver driver,
      ViolationTypes violationType, CrashTypes crashType, LocalDate date) throws Exception {
    if (recordid == null) {
      throw new InvalidConstructorArgumentException();
    }
    if (recordid < zero) {
      throw new InvalidConstructorArgumentException();
    }
    if (vehicle == null) {
      throw new InvalidConstructorArgumentException();
    }
    if (driver == null) {
      throw new InvalidConstructorArgumentException();
    }
    if (violationType == null && crashType == null) {
      throw new InvalidConstructorArgumentException();
    }
    if (date == null) {
      throw new InvalidConstructorArgumentException();
    }
    this.recordId = recordid;
    this.vehicle = vehicle;
    this.driver = driver;
    this.violationType = violationType;
    if (violationType.equals(ViolationTypes.Distracted_driving)
        || violationType.equals(ViolationTypes.Reckless_driving)
        || violationType.equals(ViolationTypes.Speeding)
        || violationType.equals(ViolationTypes.Driving_under_influence)
        || violationType.equals(ViolationTypes.Failure_to_respect_traffic_signs)
        || violationType.equals(ViolationTypes.Driving_without_a_valid_license_and_or_insurance)) {
      this.isMovingViolation = true;
    } else if (violationType.equals(ViolationTypes.Parking_violation)
        || violationType.equals(ViolationTypes.Paperwork_issues)
        || violationType.equals(ViolationTypes.Problems_with_the_vehicle)) {
      this.isMovingViolation = false;
    }
    this.crashType = crashType;
    this.date = LocalDate.of(date.getYear(), date.getMonth(), date.getDayOfMonth());
  }


  /**
   * Gets Record id.
   *
   * @return the Record id
   */
  public Integer gerRecordId() {
    return recordId;
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
   * Gets driver.
   *
   * @return the driver
   */
  public Driver getDriver() {
    return driver;
  }

  /**
   * Gets violation type for the driver.
   *
   * @return the violation type
   */
  public ViolationTypes getViolationType() {
    return violationType;
  }

  /**
   * Returns if the violation is a moving violation. Returns yes if the violation is a moving
   * violation, return no if not.
   *
   * @return the boolean
   */
  public boolean isMovingViolationTrue() {
    return isMovingViolation;
  }

  /**
   * Gets crash type for the vehicle.
   *
   * @return the crash type
   */
  public CrashTypes getCrashType() {
    return crashType;
  }

  /**
   * Gets date of the Record.
   *
   * @return the date
   */
  public LocalDate getDate() {
    LocalDate queryDate = LocalDate
        .of(this.date.getYear(), this.date.getMonth(), this.date.getDayOfMonth());
    return queryDate;
  }


  @Override
  public String toString() {
    return "Record{"
        + "\nrecordId = " + recordId
        + ",\nvehicle = " + vehicle.getColor() + " " + vehicle.getYear() + " " + vehicle.getMake()
        + " " + vehicle.getModel()
        + ",\ndriver = " + driver.getName().getFirstName() + " " + driver.getName().getLastName()
        + ",\nviolationType = " + violationType.toString()
        + ",\nisMovingViolationTrue = " + isMovingViolation
        + ",\ncrashType = " + crashType.toString()
        + " }";
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof Record)) {
      return false;
    }
    Record record = (Record) obj;
    return isMovingViolationTrue() == record.isMovingViolationTrue()
        && Objects.equals(gerRecordId(), record.gerRecordId())
        && Objects.equals(getVehicle(), record.getVehicle())
        && Objects.equals(getDriver(), record.getDriver())
        && getViolationType() == record.getViolationType()
        && getCrashType() == record.getCrashType();
  }

  @Override
  public int hashCode() {
    return Objects
        .hash(gerRecordId(), getVehicle(), getDriver(), getViolationType(), isMovingViolationTrue(),
            getCrashType());
  }
}
