package edu.neu.ccs.cs5010.assignment2;


/**
 * The Abstract class sprocket.
 *
 * @author timzyt. created on 2018/09/21.
 */
public abstract class AbstractSprocket extends AbstractStockItem implements FitsShaft {

  private Measurement forShaftDiameter;
  private Integer numOfTeeth;

  /**
   * Constructs and instantiates a sprocket.
   *
   * @param newSku new SKU number for this item.
   * @param newPriceInCent price in cent value for this item.
   * @param asom system of measurement for this item.
   * @param newNumOfTeeth new number of teeth value for this item.
   * @param newForShaftDiameterVal new for shaft diameter value for this item.
   */
  public AbstractSprocket(String newSku, Integer newPriceInCent, String asom,
      Integer newNumOfTeeth, Measurement newForShaftDiameterVal) {
    super(newSku, newPriceInCent, asom);
    this.numOfTeeth = newNumOfTeeth;
    this.forShaftDiameter = newForShaftDiameterVal;
  }

  /**
   * Getter for field 'numOfTeeth'.
   *
   * @return number of teeth on this item.
   */
  public Integer getNumOfTeeth() {
    return numOfTeeth;
  }

  /**
   * return the forShaftDiameter value for this item.
   *
   * @return the forShaftDiameter value for this item.
   */
  public Measurement getForShaftDiameter() {
    return this.forShaftDiameter;
  }

  /**
   * return whether the provided RotaryShaft may fit this item.
   *
   * @return boolean.
   */
  public boolean fitsShaft(AbstractRotaryShaft abstractRotaryShaft) {
    if (abstractRotaryShaft == null) {
      throw new NullValueException("Provided input is null.");
    }
    if (this.forShaftDiameter.equals(abstractRotaryShaft.getDiameter())) {
      return true;
    } else {
      return false;
    }
  }
}
