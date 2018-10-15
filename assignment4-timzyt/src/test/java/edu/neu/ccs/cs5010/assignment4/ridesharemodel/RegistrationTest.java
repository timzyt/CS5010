package edu.neu.ccs.cs5010.assignment4.ridesharemodel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import edu.neu.ccs.cs5010.assignment4.exceptions.InvalidConstructorArgumentException;
import edu.neu.ccs.cs5010.assignment4.ridesharemodel.driver.Country;
import edu.neu.ccs.cs5010.assignment4.ridesharemodel.driver.Driver;
import edu.neu.ccs.cs5010.assignment4.ridesharemodel.driver.License;
import edu.neu.ccs.cs5010.assignment4.ridesharemodel.driver.Name;
import edu.neu.ccs.cs5010.assignment4.ridesharemodel.insurance.Insurance;
import edu.neu.ccs.cs5010.assignment4.ridesharemodel.validators.TimeCalculator;
import edu.neu.ccs.cs5010.assignment4.ridesharemodel.vehicle.Vehicle;
import java.time.LocalDate;
import java.util.HashSet;
import org.junit.Test;
import org.junit.Before;

/**
 * Registration Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Oct 14, 2018</pre>
 */
public class RegistrationTest {

  private String firstName;
  private String lastName;
  private String firstName2;
  private String lastName2;
  private LocalDate birthday;
  private LocalDate birthday2;
  private String licenseNum;
  private Country issueCountry;
  private Country issueCountry2;
  private Integer year;
  private Integer year2;
  private LocalDate issueDate;
  private LocalDate issueDate2;
  private LocalDate expirationDate;
  private String make;
  private String model;
  private String color;
  private String licensePlate;

  private Name name;
  private Name name2;
  private License license;
  private Driver owner;
  private Driver owner2;
  private Vehicle vehicle;
  private HashSet<Driver> insuredDrivers;
  private LocalDate date;

  private TimeCalculator timeCalculator;
  private Insurance insurance;
  private Registration registration;


  @Before
  public void before() throws Exception {

    firstName = "Tim";
    lastName = "Zhu";
    firstName2 = "Jack";
    lastName2 = "Ma";
    year = 2012;
    year2 = 2000;
    birthday = LocalDate.of(1988, 4, 23);
    birthday2 = LocalDate.of(1989, 4, 26);
    issueDate = LocalDate.of(2015, 9, 1);
    issueDate2 = LocalDate.of(2018, 9, 1);
    expirationDate = LocalDate.of(2020, 01, 01);
    name = new Name(firstName, lastName);
    name2 = new Name(firstName2, lastName2);
    licenseNum = "123abc";
    issueCountry = Country.US;
    issueCountry2 = Country.Canada;
    make = "Honda";
    model = "Civic";
    color = "Black";
    licensePlate = "BBB5421";

    license = new License(licenseNum, name, birthday, issueCountry, issueDate, expirationDate);
    owner = new Driver(name, birthday, license);
    owner2 = new Driver(name2, birthday, license);
    vehicle = new Vehicle(owner, year, make, model, color, licensePlate);
    insuredDrivers = new HashSet<Driver>();
    date = LocalDate.of(2025, 01, 01);
    insurance = new Insurance(owner, vehicle, insuredDrivers, expirationDate);

    timeCalculator = new TimeCalculator();
    registration = new Registration(owner, insurance, vehicle);
  }

  @Test(expected = InvalidConstructorArgumentException.class)
  public void testRegistrationConstructor() throws Exception {
    registration = new Registration(null, insurance, vehicle);
  }

  @Test(expected = InvalidConstructorArgumentException.class)
  public void testRegistrationConstructor2() throws Exception {
    registration = new Registration(owner, null, vehicle);
  }

  /**
   * Method: setDriverName(String firstName, String lastName)
   */
  @Test
  public void testSetDriverName() throws Exception {
    registration.setDriverName(firstName2, lastName2);
  }

  @Test(expected = InvalidConstructorArgumentException.class)
  public void testSetDriverName2() throws Exception {
    registration.setDriverName(null, lastName2);
  }

  @Test(expected = InvalidConstructorArgumentException.class)
  public void testSetDriverName3() throws Exception {
    registration.setDriverName(firstName2, null);
  }

  /**
   * Method: setDriverBirthday(LocalDate date)
   */
  @Test
  public void testSetDriverBirthday() throws Exception {
    registration.setDriverBirthday(birthday2);
  }

  @Test(expected = InvalidConstructorArgumentException.class)
  public void testSetDriverBirthday2() throws Exception {
    registration.setDriverBirthday(null);
  }

  /**
   * Method: setDriverLicense(License license)
   */
  @Test
  public void testSetDriverLicense() throws Exception {
    License license2 = new License(licenseNum, name2, birthday, issueCountry, issueDate,
        expirationDate);
    registration.setDriverLicense(license2);
  }

  @Test(expected = InvalidConstructorArgumentException.class)
  public void testSetDriverLicense2() throws Exception {
    registration.setDriverLicense(null);
  }

  /**
   * Method: setInsurance(Insurance insurance)
   */
  @Test
  public void testSetInsurance2() throws Exception {
    Insurance insurance2 = new Insurance(owner2, vehicle, insuredDrivers, expirationDate);
    registration.setInsurance(insurance2);
  }

  @Test(expected = InvalidConstructorArgumentException.class)
  public void testSetInsurance() throws Exception {
    registration.setInsurance(null);
  }

  /**
   * Method: setVehicle(Vehicle vehicle)
   */
  @Test
  public void testSetVehicle() throws Exception {
    Vehicle vehicle2 = new Vehicle(owner2, year, make, model, color, licensePlate);
    registration.setVehicle(vehicle2);
  }

  /**
   * Method: setPersonInDriverSeat(Driver newDriver)
   */
  @Test
  public void testSetPersonInDriverSeat() throws Exception {
    registration.setPersonInDriverSeat(owner);
  }

  /**
   * Method: getDriver()
   */
  @Test
  public void testGetDriver() throws Exception {
    assertEquals(owner, registration.getDriver());
  }

  /**
   * Method: getInsurance()
   */
  @Test
  public void testGetInsurance() throws Exception {
    assertEquals(insurance, registration.getInsurance());
  }

  /**
   * Method: getVehicle()
   */
  @Test
  public void testGetVehicle() throws Exception {
    assertEquals(vehicle, registration.getVehicle());
  }

  /**
   * Method: validateRegistration()
   */
  @Test
  public void testValidateRegistration() throws Exception {
    assertTrue(registration.validateRegistration());
  }

  /**
   * Method: validateRegistration()
   */
  @Test
  public void testValidateRegistration2() throws Exception {
    vehicle = new Vehicle(owner, year2, make, model, color, licensePlate);
    registration = new Registration(owner, insurance,vehicle);
    assertFalse(registration.validateRegistration());
  }


  @Test
  public void testEquals() throws Exception {
    assertTrue(registration.equals(registration));
    assertTrue(registration.equals(new Registration(owner, insurance, vehicle)));
    assertFalse(registration.equals(owner));
    assertFalse(registration.equals(new Registration(owner2, insurance, vehicle)));
  }

  @Test
  public void testHashCode() throws Exception {
    registration = new Registration(owner, insurance, vehicle);
    assertTrue(registration.hashCode() == new Registration(owner, insurance, vehicle).hashCode());
  }

  @Test
  public void testToString() {
    System.out.println(registration);
  }
}
