package edu.neu.ccs.cs5010.assignment4.ridesharemodel.vehicle;

import edu.neu.ccs.cs5010.assignment4.exceptions.InvalidConstructorArgumentException;
import edu.neu.ccs.cs5010.assignment4.exceptions.InvalidVehicleYearException;
import edu.neu.ccs.cs5010.assignment4.ridesharemodel.driver.Driver;

import java.time.LocalDate;
import java.util.Objects;

/**
 * The type Vehicle.
 */
public class Vehicle {

  private Driver owner;
  private Integer year;
  private String make;
  private String model;
  private String color;
  private String licensePlate;
  private Driver personInDriverSeat;

  private Integer minVehicleYear = 1900;
  private Integer thisYear = LocalDate.now().getYear();
  private Integer minStringArgumentLength = 0;

  /**
   * Instantiates a new Vehicle.
   *
   * @param owner the owner
   * @param year the year
   * @param make the make
   * @param model the model
   * @param color the color
   * @param licensePlate the license plate
   */
  public Vehicle(Driver owner, Integer year, String make, String model, String color,
      String licensePlate) throws Exception {
    if (owner == null) {
      throw new InvalidConstructorArgumentException();
    }
    if (year == null) {
      throw new InvalidConstructorArgumentException();
    }
    if (year < minVehicleYear) {
      throw new InvalidVehicleYearException();
    }
    if (year > thisYear) {
      throw new InvalidVehicleYearException();
    }
    if (make == null) {
      throw new InvalidConstructorArgumentException();
    }
    if (make.length() == minStringArgumentLength) {
      throw new InvalidConstructorArgumentException();
    }
    if (model == null) {
      throw new InvalidConstructorArgumentException();
    }
    if (model.length() == minStringArgumentLength) {
      throw new InvalidConstructorArgumentException();
    }
    if (color == null) {
      throw new InvalidConstructorArgumentException();
    }
    if (color.length() == minStringArgumentLength) {
      throw new InvalidConstructorArgumentException();
    }
    if (licensePlate == null) {
      throw new InvalidConstructorArgumentException();
    }
    if (licensePlate.length() == minStringArgumentLength) {
      throw new InvalidConstructorArgumentException();
    }
    this.owner = owner;
    this.year = year;
    this.make = make;
    this.model = model;
    this.color = color;
    this.licensePlate = licensePlate;
    this.personInDriverSeat = null;
  }

  /**
   * Gets owner of the vehicle.
   *
   * @return the owner
   */
  public Driver getOwner() {
    return owner;
  }

  /**
   * Gets year of the vehicle.
   *
   * @return the year
   */
  public Integer getYear() {
    return year;
  }

  /**
   * Gets make of the vehicle.
   *
   * @return the make
   */
  public String getMake() {
    return make;
  }

  /**
   * Gets model of the vehicle.
   *
   * @return the model
   */
  public String getModel() {
    return model;
  }

  /**
   * Gets color of the vehicle.
   *
   * @return the color
   */
  public String getColor() {
    return color;
  }

  /**
   * Gets license plate of the vehicle.
   *
   * @return the license plate
   */
  public String getLicensePlate() {
    return licensePlate;
  }

  /**
   * Sets license plate of the vehicle.
   *
   * @param licensePlate the license plate
   */
  public void setLicensePlate(String licensePlate) throws Exception {
    if (licensePlate == null) {
      throw new InvalidConstructorArgumentException();
    }
    if (licensePlate.length() == minStringArgumentLength) {
      throw new InvalidConstructorArgumentException();
    }
    this.licensePlate = licensePlate;
  }

  /**
   * Gets person in driver seat.
   *
   * @return the person in driver seat
   */
  public Driver getPersonInDriverSeat() {
    return personInDriverSeat;
  }

  /**
   * Sets person in driver seat.
   *
   * @param personInDriverSeat the person in driver seat
   */
  public void setPersonInDriverSeat(Driver personInDriverSeat) {
    this.personInDriverSeat = personInDriverSeat;
  }


  @Override
  public String toString() {
    return "Vehicle{"
        + "\nowner = " + owner.getName().getFirstName() + " " + owner.getName().getLastName()
        + ",\ncolor = " + color
        + ",\nyear = " + year
        + ",\nmake = " + make
        + ",\nmodel = " + model
        + ",\nlicensePlate = " + licensePlate + " }";
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Vehicle vehicle = (Vehicle) obj;
    return Objects.equals(owner, vehicle.owner)
        && Objects.equals(year, vehicle.year)
        && Objects.equals(make, vehicle.make)
        && Objects.equals(model, vehicle.model)
        && Objects.equals(color, vehicle.color)
        && Objects.equals(licensePlate, vehicle.licensePlate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(owner, year, make, model, color, licensePlate);
  }
}
