package assignment1.problem4;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class VehicleTest {

  private String license = "BBB5242";
  private VehicleType type = VehicleType.Automobile;
  private String color = "black";
  private String make = "Toyota";
  private String model = "Camry";
  private Integer maxVelocity;
  private Integer minVelocity = 40;
  private Integer velocity = 55;
  private Double accelerationFactor;
  private Double decelerationfactor;
  private Direction currDirection = Direction.east;
  private Direction newDirectionChange = Direction.west;
  private Direction currDirection2 = null;
  private Direction newDirectionChange2 = null;
  private Direction newDirectionChange3 = Direction.north;
  private Vehicle newVehicle;

  @Before
  public void testSetUp() throws Exception {
    newVehicle = new Vehicle(license, type);
  }

  @Test
  public void testGetType() {
    newVehicle.setType(type);
    assertEquals(type, newVehicle.getType());
  }

  @Test
  public void testSetType() {
    newVehicle.setType(type);
    assertEquals(type, newVehicle.getType());
  }

  @Test
  public void testGetColor() {
    newVehicle.setColor(color);
    assertEquals(color, newVehicle.getColor());
  }

  @Test
  public void testSetColor() {
    newVehicle.setColor(color);
    assertEquals(color, newVehicle.getColor());
  }

  @Test
  public void testGetModel() {
    newVehicle.setModel(model);
    assertEquals(model, newVehicle.getModel());
  }

  @Test
  public void testSetModel() {
    newVehicle.setModel(model);
    assertEquals(model, newVehicle.getModel());
  }

  @Test
  public void testGetMake() {
    newVehicle.setMake(make);
    assertEquals(make, newVehicle.getMake());
  }

  @Test
  public void testSetMake() {
    newVehicle.setMake(make);
    assertEquals(make, newVehicle.getMake());
  }

  @Test
  public void testGetLicense() {
    newVehicle.setLicense(license);
    assertEquals(license, newVehicle.getLicense());
  }

  @Test
  public void testSetLicense() {
    newVehicle.setLicense(license);
    assertEquals(license, newVehicle.getLicense());
  }

  @Test
  public void testGetMaxVelocity() {
    newVehicle.setType(type);
    assertEquals((Integer) 70, newVehicle.getMaxVelocity());
  }

  @Test
  public void testGetMinVelocity() {
    newVehicle.setType(type);
    assertEquals((Integer) 40, newVehicle.getMinVelocity());
  }

  @Test
  public void testGetVelocity() {
    newVehicle.setVelocity(velocity);
    assertEquals(velocity, newVehicle.getVelocity());
  }

  @Test
  public void testSetVelocity() {
    newVehicle.setVelocity(velocity);
    assertEquals(velocity, newVehicle.getVelocity());
  }

  @Test
  public void testGetAccelerationFactor() {
    accelerationFactor = newVehicle.genAccelerationFactor();
    newVehicle.setAccelerationFactor(accelerationFactor);
    assertEquals(accelerationFactor, newVehicle.getAccelerationFactor());
  }

  @Test
  public void testSetAccelerationFactor() {
    Double accelerationFactor = newVehicle.genAccelerationFactor();
    newVehicle.setAccelerationFactor(accelerationFactor);
    assertEquals(accelerationFactor, newVehicle.getAccelerationFactor());
  }

  @Test
  public void testGetCurrDirection() {
    newVehicle.setCurrDirection(currDirection);
    assertEquals(currDirection, newVehicle.getCurrDirection());
  }

  @Test
  public void testSetCurrDirection() {
    newVehicle.setCurrDirection(currDirection);
    assertEquals(currDirection, newVehicle.getCurrDirection());
  }

  @Test
  public void testGenAccelerationFactor() {
    Double accelerationFactor = newVehicle.genAccelerationFactor();
    System.out.println("This vehicle is accelerating at a factor of " + accelerationFactor + ".");
    assertTrue(accelerationFactor >= 10 && accelerationFactor <= 50);
  }

  @Test
  public void testGenDecelerationFactor() {
    Double decelerationFactor = newVehicle.genDecelerationFactor();
    System.out.println("This vehicle is decelerating at a factor of " + decelerationFactor + ".");
    assertTrue(decelerationFactor >= 20 );
    assertTrue(decelerationFactor <= 50);
  }

  @Test
  public void testAcceleration() {
    try {
      newVehicle.setVelocity(velocity);

    System.out.println("This vehicle was running at " + newVehicle.getVelocity());
    newVehicle.acceleration();
    System.out.println("This vehicle is now running at a velocity of " + newVehicle.getVelocity()
        + " at acceleration factor of " + newVehicle.getAccelerationFactor());
    } catch (Exception e) {
      final String msg = "Velocity of this vehicle is too high due to the accelerationFactor out of range";
      assertEquals(msg, e.getMessage());
      System.out.println(msg);
    }
  }

  @Test
  public void testDeceleration() {
    try {
      newVehicle.setVelocity(velocity);
      System.out.println("This vehicle was running at " + newVehicle.getVelocity());
      newVehicle.deceleration();
      System.out.println("This vehicle is now running at a velocity of " + newVehicle.getVelocity()
        + " at deceleration factor of " + newVehicle.getDecelerationFactor());
    } catch (Exception e) {
      final String msg = "Velocity of this vehicle is too low due to the decelerationFactor out of range";
      assertEquals(msg, e.getMessage());
      System.out.println(msg);
    }
  }

  @Test
  public void testChangeDirection() {
    newVehicle.setCurrDirection(currDirection);
    newVehicle.changeDirection(newDirectionChange);
    assertEquals(newDirectionChange, newVehicle.getCurrDirection());
  }


  @Test
  public void testChangeDirection2() {
    try {
      newVehicle.setCurrDirection(currDirection2);
      newVehicle.changeDirection(newDirectionChange);
      assertEquals(newDirectionChange, newVehicle.getCurrDirection());
    } catch (Exception e) {
      final String msg = "Current direction of this vehicle is out of allowed range.";
      assertEquals(msg, e.getMessage());
      System.out.println(msg);
    }
  }

  @Test
  public void testChangeDirection3() {
    try {
      newVehicle.setCurrDirection(currDirection);
      newVehicle.changeDirection(newDirectionChange2);
      assertEquals(newDirectionChange, newVehicle.getCurrDirection());
    } catch (Exception e) {
      final String msg = "This direction change is out of allowed range.";
      assertEquals(msg, e.getMessage());
      System.out.println(msg);
    }
  }

  @Test
  public void testChangeDirection4() {
    try {
      newVehicle.setCurrDirection(currDirection);
      newVehicle.changeDirection(newDirectionChange3);
      assertEquals(newDirectionChange, newVehicle.getCurrDirection());
    } catch (Exception e) {
      final String msg = "This direction change is not allowed";
      assertEquals(msg, e.getMessage());
      System.out.println(msg);
    }
  }

}