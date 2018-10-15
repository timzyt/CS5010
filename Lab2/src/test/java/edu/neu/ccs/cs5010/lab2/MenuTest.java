package edu.neu.ccs.cs5010.lab2;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

/**
 * Menu Tester.
 *
 * @author timzyt
 * @version 1.0
 * @since <pre>Oct 2, 2018</pre>
 */
public class MenuTest {

  private List<String> meals;
  private List<String> desserts;
  private List<String> beverages;
  private List<String> drinks;
  private Menu menu;
  private List<String> meals2;
  private List<String> desserts2;
  private List<String> beverages2;
  private List<String> drinks2;

  /**
   * Before.
   *
   * @throws Exception the exception
   */
  @Before
  public void before() throws Exception {

    menu = new Menu(meals, desserts, beverages, drinks);
  }

  /**
   * Method: getMeals()
   *
   * @throws Exception the exception
   */
  @Test
  public void testGetMeals() throws Exception {
    assertEquals(meals, menu.getMeals());
  }

  /**
   * Method: setMeals(List<String> meals)
   *
   * @throws Exception the exception
   */
  @Test
  public void testSetMeals() throws Exception {
    meals2 = new ArrayList<String>();
    meals2.add("burger");
    menu.setMeals(meals2);
    assertEquals(meals2, menu.getMeals());
  }

  /**
   * Method: setMeals(List<String> meals)
   *
   * @throws Exception the exception
   */
  @Test(expected = NullPointerException.class)
  public void testSetMeals2() throws Exception {
    menu.setMeals(null);
  }

  /**
   * Method: getDesserts()
   *
   * @throws Exception the exception
   */
  @Test
  public void testGetDesserts() throws Exception {
    assertEquals(desserts, menu.getDesserts());
  }

  /**
   * Method: setDesserts(List<String> desserts)
   *
   * @throws Exception the exception
   */
  @Test
  public void testSetDesserts() throws Exception {
    desserts2 = new ArrayList<String>();
    desserts2.add("ice cream");
    menu.setDesserts(desserts2);
    assertEquals(desserts2, menu.getDesserts());
  }

  /**
   * Method: setDesserts(List<String> desserts)
   *
   * @throws Exception the exception
   */
  @Test (expected = NullPointerException.class)
  public void testSetDesserts2() throws Exception {
    menu.setDesserts(null);
  }

  /**
   * Method: getBeverages()
   *
   * @throws Exception the exception
   */
  @Test
  public void testGetBeverages() throws Exception {
    assertEquals(beverages, menu.getBeverages());
  }

  /**
   * Method: setBeverages(List<String> beverages)
   *
   * @throws Exception the exception
   */
  @Test
  public void testSetBeverages() throws Exception {
    beverages2 = new ArrayList<String>();
    beverages2.add("coke");
    menu.setBeverages(beverages2);
    assertEquals(beverages2, menu.getBeverages());
  }

  /**
   * Method: setBeverages(List<String> beverages)
   *
   * @throws Exception the exception
   */
  @Test (expected = NullPointerException.class)
  public void testSetBeverages2() throws Exception {
    menu.setBeverages(null);
  }


  /**
   * Method: getDrinks()
   *
   * @throws Exception the exception
   */
  @Test
  public void testGetDrinks() throws Exception {
    assertEquals(drinks, menu.getDrinks());
  }

  /**
   * Method: setDrinks(List<String> drinks)
   *
   * @throws Exception the exception
   */
  @Test
  public void testSetDrinks() throws Exception {
    drinks2 = new ArrayList<String>();
    drinks2.add("beer");
    menu.setDrinks(drinks2);
    assertEquals(drinks2,menu.getDrinks() );
  }

  /**
   * Method: setDrinks(List<String> drinks)
   *
   * @throws Exception the exception
   */
  @Test (expected = NullPointerException.class)
  public void testSetDrinks2() throws Exception {
    menu.setDrinks(null);
  }
} 
