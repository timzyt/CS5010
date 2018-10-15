package edu.neu.ccs.cs5010.assignment4.ridesharemodel.insurance;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import edu.neu.ccs.cs5010.assignment4.exceptions.InvalidConstructorArgumentException;
import edu.neu.ccs.cs5010.assignment4.ridesharemodel.insurance.Insurance;
import edu.neu.ccs.cs5010.assignment4.ridesharemodel.driver.Country;
import edu.neu.ccs.cs5010.assignment4.ridesharemodel.driver.Driver;
import edu.neu.ccs.cs5010.assignment4.ridesharemodel.driver.License;
import edu.neu.ccs.cs5010.assignment4.ridesharemodel.driver.Name;
import edu.neu.ccs.cs5010.assignment4.ridesharemodel.vehicle.Vehicle;

import java.time.LocalDate;
import java.util.HashSet;
import org.junit.Test;
import org.junit.Before;


/**
 * Insurance Tester.
 *
 * @author timzyt
 * @version 1.0
 * @since <pre>Oct 13, 2018</pre>
 */
public class InsuranceTest {

  private String firstName;
  private String lastName;
  private String firstName2;
  private String lastName2;
  private LocalDate birthday;
  private String licenseNum;
  private Country issueCountry;
  private Integer year;
  private LocalDate issueDate;
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

  private Insurance insurance;

  @Before
  public void before() throws Exception {
    firstName = "Tim";
    lastName = "Zhu";
    firstName2 = "Jack";
    lastName2 = "Ma";
    year = 2012;
    birthday = LocalDate.of(1988, 04, 23);
    issueDate = LocalDate.of(2015, 01, 01);
    expirationDate = LocalDate.of(2020, 01, 01);
    name = new Name(firstName, lastName);
    name2 = new Name(firstName2, lastName2);
    licenseNum = "123abc";
    issueCountry = Country.US;
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
  }

  @Test(expected = InvalidConstructorArgumentException.class)
  public void testNullOwner() throws Exception {
    Insurance insurance1 = new Insurance(null, vehicle, insuredDrivers, expirationDate);
  }

  @Test(expected = InvalidConstructorArgumentException.class)
  public void testNullVehicle() throws Exception {
    Insurance insurance2 = new Insurance(owner, null, insuredDrivers, expirationDate);
  }

  @Test(expected = InvalidConstructorArgumentException.class)
  public void testNullExpirationDate() throws Exception {
    Insurance insurance2 = new Insurance(owner, vehicle, insuredDrivers, null);
  }

  /**
   * Method: getOwner()
   */
  @Test
  public void testGetOwner() throws Exception {
    assertEquals(owner, insurance.getOwner());
  }

  /**
   * Method: getVehicle()
   */
  @Test
  public void testGetVehicle() throws Exception {
    assertEquals(vehicle, insurance.getVehicle());
  }

  /**
   * Method: getInsuredDrivers()
   */
  @Test
  public void testGetInsuredDrivers() throws Exception {
    insuredDrivers.add(owner);
    assertEquals(insuredDrivers, insurance.getInsuredDrivers());
  }

  /**
   * Method: getExpirationDate()
   */
  @Test
  public void testGetExpirationDate() throws Exception {
    assertEquals(expirationDate, insurance.getExpirationDate());
  }

  /**
   * Method: equals(Object o)
   */
  @Test
  public void testEquals() throws Exception {
    insuredDrivers.add(owner);
    assertTrue(insurance.equals(insurance));
    assertTrue(insurance.equals(new Insurance(owner, vehicle, insuredDrivers, expirationDate)));
    assertFalse(insurance.equals(new Insurance(owner2, vehicle, insuredDrivers, expirationDate)));
    assertFalse(insurance.equals(owner));
  }


  /**
   * Method: hashCode()
   */
  @Test
  public void testHashCode() throws Exception {
    assertTrue(insurance.hashCode() == new Insurance(owner, vehicle, insuredDrivers, expirationDate)
        .hashCode());
  }

  /**
   * Method: toString()
   */
  @Test
  public void testToString() throws Exception {
    insurance = new Insurance(owner, vehicle, null, expirationDate);
    System.out.print(insurance);
  }

  /**
   * Method: toString()
   */
  @Test
  public void testToString2() throws Exception {
    Driver driver2 = new Driver(name2, LocalDate.of(1960, 01, 01),
        new License("123asd", name2, LocalDate.of(1960, 01, 01), Country.US,
            LocalDate.of(2012, 12, 02),
            LocalDate.of(2025, 06, 01)));
    insuredDrivers = new HashSet<Driver>();
    insuredDrivers.add(owner);
    insuredDrivers.add(driver2);
    insurance = new Insurance(owner, vehicle, insuredDrivers, expirationDate);
    System.out.print(insurance);
  }


} 
