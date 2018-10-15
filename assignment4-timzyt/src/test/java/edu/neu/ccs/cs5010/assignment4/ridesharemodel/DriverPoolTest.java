package edu.neu.ccs.cs5010.assignment4.ridesharemodel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import edu.neu.ccs.cs5010.assignment4.ridesharemodel.driver.Country;
import edu.neu.ccs.cs5010.assignment4.ridesharemodel.driver.Driver;
import edu.neu.ccs.cs5010.assignment4.ridesharemodel.driver.License;
import edu.neu.ccs.cs5010.assignment4.ridesharemodel.driver.Name;
import edu.neu.ccs.cs5010.assignment4.ridesharemodel.insurance.Insurance;
import edu.neu.ccs.cs5010.assignment4.ridesharemodel.validators.DriverPoolValidator;
import edu.neu.ccs.cs5010.assignment4.ridesharemodel.vehicle.CrashTypes;
import edu.neu.ccs.cs5010.assignment4.ridesharemodel.vehicle.Vehicle;
import edu.neu.ccs.cs5010.assignment4.ridesharemodel.violationrecords.Record;
import edu.neu.ccs.cs5010.assignment4.ridesharemodel.violationrecords.ViolationTypes;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * DriverPool Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Oct 15, 2018</pre>
 */
public class DriverPoolTest {

  private String firstName;
  private String lastName;
  private String firstName2;
  private String lastName2;
  private String firstName3;
  private String lastName3;
  private String firstName4;
  private String lastName4;
  private Name name;
  private Name name2;
  private Name name3;
  private Name name4;
  private Integer recordId;
  private Integer negativeRecordId;
  private Integer year;
  private Integer year2;
  private Integer year3;
  private Integer year4;
  private Integer invalidYear1;
  private Integer invalidYear2;
  private LocalDate birthday;
  private LocalDate birthday2;
  private LocalDate birthday3;
  private LocalDate birthday4;
  private License license;
  private License license2;
  private License license3;
  private License license4;
  private String make;
  private String model;
  private String color;
  private String licensePlate;
  private String licensePlate2;
  private String licensePlate3;
  private String licensePlate4;
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
  private String licenseNum3;
  private String licenseNum4;
  private Country issueCountry;
  private LocalDate issueDate;
  private LocalDate issueDate2;
  private LocalDate issueDate3;
  private LocalDate issueDate4;
  private LocalDate expirationDate;
  private LocalDate expirationDate2;
  private LocalDate expirationDate3;
  private LocalDate expirationDate4;
  private LocalDate recordDate;

  private Driver driver;
  private Driver driver2;
  private Driver driver3;
  private Driver driver4;
  private Vehicle vehicle;
  private Vehicle vehicle2;
  private Vehicle vehicle3;
  private Vehicle vehicle4;
  private HashSet<Driver> insuredDrivers;
  private HashSet<Driver> insuredDrivers2;
  private HashSet<Driver> insuredDrivers3;
  private HashSet<Driver> insuredDrivers4;
  private Insurance insurance;
  private Insurance insurance2;
  private Insurance insurance3;
  private Insurance insurance4;
  private Record record;
  private Registration registration;
  private Registration registration2;
  private Registration registration3;
  private Registration registration4;
  private DmvRecords newDMVRecords;
  private DriverPool newDriverPool;

  private DriverPoolValidator newDriverPoolValidator;
  private HashMap<Driver, HashSet<Vehicle>> newDriverPoolDatebase;


