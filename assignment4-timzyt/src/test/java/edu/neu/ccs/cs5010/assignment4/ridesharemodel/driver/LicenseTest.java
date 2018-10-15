package edu.neu.ccs.cs5010.assignment4.ridesharemodel.driver.ridersharemodel.driver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import edu.neu.ccs.cs5010.assignment4.exceptions.InvalidConstructorArgumentException;
import edu.neu.ccs.cs5010.assignment4.ridesharemodel.driver.Country;
import edu.neu.ccs.cs5010.assignment4.ridesharemodel.driver.License;
import edu.neu.ccs.cs5010.assignment4.ridesharemodel.driver.Name;
import java.time.LocalDate;
import org.junit.Test;
import org.junit.Before;

/**
 * License Tester.
 *
 * @author timzyt
 * @version 1.0
 * @since <pre>Oct 13, 2018</pre>
 */
public class LicenseTest {

  private String licenseNum;
  private Name name;
  private String firstName;
  private String lastName;
  private LocalDate birthday;
  private Country issueCountry;
  private Country issueCountry2;
  private LocalDate issueDate;
  private LocalDate expirationDate;

  private License license;

  @Before
  public void before() throws Exception {
    licenseNum = "123abc";
    firstName = "Tim";
    lastName = "Zhu";
    birthday = LocalDate.of(1988, 04, 23);
    issueCountry = Country.US;
    issueCountry2 = Country.Canada;
    issueDate = LocalDate.of(2015, 01, 01);
    expirationDate = LocalDate.of(2020, 01, 01);
    name = new Name(firstName, lastName);
    license = new License(licenseNum, name, birthday, issueCountry, issueDate, expirationDate);
  }

  @Test(expected = InvalidConstructorArgumentException.class)
  public void testNullLicenseNum() throws Exception {
    License license1 = new License(null, name, birthday, issueCountry, issueDate, expirationDate);
  }

  @Test(expected = InvalidConstructorArgumentException.class)
  public void testNullName() throws Exception {
    License license1 = new License(licenseNum, null, birthday, issueCountry, issueDate, expirationDate);
  }

  @Test(expected = InvalidConstructorArgumentException.class)
  public void testNullBirthday() throws Exception {
    License license1 = new License(licenseNum, name, null, issueCountry, issueDate, expirationDate);
  }

  @Test(expected = InvalidConstructorArgumentException.class)
  public void testNullIssueCountry() throws Exception {
    License license1 = new License(licenseNum, name, birthday, null, issueDate, expirationDate);
  }

  @Test(expected = InvalidConstructorArgumentException.class)
  public void testNullIssueDate() throws Exception {
    License license1 = new License(licenseNum, name, birthday, issueCountry, null, expirationDate);
  }

  @Test(expected = InvalidConstructorArgumentException.class)
  public void testNullExpirationDate() throws Exception {
    License license1 = new License(licenseNum, name, birthday, issueCountry, issueDate, null);
  }

  /**
   * Method: getLicenseNum()
   */
  @Test
  public void testGetLicenseNum() throws Exception {
    assertEquals(licenseNum, license.getLicenseNum());
  }

  /**
   * Method: getName()
   */
  @Test
  public void testGetName() throws Exception {
    assertEquals(name, license.getName());
  }

  /**
   * Method: getBirthday()
   */
  @Test
  public void testGetBirthday() throws Exception {
    assertEquals(birthday, license.getBirthday());
  }

  /**
   * Method: getIssueCountry()
   */
  @Test
  public void testGetIssueCountry() throws Exception {
    assertEquals(issueCountry, license.getIssueCountry());
  }

  /**
   * Method: getIssueDate()
   */
  @Test
  public void testGetIssueDate() throws Exception {
    assertEquals(issueDate, license.getIssueDate());
  }

  /**
   * Method: getExpirationDate()
   */
  @Test
  public void testGetExpirationDate() throws Exception {
    assertEquals(expirationDate, license.getExpirationDate());
  }

  /**
   * Method: setExpirationDate(LocalDate expirationDate)
   */
  @Test
  public void testSetExpirationDate() throws Exception {
    LocalDate expirationDate2 = LocalDate.of(2025, 1, 1);
    license.setExpirationDate(expirationDate2);
    assertEquals(expirationDate2, license.getExpirationDate());
  }

  /**
   * Method: setExpirationDate(LocalDate expirationDate)
   */
  @Test (expected = InvalidConstructorArgumentException.class)
  public void testSetExpirationDate2() throws Exception {
    license.setExpirationDate(null);
  }

  /**
   * Method: equals(Object o)
   */
  @Test
  public void testEquals() throws Exception {
    assertTrue(license.equals(license));
    License license2 = new License(licenseNum, name, birthday, issueCountry, issueDate,
        expirationDate);
    assertTrue(license.equals(license2));
    assertFalse(license.equals(name));
    License license3 = new License(licenseNum, name, birthday, issueCountry2, issueDate,
        expirationDate);
    assertFalse(license.equals(license3));
  }

  /**
   * Method: hashCode()
   */
  @Test
  public void testHashCode() throws Exception {
    License license2 = new License(licenseNum, name, birthday, issueCountry, issueDate,
        expirationDate);
    assertTrue(license.hashCode() == license2.hashCode());
  }

  /**
   * Method: toString()
   */
  @Test
  public void testToString() throws Exception {
    System.out.println(license);
  }


} 
