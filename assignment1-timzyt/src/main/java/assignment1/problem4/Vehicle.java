package assignment1.problem4;

import java.util.HashMap;
import java.util.Objects;


/**
 * Created by timzyt on 9/14/2018. Vehicle class uses for construct and store information for a
 * vehicle, also used to implement acceleration, deceleration and change direction methods.
 */
public class Vehicle {

  private String license;
  private VehicleType type;
  private String color;
  private String make;
  private String model;
  private Integer maxVelocity;
  private Integer minVelocity;
  private Integer velocity;
  private double accelerationFactor;
  private double decelerationFactor;
  private Direction currDirection;
  private AllowedDirections mapClass = new AllowedDirections();
  private HashMap<Direction, Direction> allowedDirectionChangeMap = mapClass
      .getAllowedDirectionChanges();


  /**
   * class Vehicle uses for storing vehicle information and implementing
   *
   * @param license license plate for this vehicle.
   */
  public Vehicle(String license, VehicleType type) {
    this.license = license;
    switch (type) {
      case Motorcycle:
        this.maxVelocity = 65;
        break;
      case Automobile:
        this.maxVelocity = 70;
        break;
      case Bus:
        this.maxVelocity = 60;
        break;
      case Truck:
        this.maxVelocity = 60;
        break;
      default:
        throw new IllegalArgumentException("Vehicle type out of range");
    }
    this.minVelocity = 40;
  }


  /**
   * @return type vehicle type.
   */
  public VehicleType getType() {
    return type;
  }

  /**
   * set vehicle type.
   *
   * @param type vehicle type.
   */
  public void setType(VehicleType type) {
    this.type = type;

  }

  /**
   * @return color vehicle color.
   */
  public String getColor() {
    return color;
  }

  /**
   * set vehicle color.
   *
   * @param color vehicle color.
   */
  public void setColor(String color) {
    this.color = color;
  }

  /**
   * @return model vehicle model.
   */
  public String getModel() {
    return model;
  }

  /**
   * set vehicle model.
   *
   * @param model vehicle model.
   */
  public void setModel(String model) {
    this.model = model;
  }

  /**
   * @return make the make of this vehicle.
   */
  public String getMake() {
    return make;
  }

  /**
   * set vehicle make.
   *
   * @param make vehicle make.
   */
  public void setMake(String make) {
    this.make = make;
  }

  /**
   * @return license vehicle license.
   */
  public String getLicense() {
    return license;
  }

  /**
   * set vehicle license.
   *
   * @param license vehicle license.
   */
  public void setLicense(String license) {
    this.license = license;
  }

  /**
   * @return maxVelocity maximum vehicle velocity.
   */
  public Integer getMaxVelocity() {
    return maxVelocity;
  }

  /**
   * @return minVelocity minimum vehicle velocity.
   */
  public Integer getMinVelocity() {
    return minVelocity;
  }

  /**
   * @return velocity current vehicle velocity.
   */
  public Integer getVelocity() {
    return velocity;
  }

  /**
   * set current vehicle velocity.
   *
   * @param velocity current vehicle velocity.
   */
  public void setVelocity(Integer velocity) {
    this.velocity = velocity;
    if (velocity < this.minVelocity) {
      throw new IllegalArgumentException(
          "Velocity of this vehicle is too low "
              + "due to the decelerationFactor out of range");
    } else if (velocity > this.maxVelocity) {
      throw new IllegalArgumentException(
          "Velocity of this vehicle is too high "
              + "due to the accelerationFactor out of range");
    }
  }

  /**
   * @return vehicle acceleration factor.
   */
  public Double getAccelerationFactor() {
    return accelerationFactor;
  }

  /**
   * set vehicle acceleration factor .
   *
   * @param accelerationFactor vehicle acceleration factor.
   */
  public void setAccelerationFactor(Double accelerationFactor) {
    this.accelerationFactor = accelerationFactor;
  }

