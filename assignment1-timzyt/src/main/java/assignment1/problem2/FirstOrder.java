package assignment1.problem2;

public class FirstOrder extends AbstractStarship {

  /**
   * Constructs and initialize a AbstractStarship.
   *
   * @param shipid  the ship ID of this AbstractStarship.
   * @param fuelLevel the fuel level of this AbstractStarship.
   * @param destructionLevel the destruction leve of this AbstractStarship.
   */
  public FirstOrder(String shipid, int fuelLevel, int destructionLevel) {
    super(shipid, fuelLevel, destructionLevel);
    this.setSide(Side.FirstOrder);
  }
}
