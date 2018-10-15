package assignment1.problem2;


/**
 * Created by timzyt on 09/12/2018. StarDestroyer uses for storing Star Destroyer fighter
 * information. extends class AbstractStarship
 */
public class StarDestroyer extends FirstOrder {

  private final Integer starDestroyerMaxAttackPower = 50;

  /**
   * StarDestroyer class uses for constructs and initiates a StarDestroyer AbstractStarship.
   *
   * @param shipid ship ID of this AbstractStarship.
   * @param fuelLevel fuel level of this AbstractStarship.
   * @param destructionLevel destruction level of this AbstractStarship.
   */
  public StarDestroyer(String shipid, int fuelLevel, int destructionLevel) {
    super(shipid, fuelLevel, destructionLevel);
    this.setMaxAttackPower(starDestroyerMaxAttackPower);
  }
}