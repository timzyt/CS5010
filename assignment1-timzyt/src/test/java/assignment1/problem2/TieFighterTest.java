package assignment1.problem2;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TieFighterTest {
  private String shipID = "NabooN1";
  private String shipID2;
  private String enemyID = "AA-589";
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
  private TieFighter NabooN1;
  @Before
  public void setUp() throws Exception {
    this.NabooN1 = new TieFighter(shipID, fuel, destructionLevel);
    this.enemyShip = new AWingFighter(enemyID, 50, 85);
  }

  @Test
  public void getShipid() {
    assertEquals(shipID, NabooN1.getShipid());
  }

  @Test
  public void setShipid() {
    NabooN1.setShipid(shipID2);
    assertEquals(shipID2, NabooN1.getShipid());
  }

  @Test
  public void setIsDestroyed() {
    NabooN1.setIsDestroyed(true);
    assertTrue(NabooN1.getIsDestroyed());
  }

  @Test
  public void getIsDestroyed1() {
    NabooN1.setIsDestroyed(true);
    assertTrue(NabooN1.getIsDestroyed());
  }

  @Test
  public void testGenAttackPower() {
    Integer attack1 = NabooN1.genAttackPower();
    System.out.println(
        "Power in this attack is " + attack1 + ", maxAttackPower is " + NabooN1.getMaxAttackPower());
    NabooN1.setAttackPower(attack1);
    assertTrue(NabooN1.getAttackPower() >= 0 );
    assertTrue(NabooN1.getAttackPower() <= NabooN1.getMaxAttackPower());
  }

  @Test
  public void getAttckPower() {
    Integer attack1 = NabooN1.genAttackPower();
    NabooN1.setAttackPower(attack1);
    assertEquals(attack1, NabooN1.getAttackPower());
    System.out.println("Power in this attack is " + NabooN1.getAttackPower());
  }

  @Test
  public void setAttackPower() {
    Integer attack1 = NabooN1.genAttackPower();
    NabooN1.setAttackPower(attack1);
    assertEquals(attack1, NabooN1.getAttackPower());
    System.out.println("Power in this attack is " + NabooN1.getAttackPower());
  }

  @Test
  public void getSide() {
    assertEquals(Side.FirstOrder, NabooN1.getSide());
  }

  @Test
  public void setSide() {
    NabooN1.setSide(newSide);
    assertEquals(newSide, NabooN1.getSide());
  }

  @Test
  public void getIsDestroyed() {
    assertEquals(false, NabooN1.getIsDestroyed());
  }

  @Test
  public void getFuelLevel() {
    assertEquals((Integer) fuel, NabooN1.getFuelLevel());
  }

  @Test
  public void getDestructionLevel() {
    assertEquals((Integer) destructionLevel, NabooN1.getDestructionLevel());
  }

  @Test
  public void setDestructionLevel() {
    Integer originDesLevel = NabooN1.getDestructionLevel();
    NabooN1.setDestructionLevel(newDestructionLevel);
    assertEquals((Integer) (newDestructionLevel + originDesLevel), NabooN1.getDestructionLevel());
  }

  @Test
  public void getMaxAttackPower() {
    assertEquals(25, (int) NabooN1.getMaxAttackPower());
  }

  @Test
  public void setMaxAttackPower() {
    NabooN1.setMaxAttackPower(80);
    assertEquals((Integer) 80, NabooN1.getMaxAttackPower());
  }

  @Test
  public void getAttackPower() {
    attack1 = NabooN1.genAttackPower();
    NabooN1.setAttackPower(attack1);
    System.out.print("This attack power is " + NabooN1.getAttackPower());
    Assert.assertTrue(attack1 <= NabooN1.getMaxAttackPower());
  }

  @Test
  public void testFuel1() {
    NabooN1.fuel(fuel1);
    assertEquals((Integer) (fuel + fuel1), NabooN1.getFuelLevel());
  }

  @Test
  public void testFuel2() {
    try {
      NabooN1.fuel(fuel2);
    } catch (Exception e) {
      final String msg = "value of fuel charge out of range.";
      assertEquals(msg, e.getMessage());
    }
  }

  @Test
  public void testFuel3() {
    NabooN1.fuel(fuel3);
    assertEquals((Integer) 100, NabooN1.getFuelLevel());
  }

  @Test
  public void testAttack() {
    System.out.println(enemyShip.getIsDestroyed());
    NabooN1.attack(enemyShip);
    if (!enemyShip.getIsDestroyed()) {
      System.out.println(enemyShip.getShipid() + " has survived under attack power " + NabooN1.getAttackPower()
          + ", its destruction level is now at " + enemyShip.getDestructionLevel() + ". Enemy's isDestroyed condition is " + enemyShip.getIsDestroyed());
    } else {
      System.out.println(
          enemyShip.getShipid() + " is destroyed under attack power " + NabooN1.getAttackPower() + "! Enemy's isDestroyed condition is " + enemyShip
              .getIsDestroyed()) ;
    }
  }
}