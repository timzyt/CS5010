package edu.neu.ccs.cs5010.assignment2;

/**
 * The class Precision ball bearing.
 */
public class PrecisionBallBearing extends AbstractBallBearing {

  private String category;

  /**
   * Constructs and instantiates a Precision Ball Bearing.
   *
   * @param newSku new SKU number for this item.
   * @param newPriceInCent new price for this item.
   * @param som new system of measurement.
   * @param newSealType new seal type for this item.
   * @param newWidth new width value for this item.
   * @param newForShaftDiameterVal new for shaft diameter value for this item.
   */
  public PrecisionBallBearing(String newSku, Integer newPriceInCent, String som,
      String newSealType, Measurement newWidth, Measurement newForShaftDiameterVal)
      throws Exception {
    super(newSku, newPriceInCent, som, newSealType, newWidth, newForShaftDiameterVal);
    this.category = "Precision Ball Bearing";
    this.setSom("Metric");
  }

  /**
   * Getter for field category.
   *
   * @return String category.
   */
  @Override
  public String getCategory() {
    return this.category;
  }

  /**
   * get forShaftDiameter value for this item
   *
   * @return String value of the forShaftDiameter value for this item.
   */
  @Override
  public Measurement getShaft() {
    return this.getForShaftDiameter();
  }
}
