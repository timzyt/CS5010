package edu.neu.ccs.cs5010.assignment4.ridesharemodel.validators;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import edu.neu.ccs.cs5010.assignment4.exceptions.InvalidConstructorArgumentException;
import edu.neu.ccs.cs5010.assignment4.ridesharemodel.Registration;
import edu.neu.ccs.cs5010.assignment4.ridesharemodel.driver.Country;
import edu.neu.ccs.cs5010.assignment4.ridesharemodel.driver.Driver;
import edu.neu.ccs.cs5010.assignment4.ridesharemodel.driver.License;
import edu.neu.ccs.cs5010.assignment4.ridesharemodel.driver.Name;
import edu.neu.ccs.cs5010.assignment4.ridesharemodel.insurance.Insurance;
import edu.neu.ccs.cs5010.assignment4.ridesharemodel.vehicle.Vehicle;
import java.time.LocalDate;
import java.time.Period;
import java.util.HashSet;
import org.junit.Test;
import org.junit.Before;

/**
 * DriverValidator Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Oct 13, 2018</pre>
 */
public class DriverValidatorTest {

  private String firstName;
  private String lastName;
  private String firstName2;
  private String lastName2;
  private LocalDate birthday;
  private String licenseNum;
  private Country issueCountry;
  private Country issueCountry2;
  private Integer year;
  private LocalDate issueDate;
  private LocalDate issueDate2;
  private LocalDate expirationDate;
  private String make;
  private String model;
  private String color;
  private String licensePlate;

  private Integer legalDrivingAge;
  private Integer legalLicenseMonth;

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

  private DriverValidator newDriverValidator;

  @Before
  public void before() throws Exception {

    firstName = "Tim";
    lastName = "Zhu";
    firstName2 = "Jack";
    lastName2 = "Ma";
    year = 2012;
    birthday = LocalDate.of(1988, 4, 23);
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

    legalDrivingAge = 21;
    legalLicenseMonth = 6;

    license = new License(licenseNum, name, birthday, issueCountry, issueDate, expirationDate);
    owner = new Driver(name, birthday, license);
    owner2 = new Driver(name2, birthday, license);
    vehicle = new Vehicle(owner, year, make, model, color, licensePlate);
    insuredDrivers = new HashSet<Driver>();
    date = LocalDate.of(2025, 01, 01);
    insurance = new Insurance(owner, vehicle, insuredDrivers, expirationDate);

    timeCalculator = new TimeCalculator();
    registration = new Registration(owner, insurance, vehicle);
    newDriverValidator = new DriverValidator(registration);
  }

  @Test(expected = InvalidConstructorArgumentException.class)
  public void testNullDriver() throws Exception {
    registration = new Registration(null, insurance, vehicle);
  }

  @Test(expected = InvalidConstructorArgumentException.class)
  public void testNullInsurance() throws Exception {
    registration = new Registration(owner, null, vehicle);
  }

  /**
   * Method: validateAge(Registration registration)
   */
  @Test
  public void testValidateAge() throws Exception {
    assertTrue(timeCalculator.calculateYear(birthday) > legalDrivingAge);
  }

  /**
   * Method: validateName(Registration registration)
   */
  @Test
  public void testValidateName() throws Exception {
    assertEquals(registration.getDriver().getName(),
        registration.getDriver().getLicense().getName());
  }

  /**
   * Method: validateBirthday(Registration registration)
   */
  @Test
  public void testValidateBirthday() throws Exception {
    assertEquals(registration.getDriver().getBirthday(),
        registration.getDriver().getLicense().getBirthday());
  }

  /**
   * Method: validateCountryOfIssuance(Registration registration)
   */
  @Test
  public void testValidateCountryOfIssuance() throws Exception {
    assertTrue(newDriverValidator.validateCountryOfIssuance(registration));
    assertTrue(newDriverValidator.validateCountryOfIssuance(new Registration(
        new Driver(name, birthday,
            new License(licenseNum, name, birthday, issueCountry2, issueDate, expirationDate)),
        insurance, vehicle)));
  }

  /**
   * Method: validateLicenseDateOfIssuance(Registration registration)
   */
  @Test
  public void testValidateLicenseDateOfIssuance() throws Exception {
    assertTrue(newDriverValidator.validateLicenseDateOfIssuance(registration));
    assertFalse(newDriverValidator.validateLicenseDateOfIssuance(new Registration(
        new Driver(name, birthday,
            new License(licenseNum, name, birthday, issueCountry, issueDate2, expirationDate)),
        insurance, vehicle)));
  }

  /**
   * Method: vaidateLicenseExpiration(Registration registration)
   */
  @Test
  public void vaidateLicenseExpiration() {
    assertTrue(newDriverValidator.vaidateLicenseExpiration(registration));
  }

  /**
   * Method: masterValidator(Registration registration)
   */
  @Test
  public void testMasterValidator() throws Exception {
    assertTrue(newDriverValidator.masterValidator(registration));
  }


}
