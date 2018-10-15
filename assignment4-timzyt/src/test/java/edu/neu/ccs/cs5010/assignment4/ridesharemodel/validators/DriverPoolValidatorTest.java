package edu.neu.ccs.cs5010.assignment4.ridesharemodel.validators;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;


import edu.neu.ccs.cs5010.assignment4.ridesharemodel.DmvRecords;
import edu.neu.ccs.cs5010.assignment4.ridesharemodel.DriverPool;
import edu.neu.ccs.cs5010.assignment4.ridesharemodel.Registration;
import edu.neu.ccs.cs5010.assignment4.ridesharemodel.driver.Country;
import edu.neu.ccs.cs5010.assignment4.ridesharemodel.driver.Driver;
import edu.neu.ccs.cs5010.assignment4.ridesharemodel.driver.License;
import edu.neu.ccs.cs5010.assignment4.ridesharemodel.driver.Name;
import edu.neu.ccs.cs5010.assignment4.ridesharemodel.insurance.Insurance;
import edu.neu.ccs.cs5010.assignment4.ridesharemodel.vehicle.CrashTypes;
import edu.neu.ccs.cs5010.assignment4.ridesharemodel.vehicle.Vehicle;
import edu.neu.ccs.cs5010.assignment4.ridesharemodel.violationrecords.Record;
import edu.neu.ccs.cs5010.assignment4.ridesharemodel.violationrecords.ViolationTypes;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * DriverPoolValidator Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Oct 13, 2018</pre>
 */
public class DriverPoolValidatorTest {

  private String firstName;
  private String lastName;
  private String firstName2;
  private String lastName2;
  private Name name;
  private Name name2;
  private Integer recordId;
  private Integer negativeRecordId;
  private Integer year;
  private Integer invalidYear1;
  private Integer invalidYear2;
  private LocalDate birthday;
  private LocalDate birthday2;
  private License license;
  private License license2;
  private String make;
  private String model;
  private String color;
  private String licensePlate;
  private String licensePlate2;
  private ViolationTypes Distracted_driving;
  private ViolationTypes RecklessDriving;
  private ViolationTypes Speeding;
  private ViolationTypes Driving_under_influence;
  private ViolationTypes Failure_to_respect_traffic_signs;
  private ViolationTypes Driving_without_a_valid_license_and_or_insurance;
  private ViolationTypes Parking_violation;
  private ViolationTypes Paperwork_issues;
  private ViolationTypes Problems_with_the_vehicle;
  private CrashTypes Fender_bender;

  private String licenseNum;
  private String licenseNum2;
  private Country issueCountry;
  private LocalDate issueDate;
  private LocalDate expirationDate;
  private LocalDate expirationDate2;
  private LocalDate recordDate;

  private Driver driver;
  private Driver driver2;
  private Vehicle vehicle;
  private Vehicle vehicle2;
  private HashSet<Driver> insuredDrivers;
  private HashSet<Driver> insuredDrivers2;
  private Insurance insurance;
  private Insurance insurance2;
  private Record record;
  private Registration registration;
  private Registration registration2;
  private DmvRecords newDMVRecords;
  private DriverPool newDriverPool;

  private DriverPoolValidator newDriverPoolValidator;

