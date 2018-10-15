package assignment1.problem2;


/**
 * Created by timzyt on 09/12/2018. AWingFighter uses for storing A-Wing fighter information.
 * extends class AbstractStarship
 */
public class AWingFighter extends Resistance {

  private final Integer awingfighterMaxAttackPower = 30;

  /**
   * AWingFighter class uses for constructs and initiates a A-Wing fighter AbstractStarship.
   *
   * @param shipid ship ID of this AbstractStarship.
   * @param fuelLevel fuel level of this AbstractStarship.
   * @param destructionLevel destruction level of this AbstractStarship.
   */
  public AWingFighter(String shipid, int fuelLevel, int destructionLevel) {

    super(shipid, fuelLevel, destructionLevel);
    this.setMaxAttackPower(awingfighterMaxAttackPower);
  }
}
