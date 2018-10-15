package edu.neu.ccs.cs5010.assignment4.ridesharemodel.validators;

import edu.neu.ccs.cs5010.assignment4.ridesharemodel.DmvRecords;
import edu.neu.ccs.cs5010.assignment4.ridesharemodel.Registration;
import edu.neu.ccs.cs5010.assignment4.ridesharemodel.driver.Driver;
import edu.neu.ccs.cs5010.assignment4.ridesharemodel.vehicle.CrashTypes;
import edu.neu.ccs.cs5010.assignment4.ridesharemodel.vehicle.Vehicle;
import edu.neu.ccs.cs5010.assignment4.ridesharemodel.violationrecords.Record;
import edu.neu.ccs.cs5010.assignment4.ridesharemodel.violationrecords.ViolationTypes;

import java.time.LocalDate;

/**
 * The history validator class.
 */
public class HistoryValidator implements MasterValidator {

  private DmvRecords dmvRecords;
  private Registration registration;
  private TimeCalculator timeCalculator;
  private Integer legalViolationRecordTime = 6;
  private Integer zero = 0;

  /**
   * Instantiates a new History validator.
   *
   * @param dmvRecords the dmv records
   * @param registration the registration
   */
  public HistoryValidator(
      DmvRecords dmvRecords, Registration registration) {
    timeCalculator = new TimeCalculator();
    this.dmvRecords = dmvRecords;
    this.registration = registration;
  }

  /**
   * Validates if the driver is free of any moving violation Record.
   * If the driver has no moving
   * violation record then return true, and the driver can be accepted as a driver.
   * If the driver
   * does have any moving violation record,
   * AND being one of the below four specified violation
   * types,
   * - Reckless Driving
   * - Speeding
   * - DUI
   * - Driving with a valid license/insurance
   * then return false, and prospective driver should not be accepted as a driver.
   *
   * @param driver the prospective driver.
   * @return the boolean.
   */
  public Boolean validateDriverHistory(Driver driver) {
    if (this.dmvRecords.isDriverInDmvRecord(driver)) {
      for (Record record
          : this.dmvRecords.getAllRecordsByDriver(driver)) {
        if (record.isMovingViolationTrue()) {
          ViolationTypes driverViolation = record.getViolationType();
          if (driverViolation.equals(ViolationTypes.Reckless_driving)
              || driverViolation.equals(ViolationTypes.Speeding)
              || driverViolation.equals(ViolationTypes.Driving_under_influence)
              || driverViolation
              .equals(ViolationTypes.Driving_without_a_valid_license_and_or_insurance)) {
            return false;
          }
        }
      }
    }
    return true;
  }

  /**
   * Validates if the vehicle provided by the prospective driver has any crash Record within last
   * six months.
   * If yes return false, and the prospective driver should not be accepted as a driver,
   * otherwise return true, and the driver can be accepted as a driver.
   *
   * @param vehicle the vehicle.
   * @return the boolean.
   */
  public Boolean validateVehicleHistory(Vehicle vehicle) {
    if (this.dmvRecords.isVehicleInDmvRecord(vehicle)) {
      for (Record record
          : this.dmvRecords.getAllRecordsByVehicle(vehicle)) {
        LocalDate incidentDate = record.getDate();
        CrashTypes crash = record.getCrashType();
        Boolean isMovingViolation = record.isMovingViolationTrue();
        if ((timeCalculator.calculateYear(incidentDate) == zero
            && timeCalculator.calculateMonth(incidentDate) <= legalViolationRecordTime)
            && (crash != null || isMovingViolation)) {
          return false;
        }
      }
    }
    return true;
  }

  //  /**
  //   * Validates if there is any valid vehicle from all the vehicles provided by the driver.
  //   * return true if the driver doesn't provide any vehicle,
  //   * or at least vehicle provided is valid.
  //   * @param vehicles the list of vehicles provided by the driver.
  //   * @return the boolean.
  //   */
  //  public Boolean validateVehicleListHistory(ArrayList<Vehicle> vehicles) {
  //    // if the driver provides no vehicle, this validation should return true.
  //    if (vehicles.isEmpty()) {
  //      return true;
  //    }
  //    //if the driver provides at least one vehicle,
  //    //as long as one vehicle is valid, the validation should return true;
  //    //in another word, only when all vehicles provided the driver are deemed invalid,
  //    //would this driver be rejected.
  //    for (Vehicle vehicle : vehicles) {
  //      if (this.validateVehicleHistory(vehicle)) {
  //        return true;
  //      }
  //    }
  //    return false;
  //  }

  @Override
  public boolean masterValidator(Registration registration) {
    return this.validateDriverHistory(this.registration.getDriver())
        && this.validateVehicleHistory(this.registration.getVehicle());
  }
}
