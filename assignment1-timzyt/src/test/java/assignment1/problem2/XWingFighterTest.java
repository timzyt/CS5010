package assignment1.problem2;

import static org.junit.Assert.*;

import org.junit.*;

public class XWingFighterTest {

  private String shipID = "AA-589";
  private String shipID2;
  private String enemyID = "130 ABY";
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
  private XWingFighter AA589;

  @Before
  public void setUp() throws Exception {
    this.AA589 = new XWingFighter(shipID, fuel, destructionLevel);
    this.enemyShip = new TieFighter(enemyID, 50, 85);
  }


  @Test
  public void getShipid() {
    assertEquals(shipID, AA589.getShipid());
  }

  @Test
  public void setShipid() {
    AA589.setShipid(shipID2);
    assertEquals(shipID2, AA589.getShipid());
  }

  @Test
  public void setIsDestroyed() {
    AA589.setIsDestroyed(true);
    assertTrue(AA589.getIsDestroyed());
  }

  @Test
  public void getIsDestroyed1() {
    AA589.setIsDestroyed(true);
    assertTrue(AA589.getIsDestroyed());
  }

  @Test
  public void testGenAttackPower() {
    Integer attack1 = AA589.genAttackPower();
    System.out.println(
        "Power in this attack is " + attack1 + ", maxAttackPower is " + AA589.getMaxAttackPower());
    AA589.setAttackPower(attack1);
    assertTrue(AA589.getAttackPower() >= 0 );
    assertTrue(AA589.getAttackPower() <= AA589.getMaxAttackPower());
  }

  @Test
  public void getAttckPower() {
    Integer attack1 = AA589.genAttackPower();
    AA589.setAttackPower(attack1);
    assertEquals(attack1, AA589.getAttackPower());
    System.out.println("Power in this attack is " + AA589.getAttackPower());
  }

  @Test
  public void setAttackPower() {
    Integer attack1 = AA589.genAttackPower();
    AA589.setAttackPower(attack1);
    assertEquals(attack1, AA589.getAttackPower());
    System.out.println("Power in this attack is " + AA589.getAttackPower());
  }

  @Test
  public void getSide() {
    assertEquals(Side.Resistance, AA589.getSide());
  }

  @Test
  public void setSide() {
    AA589.setSide(newSide);
    assertEquals(newSide, AA589.getSide());
  }

  @Test
  public void getIsDestroyed() {
    assertEquals(false, AA589.getIsDestroyed());
  }

  @Test
  public void getFuelLevel() {
    assertEquals((Integer) fuel, AA589.getFuelLevel());
  }

  @Test
  public void getDestructionLevel() {
    assertEquals((Integer) destructionLevel, AA589.getDestructionLevel());
  }

  @Test
  public void setDestructionLevel() {
    Integer originDesLevel = AA589.getDestructionLevel();
    AA589.setDestructionLevel(newDestructionLevel);
    assertEquals((Integer) (newDestructionLevel + originDesLevel), AA589.getDestructionLevel());
  }

  @Test
  public void getMaxAttackPower() {
    assertEquals(40, (int) AA589.getMaxAttackPower());
  }

  @Test
  public void setMaxAttackPower() {
    AA589.setMaxAttackPower(80);
    assertEquals((Integer) 80, AA589.getMaxAttackPower());
  }

  @Test
  public void getAttackPower() {
    attack1 = AA589.genAttackPower();
    AA589.setAttackPower(attack1);
    System.out.print("This attack power is " + AA589.getAttackPower());
    Assert.assertTrue(attack1 <= AA589.getMaxAttackPower());
  }

  @Test
  public void testFuel1() {
    AA589.fuel(fuel1);
    assertEquals((Integer) (fuel + fuel1), AA589.getFuelLevel());
  }

  @Test
  public void testFuel2() {
    try {
      AA589.fuel(fuel2);
    } catch (Exception e) {
      final String msg = "value of fuel charge out of range.";
      assertEquals(msg, e.getMessage());
    }
  }

  @Test
  public void testFuel3() {
    AA589.fuel(fuel3);
    assertEquals((Integer) 100, AA589.getFuelLevel());
  }

  @Test
  public void testAttack() {
    System.out.println(enemyShip.getIsDestroyed());
    AA589.attack(enemyShip);
    if (!enemyShip.getIsDestroyed()) {
      System.out.println(
          enemyShip.getShipid() + " has survived under attack power " + AA589.getAttackPower()
              + ", its destruction level is now at " + enemyShip.getDestructionLevel()
              + ". Enemy's isDestroyed condition is " + enemyShip.getIsDestroyed());
    } else {
      System.out.println(
          enemyShip.getShipid() + " is destroyed under attack power " + AA589.getAttackPower()
              + "! Enemy's isDestroyed condition is " + enemyShip
              .getIsDestroyed());
    }
  }
}