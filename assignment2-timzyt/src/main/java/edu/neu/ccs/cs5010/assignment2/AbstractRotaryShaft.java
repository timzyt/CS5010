package edu.neu.ccs.cs5010.assignment2;

/**
 * The Abstract class rotary shaft.
 *
 * @author timzyt. created on 2018/09/21.
 */
public abstract class AbstractRotaryShaft extends AbstractStockItem {

  private Measurement length;
  private Measurement diameter;

  /**
   * Constructs and instantiates a rotary shaft.
   *
   * @param newSku new Sku number for this item.
   * @param newPriceInCent the new price in cent
   * @param asom the system of measurement for this item.
   * @param newLength new length for this item.
   * @param newDiameter new diameter for this item.
   */
  public AbstractRotaryShaft(String newSku, Integer newPriceInCent, String asom,
      Measurement newLength, Measurement newDiameter) {
    super(newSku, newPriceInCent, asom);
    this.length = newLength;
    this.diameter = newDiameter;
  }

  /**
   * Getter for field 'length'.
   *
   * @return the length for this item.
   */
  public Measurement getLength() {
    return this.length;
  }

  /**
   * Getter for field 'diameter'.
   *
   * @return the diameter for this item.
   */
  public Measurement getDiameter() {
    return this.diameter;
  }
}
