package edu.neu.ccs.cs5010.assignment3;


import java.util.ArrayList;
import java.util.HashSet;

/**
 * The class Theater.
 *
 * @author timzyt. created on 2018/10/01.
 */
public class Theater {

  private String name;
  private Integer numOfRow;
  private Integer numOfSeat;
  private HashSet<Integer> accessibility;
  private ArrayList<Row> theaterMap;

  /**
   * Instantiates a new Theater.
   *
   * @param name the theater name.
   * @param nrow the number of rows.
   * @param nseat the number of seats.
   * @param accessibility the indexes of accessible rows.
   * @throws Exception the exception.
   */
  public Theater(String name, Integer nrow, Integer nseat, HashSet<Integer> accessibility)
      throws Exception {
    if (name == null || nrow == null || nseat == 0) {
      throw new NullValueException("Provided theater name or number of row is null.");
    }
    if (name.length() == 0 || nrow <= 0 || nseat <= 0) {
      throw new InvalidConstructorArgumentException(
          "Provided theater name or number of row is invalid.");
    }
    this.name = name;
    this.numOfRow = nrow;
    this.numOfSeat = nseat;
    this.theaterMap = new ArrayList<>();
    for (int i = 0; i < this.numOfRow; i++) {
      this.theaterMap.add(new Row(i + 1, this.numOfSeat));
    }
    if (accessibility.size() > this.numOfRow) {
      throw new InvalidConstructorArgumentException("Provided list of accessible rows is invalid.");
    } else {
      this.accessibility = accessibility;
      for (Integer index : accessibility) {
        if (index > numOfRow) {
          throw new InvalidConstructorArgumentException(
              "Provided list of accessible rows is invalid.");
        } else {
          this.theaterMap.get(index - 1).setIsAccessible(true);
        }
      }
    }

  }

  //  public ArrayList<ArrayList<Seat>> buildTheater(Integer nRow, Integer nSeat) {
  //    List<Row> aTheater = new ArrayList<>(nRow);
  //    ArrayList<ArrayList<Seat>> seatMap = new ArrayList<>(nRow);
  //    for (int i = 0; i < nRow; i++) {
  //      seatMap.add(aTheater.get(i).buildRow(nSeat));
  //    }
  //    return seatMap;
  //  }

  /**
   * Getter for field name.
   *
   * @return the name.
   */
  public String getName() {
    return this.name;
  }

  //  /**
  //   * Sets name.
  //   *
  //   * @param newName the new name
  //   */
  //  public void setName(String newName) {
  //    if (newName == null) {
  //      throw new NullValueException("Provided name is null.");
  //    }
  //    if (newName.length() == 0) {
  //      throw new InvalidConstructorArgumentException("Provided name is invalid.");
  //    }
  //    this.name = newName;
  //  }

  /**
   * Getter for field numOfRow.
   *
   * @return the numOfRow.
   */
  public Integer getNumOfRow() {
    return this.numOfRow;
  }

  //  public ArrayList<ArrayList<Seat>> buildTheaterMap(Integer mSeat) {
  //    for(int i = 0; i < mSeat; i++) {
  //      this.getTheaterMap().get(i).add(new Seat);
  //
  //    }
  //  }

  /**
   * Getter for field theaterMap.
   *
   * @return the theaterMap.
   */
  public ArrayList<Row> getTheaterMap() {
    return this.theaterMap;
  }

  /**
   * Getter, return an sorted Integer list of the accessible rows.
   */
  public HashSet<Integer> getAccessibleRows() {
    //    Integer[] accessibleRows = new Integer[this.accessibility.size()];
    //    int index = 0;
    //    for (Integer integer : accessibility) {
    //      accessibleRows[index++] = integer;
    //    }
    //    Arrays.sort(accessibleRows);
    //    return accessibleRows;
    return this.accessibility;
  }
}
