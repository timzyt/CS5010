package edu.neu.ccs.cs5010.lab2;

import java.util.List;

/**
 * Public class Menu.
 *
 * @author timzyt
 * @version 1.0
 * @since <pre>Oct 2, 2018</pre>
 */
public class Menu {

  private List<String> meals;
  private List<String> desserts;
  private List<String> beverages;
  private List<String> drinks;

  /**
   * Instantiates a new Menu.
   *
   * @param meals the a meals
   * @param desserts the a desserts
   * @param beverages the a beverages
   * @param drinks the a drinks
   */
  public Menu(List<String> meals, List<String> desserts, List<String> beverages,
      List<String> drinks) {

    this.meals = meals;
    this.desserts = desserts;
    this.beverages = beverages;
    this.drinks = drinks;

  }

  /**
   * Gets meals.
   *
   * @return the meals
   */
  public List<String> getMeals() {
    return meals;
  }

  /**
   * Sets meals.
   *
   * @param meals the meals
   * @throws Exception the exception
   */
  public void setMeals(List<String> meals) throws Exception {
    if (meals == null) {
      throw new NullPointerException("Provided input is null.");
    } else {
      this.meals = meals;
    }
  }

  /**
   * Gets desserts.
   *
   * @return the desserts
   */
  public List<String> getDesserts() {
    return desserts;
  }

  /**
   * Sets desserts.
   *
   * @param desserts the desserts
   * @throws Exception the exception
   */
  public void setDesserts(List<String> desserts) throws Exception {
    if (desserts == null) {
      throw new NullPointerException("Provided input is null.");
    } else {
      this.desserts = desserts;
    }
  }

  /**
   * Gets beverages.
   *
   * @return the beverages
   */
  public List<String> getBeverages() {
    return beverages;
  }

  /**
   * Sets beverages.
   *
   * @param beverages the beverages
   * @throws Exception the exception
   */
  public void setBeverages(List<String> beverages) throws Exception {
    if (beverages == null) {
      throw new NullPointerException("Provided input is null.");
    } else {
      this.beverages = beverages;
    }
  }

  /**
   * Gets drinks.
   *
   * @return the drinks
   */
  public List<String> getDrinks() {
    return drinks;
  }

  /**
   * Sets drinks.
   *
   * @param drinks the drinks
   * @throws Exception the exception
   */
  public void setDrinks(List<String> drinks) throws Exception {
    if (drinks == null) {
      throw new NullPointerException("Provided input is null.");
    } else {
      this.drinks = drinks;
    }
  }
}
