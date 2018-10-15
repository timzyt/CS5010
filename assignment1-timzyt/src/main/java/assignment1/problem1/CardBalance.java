package assignment1.problem1;

import java.util.Objects;

/**
 * Created by timzyt on 9/9/2018. CardBalance class uses for storing card balance information
 */
public class CardBalance {
  private Integer dollar;
  private Integer cent;

  /**
   * Constructs and initialize a CardBalance of balance (dollar.cent)
   *
   * @param dollar dollar amount of a CardBalance
   * @param cent cent amount of a CardBalance
   */
  public CardBalance(Integer dollar, Integer cent) {
    this.dollar = dollar;
    this.cent = cent;
  }

  /**
   * set the value range of dollar to be equal or greater than 0.
   *
   * @param dollar dollar value of this card balance
   */
  public void setDollar(Integer dollar) {
    if (dollar >= 0) {
      this.dollar = dollar;
    } else {
      throw new IllegalArgumentException("dollar of card balance out of range");
    }
  }

  /**
   * set the value range of cent to be equal or greater than 0, and equal or less than 99
   *
   * @param cent cent value of this card balance.
   */
  public void setCent(Integer cent) {
    if (cent >= 0 && cent <= 99) {
      this.cent = cent;
    } else {
      throw new IllegalArgumentException("cent of card balance out of range");
    }
  }

  /**
   * @return dollar dollar value of this card balance.
   */
  //getter
  public Integer getDollar() {
    return this.dollar;
  }

  /**
   * @return cent cent value of this card balance.
   */
  public Integer getCent() {
    return this.cent;
  }

  /************************************************************************
   * equals and hashCode methods.
   *
   * @param object object.
   * @return boolean.
   */
  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null || getClass() != object.getClass()) {
      return false;
    }
    CardBalance that = (CardBalance) object;
    return Objects.equals(dollar, that.dollar)
        && Objects.equals(cent, that.cent);
  }

  @Override
  public int hashCode() {
    return Objects.hash(dollar, cent);
  }
}
