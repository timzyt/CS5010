package edu.neu.ccs.cs5010.assignment4.ridesharemodel;

import edu.neu.ccs.cs5010.assignment4.ridesharemodel.driver.Driver;
import edu.neu.ccs.cs5010.assignment4.ridesharemodel.validators.DriverPoolValidator;
import edu.neu.ccs.cs5010.assignment4.ridesharemodel.vehicle.Vehicle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;

/**
 * Driver pool class. Serves as one of the ridershare models.
 */
public class DriverPool {

  private HashMap<Driver, HashSet<Vehicle>> driverPoolDatabase;
  private DriverPoolValidator driverPoolValidator;

  /**
   * Instantiates a new Driver pool.
   */
  public DriverPool() {
    driverPoolDatabase = new HashMap<Driver, HashSet<Vehicle>>();
    driverPoolValidator = new DriverPoolValidator(this);
  }

  /**
   * Gets driver pool.
   *
   * @return the driver pool
   */
  public HashMap<Driver, HashSet<Vehicle>> getDriverPoolDatabase() {
    return driverPoolDatabase;
  }

  /**
   * Add the driver and vehicle into the existing driver pool.
   *
   * @param registration the registration
   */
  public void addDriverVehicle(Registration registration) {
    Driver newDriver = registration.getDriver();
    Vehicle newVehicle = registration.getVehicle();
    if (!this.driverPoolDatabase.keySet().contains(newDriver)) {
      HashSet<Vehicle> newVehicleSet = new HashSet<Vehicle>();
      if (newVehicle != null) {
        newVehicleSet.add(newVehicle);
      }
      this.driverPoolDatabase.put(newDriver, newVehicleSet);
    } else {
      this.driverPoolDatabase.get(newDriver).add(newVehicle);
    }
  }

  /**
   * Returns the result from the master validator whether the new registration was meeting all three
   * requirements for the existing driver pool.
   *
   * @param registration the registration
   * @return the boolean
   */
  public boolean validateRegistrationInPool(Registration registration) {
    return this.driverPoolValidator.masterValidator(registration);
  }


  /**
   * Concludes validations happen both in the registration and the existing driver pool. Add the
   * provided driver into the existing driver database if passes the validation, otherwise print
   * failure message.
   *
   * @param registration the registration
   */
  public void masterValidator(Registration registration) {
    if (this.driverPoolValidator.masterValidator(registration)
        && registration.validateRegistration()) {
      this.addDriverVehicle(registration);
      System.out.println("This driver is successfully added into the existing driver pool.");
    } else {
      System.out.println("Sorry this driver cannot be accepted at this time.");
    }
  }

  /**
   * Find all the driver whose last name match the given last name.
   *
   * @param lastName provided last name.
   * @return ArraryList of drivers as driverList.
   */
  public ArrayList<Driver> findDriverList(String lastName) {
    ArrayList<Driver> driverList = new ArrayList<>();
    for (Driver driver : this.driverPoolDatabase.keySet()) {
      if (driver.getName().getLastName().equals(lastName)) {
        driverList.add(driver);
      }
    }
    Collections.sort(driverList, new Comparator<Driver>() {
      @Override
      public int compare(Driver obj1, Driver obj2) {
        return obj1.getName().getFirstName().compareToIgnoreCase(obj2.getName().getFirstName());
      }
    });
    return driverList;
  }

  /**
   * Find all vehicles matching every driver in the provided driver list.
   *
   * @param driverList the driver list
   * @return HashMap of drivers and their registered vehicles
   */
  public HashMap<Driver, HashSet<Vehicle>> findFullList(ArrayList<Driver> driverList) {
    HashMap<Driver, HashSet<Vehicle>> fullList = new HashMap<Driver, HashSet<Vehicle>>();
    for (Driver driver : driverList) {
      if (!this.driverPoolDatabase.get(driver).isEmpty()) {
        fullList.put(driver, this.driverPoolDatabase.get(driver));
      } else {
        fullList.put(driver, null);
      }
    }
    return fullList;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    DriverPool that = (DriverPool) obj;
    return Objects.equals(driverPoolDatabase, that.driverPoolDatabase);
  }

  @Override
  public int hashCode() {
    return Objects.hash(driverPoolDatabase);
  }

  @Override
  public String toString() {
    if (this.driverPoolDatabase.isEmpty()) {
      return "This driver pool is empty.";
    }
    Integer driverCount = this.driverPoolDatabase.keySet().size();
    HashSet<Vehicle> vehicleList = new HashSet<>();
    for (Driver oneDriver : this.driverPoolDatabase.keySet()) {
      Iterator<Vehicle> vehicleIterator = this.getDriverPoolDatabase().get(oneDriver).iterator();
      while (vehicleIterator.hasNext()) {
        Vehicle vehicle = vehicleIterator.next();
        if (vehicle != null && !vehicleList.contains(vehicle)) {
          vehicleList.add(vehicle);
        }
      }
    }
    Integer vehicleCount = vehicleList.size();
    return "This driver pool has " + driverCount + " drivers, and " + vehicleCount
        + " unique vehicles.";
  }
}
