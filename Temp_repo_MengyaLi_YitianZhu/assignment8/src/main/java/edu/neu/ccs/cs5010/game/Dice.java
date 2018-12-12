package edu.neu.ccs.cs5010.game;

import edu.neu.ccs.cs5010.exceptions.IllegalValueException;

import java.util.Random;

/**
 * Dice class.
 */
public class Dice {

  private int value;
  private Random rand;
  private static final int MIN_DICE_VALUE = 1;
  /**
   * The constant MAX_DICE_VALUE.
   */
  public static final int MAX_DICE_VALUE = 6;

  /**
   * Instantiates a new Dice.
   */
  public Dice() {
    rand = new Random();
  }

  /**
   * Gets value of the dice.
   *
   * @return the value
   */
  public int getValue() {
    return this.value;
  }

  /**
   * Sets value for the dice.
   *
   * @param value the value
   */
  public void setValue(int value) {
    if (value >= 1 && value <= 6) {
      this.value = value;
    } else {
      throw new IllegalValueException("This dice's value is invalid.");
    }
  }

  /**
   * Roll the dice.
   */
  public void roll() {
    this.value = rand.nextInt(MAX_DICE_VALUE) + MIN_DICE_VALUE;
  }

  @Override
  public String toString() {
    return "Current dice is rolled to to value " + value;
  }
}
