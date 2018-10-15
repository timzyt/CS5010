package edu.neu.ccs.cs5010.lab2;

/**
 * Public class Address.
 *
 * @author timzyt
 * @version 1.0
 * @since <pre>Oct 2, 2018</pre>
 */
public class Address {

  private String streetNumber;
  private String city;
  private String zipCode;
  private String state;
  private String country;

  /**
   * Instantiates a new Address.
   *
   * @param streetNumber a street number
   * @param city a city
   * @param zipCode a zip code
   * @param state a state
   * @param country a country
   */
  public Address(String streetNumber, String city, String zipCode, String state, String country) {

    this.streetNumber = streetNumber;
    this.city = city;
    this.zipCode = zipCode;
    this.state = state;
    this.country = country;

  }

  /**
   * Gets street number.
   *
   * @return the street number
   */
  public String getStreetNumber() {
    return streetNumber;
  }

  /**
   * Sets street number.
   *
   * @param streetNumber the street number
   * @throws Exception the exception
   */
  public void setStreetNumber(String streetNumber) throws Exception {
    if (streetNumber == null) {
      throw new NullPointerException("Provided input is null.");
    } else {
      this.streetNumber = streetNumber;
    }
  }

  /**
   * Gets city.
   *
   * @return the city
   */
  public String getCity() {
    return city;
  }

  /**
   * Sets city.
   *
   * @param city the city
   * @throws Exception the exception
   */
  public void setCity(String city) throws Exception {
    if (city == null) {
      throw new NullPointerException("Provided input is null.");
    } else {
      this.city = city;
    }
  }

  /**
   * Gets zip code.
   *
   * @return the zip code
   */
  public String getZipCode() {
    return zipCode;
  }

  /**
   * Sets zip code.
   *
   * @param zipCode the zip code
   * @throws Exception the exception
   */
  public void setZipCode(String zipCode) throws Exception {
    if (zipCode == null) {
      throw new NullPointerException("Provided input is null.");
    } else {
      this.zipCode = zipCode;
    }
  }

  /**
   * Gets state.
   *
   * @return the state
   */
  public String getState() {
    return state;
  }

  /**
   * Sets state.
   *
   * @param state the state
   * @throws Exception the exception
   */
  public void setState(String state) throws Exception {
    if (state == null) {
      throw new NullPointerException("Provided input is null.");
    } else {
      this.state = state;
    }
  }

  /**
   * Gets country.
   *
   * @return the country
   */
  public String getCountry() {
    return country;
  }

  /**
   * Sets country.
   *
   * @param country the country
   * @throws Exception the exception
   */
  public void setCountry(String country) throws Exception {
    if (country == null) {
      throw new NullPointerException("Provided input is null.");
    } else {
      this.country = country;
    }
  }
}