  @Before
  public void before() throws Exception {

    firstName = "Tim";
    lastName = "Zhu";
    firstName2 = "Jack";
    lastName2 = "Ma";
    year = 2012;
    recordId = 1111;
    negativeRecordId = -123;
    invalidYear1 = 1800;
    invalidYear2 = 2020;
    birthday = LocalDate.of(1988, 04, 23);
    birthday2 = LocalDate.of(1989, 11, 02);
    name = new Name(firstName, lastName);
    name2 = new Name(firstName2, lastName2);
    licenseNum = "123abc";
    licenseNum2 = "456efg";
    issueCountry = Country.US;
    issueDate = LocalDate.of(2015, 01, 01);
    expirationDate = LocalDate.of(2020, 01, 01);
    expirationDate2 = LocalDate.of(2025, 01, 01);
    recordDate = LocalDate.of(2016, 05, 01);
    make = "Honda";
    model = "Civic";
    color = "Black";
    licensePlate = "BBB5421";
    licensePlate2 = "AS241";
    Distracted_driving = ViolationTypes.Distracted_driving;
    RecklessDriving = ViolationTypes.Reckless_driving;
    Speeding = ViolationTypes.Speeding;
    Driving_under_influence = ViolationTypes.Driving_under_influence;
    Failure_to_respect_traffic_signs = ViolationTypes.Failure_to_respect_traffic_signs;
    Driving_without_a_valid_license_and_or_insurance = ViolationTypes.Driving_without_a_valid_license_and_or_insurance;
    Parking_violation = ViolationTypes.Parking_violation;
    Paperwork_issues = ViolationTypes.Paperwork_issues;
    Problems_with_the_vehicle = ViolationTypes.Problems_with_the_vehicle;
    Fender_bender = CrashTypes.Crash_involing_bodily_injuries;

    license = new License(licenseNum, name, birthday, issueCountry, issueDate, expirationDate);
    license2 = new License(licenseNum2, name2, birthday2, issueCountry, issueDate, expirationDate);
    driver = new Driver(name, birthday, license);
    driver2 = new Driver(name2, birthday2, license2);
    vehicle = new Vehicle(driver, year, make, model, color, licensePlate);
    vehicle.setPersonInDriverSeat(driver);
    vehicle2 = new Vehicle(driver, year, make, model, color, licensePlate2);
    vehicle2.setPersonInDriverSeat(driver2);
    insuredDrivers = new HashSet<Driver>();
    insuredDrivers.add(driver2);
    insuredDrivers2 = new HashSet<Driver>();
    insurance = new Insurance(driver, vehicle, insuredDrivers, expirationDate);
    insurance2 = new Insurance(driver2, vehicle2, insuredDrivers2, expirationDate2);
    record = new Record(recordId, vehicle, driver, Speeding, Fender_bender, recordDate);

    registration = new Registration(driver, insurance, vehicle);
    registration2 = new Registration(driver, insurance2, vehicle2);
    newDMVRecords = new DmvRecords();
    newDriverPool = new DriverPool();

    newDriverPoolValidator = new DriverPoolValidator(newDriverPool);
  }

  @After
  public void after() throws Exception {
  }

  /**
   * Method: validateUniqueness(Registration registration)
   */
  @Test
  public void testValidateUniqueness() throws Exception {
//    assertFalse(newDriverPool.getDriverPoolDatabase() == null);
    assertTrue(newDriverPoolValidator.validateUniqueness(registration));
    newDriverPool.addDriverVehicle(registration);
    assertFalse(newDriverPoolValidator.validateUniqueness(registration));
  }

  /**
   * Method: validateDriverWithMultipleVehicles(Registration registration)
   */
  @Test
  public void testValidateDriverWithMultipleVehicles1() throws Exception {
    Registration registration0 = new Registration(driver, insurance, vehicle2);
    newDriverPool.addDriverVehicle(registration0);
    assertFalse(newDriverPool.getDriverPoolDatabase().get(driver).isEmpty());
    assertTrue(newDriverPoolValidator.validateDriverWithMultipleVehicles(registration));
  }

  @Test
  public void testValidateDriverWithMultipleVehicles2() throws Exception {
    Registration registration0 = new Registration(driver, insurance, null);
    newDriverPool.addDriverVehicle(registration0);
    assertTrue(newDriverPoolValidator.validateDriverWithMultipleVehicles(registration));
  }

  @Test
  public void testValidateDriverWithMultipleVehicles3() throws Exception {
    Registration registration0 = new Registration(driver, insurance, vehicle);
    registration0.getVehicle().setPersonInDriverSeat(driver);
    newDriverPool.addDriverVehicle(registration0);
    assertFalse(newDriverPoolValidator.validateDriverWithMultipleVehicles(registration));
  }

  /**
   * Method: findDriverFromVehicleSet(HashSet<Vehicle> vehicleSet, Vehicle vehicle)
   */
  @Test
  public void testFindDriverFromVehicleSet() throws Exception {
    Vehicle vehicle1 = new Vehicle(driver, year, make, model, color, licensePlate);
    vehicle1.setPersonInDriverSeat(driver);
    HashSet<Vehicle> vehicleSet = new HashSet<>();
    vehicleSet.add(vehicle1);
    Vehicle vehicle3 = new Vehicle(driver, year, make, model, color, licensePlate);
    System.out.println(vehicle1);
    assertTrue(
          newDriverPoolValidator.findDriverFromVehicleSet(vehicleSet, vehicle3).equals(driver));
  }

