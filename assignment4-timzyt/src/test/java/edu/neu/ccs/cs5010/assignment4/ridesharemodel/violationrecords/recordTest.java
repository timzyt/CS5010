package edu.neu.ccs.cs5010.assignment4.ridesharemodel.violationrecords;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import edu.neu.ccs.cs5010.assignment4.exceptions.InvalidConstructorArgumentException;
import edu.neu.ccs.cs5010.assignment4.ridesharemodel.driver.Country;
import edu.neu.ccs.cs5010.assignment4.ridesharemodel.driver.Driver;
import edu.neu.ccs.cs5010.assignment4.ridesharemodel.driver.License;
import edu.neu.ccs.cs5010.assignment4.ridesharemodel.driver.Name;
import edu.neu.ccs.cs5010.assignment4.ridesharemodel.vehicle.CrashTypes;
import edu.neu.ccs.cs5010.assignment4.ridesharemodel.vehicle.Vehicle;

import edu.neu.ccs.cs5010.assignment4.ridesharemodel.violationrecords.Record;
import edu.neu.ccs.cs5010.assignment4.ridesharemodel.violationrecords.ViolationTypes;
import java.time.LocalDate;
import org.junit.Test;
import org.junit.Before;

/**
 * Record Tester.
 *
 * @author timzyt
 * @version 1.0
 * @since <pre>Oct 13, 2018</pre>
 */
public class recordTest {


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

  private String nullFirstName;
  private String nullLastName;
  private String emptyFirstName;
  private String emptyLastName;
  private Name nullName;
  private LocalDate nullBirhday;
  private License nullLicense;

  private String licenseNum;
  private String licenseNum2;
  private Country issueCountry;
  private LocalDate issueDate;
  private LocalDate expirationDate;
  private LocalDate recordDate;

  private Driver driver;
  private Vehicle vehicle;
  private Record record;

  @Before
  public void before() throws Exception {

    firstName = "Tim";
    lastName = "Zhu";
    firstName2 = "Jack";
    lastName2 = "Ma";
    emptyFirstName = "";
    emptyLastName = "";
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
    recordDate = LocalDate.of(2016, 05, 01);
    make = "Honda";
    model = "Civic";
    color = "Black";
    licensePlate = "BBB5421";
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
    vehicle = new Vehicle(driver, year, make, model, color, licensePlate);
    record = new Record(recordId, vehicle, driver, Speeding, Fender_bender, recordDate);
  }

  @Test(expected = InvalidConstructorArgumentException.class)
  public void testNullRecordId() throws Exception {
    record = new Record(null, vehicle, driver, Speeding, Fender_bender, recordDate);
  }

  @Test(expected = InvalidConstructorArgumentException.class)
  public void testNegativeRecordId() throws Exception {
    record = new Record(negativeRecordId, vehicle, driver, Speeding, Fender_bender, recordDate);
  }

  @Test(expected = InvalidConstructorArgumentException.class)
  public void testNullVehicle() throws Exception {
    record = new Record(recordId, null, driver, Speeding, Fender_bender, recordDate);
  }

  @Test(expected = InvalidConstructorArgumentException.class)
  public void testNullDriver() throws Exception {
    record = new Record(recordId, vehicle, null, Speeding, Fender_bender, recordDate);
  }

  @Test(expected = InvalidConstructorArgumentException.class)
  public void testBothNullViolationTypeAndCrashType() throws Exception {
    record = new Record(recordId, vehicle, driver, null, null, recordDate);
  }

  @Test(expected = InvalidConstructorArgumentException.class)
  public void testNullDate() throws Exception {
    record = new Record(recordId, vehicle, driver, Speeding, Fender_bender, null);
  }

  /**
   * Method: gerRecordId()
   */
  @Test
  public void testGetRecordID() throws Exception {
    assertEquals(recordId, record.gerRecordId());
  }

  /**
   * Method: getVehicle()
   */
  @Test
  public void testGetVehicle() throws Exception {
    assertEquals(vehicle, record.getVehicle());
  }

  /**
   * Method: getDriver()
   */
  @Test
  public void testGetDriver() throws Exception {
    assertEquals(driver, record.getDriver());
  }

  /**
   * Method: getViolationType()
   */
  @Test
  public void testGetViolationType() throws Exception {
    assertEquals(Speeding, record.getViolationType());
  }

  /**
   * Method: isMovingViolationTrue()
   */
  @Test
  public void testIsMovingViolation() throws Exception {
    assertTrue(new Record(recordId, vehicle, driver, Distracted_driving, Fender_bender, recordDate).isMovingViolationTrue());
    assertTrue(new Record(recordId, vehicle, driver, RecklessDriving, Fender_bender, recordDate).isMovingViolationTrue());
    assertTrue(record.isMovingViolationTrue());
    assertTrue(new Record(recordId, vehicle, driver, Driving_under_influence, Fender_bender, recordDate).isMovingViolationTrue());
    assertTrue(new Record(recordId, vehicle, driver, Failure_to_respect_traffic_signs,
        Fender_bender, recordDate).isMovingViolationTrue());
    assertTrue(new Record(recordId, vehicle, driver, Driving_without_a_valid_license_and_or_insurance,
        Fender_bender, recordDate).isMovingViolationTrue());
    assertFalse(new Record(recordId, vehicle, driver, Parking_violation, Fender_bender, recordDate).isMovingViolationTrue());
    assertFalse(new Record(recordId, vehicle, driver, Paperwork_issues, Fender_bender, recordDate).isMovingViolationTrue());
    assertFalse(new Record(recordId, vehicle, driver, Problems_with_the_vehicle, Fender_bender, recordDate).isMovingViolationTrue());
  }

  /**
   * Method: getCrashType()
   */
  @Test
  public void testGetCrashType() throws Exception {
    assertEquals(Fender_bender, record.getCrashType());
  }

  /**
   * Method: getDate()
   */
  @Test
  public void testGetDate() throws Exception {
    assertEquals(recordDate, record.getDate());
  }

  /**
   * Method: equals(Object o)
   */
  @Test
  public void testEquals() throws Exception {
    assertTrue(record.equals(record));
    assertTrue(
        record.equals(new Record(recordId, vehicle, driver, Speeding, Fender_bender, recordDate)));
    assertFalse(record.equals(vehicle));
    assertFalse(record.equals(
        new Record(recordId, vehicle, driver, ViolationTypes.Distracted_driving, Fender_bender,
            recordDate)));
  }

  /**
   * Method: hashCode()
   */
  @Test
  public void testHashCode() throws Exception {
    assertTrue(record.hashCode() == new Record(recordId, vehicle, driver, Speeding, Fender_bender,
        recordDate).hashCode());
    ;
  }


  /**
   * Method: toString()
   */
  @Test
  public void testToString() throws Exception {
    System.out.println(record.toString());
  }

} 
