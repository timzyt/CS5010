package edu.neu.ccs.cs5010.assignment4.extracredit;

import edu.neu.ccs.cs5010.assignment4.RiderShareView;
import edu.neu.ccs.cs5010.assignment4.ridesharemodel.DriverPool;
import edu.neu.ccs.cs5010.assignment4.ridesharemodel.driver.Driver;
import edu.neu.ccs.cs5010.assignment4.ridesharemodel.vehicle.Vehicle;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Observable;

/**
 * The type Driver pool watch dogs.
 */
public class DriverPoolWatchDogs extends Observable {

  private DriverPool newDriverPool;

  private HashMap<Vehicle, Driver> driverVehicleStatus;
  private HashSet<Driver> workingDriver;
  private HashSet<Driver> oneDriverMultipleVehicleWatchList;
  private HashMap<Vehicle, HashSet<Driver>> sharedVehicleWatchList;

  /**
   * Instantiates a new Driver pool watch dogs.
   *
   * @param driverPool the driver pool
   */
  public DriverPoolWatchDogs(DriverPool driverPool) {
    this.newDriverPool = driverPool;
    // create a HashMap driverVehicleStatus,
    // keep record of all vehicles and their working drivers
    // key being unique vehicles registered in the driver pool
    // value being the current person in the driver seat,
    // turned on driving mode from the app, starting the trip.
    driverVehicleStatus = new HashMap<>();
    // create a HashSet workingDriver,
    // live update the drivers that signed on to start the trip.
    workingDriver = new HashSet<>();
    // create a HashSet oneDriverMultipleVehicleWatchList,
    // which logs all the drivers that have signed onto multiple vehicles
    oneDriverMultipleVehicleWatchList = new HashSet<>();
    //loop through the driver pool database,
    // collect all unique vehicles into the key set,
    // and add corresponding personInTheDriverSeat to the values
    sharedVehicleWatchList = new HashMap<>();
  }

  /**
   * Driver pool sanity check method, run checks to catch drivers in multiple vehicles, and vehicles
   * being operated by multiple drivers.
   */
  public void driverPoolSanityCheck() {
    for (Driver driver : this.newDriverPool.getDriverPoolDatabase().keySet()) {
      // create iterator to iterate through the registered vehicle list for each driver
      Iterator<Vehicle> vehicleIterator = this.newDriverPool.getDriverPoolDatabase().get(driver)
          .iterator();
      while (vehicleIterator.hasNext()) {
        Vehicle vehicle = vehicleIterator.next();
        // check if the current vehicle is null or is already logged in the driverVehicleStatus
        // null vehicle should be passed, but it's intended to log if the driverInSeat is null
        if (vehicle != null && !driverVehicleStatus.keySet().contains(vehicle)) {
          driverVehicleStatus.put(vehicle, vehicle.getPersonInDriverSeat());
          if (vehicle.getPersonInDriverSeat() != null
              && !workingDriver.contains(vehicle.getPersonInDriverSeat())) {
            workingDriver.add(vehicle.getPersonInDriverSeat());
          } else {
            if (vehicle.getPersonInDriverSeat() != null) {
              oneDriverMultipleVehicleWatchList.add(vehicle.getPersonInDriverSeat());
            }
          }
          // if find one vehicle that's already in the driverVehicleStatus,
          // (meaning this vehicle is already logged onto and is in a trip)
          // and now the new instance of the same vehicle
          // has another driver in the field personInSeat
          // because no one driver should be logged onto multiple vehicles
          // add this vehicle and the driver into the sharedVehicleWatchList
        } else if (vehicle != null && vehicle.getPersonInDriverSeat() != null
            && driverVehicleStatus.keySet().contains(vehicle)) {
          // check if this vehicle is already in the sharedVehicleWatchList
          // if not create a new HashSet to add the drivers
          if (!sharedVehicleWatchList.keySet().contains(vehicle)) {
            //make sure to add the driver that's already
            // logged in driverVehicleStatus for this vehicle
            sharedVehicleWatchList
                .put(vehicle,
                    new HashSet<Driver>(Arrays.asList(driverVehicleStatus.get(vehicle),
                        vehicle.getPersonInDriverSeat())));
          } else {
            // if this vehicle is already caught and added into the sharedVehicleWatchList
            // simply add the new personInSeat into its corresponding HashSet
            sharedVehicleWatchList.get(vehicle).add(vehicle.getPersonInDriverSeat());
          }
        }
      }
    }
  }

  /**
   * One driver multiple vehicle watchdog method. parse out the violating drivers, and pass to
   * observer.
   */
  public void oneDriverMultipleVehicleWatchdog() {
    // run driver pool sanity check
    this.driverPoolSanityCheck();
    // check if we caught any illegal driver in the oneDriverMultipleVehicleWatchList set
    // convert the list to string to pass to the observer
    StringBuilder driverList = new StringBuilder();
    // if so notify the observer and make a report
    if (!oneDriverMultipleVehicleWatchList.isEmpty()) {
      driverList
          .append("Found violating drivers in multiple vehicles at the same time as below:\n");
      for (Driver driver : oneDriverMultipleVehicleWatchList) {
        driverList
            .append(driver.getName().getFirstName() + " " + driver.getName().getLastName() + "\n");
      }
      notifyObservers(driverList.toString());
    }
  }

  /**
   * Share vehicle watchdog. parse out the violating vehicles, and pass to observer
   */
  public void shareVehicleWatchdog() {
    // run driver pool sanity check
    this.driverPoolSanityCheck();
    // check if we caught any illegal driver in the sharedVehicleWatchList set
    // convert the list to string to pass to the observer
    StringBuilder vehicleList = new StringBuilder();
    // if so notify the observer and make a report
    if (!sharedVehicleWatchList.isEmpty()) {
      vehicleList
          .append(
              "Found violating vehicles having multiple "
                  + "driver logged on at the same time as below:\n");
      for (Vehicle vehicle : sharedVehicleWatchList.keySet()) {
        vehicleList
            .append(vehicle.toString() + "\n");
      }
      notifyObservers(vehicleList);
    }
  }

  /**
   * connecting observer and the observables.
   *
   * @param args the input arguments
   */
  public static void main(String[] args) {
    DriverPoolWatchDogs observable = new DriverPoolWatchDogs(new DriverPool());
    observable.addObserver(new RiderShareView());
    observable.oneDriverMultipleVehicleWatchdog();
    observable.shareVehicleWatchdog();
  }
}
