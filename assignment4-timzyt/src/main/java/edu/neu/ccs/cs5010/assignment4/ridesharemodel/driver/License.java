package edu.neu.ccs.cs5010.assignment4.ridesharemodel.driver;

import edu.neu.ccs.cs5010.assignment4.exceptions.InvalidConstructorArgumentException;

import java.time.LocalDate;
import java.util.Objects;

/**
 * The License class.
 */
public class License {

  private String licenseNum;
  private Name name;
  private LocalDate birthday;
  private Country issueCountry;
  private LocalDate issueDate;
  private LocalDate expirationDate;


  /**
   * Instantiates a new License.
   *
   * @param licenseNum the license num
   * @param name the name
   * @param birthday the birthday
   * @param issueCountry the issue country
   * @param issueDate the issue date
   * @param expirationDate the expiration date
   */
  public License(String licenseNum, Name name, LocalDate birthday, Country issueCountry,
      LocalDate issueDate, LocalDate expirationDate) {
    if (licenseNum == null) {
      throw new InvalidConstructorArgumentException();
    }
    if (name == null) {
      throw new InvalidConstructorArgumentException();
    }
    if (birthday == null) {
      throw new InvalidConstructorArgumentException();
    }
    if (issueCountry == null) {
      throw new InvalidConstructorArgumentException();
    }
    if (issueDate == null) {
      throw new InvalidConstructorArgumentException();
    }
    if (expirationDate == null) {
      throw new InvalidConstructorArgumentException();
    }
    this.licenseNum = licenseNum;
    this.name = name;
    this.birthday = LocalDate.of(birthday.getYear(), birthday.getMonth(), birthday.getDayOfMonth());
    this.issueCountry = issueCountry;
    this.issueDate = LocalDate
        .of(issueDate.getYear(), issueDate.getMonth(), issueDate.getDayOfMonth());
    this.expirationDate = LocalDate
        .of(expirationDate.getYear(), expirationDate.getMonth(), expirationDate.getDayOfMonth());
  }


  /**
   * Gets license num.
   *
   * @return the license num
   */
  public String getLicenseNum() {
    return licenseNum;
  }

  /**
   * Gets name on the license.
   *
   * @return the name
   */
  public Name getName() {
    return name;
  }


  /**
   * Gets birthday on the license.
   *
   * @return the birthday
   */
  public LocalDate getBirthday() {
    LocalDate queryBirthday = LocalDate
        .of(this.birthday.getYear(), this.birthday.getMonth(), this.birthday.getDayOfMonth());
    return queryBirthday;
  }

  /**
   * Gets issuance country on the license.
   *
   * @return the issue country
   */
  public Country getIssueCountry() {
    return issueCountry;
  }

  /**
   * Gets issue date on the license.
   *
   * @return the issue date
   */
  public LocalDate getIssueDate() {
    LocalDate queryIssueDate = LocalDate
        .of(this.issueDate.getYear(), this.issueDate.getMonth(), this.issueDate.getDayOfMonth());
    return queryIssueDate;
  }

  /**
   * Gets expiration date on the license.
   *
   * @return the expiration date
   */
  public LocalDate getExpirationDate() {
    LocalDate queryExpirationDate = LocalDate
        .of(expirationDate.getYear(), expirationDate.getMonth(), expirationDate.getDayOfMonth());
    return queryExpirationDate;
  }

  /**
   * Sets expiration date.
   *
   * @param expirationDate the expiration date
   */
  public void setExpirationDate(LocalDate expirationDate) throws Exception {
    if (expirationDate == null) {
      throw new InvalidConstructorArgumentException();
    }
    this.expirationDate = LocalDate
        .of(expirationDate.getYear(), expirationDate.getMonth(), expirationDate.getDayOfMonth());
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof License)) {
      return false;
    }
    License license = (License) obj;
    return Objects.equals(getLicenseNum(), license.getLicenseNum())
        && Objects.equals(getName(), license.getName())
        && Objects.equals(getBirthday(), license.getBirthday())
        && getIssueCountry() == license.getIssueCountry()
        && Objects.equals(getIssueDate(), license.getIssueDate())
        && Objects.equals(getExpirationDate(), license.getExpirationDate());
  }

  @Override
  public int hashCode() {
    return Objects
        .hash(getLicenseNum(), getName(), getBirthday(), getIssueCountry(), getIssueDate(),
            getExpirationDate());
  }

  @Override
  public String toString() {
    return "License{"
        + "licenseNum = " + licenseNum
        + ", name = " + name
        + ", birthday = " + birthday.getYear() + '-' + birthday.getMonth() + '-' + birthday
        .getDayOfMonth()
        + ", issueCountry = " + issueCountry
        + ", issueDate = " + issueDate.getYear() + '-' + issueDate.getMonth() + '-' + issueDate
        .getDayOfMonth()
        + ", expirationDate = " + expirationDate.getYear() + '-' + expirationDate.getMonth() + '-'
        + expirationDate.getDayOfMonth() + '}';
  }
}
