package edu.neu.ccs.cs5010.assignment4.ridesharemodel.driver.ridersharemodel.vehicle;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import edu.neu.ccs.cs5010.assignment4.exceptions.InvalidConstructorArgumentException;
import edu.neu.ccs.cs5010.assignment4.exceptions.InvalidVehicleYearException;
import edu.neu.ccs.cs5010.assignment4.ridesharemodel.driver.Country;
import edu.neu.ccs.cs5010.assignment4.ridesharemodel.driver.Driver;
import edu.neu.ccs.cs5010.assignment4.ridesharemodel.driver.License;
import edu.neu.ccs.cs5010.assignment4.ridesharemodel.driver.Name;
import edu.neu.ccs.cs5010.assignment4.ridesharemodel.vehicle.Vehicle;
import java.time.LocalDate;
import org.junit.Test;
import org.junit.Before;

/**
 * Vehicle Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Oct 13, 2018</pre>
 */
public class VehicleTest {

  private String firstName;
  private String lastName;
  private String firstName2;
  private String lastName2;
  private Name name;
  private Name name2;
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

  private Driver driver;
  private Vehicle vehicle;

  @Before
  public void before() throws Exception {
    firstName = "Tim";
    lastName = "Zhu";
    firstName2 = "Jack";
    lastName2 = "Ma";
    emptyFirstName = "";
    emptyLastName = "";
    year = 2012;
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
    make = "Honda";
    model = "Civic";
    color = "Black";
    licensePlate = "BBB5421";

    license = new License(licenseNum, name, birthday, issueCountry, issueDate, expirationDate);
    license2 = new License(licenseNum2, name2, birthday2, issueCountry, issueDate, expirationDate);
    driver = new Driver(name, birthday, license);
    vehicle = new Vehicle(driver, year, make, model, color, licensePlate);
  }

  @Test(expected = InvalidConstructorArgumentException.class)
  public void testNullOwner() throws Exception {
    vehicle = new Vehicle(null, year, make, model, color, licensePlate);
  }

  @Test(expected = InvalidConstructorArgumentException.class)
  public void testNullYear() throws Exception {
    vehicle = new Vehicle(driver, null, make, model, color, licensePlate);
  }

  @Test(expected = InvalidVehicleYearException.class)
  public void testInvalidYear1() throws Exception {
    vehicle = new Vehicle(driver, invalidYear1, make, model, color, licensePlate);
  }

  @Test(expected = InvalidVehicleYearException.class)
  public void testInvalidYear2() throws Exception {
    vehicle = new Vehicle(driver, invalidYear2, make, model, color, licensePlate);
  }

  @Test(expected = InvalidConstructorArgumentException.class)
  public void testNullMake() throws Exception {
    vehicle = new Vehicle(driver, year, null, model, color, licensePlate);
  }

  @Test(expected = InvalidConstructorArgumentException.class)
  public void testEmptyMake() throws Exception {
    vehicle = new Vehicle(driver, year, "", model, color, licensePlate);
  }

  @Test(expected = InvalidConstructorArgumentException.class)
  public void testNullModel() throws Exception {
    vehicle = new Vehicle(driver, year, make, null, color, licensePlate);
  }

  @Test(expected = InvalidConstructorArgumentException.class)
  public void testEmptyModel() throws Exception {
    vehicle = new Vehicle(driver, year, make, "", color, licensePlate);
  }

  @Test(expected = InvalidConstructorArgumentException.class)
  public void testNullColor() throws Exception {
    vehicle = new Vehicle(driver, year, make, model, null, licensePlate);
  }

  @Test(expected = InvalidConstructorArgumentException.class)
  public void testEmptyColor() throws Exception {
    vehicle = new Vehicle(driver, year, make, model, "", licensePlate);
  }

  @Test(expected = InvalidConstructorArgumentException.class)
  public void testNullLicensePlate() throws Exception {
    vehicle = new Vehicle(driver, year, make, model, color, null);
  }

  @Test(expected = InvalidConstructorArgumentException.class)
  public void testEmptyLicesePlate() throws Exception {
    vehicle = new Vehicle(driver, year, make, model, color, "");
  }


  /**
   * Method: getOwner()
   */
  @Test
  public void testGetOwner() throws Exception {
    assertEquals(driver, vehicle.getOwner());
  }

  /**
   * Method: getYear()
   */
  @Test
  public void testGetYear() throws Exception {
    assertEquals(year, vehicle.getYear());
  }

  /**
   * Method: getMake()
   */
  @Test
  public void testGetMake() throws Exception {
    assertEquals(make, vehicle.getMake());
  }

  /**
   * Method: getModel()
   */
  @Test
  public void testGetModel() throws Exception {
    assertEquals(model, vehicle.getModel());
  }

  /**
   * Method: getColor()
   */
  @Test
  public void testGetColor() throws Exception {
    assertEquals(color, vehicle.getColor());
  }

  /**
   * Method: getLicensePlate()
   */
  @Test
  public void testGetLicensePlate() throws Exception {
    assertEquals(licensePlate, vehicle.getLicensePlate());
  }

  /**
   * Method: setLicensePlate(String licensePlate)
   */
  @Test
  public void testSetLicensePlate() throws Exception {
    String newLicensePlate = "854aec";
    vehicle.setLicensePlate(newLicensePlate);
    assertEquals(newLicensePlate, vehicle.getLicensePlate());
  }

  /**
   * Method: setLicensePlate(String licensePlate)
   */
  @Test(expected = InvalidConstructorArgumentException.class)
  public void testSetNullLicensePlate() throws Exception {
    vehicle.setLicensePlate(null);
  }

  /**
   * Method: setLicensePlate(String licensePlate)
   */
  @Test(expected = InvalidConstructorArgumentException.class)
  public void testSetEmptyLicensePlate() throws Exception {
    vehicle.setLicensePlate("");
  }

  /**
   * Method: getPersonInDriverSeat()
   */
  @Test
  public void testGetPersonInDriverSeat() throws Exception {
    Driver driver2 = new Driver(name2, birthday2, license2);
    vehicle.setPersonInDriverSeat(driver2);
    assertEquals(driver2, vehicle.getPersonInDriverSeat());
  }

  /**
   * Method: setPersonInDriverSeat(Driver personInDriverSeat)
   */
  @Test
  public void testSetPersonInDriverSeat() throws Exception {
    Driver driver2 = new Driver(name2, birthday2, license2);
    vehicle.setPersonInDriverSeat(driver2);
    assertEquals(driver2, vehicle.getPersonInDriverSeat());
  }

  /**
   * Method: equals(Object o)
   */
  @Test
  public void testEquals() throws Exception {
    assertTrue(vehicle.equals(vehicle));
    assertTrue(vehicle.equals(new Vehicle(driver, year, make, model, color, licensePlate)));
    assertFalse(vehicle.equals(driver));
    Driver driver2 = new Driver(name2, birthday2, license2);
    assertFalse(vehicle.equals(new Vehicle(driver2, year, make, model, color, licensePlate)));
  }

  /**
   * Method: hashCode()
   */
  @Test
  public void testHashCode() throws Exception {
    assertTrue(vehicle.hashCode() == new Vehicle(driver, year, make, model, color, licensePlate)
        .hashCode());
  }

  /**
   * Method: toString()
   */
  @Test
  public void testToString() throws Exception {
    System.out.print(vehicle);
  }


} 
