package edu.neu.ccs.cs5010.assignment4.ridesharemodel;

import edu.neu.ccs.cs5010.assignment4.ridesharemodel.driver.Driver;
import edu.neu.ccs.cs5010.assignment4.ridesharemodel.vehicle.Vehicle;
import edu.neu.ccs.cs5010.assignment4.ridesharemodel.violationrecords.Record;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * The DMV records class. Serves as one of the ridershare models.
 */
public class DmvRecords {

  private HashSet<Record> dmvRecordDatebase = new HashSet<Record>();

  /**
   * Instantiates a new Dmv records.
   */
  public DmvRecords() {

  }

  /**
   * Gets this dmv records.
   *
   * @return the dmv records
   */
  public HashSet<Record> getDmvRecords() {
    return this.dmvRecordDatebase;
  }

  /**
   * Add a new Record into this DMV records.
   *
   * @param record the Record
   */
  public void addRecord(Record record) {
    this.dmvRecordDatebase.add(record);
  }


  /**
   * Find if a given driver has Record in the DMV records, return true if yes, otherwise return
   * false.
   *
   * @param driver the driver
   * @return the boolean
   */
  public Boolean isDriverInDmvRecord(Driver driver) {
    for (Record record
        : this.getDmvRecords()) {
      if (record.getDriver().equals(driver)) {
        return true;
      }
    }
    return false;
  }

  /**
   * Find if a given vehicle has Record in the DMV records, return true if yes, otherwise return
   * false.
   *
   * @param vehicle the vehicle
   * @return the boolean
   */
  public Boolean isVehicleInDmvRecord(Vehicle vehicle) {
    for (Record record
        : this.getDmvRecords()) {
      if (record.getVehicle().equals(vehicle)) {
        return true;
      }
    }
    return false;
  }

  /**
   * Gets all records for a given driver.
   *
   * @param driver the driver
   * @return the all records
   */
  public HashSet<Record> getAllRecordsByDriver(Driver driver) {
    HashSet<Record> fullRecordList = new HashSet<Record>();
    if (this.isDriverInDmvRecord(driver)) {
      for (Record record
          : this.getDmvRecords()) {
        if (record.getDriver().equals(driver)) {
          fullRecordList.add(record);
        }
      }
    }
    return fullRecordList;
  }

  /**
   * Gets all records for multiple drivers.
   *
   * @param driverList the driver list
   * @return the all records for multiple drivers
   */
  public HashMap<Driver, HashSet<Record>> getAllRecordsForMultipleDrivers(
      ArrayList<Driver> driverList) {
    HashMap<Driver, HashSet<Record>> fullRecordForMultipleDrivers = new HashMap<>();
    for (Driver driver : driverList) {
      if (getAllRecordsByDriver((driver)) != null) {
        fullRecordForMultipleDrivers.put(driver, getAllRecordsByDriver(driver));
      }
    }
    return fullRecordForMultipleDrivers;
  }

  /**
   * Gets all records for a given vehicle.
   *
   * @param vehicle the vehicle
   * @return the all records
   */
  public HashSet<Record> getAllRecordsByVehicle(Vehicle vehicle) {
    HashSet<Record> fullRecordList = new HashSet<Record>();
    if (this.isVehicleInDmvRecord(vehicle)) {
      for (Record record
          : this.getDmvRecords()) {
        if (record.getVehicle().equals(vehicle)) {
          fullRecordList.add(record);
        }
      }
    }
    return fullRecordList;
  }


}
