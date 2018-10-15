package edu.neu.ccs.cs5010.lab2;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.*;

/**
 * Restaurant Tester.
 *
 * @author timzyt
 * @version 1.0
 * @since <pre>Oct 2, 2018</pre>
 */
public class RestaurantTest {

  private String resName;
  private Boolean isOpen;
  private String str;
  private String city;
  private String zip;
  private String state;
  private String country;
  private String newResName;
  private String newStr;
  private List<String> meals;
  private List<String> desserts;
  private List<String> beverages;
  private List<String> drinks;
  private Address address1;
  private Menu menu;
  private Restaurant shakeShack;

  /**
   * Before.
   *
   * @throws Exception the exception
   */
  @Before
  public void before() throws Exception {
    resName = "ShakeShack";
    isOpen = true;
    str = "123 a St.";
    city = "Seattle";
    zip = "98109";
    state = "WA";
    country = "USA";

    menu = new Menu(meals, desserts, beverages, drinks);
    address1 = new Address(str, city, zip, state, country);
    shakeShack = new Restaurant(resName, address1, menu, isOpen);
  }

  /**
   * Method: getResName()
   *
   * @throws Exception the exception
   */
  @Test
  public void testGetResName() throws Exception {
    assertEquals(resName, shakeShack.getResName());
  }

  /**
   * Method: setResName(String resName)
   *
   * @throws Exception the exception
   */
  @Test
  public void testSetResName() throws Exception {
    newResName = "KFC";
    shakeShack.setResName(newResName);
    assertEquals(newResName, shakeShack.getResName());
  }


  /**
   * Test set res name 2.
   *
   * @throws Exception the exception
   */
  @Test(expected = NullPointerException.class)
  public void testSetResName2() throws Exception {
    shakeShack.setResName(newResName);
    assertEquals(newResName, shakeShack.getResName());
  }

  /**
   * Method: getIsOpen()
   *
   * @throws Exception the exception
   */
  @Test
  public void testGetIsOpen() throws Exception {
    assertTrue(shakeShack.getIsOpen());
  }

  /**
   * Method: setIsOpen(Boolean open)
   *
   * @throws Exception the exception
   */
  @Test(expected = NullPointerException.class)
  public void testSetIsOpen() throws Exception {
    shakeShack.setIsOpen(null);
  }

  /**
   * Method: setIsOpen(Boolean open)
   *
   * @throws Exception the exception
   */
  @Test
  public void testSetIsOpen2() throws Exception {
    isOpen = true;
    shakeShack.setIsOpen(isOpen);
  }

  /**
   * Method: getAddress()
   *
   * @throws Exception the exception
   */
  @Test
  public void testGetAddress() throws Exception {
    assertEquals(address1, shakeShack.getAddress());
  }

  /**
   * Method: setAddress(Address address)
   *
   * @throws Exception the exception
   */
  @Test(expected = NullPointerException.class)
  public void testSetAddress() throws Exception {
    shakeShack.setAddress(null);
  }

  /**
   * Method: setAddress(Address address)
   *
   * @throws Exception the exception
   */
  @Test
  public void testSetAddress2() throws Exception {
    shakeShack.setAddress(address1);
  }

  /**
   * Method: getMenu()
   *
   * @throws Exception the exception
   */
  @Test
  public void testGetMenu() throws Exception {
    assertEquals(menu, shakeShack.getMenu());
  }

  /**
   * Method: setMenu(Menu menu)
   *
   * @throws Exception the exception
   */
  @Test(expected = NullPointerException.class)
  public void testSetMenu() throws Exception {
    shakeShack.setMenu(null);
  }

  /**
   * Method: setMenu(Menu menu)
   *
   * @throws Exception the exception
   */
  @Test
  public void testSetMenu2() throws Exception {
    List<String> newMeal = new ArrayList<>();
    List<String> newDesserts = new ArrayList<>();
    List<String> newBeverages = new ArrayList<>();
    List<String> newDrinks = new ArrayList<>();
    newDrinks.add("coke");

    Menu menu2 = new Menu(newMeal, newDesserts, newBeverages, newDrinks);
    shakeShack.setMenu(menu2);
    assertEquals(menu2, shakeShack.getMenu());
  }
} 
