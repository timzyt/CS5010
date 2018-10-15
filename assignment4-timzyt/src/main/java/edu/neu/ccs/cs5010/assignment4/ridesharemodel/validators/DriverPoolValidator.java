package edu.neu.ccs.cs5010.assignment4.ridesharemodel.validators;

import edu.neu.ccs.cs5010.assignment4.ridesharemodel.DriverPool;
import edu.neu.ccs.cs5010.assignment4.ridesharemodel.Registration;
import edu.neu.ccs.cs5010.assignment4.ridesharemodel.driver.Driver;
import edu.neu.ccs.cs5010.assignment4.ridesharemodel.vehicle.Vehicle;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * The driver pool validator class.
 */
public class DriverPoolValidator implements MasterValidator {

  private DriverPool driverPool;

  /**
   * Instantiates a new Driver pool validator.
   *
   * @param driverPool the driver pool
   */
  public DriverPoolValidator(DriverPool driverPool) {
    this.driverPool = driverPool;
  }

  /**
   * Validate if the accepted driver is adding a vehicle that's already in the existing driver pool.
   * If yes, return false, otherwise return true.
   *
   * @param registration the registration
   * @return the boolean.
   */
  public Boolean validateUniqueness(Registration registration) {
    Driver newDriver = registration.getDriver();
    Vehicle newVehicle = registration.getVehicle();
    if (driverPool.getDriverPoolDatabase().containsKey(newDriver) && driverPool
        .getDriverPoolDatabase().get(newDriver).contains(newVehicle)) {
      return false;
    }
    return true;
  }


  /**
   * If the accepted driver has multiple vehicles, validates whether this driver is driving only one
   * vehicle at the same time.If yes, return true, otherwise return false.
   *
   * @param registration the registration
   * @return the boolean.
   */
  public Boolean validateDriverWithMultipleVehicles(Registration registration) {
    Driver newDriver = registration.getDriver();
    HashSet<Driver> driverCheckSet = new HashSet<>();
    //check if registered driver has no vehicle, if so return true;
    if (this.driverPool.getDriverPoolDatabase().get(newDriver).isEmpty()) {
      return true;
    } else {
      for (Vehicle e : driverPool.getDriverPoolDatabase().get(newDriver)) {
        driverCheckSet.add(newDriver);
        if (driverCheckSet.contains(e.getPersonInDriverSeat())) {
          return false;
        } else {
          //if the personInDriverSeat is null, meaning nobody is driving this vehicle,
          // so no need to add it into the checklist.
          if (e.getPersonInDriverSeat() != null) {
            driverCheckSet.add(e.getPersonInDriverSeat());
          }
        }
      }
    }
    return true;
  }

  /**
   * Given a vehicle, find the physically identical vehicle in a given hashset, then return the
   * person in the driving seat of the found vehicle.
   *
   * @param vehicleSet the vehicle set
   * @param vehicle the vehicle
   * @return the driver
   */
  //helper method to iterate through the vehicle set, and return the specific vehicle in the set
  public ArrayList<Driver> findDriverFromVehicleSet(HashSet<Vehicle> vehicleSet, Vehicle vehicle) {
    ArrayList<Driver> personInSeatList = new ArrayList<>();
    if (vehicle.getPersonInDriverSeat() != null) {
      personInSeatList.add(vehicle.getPersonInDriverSeat());
    }
    for (Vehicle v : vehicleSet) {
      if (v.equals(vehicle)) {
        if (v.getPersonInDriverSeat() != null) {
          personInSeatList.add(v.getPersonInDriverSeat());
        }
      }
    }
    //if no identical vehicle is found in the set, return null.
    return personInSeatList;
  }

  /**
   * If one vehicle is registered under multiple drivers, validate that no different drivers should
   * be driving the same vehicle at the same time, possibly in different directions. If no such
   * conflict happens, return true, otherwise return false.
   *
   * @param registration the registration
   * @return the boolean.
   */
  public Boolean validateSharedVehicle(Registration registration) {
    Vehicle newVehicle = registration.getVehicle();

    for (Driver d : driverPool.getDriverPoolDatabase().keySet()) {
      //check if the existing driverPool contains the newVehicle,
      // if not, no chance of having multiple driver in it, so return true.
      if (!driverPool.getDriverPoolDatabase().get(d).contains(newVehicle)) {
        return true;
      } else {
        for (Vehicle v : driverPool.getDriverPoolDatabase().get(d)) {
          if (v.getPersonInDriverSeat().equals(newVehicle.getPersonInDriverSeat())) {
            return false;
          }
        }
      }
    }
    return true;
  }

  @Override
  public boolean masterValidator(Registration registration) {
    return validateUniqueness(registration)
        && validateDriverWithMultipleVehicles(registration)
        && validateSharedVehicle(registration);
  }
}
