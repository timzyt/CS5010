package edu.neu.ccs.cs5010.assignment4.ridesharemodel.insurance;

import edu.neu.ccs.cs5010.assignment4.exceptions.InvalidConstructorArgumentException;
import edu.neu.ccs.cs5010.assignment4.ridesharemodel.driver.Driver;
import edu.neu.ccs.cs5010.assignment4.ridesharemodel.vehicle.Vehicle;


import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;

/**
 * The type Insurance.
 */
public class Insurance {

  private Driver owner;
  private Vehicle vehicle;
  private HashSet<Driver> insuredDrivers;
  private LocalDate expirationDate;


  /**
   * Instantiates a new Insurance.
   *
   * @param owner the owner
   * @param vehicle the vehicle
   * @param insuredDrivers the insured drivers
   * @param expirationDate the expiration date
   */
  public Insurance(Driver owner, Vehicle vehicle,
      HashSet<Driver> insuredDrivers, LocalDate expirationDate) throws Exception {
    if (owner == null) {
      throw new InvalidConstructorArgumentException();
    }
    if (vehicle == null) {
      throw new InvalidConstructorArgumentException();
    }
    if (expirationDate == null) {
      throw new InvalidConstructorArgumentException();
    }
    this.owner = owner;
    this.vehicle = vehicle;
    this.insuredDrivers = insuredDrivers;
    this.expirationDate = LocalDate
        .of(expirationDate.getYear(), expirationDate.getMonth(), expirationDate.getDayOfMonth());
  }


  /**
   * Gets owner.
   *
   * @return the owner
   */
  public Driver getOwner() {
    return owner;
  }

  /**
   * Gets vehicle.
   *
   * @return the vehicle
   */
  public Vehicle getVehicle() {
    return vehicle;
  }

  /**
   * Gets insured drivers.
   *
   * @return the insured drivers
   */
  public HashSet<Driver> getInsuredDrivers() {
    return insuredDrivers;
  }

  /**
   * Gets expiration date.
   *
   * @return the expiration date
   */
  public LocalDate getExpirationDate() {
    LocalDate queryExpirationDate = LocalDate
        .of(this.expirationDate.getYear(), this.expirationDate.getMonth(),
            this.expirationDate.getDayOfMonth());
    return queryExpirationDate;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Insurance insurance = (Insurance) obj;
    return Objects.equals(owner, insurance.owner)
        && Objects.equals(vehicle, insurance.vehicle)
        && Objects.equals(insuredDrivers, insurance.insuredDrivers)
        && Objects.equals(expirationDate, insurance.expirationDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(getOwner(), getVehicle(), getInsuredDrivers(), getExpirationDate());
  }

  @Override
  public String toString() {
    StringBuilder insuredDriverList = new StringBuilder();
    if (this.insuredDrivers == null) {
      insuredDriverList.append("No other insured drivers.");
    } else {
      insuredDriverList.append("Additional insured driver(s): ");
      for (Driver driver : this.insuredDrivers) {
        insuredDriverList
            .append(driver.getName().getFirstName() + " " + driver.getName().getLastName() + ", ");
      }
      insuredDriverList.delete(insuredDriverList.length() - 2, insuredDriverList.length());
    }
    return "Insurance{"
        + "\nowner = " + owner.getName().getFirstName() + " " + owner.getName().getLastName()
        + ",\nvehicle = " + vehicle.getColor() + " " + vehicle.getYear() + " " + vehicle.getMake()
        + " " + vehicle.getModel()
        + ",\ninsured drivers = "
        + insuredDriverList
        + ",\nexpirationDate = " + expirationDate.getYear() + '-' + expirationDate.getMonth()
        + '-' + expirationDate.getDayOfMonth() + " }";
  }
}
