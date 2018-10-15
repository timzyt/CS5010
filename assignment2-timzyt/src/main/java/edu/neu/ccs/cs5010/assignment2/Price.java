package edu.neu.ccs.cs5010.assignment2;

/**
 * The class Price.
 *
 * @author timzyt. created on 2018/09/21.
 */
public class Price {

  private String currency;
  private Integer priceInCent;
  private Integer priceMin = 0;

  /**
   * Constructs and instantiates Price.
   *
   * @param usd currency value of the priceInCent.
   * @param newPriceInCent priceInCent value in cents.
   */
  public Price(String usd, Integer newPriceInCent) {
    if (usd == null || newPriceInCent == null) {
      throw new NullValueException("Provided input is null.");
    }
    if (usd.length() == 0 || newPriceInCent < priceMin) {
      throw new InvalidConstructorArgumentsException(
          "Provided priceInCent information is invalid.");
    }
    this.currency = usd;
    this.priceInCent = newPriceInCent;
  }

  /**
   * Print price string.
   *
   * @return the string
   */
  public String printPrice() {
    StringBuffer priceInString = new StringBuffer().append(currency)
        .append(((double) priceInCent / 100.00));
    return priceInString.toString();
  }

  /**
   * Getter for field 'currency'.
   *
   * @return currency value of this priceInCent.
   */
  public String getCurrency() {
    return currency;
  }

  /**
   * Setter for field 'currency'.
   *
   * @param newCurrency new currency value for this priceInCent.
   */
  public void setCurrency(String newCurrency) {
    if (newCurrency == null) {
      throw new NullValueException("Provided input is null.");
    }
    if (newCurrency.length() == 0) {
      throw new InvalidConstructorArgumentsException(
          "Provided currency information is invalid.");
    }
    this.currency = newCurrency;
  }

  /**
   * Getter for field 'priceInCent'.
   *
   * @return price value in cent.
   */
  public Integer getPriceInCent() {
    return this.priceInCent;
  }
}