  @Before
  public void before() throws Exception {

    firstName = "Tim";
    lastName = "Zhu";
    firstName2 = "Jack";
    lastName2 = "Ma";
    firstName3 = "Gavin";
    lastName3 = "Zhu";
    firstName4 = "Huateng";
    lastName4 = "Ma";
    year = 2012;
    year2 = 2015;
    year3 = 2014;
    year4 = 2017;
    recordId = 1111;
    negativeRecordId = -123;
    invalidYear1 = 1800;
    invalidYear2 = 2020;
    birthday = LocalDate.of(1988, 04, 23);
    birthday2 = LocalDate.of(1989, 11, 02);
    birthday3 = LocalDate.of(1961, 06, 25);
    birthday4 = LocalDate.of(1975, 02, 12);
    name = new Name(firstName, lastName);
    name2 = new Name(firstName2, lastName2);
    name3 = new Name(firstName3, lastName3);
    name4 = new Name(firstName4, lastName4);
    licenseNum = "123abc";
    licenseNum2 = "456efg";
    licenseNum3 = "IU1234a";
    licenseNum4 = "KEY159";
    issueCountry = Country.US;
    issueDate = LocalDate.of(2015, 1, 1);
    expirationDate = LocalDate.of(2020, 1, 1);
    expirationDate2 = LocalDate.of(2025, 1, 1);
    expirationDate3 = LocalDate.of(2022, 4, 1);
    expirationDate4 = LocalDate.of(2021, 8, 8);
    recordDate = LocalDate.of(2016, 05, 01);
    make = "Honda";
    model = "Civic";
    color = "Black";
    licensePlate = "BBB5421";
    licensePlate2 = "AS241";
    licensePlate3 = "AABG3";
    licensePlate4 = "ABG134";
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
    license2 = new License(licenseNum2, name2, birthday2, issueCountry, issueDate, expirationDate2);
    license3 = new License(licenseNum3, name3, birthday3, issueCountry, issueDate, expirationDate3);
    license4 = new License(licenseNum4, name4, birthday4, issueCountry, issueDate, expirationDate4);
    driver = new Driver(name, birthday, license);
    driver2 = new Driver(name2, birthday2, license2);
    driver3 = new Driver(name3, birthday3, license3);
    driver4 = new Driver(name4, birthday4, license4);
    vehicle = new Vehicle(driver, year, make, model, color, licensePlate);
    vehicle.setPersonInDriverSeat(driver);
    vehicle2 = new Vehicle(driver2, year, make, model, color, licensePlate2);
    vehicle2.setPersonInDriverSeat(driver2);
    vehicle3 = new Vehicle(driver3, year, make, model, color, licensePlate3);
    vehicle3.setPersonInDriverSeat(driver3);
    vehicle4 = new Vehicle(driver4, year, make, model, color, licensePlate4);
    vehicle4.setPersonInDriverSeat(driver4);
    insuredDrivers = new HashSet<Driver>();
    insuredDrivers.add(driver2);
    insuredDrivers2 = new HashSet<Driver>();
    insuredDrivers3 = new HashSet<Driver>();
    insuredDrivers3.add(driver3);
    insuredDrivers4 = new HashSet<Driver>();
    insuredDrivers4.add(driver4);
    insurance = new Insurance(driver, vehicle, insuredDrivers, expirationDate);
    insurance2 = new Insurance(driver2, vehicle2, insuredDrivers2, expirationDate2);
    insurance3 = new Insurance(driver3, vehicle3, insuredDrivers3, expirationDate3);
    insurance4 = new Insurance(driver4, vehicle4, insuredDrivers4, expirationDate4);
    record = new Record(recordId, vehicle, driver, Speeding, Fender_bender, recordDate);

    registration = new Registration(driver, insurance, vehicle);
    registration2 = new Registration(driver2, insurance2, vehicle2);
    registration3 = new Registration(driver3, insurance3,vehicle3);
    registration4 = new Registration(driver4, insurance4,vehicle4);
    newDMVRecords = new DmvRecords();

    newDriverPool = new DriverPool();
    newDriverPoolValidator = new DriverPoolValidator(newDriverPool);
    newDriverPoolDatebase = new HashMap<Driver, HashSet<Vehicle>>();

  }

  @After
  public void after() throws Exception {
  }

  /**
   * Method: getDriverPoolDatabase()
   */
  @Test
  public void testGetDriverPoolDatabase() throws Exception {
    assertTrue(newDriverPool.getDriverPoolDatabase().equals(newDriverPoolDatebase));
  }

  /**
   * Method: addDriverVehicle(Registration registration)
   */
  @Test
  public void testAddDriverVehicle() throws Exception {
    newDriverPool.addDriverVehicle(registration);
    newDriverPool.addDriverVehicle(registration2);
//    System.out.println(newDriverPool.getDriverPoolDatabase().get(registration.getDriver()).size());
  }

  /**
   * Method: validateRegistrationInPool(Registration registration)
   */
  @Test
  public void testValidateRegistrationInPool() throws Exception {
    newDriverPool.addDriverVehicle(registration);
    newDriverPool.validateRegistrationInPool(registration2);
  }

