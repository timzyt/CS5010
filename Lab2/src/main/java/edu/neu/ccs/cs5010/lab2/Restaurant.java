package edu.neu.ccs.cs5010.lab2;

/**
 * Public class Restaurant.
 *
 * @author timzyt
 * @version 1.0
 * @since <pre>Oct 2, 2018</pre>
 */
public class Restaurant {

  private String resName;
  private Address address;
  private Menu menu;
  private Boolean isOpen;

  /**
   * Instantiates a new Restaurant.
   *
   * @param resName the res name
   * @param address the address
   * @param menu the menu
   * @param isOpen the is open
   */
  public Restaurant(String resName, Address address, Menu menu, Boolean isOpen) {
    this.resName = resName;
    this.address = address;
    this.menu = menu;
    this.isOpen = isOpen;
  }

  /**
   * Gets res name.
   *
   * @return the res name
   */
  public String getResName() {
    return resName;
  }

  /**
   * Sets res name.
   *
   * @param resName the res name
   * @throws Exception the exception
   */
  public void setResName(String resName) throws Exception {
    if (resName == null) {
      throw new NullPointerException("Provided input is null.");
    } else {
      this.resName = resName;
    }
  }

  /**
   * Gets open.
   *
   * @return the open
   */
  public Boolean getIsOpen() {
    return isOpen;
  }

  /**
   * Sets open.
   *
   * @param open the open
   * @throws NullPointerException the null pointer exception
   */
  public void setIsOpen(Boolean open) throws NullPointerException {
    if (open == null) {
      throw new NullPointerException("Provided input is null.");
    } else {
      this.isOpen = open;
    }
  }

  /**
   * Gets address.
   *
   * @return the address
   */
  public Address getAddress() {
    return address;
  }

  /**
   * Sets address.
   *
   * @param newAddress the address
   * @throws Exception the exception
   */
  public void setAddress(Address newAddress) throws Exception {
    if (newAddress == null) {
      throw new NullPointerException("Provided input is null.");
    } else {
      this.address = newAddress;
    }
  }

  /**
   * Gets menu.
   *
   * @return the menu
   */
  public Menu getMenu() {
    return menu;
  }

  /**
   * Sets menu.
   *
   * @param newMenu the menu
   * @throws Exception the exception
   */
  public void setMenu(Menu newMenu) throws Exception {
    if (newMenu == null) {
      throw new NullPointerException("Provided input is null.");
    } else {
      this.menu = newMenu;
    }
  }
}
