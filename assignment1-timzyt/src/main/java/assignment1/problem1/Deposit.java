package assignment1.problem1;

import java.util.Objects;

/**
 * Created by timzyt on 9/9/2018. Deposit class uses for storing deposit amount and information
 */
public class Deposit {

  private int dollar;
  private int cent;
  private String fName;
  private String lName;

  /**
   * Constructs and initialize a Deposit amount(dollar.cent)
   *
   * @param dollar dollar amount of a deposit
   * @param cent cent amount of a Deposit
   * @param fName first name of provided card owner
   * @param lName last name of provided card owner
   */
  public Deposit(int dollar, int cent, String fName, String lName) {

    if (dollar >= 5 & dollar <= 50) {
      this.dollar = dollar;
    } else {
      throw new IllegalArgumentException("dollar of this deposit is out of range");
    }
    if ((this.dollar == 50 && cent == 0) || (this.dollar >= 0 && this.dollar < 50
        && cent >= 0 && cent <= 99)) {
      this.cent = cent;
    } else {
      throw new IllegalArgumentException("cent of this deposit is out of range");
    }
    if (fName == null || fName.length() == 0) {
      throw new IllegalArgumentException("this first name is not valid");
    } else {
      this.fName = fName;
    }
    if (lName == null || lName.length() == 0) {
      throw new IllegalArgumentException("this last name is not valid");
    } else {
      this.lName = lName;
    }
  }

  //setter set values of dollar and cent in deposit

  /**
   * set the value range of dollar to be equal or greater than 0.
   *
   * @param dollar dollar amount of a deposit pre dollar [5,50].
   */
  public void setDollar(Integer dollar) {
    if (dollar >= 5 && dollar <= 50) {
      this.dollar = dollar;
    } else {
      throw new IllegalArgumentException("dollar of this deposit is out of range");
    }
  }

  /**
   * set the value range of cent to be equal or greater than 0, and equal or less than 99.
   *
   * @param cent cent amount of a deposit pre cent [0,99].
   */
  public void setCent(Integer cent) {
    if ((this.dollar == 50 && cent == 0) || (this.dollar >= 0 && this.dollar < 50
        && cent >= 0 && cent <= 99)) {
      this.cent = cent;
    } else {
      throw new IllegalArgumentException("cent of this deposit is out of range");
    }
  }

  //getter get deposit's dollar and cent amount

  /**
   * @return dollar dollar value of this deposit.
   */
  public Integer getDollar() {
    return this.dollar;
  }

  /**
   * @return cent cent value of this deposit.
   */
  public Integer getCent() {
    return this.cent;
  }

  //getter get user's first and last name

  /**
   * return the first name of this user.
   *
   * @return fname
   */
  public String getFname() {
    return fName;
  }

  /**
   * get last name of this user.
   *
   * @return lName
   */
  public String getlName() {
    return lName;
  }

  public void setFname(String firstName) {
    this.fName = firstName;
  }

  public void setlName(String lastName) {
    this.lName = lastName;
  }

  /****************************************************************************
   * equals and hashCode methods.
   *
   * @param object object.
   * @return boolean.
   */
  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null || getClass() != object.getClass()) {
      return false;
    }
    Deposit deposit = (Deposit) object;
    return dollar == deposit.dollar
        && cent == deposit.cent
        && Objects.equals(fName, deposit.fName)
        && Objects.equals(lName, deposit.lName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(dollar, cent, fName, lName);
  }
}