  @Test
  public void testFindDriverFromVehicleSet2() throws Exception {
    Vehicle vehicle1 = new Vehicle(driver, year, make, model, color, licensePlate);
    Vehicle vehicle2 = new Vehicle(driver2, year, make, model, color, licensePlate);
    vehicle1.setPersonInDriverSeat(driver);
    vehicle2.setPersonInDriverSeat(driver2);
    HashSet<Vehicle> vehicleSet = new HashSet<>();
    vehicleSet.add(vehicle1);
//    Driver driver3 = new Driver(new Name(firstName, lastName2),birthday,license);
//    Vehicle vehicle3 = new Vehicle(driver3, year, make, model, color, licensePlate);
////    vehicle3.setPersonInDriverSeat(driver3);
//    ArrayList<Driver> driverCheckList = new ArrayList<>();
//    driverCheckList.add(driver2);
//    driverCheckList.add(driver);
//    assertEquals(vehicle1, vehicle2);
//    System.out.println(vehicle1);
//    System.out.println(vehicle2);
    assertTrue(
        newDriverPoolValidator.findDriverFromVehicleSet(vehicleSet, vehicle2) == null);
  }

  /**
   * Method: validateSharedVehicle(Registration registration)
   */
  @Test
  public void testValidateSharedVehicle() throws Exception {
    Vehicle testVehicle = new Vehicle(driver, year, make, model, color, licensePlate);
    Vehicle testVehicle2 = new Vehicle(driver, year, make, model, color, licensePlate);
    Registration registration0 = new Registration(driver, insurance, testVehicle);
    registration2 = new Registration(driver2, insurance, testVehicle2);
    registration0.getVehicle().setPersonInDriverSeat(driver);
    registration2.getVehicle().setPersonInDriverSeat(driver2);
    newDriverPool.addDriverVehicle(registration0);

//    newDriverPool.addDriverVehicle(registration);
//    for (Vehicle ve :newDriverPool.getDriverPoolDatabase().get(registration0.getDriver())) {
//      assertTrue(ve.equals(registration2.getVehicle()));
//    }
//    assertTrue(newDriverPool.getDriverPoolDatabase().get(registration0.getDriver()).contains(registration2.getVehicle()));
//    assertTrue(registration2.getVehicle().getPersonInDriverSeat() == null);
//
    assertTrue(newDriverPoolValidator.validateSharedVehicle(registration2));
  }

  @Test
  public void testValidateSharedVehicle2() throws Exception {
    Vehicle testVehicle = new Vehicle(driver, year, make, model, color, licensePlate);
    Vehicle testVehicle2 = new Vehicle(driver, year, make, model, color, licensePlate);
    Registration registration0 = new Registration(driver, insurance, testVehicle);
    registration2 = new Registration(driver2, insurance, testVehicle2);
    registration0.getVehicle().setPersonInDriverSeat(driver);
    registration2.getVehicle().setPersonInDriverSeat(driver);
    newDriverPool.addDriverVehicle(registration0);
    assertFalse(newDriverPoolValidator.validateSharedVehicle(registration2));
  }

  /**
   * Method: masterValidator(Registration registration)
   */
  @Test
  public void testMasterValidator() throws Exception {
    Vehicle testVehicle = new Vehicle(driver, year, make, model, color, licensePlate);
    Vehicle testVehicle2 = new Vehicle(driver, year, make, model, color, licensePlate);
    Registration registration0 = new Registration(driver, insurance, testVehicle);
    registration2 = new Registration(driver2, insurance, testVehicle2);
    registration0.getVehicle().setPersonInDriverSeat(driver);
    registration2.getVehicle().setPersonInDriverSeat(driver2);
    newDriverPool.addDriverVehicle(registration0);
    assertTrue(newDriverPoolValidator.validateUniqueness(registration2));
    assertTrue(newDriverPoolValidator.validateDriverWithMultipleVehicles(registration2));
    assertTrue(newDriverPoolValidator.validateSharedVehicle(registration2));
    assertTrue(newDriverPoolValidator.masterValidator(registration2));
  }


} 
