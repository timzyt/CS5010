package edu.neu.ccs.cs5010.assignment4.ridesharemodel.validators;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import edu.neu.ccs.cs5010.assignment4.ridesharemodel.DmvRecords;
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
import java.util.HashSet;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * HistoryValidator Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Oct 13, 2018</pre>
 */
public class HistoryValidatorTest {

  private String firstName;
  private String lastName;
  private String firstName2;
  private String lastName2;
  private Name name1;
  private Name name2;
  private LocalDate birthday;
  private LocalDate birthday2;
  private String make;
  private String model;
  private String color;
  private String licensePlate;
  private String licensePlate2;
  private Integer year;

  private Driver driver;
  private Driver driver2;

  private String licenseNum1;
  private String licenseNum2;
  private Country issueCountry;
  private LocalDate issueDate;
  private LocalDate expirationDate1;
  private LocalDate expirationDate2;

  private Integer recordId1;
  private Integer recordId2;
  private Integer recordId3;
  private Integer recordId4;
  private Integer recordId5;
  private ViolationTypes violationType1;
  private ViolationTypes violationType2;
  private ViolationTypes violationType3;
  private ViolationTypes violationType4;
  private ViolationTypes violationType5;
  private CrashTypes crashType1;
  private CrashTypes crashType2;
  private LocalDate incidentDate1;
  private LocalDate incidentDate2;
  private HashSet<Driver> insuredDrivers1;

  private License license1;
  private Driver driver1;
  private Vehicle vehicle1;
  private Vehicle vehicle2;
  private Insurance insurance1;

  private Record record1;
  private Record record2;
  private Record record3;
  private Record record4;
  private Record record5;

  private Registration registration1;
  private TimeCalculator newTimeCalculator;
  private HistoryValidator newHistoryValidator;
  private DmvRecords newDMVRecords;

  @Before
  public void before() throws Exception {
    firstName = "Tim";
    lastName = "Zhu";
    firstName2 = "Jack";
    lastName2 = "Ma";
    year = 2012;
    recordId1 = 1111;
    recordId2 = 1245;
    recordId3 = 5421;
    recordId4 = 9872;
    recordId5 = 1021;
    birthday = LocalDate.of(1988, 04, 23);
    birthday2 = LocalDate.of(1989, 11, 02);
    name1 = new Name(firstName, lastName);
    name2 = new Name(firstName2, lastName2);
    make = "Honda";
    model = "Civic";
    color = "Black";
    licensePlate = "BBB5421";
    licensePlate2 = "AS241";
    licenseNum1 = "123abc";
    licenseNum2 = "456efg";
    issueCountry = Country.US;
    issueDate = LocalDate.of(2015, 01, 01);
    expirationDate1 = LocalDate.of(2020, 01, 01);
    expirationDate2 = LocalDate.of(2025, 01, 01);
    incidentDate1 = LocalDate.of(2016, 5, 01);
    incidentDate2 = LocalDate.of(2018, 5, 26);
    violationType1 = ViolationTypes.Reckless_driving;
    violationType2 = ViolationTypes.Speeding;
    violationType3 = ViolationTypes.Driving_under_influence;
    violationType4 = ViolationTypes.Driving_without_a_valid_license_and_or_insurance;
    violationType5 = ViolationTypes.Parking_violation;
    crashType1 = CrashTypes.Fender_bender;
    crashType2 = CrashTypes.Crash_involing_bodily_injuries;

    license1 = new License(licenseNum1,name1, birthday, issueCountry,issueDate,expirationDate1);
    driver1 = new Driver(name1, birthday,license1);
    driver2 = new Driver(name2, birthday,license1);
    insuredDrivers1 = new HashSet<>();

    vehicle1 = new Vehicle(driver1, year, make, model, color, licensePlate);
    insurance1 = new Insurance(driver1, vehicle1,insuredDrivers1, expirationDate2);

    record1 = new Record(recordId1, vehicle1, driver1, violationType1, crashType1, incidentDate1);
    record2 = new Record(recordId2, vehicle1, driver1, violationType2, crashType2, incidentDate2);
    record3 = new Record(recordId3, vehicle1, driver1, violationType3, crashType1, incidentDate1);
    record4 = new Record(recordId4, vehicle1, driver1, violationType4, crashType2, incidentDate2);
    record5 = new Record(recordId5, vehicle1, driver2, violationType5, crashType1, incidentDate1);

    newTimeCalculator = new TimeCalculator();
    registration1 = new Registration(driver1, insurance1, vehicle1);
    newDMVRecords = new DmvRecords();
    newHistoryValidator = new HistoryValidator(newDMVRecords,registration1);

  }

  @After
  public void after() throws Exception {
  }

  /**
   * Method: validateDriverHistory(Driver driver)
   */
  @Test
  public void testValidateDriverHistory() throws Exception {
    newDMVRecords.addRecord(record1);
    assertFalse(newHistoryValidator.validateDriverHistory(driver1));
  }
  @Test
  public void testValidateDriverHistory2() throws Exception {
    newDMVRecords.addRecord(record2);
    assertFalse(newHistoryValidator.validateDriverHistory(driver1));
  }

  @Test
  public void testValidateDriverHistory3() throws Exception {
    newDMVRecords.addRecord(record3);
    assertFalse(newHistoryValidator.validateDriverHistory(driver1));
  }

  @Test
  public void testValidateDriverHistory4() throws Exception {
    newDMVRecords.addRecord(record4);
    assertFalse(newHistoryValidator.validateDriverHistory(driver1));
  }

  @Test
  public void testValidateDriverHistory5() throws Exception {
    newDMVRecords.addRecord(record5);
    assertTrue(newHistoryValidator.validateDriverHistory(driver2));
  }

  /**
   * Method: validateVehicleHistory(Vehicle vehicle)
   */
  @Test
  public void testValidateVehicleHistory() throws Exception {
    newDMVRecords.addRecord(record1);
    assertTrue(newHistoryValidator.validateVehicleHistory(vehicle1));
  }

  @Test
  public void testValidateVehicleHistory2() throws Exception {
    record1 = new Record(recordId2,vehicle1,driver1, violationType1, crashType1, incidentDate2);
    newDMVRecords.addRecord(record1);
    assertFalse(newHistoryValidator.validateVehicleHistory(vehicle1));
  }

  @Test
  public void testValidateVehicleHistory3() throws Exception {
    record1 = new Record(recordId2,vehicle1,driver1, violationType1, null, incidentDate2);
    newDMVRecords.addRecord(record1);
    assertFalse(newHistoryValidator.validateVehicleHistory(vehicle1));
  }

  /**
   * Method: masterValidator(Registration registration)
   */
  @Test
  public void testMasterValidator() throws Exception {
    record1 = new Record(recordId2,vehicle1,driver1, violationType1, crashType1, incidentDate2);
    newDMVRecords.addRecord(record1);
    assertFalse(newHistoryValidator.masterValidator(registration1));
  }

  @Test
  public void testMasterValidator2() throws Exception {
    record1 = new Record(recordId2,vehicle1,driver1, violationType5, crashType1, incidentDate1);
    newDMVRecords.addRecord(record1);
    assertTrue(newHistoryValidator.masterValidator(registration1));
  }


} 