  /**
   * Method: masterValidator(Registration registration)
   */
  @Test
  public void testMasterValidator() throws Exception {
    newDriverPool.addDriverVehicle(registration);
    Name name3 = new Name(firstName, lastName2);
    License license3 = new License(licenseNum, name3,birthday,issueCountry,issueDate,expirationDate);
    Driver driver3 = new Driver(name3,birthday,license3);
    Vehicle vehicle3 = new Vehicle(driver3, 2018,make, model, color, licensePlate2);
    HashSet<Driver> insuredDrivers3 = new HashSet<>();
    insuredDrivers3.add(driver3);
    Insurance insurance3 = new Insurance(driver3, vehicle3,insuredDrivers3,expirationDate2);
    Registration registration3 = new Registration(driver3, insurance3,vehicle3);

    newDriverPool.masterValidator(registration3);

//    System.out.println(newDriverPoolValidator.masterValidator(registration3));
//    System.out.println(newDriverPoolValidator.validateUniqueness(registration3));
//    System.out.println(newDriverPoolValidator.validateDriverWithMultipleVehicles(registration3));
//    System.out.println(newDriverPoolValidator.validateSharedVehicle(registration3));
//    insuredDrivers2.add(driver);
//    System.out.println(registration2.validateRegistration());

  }

  /**
   * Method: masterValidator(Registration registration)
   */
  @Test
  public void testMasterValidator2() throws Exception {
    newDriverPool.addDriverVehicle(registration);
    newDriverPool.masterValidator(registration);

//    System.out.println(newDriverPoolValidator.masterValidator(registration3));
//    System.out.println(newDriverPoolValidator.validateUniqueness(registration3));
//    System.out.println(newDriverPoolValidator.validateDriverWithMultipleVehicles(registration3));
//    System.out.println(newDriverPoolValidator.validateSharedVehicle(registration3));
//    insuredDrivers2.add(driver);
//    System.out.println(registration2.validateRegistration());

  }

  /**
   * Method: findDriverList(String lastName)
   */
  @Test
  public void testFindDriverList() throws Exception {
    ArrayList<Driver> expectedResult = new ArrayList<>();
    expectedResult.add(driver3);
    expectedResult.add(driver);
    newDriverPool.addDriverVehicle(registration);
    newDriverPool.addDriverVehicle(registration3);
    ArrayList<Driver> result = newDriverPool.findDriverList(lastName3);
    for (Driver driver : result) {
      System.out.println(driver.toString());
    }
    assertTrue(expectedResult.size()== result.size());
    for (int i = 0; i < result.size() - 1; i++) {
      assertTrue(result.get(i).equals(expectedResult.get(i)));
    }
  }

  /**
   * Method: findFullList(ArrayList<Driver> driverList)
   */
  @Test
  public void testFindFullList() throws Exception {
    registration4 = new Registration(driver4, insurance4, null);
    ArrayList<Driver> queryDriverList = new ArrayList<>();
    queryDriverList.add(driver);
    queryDriverList.add(driver2);
    queryDriverList.add(driver3);
    queryDriverList.add(driver4);
    newDriverPool.addDriverVehicle(registration);
    newDriverPool.addDriverVehicle(registration2);
    newDriverPool.addDriverVehicle(registration3);
    newDriverPool.addDriverVehicle(registration4);

    HashMap<Driver, HashSet<Vehicle>> resultList = newDriverPool.findFullList(queryDriverList);
  }

  /**
   * Method: equals(Object obj)
   */
  @Test
  public void testEquals() throws Exception {
    assertTrue(newDriverPool.equals(newDriverPool));
    assertTrue(newDriverPool.equals(new DriverPool()));
    assertFalse(newDriverPool.equals(null));
    assertFalse(newDriverPool.equals(newDriverPoolDatebase));
    System.out.println(newDriverPool.getDriverPoolDatabase().hashCode());
    System.out.println(new DriverPool().getDriverPoolDatabase().hashCode());
    assertEquals(newDriverPool.getDriverPoolDatabase(), new DriverPool().getDriverPoolDatabase());
  }

  /**
   * Method: hashCode()
   */
  @Test
  public void testHashCode() throws Exception {
    assertTrue(newDriverPool.hashCode() == new DriverPool().hashCode());
  }

  /**
   * Method: toString()
   */
  @Test
  public void testToString() throws Exception {
    registration4 = new Registration(driver4, insurance4, null);
//    ArrayList<Driver> queryDriverList = new ArrayList<>();
//    queryDriverList.add(driver);
//    queryDriverList.add(driver2);
//    queryDriverList.add(driver3);
//    queryDriverList.add(driver4);
    newDriverPool.addDriverVehicle(registration);
    newDriverPool.addDriverVehicle(registration2);
    newDriverPool.addDriverVehicle(registration3);
    newDriverPool.addDriverVehicle(registration4);
    System.out.println(newDriverPool.toString());
  }


} 
