package edu.neu.ccs.cs5010.assignment4.ridesharemodel.driver.ridersharemodel.driver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import edu.neu.ccs.cs5010.assignment4.exceptions.InvalidConstructorArgumentException;
import edu.neu.ccs.cs5010.assignment4.ridesharemodel.driver.Country;
import edu.neu.ccs.cs5010.assignment4.ridesharemodel.driver.Driver;
import edu.neu.ccs.cs5010.assignment4.ridesharemodel.driver.License;
import edu.neu.ccs.cs5010.assignment4.ridesharemodel.driver.Name;
import java.time.LocalDate;
import org.junit.Test;
import org.junit.Before;

/**
 * Driver Tester.
 *
 * @author timzyt
 * @version 1.0
 * @since <pre>Oct 13, 2018</pre>
 */
public class DriverTest {

  private String firstName;
  private String lastName;
  private String firstName2;
  private String lastName2;
  private Name name;
  private Name name2;
  private LocalDate birthday;
  private LocalDate birthday2;
  private License license;
  private License license2;

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


  @Before
  public void before() throws Exception {
    firstName = "Tim";
    lastName = "Zhu";
    firstName2 = "Jack";
    lastName2 = "Ma";
    emptyFirstName = "";
    emptyLastName = "";
    birthday = LocalDate.of(1988, 04, 23);
    birthday2 = LocalDate.of(1989, 11, 02);
    name = new Name(firstName, lastName);
    name2 = new Name(firstName2, lastName2);
    licenseNum = "123abc";
    licenseNum2 = "456efg";
    issueCountry = Country.US;
    issueDate = LocalDate.of(2015, 01, 01);
    expirationDate = LocalDate.of(2020, 01, 01);

    license = new License(licenseNum, name, birthday, issueCountry, issueDate, expirationDate);
    license2 = new License(licenseNum2, name2, birthday2, issueCountry, issueDate, expirationDate);
    driver = new Driver(name, birthday, license);
  }

  @Test(expected = InvalidConstructorArgumentException.class)
  public void testNullName() throws Exception {
    Driver driver2 = new Driver(nullName, birthday, license);
  }

  @Test(expected = InvalidConstructorArgumentException.class)
  public void testNullBirthday() throws Exception {
    Driver driver3 = new Driver(name, nullBirhday, license);
  }

  @Test(expected = InvalidConstructorArgumentException.class)
  public void testNullLicense() throws Exception {
    Driver driver4 = new Driver(name, birthday, nullLicense);
  }

  /**
   * Method: getName()
   */
  @Test
  public void testGetName() throws Exception {
    assertEquals(name, driver.getName());
  }

  /**
   * Method: getBirthday()
   */
  @Test
  public void testGetBirthday() throws Exception {
    assertEquals(birthday, driver.getBirthday());
  }

  /**
   * Method: getLicense()
   */
  @Test
  public void testGetLicense() throws Exception {
    assertEquals(license, driver.getLicense());
  }

  /**
   * Method: setName(String firstName, String lastName)
   */
  @Test
  public void testSetName() throws Exception {
    driver.setName(firstName2, lastName2);
  }


  /**
   * Method: setBirthday(LocalDate birthday)
   */
  @Test
  public void testSetBirthday() throws Exception {
    driver.setBirthday(birthday2);
  }

  /**
   * Method: setBirthday(LocalDate birthday)
   */
  @Test(expected = InvalidConstructorArgumentException.class)
  public void testSetBirthday2() throws Exception {
    driver.setBirthday(nullBirhday);
  }

  /**
   * Method: setLicense(License license)
   */
  @Test
  public void testSetLicense() throws Exception {
    driver.setLicense(license2);
    assertEquals(license2, driver.getLicense());
  }

  /**
   * Method: setLicense(License license)
   */
  @Test(expected = InvalidConstructorArgumentException.class)
  public void testSetLicense2() throws Exception {
    driver.setLicense(nullLicense);
  }

  /**
   * Method: equals(Object o)
   */
  @Test
  public void testEquals() throws Exception {
    assertTrue(driver.equals(driver));
    Driver driver2 = new Driver(name, birthday, license);
    assertTrue(driver.equals(driver2));
    assertFalse(driver.equals(name));
    Driver driver3 = new Driver(name2, birthday, license);
    assertFalse(driver.equals(driver3));
  }

  /**
   * Method: hashCode()
   */
  @Test
  public void testHashCode() throws Exception {
    Driver driver2 = new Driver(name, birthday, license);
    assertTrue(driver.hashCode() == driver2.hashCode());
  }

  /**
   * Method: toString()
   */
  @Test
  public void testToString() throws Exception {
    System.out.println(driver);
  }


} 
