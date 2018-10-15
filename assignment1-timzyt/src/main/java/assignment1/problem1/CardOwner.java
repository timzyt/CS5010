package assignment1.problem1;

import java.util.Objects;

/**
 * Created by timzyt on 9/9/2018. CardOwner class uses for storing person information
 */
public class CardOwner {

  private String firstName;
  private String lastName;
  private String address;
  private String emailAddress;

  /**
   * Constructs and initiates a CardOwner with firstName, lastName, address and emailAddress.
   *
   * @param firstName CardOwner's first name
   * @param lastName CardOwner's last name
   * @param address CardOwner's address
   * @param emailAddress CardOwner's email address
   */
  public CardOwner(String firstName, String lastName, String address, String emailAddress) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.address = address;
    this.emailAddress = emailAddress;
  }

  //getter

  /**
   * @return firstName first name of this card owner.
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * @return lastName last name of this card owner.
   */
  public String getLastName() {
    return lastName;
  }

  //setter

  /**
   * @param fname first name of this card user.
   */
  public void setFirstName(String fname) {
    this.firstName = fname;
  }

  /**
   * @param lname last name of this card user.
   */
  public void setLastname(String lname) {
    this.lastName = lname;
  }

  /**
   * @return address address of this owner.
   */
  public String getAddress() {
    return address;
  }

  /**
   * set the address of this owner.
   *
   * @param address address of this owner.
   */
  public void setAddress(String address) {
    this.address = address;
  }

  /**
   * @return emailAddress email address of this owner.
   */
  public String getEmailAddress() {
    return emailAddress;
  }

  /**
   * set the email address of this owner.
   *
   * @param emailAddress email address of this owner.
   */
  public void setEmailAddress(String emailAddress) {
    this.emailAddress = emailAddress;
  }


  /****************************************************************************
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
    CardOwner cardOwner = (CardOwner) object;
    return Objects.equals(firstName, cardOwner.firstName)
        && Objects.equals(lastName, cardOwner.lastName)
        && Objects.equals(address, cardOwner.address)
        && Objects.equals(emailAddress, cardOwner.emailAddress);
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstName, lastName, address, emailAddress);
  }
}
