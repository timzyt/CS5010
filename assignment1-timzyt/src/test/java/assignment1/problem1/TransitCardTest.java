package assignment1.problem1;

import static org.junit.Assert.*;

import org.junit.Test;

public class TransitCardTest {

  private TransitCard newCard;
  private TransitCard newCard2;
  private String cardID;
  private String cardID2;
  private CardOwner owner;
  private CardBalance balance;
  private CardBalance balance2;
  private Deposit newDeposit;
  private Deposit newDeposit2;
  private int balanceDollar;
  private int balanceCent;
  private int balanceDollar2;
  private int balanceCent2;

  @org.junit.Before
  public void setUp() throws Exception {
    this.owner = new CardOwner("Tim", "Zhu", "SLU", "zhu.yit@husky.neu.edu");
    this.balance = new CardBalance(123, 50);
    this.balance2 = new CardBalance(100, 40);
    this.newCard = new TransitCard(cardID, owner, balance);
    this.newCard2 = new TransitCard(cardID2, owner, balance2);
    this.newDeposit = new Deposit(49, 50, "Tim", "Zhu");
    this.newDeposit2 = new Deposit(20, 15, "Tim", "Zhu");
    newCard.depositMoney(newDeposit);
    newCard2.depositMoney(newDeposit2);
    this.balanceDollar = balance.getDollar();
    this.balanceCent = balance.getCent();
    this.balanceDollar2 = balance2.getDollar();
    this.balanceCent2 = balance2.getCent();
  }


  @Test
  public void getCardID() {
    newCard.setCardId(cardID);
    assertEquals(cardID, newCard.getCardId());
  }

  @Test
  public void setCardID() {
    newCard.setCardId(cardID);
    assertEquals(cardID, newCard.getCardId());
  }

  @Test
  public void getCardOwner() {

    assertEquals(owner, newCard.getCardOwner());
  }

  @Test
  public void getCardBalance() {
    assertEquals(balance, newCard.getCardBalance());
  }

  @Test
  public void setCardOwner() {
    newCard.setCardOwner(owner);
    assertEquals(owner, newCard.getCardOwner());
  }

  @Test
  public void setCardBalance() {
    newCard.setCardBalance(balance);
    assertEquals(balance, newCard.getCardBalance());
  }

  @Test
  public void depositMoney() {
    assertEquals(173, balanceDollar);
    assertEquals(0, balanceCent);
    assertEquals(120,balanceDollar2);
    assertEquals(55,balanceCent2);
  }
}
