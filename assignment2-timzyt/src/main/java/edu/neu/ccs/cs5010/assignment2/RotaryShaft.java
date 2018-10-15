package edu.neu.ccs.cs5010.assignment2;

/**
 * The class Rotary shaft.
 */
public class RotaryShaft extends AbstractRotaryShaft {

  private String category;

  /**
   * Constructs and instantiates a rotary shaft.
   *
   * @param newSku new Sku number for this item.\
   * @param newPriceInCent price in cent value for this item.
   * @param asom the system of measurement for this item.
   * @param newLength new length for this item.
   * @param newDiameter new diameter for this item.
   */
  public RotaryShaft(String newSku, Integer newPriceInCent,
      String asom, Measurement newLength, Measurement newDiameter) {
    super(newSku, newPriceInCent, asom, newLength, newDiameter);
    this.category = "Rotary Shaft";
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
   * @return String value of the shaft diameter value for this item.
   */
  @Override
  public Measurement getShaft() {
    return this.getDiameter();
  }
}
