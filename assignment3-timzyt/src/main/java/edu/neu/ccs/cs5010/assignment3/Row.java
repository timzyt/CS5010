package edu.neu.ccs.cs5010.assignment3;

import java.util.ArrayList;

/**
 * The class Row.
 *
 * @author timzyt. created on 2018/10/01.
 */
public class Row {

  private Integer rowNum;
  private Integer numOfSeat;
  private Boolean isAccessible;
  private ArrayList<Seat> rowMap;

  /**
   * Instantiates a new Row.
   *
   * @param rowNum the row num.
   * @param numOfSeat the num of seat.
   * @throws Exception the exception.
   */
  public Row(Integer rowNum, Integer numOfSeat) throws Exception {
    if (rowNum == null || numOfSeat == null) {
      throw new NullValueException("Provided rowNum or numOfSeat is null.");
    }
    if (rowNum == 0 || numOfSeat == 0) {
      throw new InvalidConstructorArgumentException("Provided rowNum or numOfSeat is invalid.");
    }
    this.rowNum = rowNum;
    this.numOfSeat = numOfSeat;
    this.rowMap = new ArrayList<>();
    this.isAccessible = false;
    for (int i = 0; i < this.numOfSeat; i++) {
      this.rowMap.add(new Seat(Character.toString((char) ('A' + i)), ""));
    }
  }

  /**
   * Getter for rowMap.
   *
   * @return the rowMap.
   */
  public ArrayList<Seat> getRowMap() {
    return this.rowMap;
  }

  /**
   * Getter for field rowNumber.
   *
   * @return the rowNumber.
   */
  public Integer getRowNumber() {
    return this.rowNum;
  }

  //  public void setRowNumber(Integer i) {
  //    if (i == null) {
  //      throw new NullValueException("Provided row number is null.");
  //    }
  //    if (i < 0) {
  //      throw new InvalidConstructorArgumentException("Provided row number is invalid.");
  //    }
  //    this.rowNum = i;
  //  }

  /**
   * Getter for field numOfSeat.
   *
   * @return the numOfSeat.
   */
  public Integer getNumOfSeat() {
    return this.numOfSeat;
  }

  //  public void setNumOfSeat(Integer nSeat) throws Exception{
  //    if (nSeat == null) {
  //      throw new NullValueException("Provided input is null.");
  //    }
  //    if (nSeat == 0) {
  //      throw new InvalidConstructorArgumentException("Provided input is invalid.");
  //    }
  //    this.numOfSeat = nSeat;
  //  }

  /**
   * Getter for the field isAccessible.
   *
   * @return isAccessible as boolean value.
   */
  public Boolean getIsAccessible() {
    return this.isAccessible;
  }

  /**
   * Setter for the field isAccessible.
   *
   * @param accessibility boolean parameter for isAccessible.
   */
  public void setIsAccessible(Boolean accessibility) {
    this.isAccessible = accessibility;
  }

  /**
   * Gets the number of empty seat.
   *
   * @return the number of empty seat.
   */
  public Integer getEmptySeat() {
    Integer nemptySeat = 0;
    for (int i = 0; i < this.numOfSeat - 1; i++) {
      if (this.rowMap.get(i).getReservedFor().contentEquals("")) {
        nemptySeat += 1;
      }
    }
    return nemptySeat + 1;
  }
}