  /**
   * @return vehicle deceleration factor.
   */
  public double getDecelerationFactor() {
    return decelerationFactor;
  }

  /**
   * set vehicle deceleration factor .
   *
   * @param decelerationFactor vehicle deceleration factor.
   */
  public void setDecelerationFactor(Double decelerationFactor) {
    this.decelerationFactor = decelerationFactor;
  }

  /**
   * @return currDirection vehicle current direction.
   */
  public Direction getCurrDirection() {
    return currDirection;
  }

  /**
   * set current vehicle direction.
   *
   * @param currDirection vehicle current direction.
   */
  public void setCurrDirection(Direction currDirection) {
    this.currDirection = currDirection;
  }

  /**
   * @return a random number within thr range of 10 and 50.
   */
  public double genAccelerationFactor() {
    GenRandomNumber genRandNum = new GenRandomNumber();
    return genRandNum.genRandNum(10, 50);
  }

  /**
   * @return a randome number within the range of 20 and 50.
   */
  public double genDecelerationFactor() {
    GenRandomNumber genRandNum = new GenRandomNumber();
    return genRandNum.genRandNum(20, 50);
  }

  /*******************************************************************************************
   * acceleration method.
   * - generate a random acceleration rate within the allowed range.
   * - update the velocity of this vehicle based on the acceleration rate.
   *
   * @return current velocity of this vehicle.
   */
  public Integer acceleration() {
    double acceFactor = this.genAccelerationFactor();
    this.setAccelerationFactor(Double.parseDouble(String.format("%.1f", acceFactor)));
    Integer newVelocity = (int) (this.getVelocity() * (1 + acceFactor / 100));
    this.setVelocity(newVelocity);
    return this.velocity;
  }

  /*******************************************************************************************
   * deceleration method.
   * - generate a random deceleration rate within the allowed range.
   * - update the velocity of this vehicle based on the deceleration rate.
   *
   * @return this.velocity current velocity of this vehicle.
   */
  public Integer deceleration() {
    Double deceFactor = this.genDecelerationFactor();
    this.setDecelerationFactor(Double.parseDouble(String.format("%.1f", deceFactor)));
    Integer newVelocity = (int) (this.getVelocity() * (1 - deceFactor / 100));
    this.setVelocity(newVelocity);
    return this.velocity;
  }


  /*****************************************************************************************
   * changeDirection method.
   * -checks if the current driving direction or new direction proposed is within the allowed range.
   * -based on the current driving direction,
   * checks if the change to the proposed new direction is allowed.
   * -make the direction change based on the order.
   *
   * @param newDirection the new direction.
   */
  public void changeDirection(Direction newDirection) {
    if (!allowedDirectionChangeMap.containsKey(this.currDirection)) {
      throw new IllegalArgumentException(
          "Current direction of this vehicle is out of allowed range.");
    } else if (!allowedDirectionChangeMap.containsKey(newDirection)) {
      throw new IllegalArgumentException("This direction change is out of allowed range.");
    } else if (newDirection.equals(this.allowedDirectionChangeMap.get(this.currDirection))) {
      this.setCurrDirection(newDirection);
    } else {
      throw new IllegalArgumentException("This direction change is not allowed");
    }
  }

  /*****************************************************************************************
   * equals and hashCode methods.
   * @param obj object.
   * @return boolean.
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Vehicle vehicle = (Vehicle) obj;
    return type == vehicle.type
        && Objects.equals(color, vehicle.color)
        && Objects.equals(make, vehicle.make)
        && Objects.equals(model, vehicle.model)
        && Objects.equals(license, vehicle.license)
        && Objects.equals(maxVelocity, vehicle.maxVelocity)
        && Objects.equals(minVelocity, vehicle.minVelocity)
        && Objects.equals(velocity, vehicle.velocity)
        && Objects.equals(currDirection, vehicle.currDirection);
  }

  @Override
  public int hashCode() {
    return Objects
        .hash(type, color, make, model, license, maxVelocity, minVelocity, velocity, currDirection);
  }

}
