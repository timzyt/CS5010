package assignment1.problem2;

/**
 * Created by timzyt on 09/12/2018. XWingFighter uses for storing X-Wing fighter information.
 * extends class AbstractStarship
 */
public class XWingFighter extends Resistance {

  private final Integer xwingfighterMaxAttackPower = 40;
  /**
   * XWingFighter class uses for constructs and initiates a X-Wing fighter AbstractStarship.
   *
   * @param shipid ship ID of this AbstractStarship.
   * @param fuelLevel fuel level of this AbstractStarship.
   * @param destructionLevel destruction level of this AbstractStarship.
   */
  public XWingFighter(String shipid, int fuelLevel, int destructionLevel) {
    super(shipid, fuelLevel, destructionLevel);
    this.setMaxAttackPower(xwingfighterMaxAttackPower);
  }
}
