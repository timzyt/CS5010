package edu.neu.ccs.cs5010.assignment2;

/**
 * The Abstract class ball bearing.
 *
 * @author timzyt. created on 2018/09/21.
 */
public abstract class AbstractBallBearing extends AbstractStockItem implements FitsShaft {

  private SealType sealType;
  private Measurement width;
  private Measurement forShaftDiameter;

  /**
   * Constructs and instantiates a Precision Ball Bearing.
   *
   * @param newSku new SKU number for this item.
   * @param newPriceInCent new price for this item.
   * @param asom new system of measurement for this item.
   * @param newSealType new seal type for this item.
   * @param newWidth new width value for this item.
   * @param newForShaftDiameterVal new for shaft diameter value for this item.
   */
  public AbstractBallBearing(String newSku, Integer newPriceInCent, String asom,
      String newSealType, Measurement newWidth, Measurement newForShaftDiameterVal) {
    super(newSku, newPriceInCent, asom);
    this.sealType = SealType.valueOf(newSealType);
    this.width = newWidth;
    this.forShaftDiameter = newForShaftDiameterVal;
  }

  /**
   * Getter of field 'SealType'.
   *
   * @return seal type of this item.
   */
  public SealType getSealType() {
    return sealType;
  }

  /**
   * Getter of field 'width'.
   *
   * @return width of this item.
   */
  public Measurement getWidth() {
    return width;
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

  /**
   * return the forShaftDiameter value for this item.
   *
   * @return the forShaftDiameter value for this item.
   */
  public Measurement getForShaftDiameter() {
    return this.forShaftDiameter;
  }
}
