package edu.neu.ccs.cs5010.assignment4;


import edu.neu.ccs.cs5010.assignment4.extracredit.DriverPoolWatchDogs;
import edu.neu.ccs.cs5010.assignment4.ridesharemodel.driver.Driver;
import edu.neu.ccs.cs5010.assignment4.ridesharemodel.vehicle.Vehicle;
import edu.neu.ccs.cs5010.assignment4.ridesharemodel.violationrecords.Record;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Observable;
import java.util.Observer;

/**
 * The ridershare view class.
 */
public class RiderShareView implements Observer {


  /**
   * Print query result from the query based on provided last name.
   *
   * @param driverList the driver list
   * @param fullList the full list of both drivers and vehicles
   * @param fullRecordForMultipleDrivers the full DMV Record for multiple drivers
   */
  public void printQueryResult(ArrayList<Driver> driverList,
      HashMap<Driver, HashSet<Vehicle>> fullList,
      HashMap<Driver, HashSet<Record>> fullRecordForMultipleDrivers) {
    //    HashSet<Record> recordList = new HashSet<Record>();
    if (driverList == null || driverList.size() == 0) {
      System.out.println("No registered driver found.");
    } else {
      //when diverList isn't null,
      // print each driver's last name and then first name such as "Smith, Anne"
      for (Driver driver : driverList) {
        System.out
            .println(driver.getName().getLastName()
                + ", " + driver.getName().getFirstName());
        //when fullList isn't null, print each driver's vehicle's information,
        // in the order of year, color, make, model, licensePlate
        if (fullList.get(driver) != null) {
          for (Vehicle vehicle : fullList.get(driver)) {
            System.out.println(
                "     " + vehicle.getYear() + " " + vehicle.getColor() + " " + vehicle.getMake()
                    + " " + vehicle.getModel() + ", " + vehicle.getLicensePlate());
          }
        }
        //when the Record isn't null, print each driver violation
        if (fullRecordForMultipleDrivers.get(driver) != null
            && !fullRecordForMultipleDrivers.get(driver).isEmpty()) {
          System.out.println("     Driving violations:");
          for (Record record
              : fullRecordForMultipleDrivers.get(driver)) {
            System.out.println("          " + record.getViolationType().toString());
          }
        }
      }
    }

  }


  @Override
  public void update(Observable obsvbl, Object arg) {
    if (obsvbl instanceof DriverPoolWatchDogs && arg instanceof String) {
      // if arg is instanceof HashSet, meaning the arg is sharedVehicleWatchList
      System.out.print(arg);
    }
  }
}
