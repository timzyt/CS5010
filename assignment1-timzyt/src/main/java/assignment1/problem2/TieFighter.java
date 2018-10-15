package assignment1.problem2;


/**
 * Created by timzyt on 09/12/2018. TieFighter uses for storing Tie fighter information. extends
 * class AbstractStarship
 */
public class TieFighter extends FirstOrder {

  private final Integer tiefighterMaxAttackPower = 25;
  /**
   * TieFighter class uses for constructs and initiates a Tie fighter AbstractStarship.
   *
   * @param shipid ship ID of this AbstractStarship.
   * @param fuelLevel fuel level of this AbstractStarship.
   * @param destructionLevel destruction level of this AbstractStarship.
   */
  public TieFighter(String shipid, int fuelLevel, int destructionLevel) {
    super(shipid, fuelLevel, destructionLevel);
    this.setMaxAttackPower(tiefighterMaxAttackPower);
  }
}