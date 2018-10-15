package edu.neu.ccs.cs5010.assignment2;


/**
 * The Abstract class stock item.
 *
 * @author timzyt. created on 2018/09/21.
 */
public abstract class AbstractStockItem {


  private String sku;
  private Price price;
  private SystemOfMeasurement som;

  /**
   * Constructs and instantiates an abstract stock item.
   *
   * @param newSku new SKU number for this abstract stock item.
   * @param newPriceInCent new price for this abstract stock item.
   * @param asom system of measurement valur for this abstract stock item.
   */
  public AbstractStockItem(String newSku, Integer newPriceInCent, String asom) {
    if (newSku == null || asom == null) {
      throw new NullValueException("Provided input is null.");
    }
    if (newSku.length() == 0 || newPriceInCent <= 0) {
      throw new InvalidConstructorArgumentsException(
          "Provided information is invalid.");
    }
    this.sku = newSku;
    this.price = new Price("$", newPriceInCent);
    this.som = SystemOfMeasurement.valueOf(asom);
  }

  /**
   * Setter for field som.
   *
   * @param som new system of measurement.
   */
  public void setSom(String som) throws Exception {
    if (som == null) {
      throw new NullValueException("Provided system of measurement is null.");
    }
    if (som.length() == 0) {
      throw new InvalidConstructorArgumentsException("Provided system of measurement is invalid.");
    }
    this.som = SystemOfMeasurement.valueOf(som);
  }

  /**
   * Getter for field category.
   *
   * @return String category value of this item.
   */
  abstract String getCategory();

  /**
   * Getter for field 'sku'.
   *
   * @return the sku (Stock-keeping unit) for this item.
   */
  public String getSku() {
    return this.sku;
  }

  /**
   * Getter for field 'price'.
   *
   * @return price of this item.
   */
  public Price getPrice() {
    return this.price;
  }

  /**
   * Getter for field 'som'.
   *
   * @return system of measurement for this item.
   */
  public SystemOfMeasurement getSom() {
    return this.som;
  }

  /**
   * Abstract method to return either shaft diameter or forShaftDia measurement based on object
   * type.
   *
   * @return the shaft
   */
  abstract Measurement getShaft();
}
