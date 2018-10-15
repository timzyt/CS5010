package edu.neu.ccs.cs5010.assignment4.ridesharemodel.driver;

import edu.neu.ccs.cs5010.assignment4.exceptions.InvalidConstructorArgumentException;

import java.util.Objects;

/**
 * The Name class.
 */
public class Name {

  /**
   * The First name.
   */
  private String firstName;
  /**
   * The Last name.
   */
  private String lastName;

  /**
   * Instantiates a new Name.
   *
   * @param firstName the first name
   * @param lastName the last name
   */
  public Name(String firstName, String lastName) throws Exception {
    if (firstName == null) {
      throw new InvalidConstructorArgumentException();
    }
    if (lastName == null) {
      throw new InvalidConstructorArgumentException();
    }
    if (firstName.length() == 0) {
      throw new InvalidConstructorArgumentException();
    }
    if (lastName.length() == 0) {
      throw new InvalidConstructorArgumentException();
    }
    this.firstName = firstName;
    this.lastName = lastName;
  }


  /**
   * Sets first name.
   *
   * @param firstName the first name
   */
  public void setFirstName(String firstName) throws Exception {
    if (firstName == null) {
      throw new InvalidConstructorArgumentException();
    }
    if (firstName.length() == 0) {
      throw new InvalidConstructorArgumentException();
    }
    this.firstName = firstName;
  }

  /**
   * Sets last name.
   *
   * @param lastName the last name
   */
  public void setLastName(String lastName) throws Exception {
    if (lastName == null) {
      throw new InvalidConstructorArgumentException();
    }
    if (lastName.length() == 0) {
      throw new InvalidConstructorArgumentException();
    }
    this.lastName = lastName;
  }

  /**
   * Gets first name.
   *
   * @return the first name
   */
  public String getFirstName() {
    return this.firstName;
  }


  /**
   * Gets last name.
   *
   * @return the last name
   */
  public String getLastName() {
    return this.lastName;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof Name)) {
      return false;
    }
    Name name = (Name) obj;
    return Objects.equals(getFirstName(), name.getFirstName())
        && Objects.equals(lastName, name.lastName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(getFirstName(), lastName);
  }

  @Override
  public String toString() {
    return firstName + ' ' + lastName;
  }

}
