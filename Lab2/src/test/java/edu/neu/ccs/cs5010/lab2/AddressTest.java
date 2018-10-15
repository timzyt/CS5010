package edu.neu.ccs.cs5010.lab2;

import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.*;

/**
 * Address Tester.
 *
 * @author timzyt
 * @version 1.0
 * @since <pre>Oct 2, 2018</pre>
 */
public class AddressTest {

  private String str;
  private String city;
  private String zip;
  private String state;
  private String country;
  private Address address;

  /**
   * Before.
   *
   * @throws Exception the exception
   */
  @Before
  public void before() throws Exception {
    str = "123 a St.";
    city = "Seattle";
    zip = "98109";
    state = "WA";
    country = "USA";
    address = new Address(str, city, zip, state, country);
  }

  /**
   * Method: getStreetNumber()
   *
   * @throws Exception the exception
   */
  @Test
  public void testGetStreetNumber() throws Exception {
    assertEquals(str, address.getStreetNumber());
  }

  /**
   * Method: setStreetNumber(String streetNumber)
   *
   * @throws Exception the exception
   */
  @Test
  public void testSetStreetNumber() throws Exception {
    String newStr = "456 b St.";
    address.setStreetNumber(newStr);
    assertEquals(newStr, address.getStreetNumber());
  }

  /**
   * Method: setStreetNumber(String streetNumber)
   *
   * @throws Exception the exception
   */
  @Test(expected = NullPointerException.class)
  public void testSetStreetNumber2() throws Exception {
    address.setStreetNumber(null);
  }

  /**
   * Method: getCity()
   *
   * @throws Exception the exception
   */
  @Test
  public void testGetCity() throws Exception {
    assertEquals(city, address.getCity());
  }

  /**
   * Method: setCity(String city)
   *
   * @throws Exception the exception
   */
  @Test
  public void testSetCity() throws Exception {
    String newCity = "Portland";
    address.setCity(newCity);
    assertEquals(newCity, address.getCity());
  }

  /**
   * Method: setCity(String city)
   *
   * @throws Exception the exception
   */
  @Test(expected = NullPointerException.class)
  public void testSetCity2() throws Exception {
    address.setCity(null);
  }

  /**
   * Method: getZipCode()
   *
   * @throws Exception the exception
   */
  @Test
  public void testGetZipCode() throws Exception {
    assertEquals(zip, address.getZipCode());
  }

  /**
   * Method: setZipCode(String zipCode)
   *
   * @throws Exception the exception
   */
  @Test
  public void testSetZipCode() throws Exception {
    String newZip = "97204";
    address.setZipCode(newZip);
    assertEquals(newZip, address.getZipCode());
  }

  /**
   * Method: setZipCode(String zipCode)
   *
   * @throws Exception the exception
   */
  @Test(expected = NullPointerException.class)
  public void testSetZipCode2() throws Exception {
    address.setZipCode(null);
  }

  /**
   * Method: getState()
   *
   * @throws Exception the exception
   */
  @Test
  public void testGetState() throws Exception {
    assertEquals(state, address.getState());
  }

  /**
   * Method: setState(String state)
   *
   * @throws Exception the exception
   */
  @Test
  public void testSetState() throws Exception {
    String newState = "OR";
    address.setState(newState);
    assertEquals(newState, address.getState());
  }

  /**
   * Method: setState(String state)
   *
   * @throws Exception the exception
   */
  @Test(expected = NullPointerException.class)
  public void testSetState2() throws Exception {
    address.setState(null);
  }

  /**
   * Method: getCountry()
   *
   * @throws Exception the exception
   */
  @Test
  public void testGetCountry() throws Exception {
    assertEquals(country, address.getCountry());
  }

  /**
   * Method: setCountry(String country)
   *
   * @throws Exception the exception
   */
  @Test
  public void testSetCountry() throws Exception {
    String newCountry = "Canada";
    address.setCountry(newCountry);
    assertEquals(newCountry, address.getCountry());
  }

  /**
   * Method: setCountry(String country)
   *
   * @throws Exception the exception
   */
  @Test(expected = NullPointerException.class)
  public void testSetCountry2() throws Exception {
    address.setCountry(null);
  }
} 
