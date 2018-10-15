package edu.neu.ccs.cs5010.assignment3;

/**
 * The class Seat.
 *
 * @author timzyt. created on 2018/10/01.
 */
public class Seat {

  /**
   * The Seat name.
   */
  String seatName;
  /**
   * The Reserved for.
   */
  String reservedFor;

  /**
   * Instantiates a new Seat.
   *
   * @param seatName the seat name.
   * @param reservedFor the reserved for.
   */
  public Seat(String seatName, String reservedFor) {
    this.seatName = seatName;
    this.reservedFor = reservedFor;
  }

  /**
   * Getter for field seatName.
   *
   * @return seatName the seat name.
   */
  public String getSeatName() {
    return this.seatName;
  }

  /**
   * Setter for field seatName.
   *
   * @param index the order of the seat.
   * @throws Exception the exception.
   */
  public void setSeatName(Integer index) throws Exception {
    if (index > 25) {
      throw new InvalidNumberOfSeatException("Number of seat is over the limit.");
    }
    this.seatName = Character.toString((char) ('A' + index));
  }

  /**
   * Setter for field reservedFor.
   *
   * @param newPerson a person.
   */
  public void setReservedFor(String newPerson) throws Exception {
    if (newPerson == null) {
      throw new NullValueException("Provided input is null.");
    }
    if (newPerson.length() == 0) {
      throw new InvalidConstructorArgumentException("Provided input is invalid.");
    }
    if (!newPerson.matches("^[A-Za-z\\s]*$")) {
      throw new InvalidUserInputException("Provided reservation name is invalid.");
    }
    this.reservedFor = newPerson;
  }

  /**
   * Getter for field reservedFor.
   *
   * @return the reserved for.
   */
  public String getReservedFor() {
    return this.reservedFor;
  }

}
