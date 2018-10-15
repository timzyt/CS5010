package assignment1.problem2;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StarDestroyerTest {
  private String shipID = "Accuser";
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
  private StarDestroyer Accuser;

  @Before
  public void setUp() throws Exception {
    this.Accuser = new StarDestroyer(shipID, fuel, destructionLevel);
    this.enemyShip = new AWingFighter(enemyID, 50, 85);
  }

  @Test
  public void getShipid() {
    assertEquals(shipID, Accuser.getShipid());
  }

  @Test
  public void setShipid() {
    Accuser.setShipid(shipID2);
    assertEquals(shipID2, Accuser.getShipid());
  }

  @Test
  public void setIsDestroyed() {
    Accuser.setIsDestroyed(true);
    assertTrue(Accuser.getIsDestroyed());
  }

  @Test
  public void getIsDestroyed1() {
    Accuser.setIsDestroyed(true);
    assertTrue(Accuser.getIsDestroyed());
  }

  @Test
  public void testGenAttackPower() {
    Integer attack1 = Accuser.genAttackPower();
    System.out.println(
        "Power in this attack is " + attack1 + ", maxAttackPower is " + Accuser.getMaxAttackPower());
    Accuser.setAttackPower(attack1);
    assertTrue(Accuser.getAttackPower() >= 0 );
    assertTrue(Accuser.getAttackPower() <= Accuser.getMaxAttackPower());
  }

  @Test
  public void getAttckPower() {
    Integer attack1 = Accuser.genAttackPower();
    Accuser.setAttackPower(attack1);
    assertEquals(attack1, Accuser.getAttackPower());
    System.out.println("Power in this attack is " + Accuser.getAttackPower());
  }

  @Test
  public void setAttackPower() {
    Integer attack1 = Accuser.genAttackPower();
    Accuser.setAttackPower(attack1);
    assertEquals(attack1, Accuser.getAttackPower());
    System.out.println("Power in this attack is " + Accuser.getAttackPower());
  }

  @Test
  public void getSide() {
    assertEquals(Side.FirstOrder, Accuser.getSide());
  }

  @Test
  public void setSide() {
    Accuser.setSide(newSide);
    assertEquals(newSide, Accuser.getSide());
  }

  @Test
  public void getIsDestroyed() {
    assertEquals(false, Accuser.getIsDestroyed());
  }

  @Test
  public void getFuelLevel() {
    assertEquals((Integer) fuel, Accuser.getFuelLevel());
  }

  @Test
  public void getDestructionLevel() {
    assertEquals((Integer) destructionLevel, Accuser.getDestructionLevel());
  }

  @Test
  public void setDestructionLevel() {
    Integer originDesLevel = Accuser.getDestructionLevel();
    Accuser.setDestructionLevel(newDestructionLevel);
    assertEquals((Integer) (newDestructionLevel + originDesLevel), Accuser.getDestructionLevel());
  }

  @Test
  public void getMaxAttackPower() {
    assertEquals(50, (int) Accuser.getMaxAttackPower());
  }

  @Test
  public void setMaxAttackPower() {
    Accuser.setMaxAttackPower(80);
    assertEquals((Integer) 80, Accuser.getMaxAttackPower());
  }

  @Test
  public void getAttackPower() {
    attack1 = Accuser.genAttackPower();
    Accuser.setAttackPower(attack1);
    System.out.print("This attack power is " + Accuser.getAttackPower());
    Assert.assertTrue(attack1 <= Accuser.getMaxAttackPower());
  }

  @Test
  public void testFuel1() {
    Accuser.fuel(fuel1);
    assertEquals((Integer) (fuel + fuel1), Accuser.getFuelLevel());
  }

  @Test
  public void testFuel2() {
    try {
      Accuser.fuel(fuel2);
    } catch (Exception e) {
      final String msg = "value of fuel charge out of range.";
      assertEquals(msg, e.getMessage());
    }
  }

  @Test
  public void testFuel3() {
    Accuser.fuel(fuel3);
    assertEquals((Integer) 100, Accuser.getFuelLevel());
  }

  @Test
  public void testAttack() {
    System.out.println(enemyShip.getIsDestroyed());
    Accuser.attack(enemyShip);
    if (!enemyShip.getIsDestroyed()) {
      System.out.println(enemyShip.getShipid() + " has survived under attack power " + Accuser.getAttackPower()
          + ", its destruction level is now at " + enemyShip.getDestructionLevel() + ". Enemy's isDestroyed condition is " + enemyShip.getIsDestroyed());
    } else {
      System.out.println(
          enemyShip.getShipid() + " is destroyed under attack power " + Accuser.getAttackPower() + "! Enemy's isDestroyed condition is " + enemyShip
              .getIsDestroyed()) ;
    }
  }
}