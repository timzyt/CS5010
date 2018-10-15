package assignment1.problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CardOwnerTest {

  private String firstName;
  private String firstName2;
  private String lastName;
  private String lastName2;
  private String address = "123 A Street";
  private String emailAddress = "abc@aol.com";
  private CardOwner owner;

  @Before
  public void setUp() throws Exception {
    owner = new CardOwner(firstName, lastName, address, emailAddress);
  }


  @Test
  public void getFirstName() {
    assertEquals(firstName, owner.getFirstName());
  }

  @Test
  public void setFirstName() {
    owner.setFirstName(firstName2);
    assertEquals(firstName2, owner.getFirstName());
  }

  @Test
  public void getLastName() {
    assertEquals(lastName, owner.getLastName());
  }


  @Test
  public void setLastname() {
    owner.setLastname(lastName2);
    assertEquals(lastName2, owner.getLastName());
  }

  @Test
  public void getAddress() {
    assertEquals(address, owner.getAddress());
  }

  @Test
  public void setAddress() {
    owner.setAddress(address);
    assertEquals(address, owner.getAddress());
  }

  @Test
  public void getEmailAddress() {
    owner.setEmailAddress(emailAddress);
    assertEquals(emailAddress, owner.getEmailAddress());
  }

  @Test
  public void setEmailAddress() {
    owner.setEmailAddress(emailAddress);
    assertEquals(emailAddress, owner.getEmailAddress());
  }
}