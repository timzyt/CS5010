package assignment1.problem2;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AWingFighterTest {
  private String shipID = "AA-590";
  private String shipID2;
  private String enemyID = "50 ABY";
  private String enemyID2;
  private Side newSide = Side.FirstOrder;
  private Integer newDestructionLevel = 40;
  private Integer attack1;
  private Integer fuel = 80;
  private Integer fuel1 = 10;
  private Integer fuel2 = -10;
  private Integer fuel3 = 30;
  private Integer destructionLevel = 20;
  private Integer destructionLevel2 = 50;
  private AbstractStarship enemyShip;
  private AWingFighter AA590;
  @Before
  public void setUp() throws Exception {
    this.AA590 = new AWingFighter(shipID, fuel, destructionLevel);
    this.enemyShip = new StarDestroyer(enemyID, 50, 85);
  }

  @Test
  public void getShipid() {
    assertEquals(shipID, AA590.getShipid());
  }

  @Test
  public void setShipid() {
    AA590.setShipid(shipID2);
    assertEquals(shipID2, AA590.getShipid());
  }

  @Test
  public void setIsDestroyed() {
    AA590.setIsDestroyed(true);
    assertTrue(AA590.getIsDestroyed());
  }

  @Test
  public void getIsDestroyed1() {
    AA590.setIsDestroyed(true);
    assertTrue(AA590.getIsDestroyed());
  }

  @Test
  public void testGenAttackPower() {
    Integer attack1 = AA590.genAttackPower();
    System.out.println(
        "Power in this attack is " + attack1 + ", maxAttackPower is " + AA590.getMaxAttackPower());
    AA590.setAttackPower(attack1);
    assertTrue(AA590.getAttackPower() >= 0 );
    assertTrue(AA590.getAttackPower() <= AA590.getMaxAttackPower());
  }

  @Test
  public void getAttckPower() {
    Integer attack1 = AA590.genAttackPower();
    AA590.setAttackPower(attack1);
    assertEquals(attack1, AA590.getAttackPower());
    System.out.println("Power in this attack is " + AA590.getAttackPower());
  }

  @Test
  public void setAttackPower() {
    Integer attack1 = AA590.genAttackPower();
    AA590.setAttackPower(attack1);
    assertEquals(attack1, AA590.getAttackPower());
    System.out.println("Power in this attack is " + AA590.getAttackPower());
  }

  @Test
  public void getSide() {
    assertEquals(Side.Resistance, AA590.getSide());
  }

  @Test
  public void setSide() {
    AA590.setSide(newSide);
    assertEquals(newSide, AA590.getSide());
  }

  @Test
  public void getIsDestroyed() {
    assertEquals(false, AA590.getIsDestroyed());
  }

  @Test
  public void getFuelLevel() {
    assertEquals((Integer) fuel, AA590.getFuelLevel());
  }

  @Test
  public void getDestructionLevel() {
    assertEquals((Integer) destructionLevel, AA590.getDestructionLevel());
  }

  @Test
  public void setDestructionLevel() {
    Integer originDesLevel = AA590.getDestructionLevel();
    AA590.setDestructionLevel(newDestructionLevel);
    assertEquals((Integer) (newDestructionLevel + originDesLevel), AA590.getDestructionLevel());
  }

  @Test
  public void getMaxAttackPower() {
    assertEquals(30, (int) AA590.getMaxAttackPower());
  }

  @Test
  public void setMaxAttackPower() {
    AA590.setMaxAttackPower(80);
    assertEquals((Integer) 80, AA590.getMaxAttackPower());
  }

  @Test
  public void getAttackPower() {
    attack1 = AA590.genAttackPower();
    AA590.setAttackPower(attack1);
    System.out.print("This attack power is " + AA590.getAttackPower());
    Assert.assertTrue(attack1 <= AA590.getMaxAttackPower());
  }

  @Test
  public void testFuel1() {
    AA590.fuel(fuel1);
    assertEquals((Integer) (fuel + fuel1), AA590.getFuelLevel());
  }

  @Test
  public void testFuel2() {
    try {
      AA590.fuel(fuel2);
    } catch (Exception e) {
      final String msg = "value of fuel charge out of range.";
      assertEquals(msg, e.getMessage());
    }
  }

  @Test
  public void testFuel3() {
    AA590.fuel(fuel3);
    assertEquals((Integer) 100, AA590.getFuelLevel());
  }

  @Test
  public void testAttack() {
    System.out.println(enemyShip.getIsDestroyed());
    AA590.attack(enemyShip);
    if (!enemyShip.getIsDestroyed()) {
      System.out.println(enemyShip.getShipid() + " has survived under attack power " + AA590.getAttackPower()
          + ", its destruction level is now at " + enemyShip.getDestructionLevel() + ". Enemy's isDestroyed condition is " + enemyShip.getIsDestroyed());
    } else {
      System.out.println(
          enemyShip.getShipid() + " is destroyed under attack power " + AA590.getAttackPower() + "! Enemy's isDestroyed condition is " + enemyShip
              .getIsDestroyed()) ;
    }
  }
}