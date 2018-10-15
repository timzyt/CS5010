package edu.neu.ccs.cs5010.assignment2;

/**
 * The class Sprocket for ANSI roller chain.
 */
public class SprocketForansiRollerChain extends AbstractSprocket {

  private String category;

  /**
   * Constructs and instantiates a sprocket.
   *
   * @param newSku new SKU number for this item.
   * @param newPriceInCent price in cent value for this item.
   * @param inch system of measurement for this item.
   * @param newNumOfTeeth new number of teeth value for this item.
   * @param newForShaftDiameterVal new for shaft diameter value for this item.
   */
  public SprocketForansiRollerChain(String newSku, Integer newPriceInCent,
      String inch, Integer newNumOfTeeth, Measurement newForShaftDiameterVal) throws Exception {
    super(newSku, newPriceInCent, inch, newNumOfTeeth, newForShaftDiameterVal);

    this.category = "Sprockets for ANSI Roller Chain";
    this.setSom("Inch");
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
