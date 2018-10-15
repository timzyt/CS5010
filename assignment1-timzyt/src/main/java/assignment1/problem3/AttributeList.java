package assignment1.problem3;

import java.util.Date;
import java.util.Objects;

public class AttributeList {

  private Integer index;
  private Date date;
  private String itemName;
  private String description;

  /**
   * constructs and instantiates an item instance to be listed in the attribute list.
   *
   * @param idx index of this item.
   * @param date date of this item.
   * @param name name of this item.
   * @param content content of this item.
   */
  public AttributeList(Integer idx, Date date, String name, String content) {
    this.index = idx;
    setDate(date);
    this.itemName = name;
    this.description = content;
  }

  /**
   * Set the index of this item.
   *
   * @return index index of this data entry.
   */
  public Integer getIndex() {
    return index;
  }

  /**
   * @param index index of this data entry.
   */
  public void setIndex(Integer index) {
    this.index = index;
  }

  /**
   * @return date of this data entry.
   */
  public Date getDate() {
    return new Date(this.date.getTime());
  }

  /**
   * set the date of this data entry.
   *
   * @param date date of this data entry.
   */
  public void setDate(Date date) {
    this.date = new Date(date.getTime());
  }

  /**
   * @return itemName name of this data entry.
   */
  public String getItemName() {
    return itemName;
  }

  /**
   * set the name of this data entry.
   *
   * @param itemName name of this data entry.
   */
  public void setItemName(String itemName) {
    this.itemName = itemName;
  }

  /**
   * @return description of this data entry.
   */
  public String getDescription() {
    return description;
  }

  /**
   * set the description of this data entry.
   *
   * @param description description of this data entry.
   */
  public void setDescription(String description) {
    this.description = description;
  }

  /**********************************************************************************************
   * equals and hashCode methods.
   * @param obj object.
   * @return boolean.
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    AttributeList that = (AttributeList) obj;
    return Objects.equals(index, that.index)
        && Objects.equals(date, that.date)
        && Objects.equals(itemName, that.itemName)
        && Objects.equals(description, that.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(index, date, itemName, description);
  }
}
