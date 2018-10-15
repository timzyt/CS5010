package assignment1.problem1;

import java.util.Objects;

/**
 * Created by timzyt on 9/10/2018. TransitCard class uses for implementing method depositMoney.
 */
public class TransitCard {

  private String cardId;
  private CardOwner owner;
  private CardBalance balance;

  /**
   * Constructs and initiates a transit card with cardId, card owner and card balance.
   *
   * @param cardId card ID of this transit card.
   * @param owner card owner of this transit card.
   * @param balance card balance of this transit card.
   */
  public TransitCard(String cardId, CardOwner owner, CardBalance balance) {
    this.owner = owner;
    setCardBalance(balance);
  }

  /**
   * @return cardId card ID of this transit card.
   */
  public String getCardId() {
    return cardId;
  }

  /**
   * set card ID of this transit card.
   *
   * @param cardId card ID of this transit card.
   */
  public void setCardId(String cardId) {
    this.cardId = cardId;
  }
  //getter get card owner and card balance information

  /**
   * @return this.owner owner of this transit card.
   */
  public CardOwner getCardOwner() {
    return this.owner;
  }

  /**
   * @return this.balance card balance of this transit card.
   */
  public CardBalance getCardBalance() {
    return this.balance;
  }

  //setter set card owner and card balance

  /**
   * set card owner of this transit card.
   *
   * @param owner card owner of this transit card.
   */
  public void setCardOwner(CardOwner owner) {
    this.owner = owner;
  }

  /**
   * set card balance of this transit card.
   *
   * @param balance card balance of this transit card.
   */
  public void setCardBalance(CardBalance balance) {
    this.balance = balance;
  }


  /**********************************************************************************
   * depositMoney method:
   * -compares provided card owner's first name and last name against information on file.
   * -add the deposit amount onto card balance if card owner information matches.
   * -throws IllegalArgumentException if otherwise.
   *
   * @param newDeposit a new deposit
   * @throws IllegalArgumentException "deposit cannot be made"
   */
  public void depositMoney(Deposit newDeposit) throws IllegalArgumentException {

    // compares provided card owner's first name and last name with card owner information on file
    if (newDeposit.getFname().equals(owner.getFirstName()) && newDeposit.getlName()
        .equals(owner.getLastName())) {   //TODO: check Java.util String contains equals method.

      // check if total cent after deposit would be greater than 100
      if (balance.getCent() + newDeposit.getCent() >= 100) {
        balance.setCent(balance.getCent() + newDeposit.getCent() - 100);
        balance.setDollar(balance.getDollar() + newDeposit.getDollar() + 1);
      } else {
        balance.setCent(balance.getCent() + newDeposit.getCent());
        balance.setDollar(balance.getDollar() + newDeposit.getDollar());
      }
    } else {

      // if card owner information doesn't match, throws IllegalArgumentException
      throw new IllegalArgumentException(
          "card owner information provided doesn't match the information on file, "
              + "deposit can't be done.");
    }
  }


  /************************************************************************************
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
    TransitCard that = (TransitCard) object;
    return Objects.equals(cardId, that.cardId)
        && Objects.equals(owner, that.owner)
        && Objects.equals(balance, that.balance);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cardId, owner, balance);
  }
}
