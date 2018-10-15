package edu.neu.ccs.cs5010.assignment4.ridesharemodel.driver;

import edu.neu.ccs.cs5010.assignment4.exceptions.InvalidConstructorArgumentException;

import java.time.LocalDate;
import java.util.Objects;

/**
 * The driver class.
 */
public class Driver {

  private Name name;
  private LocalDate birthday;
  private License license;

  /**
   * Instantiates a new driver.
   *
   * @param name the name
   * @param birthday the birthday
   * @param license the license
   */
  public Driver(Name name, LocalDate birthday, License license) throws Exception {
    if (name == null) {
      throw new InvalidConstructorArgumentException();
    }
    if (birthday == null) {
      throw new InvalidConstructorArgumentException();
    }
    if (license == null) {
      throw new InvalidConstructorArgumentException();
    }
    this.name = name;
    this.birthday = LocalDate.of(birthday.getYear(), birthday.getMonth(), birthday.getDayOfMonth());
    this.license = license;
  }


  /**
   * Gets the driver name.
   *
   * @return the name
   */
  public Name getName() {
    return name;
  }

  /**
   * Gets the driver's birthday.
   *
   * @return the birthday
   */
  public LocalDate getBirthday() {
    LocalDate queryBirthday = LocalDate
        .of(this.birthday.getYear(), this.birthday.getMonth(), this.birthday.getDayOfMonth());
    return queryBirthday;
  }


  /**
   * Gets the driver's license.
   *
   * @return the license
   */
  public License getLicense() {
    return license;
  }


  /**
   * Sets name for the driver.
   *
   * @param firstName the first name
   * @param lastName the last name
   */
  public void setName(String firstName, String lastName) throws Exception {
    this.name.setFirstName(firstName);
    this.name.setLastName(lastName);
  }

  /**
   * Sets birthday for the driver.
   *
   * @param birthday the birthday
   */
  public void setBirthday(LocalDate birthday) throws Exception {
    if (birthday == null) {
      throw new InvalidConstructorArgumentException();
    }
    this.birthday = LocalDate.of(birthday.getYear(), birthday.getMonth(), birthday.getDayOfMonth());
  }

  /**
   * Sets license for the driver.
   *
   * @param license the license
   */
  public void setLicense(License license) throws Exception {
    if (license == null) {
      throw new InvalidConstructorArgumentException();
    }
    this.license = license;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof Driver)) {
      return false;
    }
    Driver driver = (Driver) obj;
    return Objects.equals(getName(), driver.getName())
        && Objects.equals(getBirthday(), driver.getBirthday())
        && Objects.equals(getLicense(), driver.getLicense());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getName(), getBirthday(), getLicense());
  }

  @Override
  public String toString() {
    return "driver{"
        + "name = " + name
        + ", birthday = " + birthday.getYear() + '-' + birthday.getMonth() + '-'
        + birthday.getDayOfMonth()
        + ", license Number = " + license.getLicenseNum() + '}';
  }

}
