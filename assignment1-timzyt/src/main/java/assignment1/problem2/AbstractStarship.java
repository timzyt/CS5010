package assignment1.problem2;

import java.util.Objects;

/**
 * Created by timzyt on 09/12/2018. super class which constructs and initiates a generic AbstractStarship
 * with its organization, the destroy status, fuel level. AbstractStarship class also uses to implement fuel
 * and attack methods.
 */
public abstract class AbstractStarship {

  private String shipid;
  private Side side;
  private boolean isDestroyed;
  private Integer fuelLevel;
  private Integer destructionLevel;
  private Integer maxAttackPower;

  /**
   * Constructs and initialize a AbstractStarship.
   *
   * @param shipid the side this AbstractStarship belongs to.
   * @param fuelLevel the fuel level of this AbstractStarship.
   * @param destructionLevel the destruction leve of this AbstractStarship.
   */
  public AbstractStarship(String shipid, Integer fuelLevel,
      Integer destructionLevel) {
    this.shipid = shipid;
    if (fuelLevel <= 100 && fuelLevel > 0) {
      this.fuelLevel = fuelLevel;
    } else if (fuelLevel == 0) {
      throw new IllegalArgumentException("This ship is out of fuel, cannot be deployed");
    } else {
      throw new IllegalArgumentException("The fuel value is out of range.");
    }
    if (destructionLevel == 100) {
      this.isDestroyed = true;
      throw new IllegalArgumentException("This ship is destroyed.");
    } else if (destructionLevel > 100 || destructionLevel < 0) {
      throw new IllegalArgumentException("DestructionLevel out of range.");
    } else {
      this.destructionLevel = destructionLevel;
    }
  }

  /**
   * @return shipid the ship ID of this AbstractStarship.
   */
  public String getShipid() {
    return shipid;
  }

  /**
   * set ship ID of this AbstractStarship.
   *
   * @param shipid ship ID of this AbstractStarship.
   */
  public void setShipid(String shipid) {
    this.shipid = shipid;
  }

  /**
   * @return Side the side this AbstractStarship belongs to.
   */
  public Side getSide() {
    return this.side;
  }

  /**
   * set side of this AbstractStarship.
   */
  public void setSide(Side side) {
    this.side = side;
  }

  /**
   * @param status status of this AbstractStarship.
   */
  public void setIsDestroyed(boolean status) {
    this.isDestroyed = status;
  }

  /**
   * @return isDestroyed the status of this AbstractStarship.
   */
  public boolean getIsDestroyed() {
    return this.isDestroyed;
  }

  /**
   * @return fuelLevel the fuel level of this AbstractStarship.
   */
  public Integer getFuelLevel() {
    return fuelLevel;
  }

  /**
   * @return destructionLevel the destruction level of this AbstractStarship.
   */
  public Integer getDestructionLevel() {
    return destructionLevel;
  }

  /**
   * set the destruction level of a AbstractStarship.
   *
   * @param attack the attack level.
   */
  public void setDestructionLevel(Integer attack) {
    this.destructionLevel += attack;
  }

  /**
   * @return maxAttackPower the maximum attack power of this AbstractStarship.
   */
  public Integer getMaxAttackPower() {
    return this.maxAttackPower;
  }

  /**
   * set the maximum attack power of this AbstractStarship
   * @param maxPower the maximum attack power of this AbstractStarship.
   */
  public void setMaxAttackPower(Integer maxPower) {
    this.maxAttackPower = maxPower;
  }

  /**
   * @return a random attack power within the range of maximum attack power.
   */
  public Integer genAttackPower() {
    GenRandomNumber genRandNum = new GenRandomNumber();
    return genRandNum.genRandNum(this.maxAttackPower);
  }

  /**
   * @return attack power of this attack.
   */
  public Integer getAttackPower() {
    return this.maxAttackPower;
  }

  /**
   * set the attack power of this attack to the generated random attack power.
   *
   * @param randomAttackPower generated random attack power
   */
  public void setAttackPower(Integer randomAttackPower) {
    this.maxAttackPower = randomAttackPower;
  }


  /**************************************************************************
   * fuel method;
   * -evaluate provided fuel against the current fuel level of this AbstractStarship.
   * -update the fuel level of this AbstractStarship.
   * -throws IllegalArgumentException if otherwise.
   *
   * @param fuel the amount of fuel charging into this AbstractStarship.
   * @throws IllegalArgumentException "value of fuel charge out of range."
   */
  public void fuel(Integer fuel) throws IllegalArgumentException {
    if (fuel <= 0) {
      throw new IllegalArgumentException("value of fuel charge out of range.");
    } else if (100 - fuelLevel < fuel) {
      this.fuelLevel = 100;
    } else {
      this.fuelLevel += fuel;
    }
  }

  /********************************************************************************************
   * attack method
   * -evaluate the destruction level of the enemy against the attack power from this AbstractStarship.
   * -update the destruction level of the enemy. -throws IllegalArgumentException if otherwise.
   *
   * @param enemy an enemy AbstractStarship.
   * @throws IllegalArgumentException "Enemy is already destroyed, attack unnecessary."
   */
  public void attack(AbstractStarship enemy) throws IllegalArgumentException {
    if (!this.isDestroyed) {
      Integer randomAttackPower = this.genAttackPower();
      this.setAttackPower(randomAttackPower);
      if (randomAttackPower >= (100 - enemy.getDestructionLevel())) {
        enemy.setIsDestroyed(true);
        enemy.setDestructionLevel(100 - enemy.getDestructionLevel());
        System.out.println(
            "Enemy " + enemy.getShipid() + " is destroyed under attack power "
                + this.getAttackPower() + "!");
      } else {
        enemy.setDestructionLevel(randomAttackPower);
      }
    } else {
      throw new IllegalArgumentException(
          "Enemy is already destroyed, attack unnecessary."
      );
    }
  }

  /***********************************************************************************
   * equals and hashCode methods.
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
    AbstractStarship abstractStarship = (AbstractStarship) object;
    return isDestroyed == abstractStarship.isDestroyed
        && Objects.equals(shipid, abstractStarship.shipid)
        && side == abstractStarship.side
        && Objects.equals(fuelLevel, abstractStarship.fuelLevel)
        && Objects.equals(destructionLevel, abstractStarship.destructionLevel)
        && Objects.equals(maxAttackPower, abstractStarship.maxAttackPower);
  }

  @Override
  public int hashCode() {
    return Objects.hash(shipid, side, isDestroyed, fuelLevel, destructionLevel, maxAttackPower);
  }

}
