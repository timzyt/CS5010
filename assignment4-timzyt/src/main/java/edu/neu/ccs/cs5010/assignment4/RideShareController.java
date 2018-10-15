package edu.neu.ccs.cs5010.assignment4;

import edu.neu.ccs.cs5010.assignment4.ridesharemodel.DmvRecords;
import edu.neu.ccs.cs5010.assignment4.ridesharemodel.DriverPool;
import edu.neu.ccs.cs5010.assignment4.ridesharemodel.Registration;
import edu.neu.ccs.cs5010.assignment4.ridesharemodel.driver.Driver;
import edu.neu.ccs.cs5010.assignment4.ridesharemodel.driver.License;
import edu.neu.ccs.cs5010.assignment4.ridesharemodel.insurance.Insurance;
import edu.neu.ccs.cs5010.assignment4.ridesharemodel.vehicle.Vehicle;
import edu.neu.ccs.cs5010.assignment4.ridesharemodel.violationrecords.Record;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * The rideshare controller class.
 */
public class RideShareController {

  private Registration registration;
  private DriverPool driverPool;
  private DmvRecords dmvRecords;
  private RiderShareView view;

  /**
   * Instantiates a new Ride share controller.
   *
   * @param registration the registration
   * @param driverPool the driver pool
   * @param dmvRecords the dmv records
   * @param view the view
   */
  public RideShareController(Registration registration, DriverPool driverPool,
      DmvRecords dmvRecords, RiderShareView view) {
    this.registration = registration;
    this.driverPool = driverPool;
    this.dmvRecords = dmvRecords;
    this.view = view;
  }

  /**
   * Sets driver name.
   *
   * @param firstName the first name
   * @param lastName the last name
   */
  public void setDriverName(String firstName, String lastName) throws Exception {
    this.registration.setDriverName(firstName, lastName);
  }

  /**
   * Sets driver birthday.
   *
   * @param date the date
   */
  public void setDriverBirthday(LocalDate date) throws Exception {
    this.registration.setDriverBirthday(date);
  }

  /**
   * Sets driver license.
   *
   * @param license the license
   */
  public void setDriverLicense(License license) throws Exception {
    this.registration.setDriverLicense(license);
  }

  /**
   * Sets insurance.
   *
   * @param insurance the insurance
   */
  public void setInsurance(Insurance insurance) throws Exception {
    this.registration.setInsurance(insurance);
  }

  /**
   * Sets vehicle.
   *
   * @param vehicle the vehicle
   */
  public void setVehicle(Vehicle vehicle) throws Exception {
    this.registration.setVehicle(vehicle);
  }

  /**
   * Gets driver.
   */
  public Driver getDriver() {
    return this.registration.getDriver();
  }

  /**
   * Gets vehicle.
   */
  public Vehicle getVehicle() {
    return this.registration.getVehicle();
  }

  /**
   * Gets insurance.
   */
  public Insurance getInsurance() {
    return this.registration.getInsurance();
  }

  /**
   * Gets driver Record.
   *
   * @param newDriver the new driver
   */
  public HashSet<Record> getDriverRecord(Driver newDriver) {
    return this.dmvRecords.getAllRecordsByDriver(newDriver);
  }

  /**
   * Gets vehicle Record.
   *
   * @param newVehicle the new vehicle
   */
  public HashSet<Record> getVehicleRecord(Vehicle newVehicle) {
    return this.dmvRecords.getAllRecordsByVehicle(newVehicle);
  }

  /**
   * Add new driver.
   *
   * @param registration the registration
   */
  public void addNewDriver(Registration registration) {
    this.driverPool.masterValidator(registration);
  }

  /**
   * Provide driver info.
   *
   * @param lastName the last name
   */
  public void provideDriverInfo(String lastName) {
    ArrayList<Driver> driverList = this.driverPool.findDriverList(lastName);
    HashMap<Driver, HashSet<Vehicle>> fullList = this.driverPool.findFullList(driverList);
    HashMap<Driver, HashSet<Record>> fullRecordForMultipleDrivers = this.dmvRecords
        .getAllRecordsForMultipleDrivers(driverList);
    view.printQueryResult(driverList, fullList, fullRecordForMultipleDrivers);
  }
}
