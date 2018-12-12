package edu.neu.ccs.cs5010.game;

import java.util.Arrays;

/**
 * Set of dice Class.
 */
public class SetOfDice {

  /**
   * The constant ZERO.
   */
  public static final int ZERO = 0;
  /**
   * The constant ONE.
   */
  public static final int ONE = 1;
  /**
   * The constant TWO.
   */
  public static final int TWO = 2;
  /**
   * The constant THREE.
   */
  public static final int THREE = 3;
  /**
   * The constant FOUR.
   */
  public static final int FOUR = 4;
  /**
   * The constant FIVE.
   */
  public static final int FIVE = 5;
  /**
   * The constant SIX.
   */
  public static final int SIX = 6;
  /**
   * The constant TOTAL_NUM_OF_DICE.
   */
  public static final int TOTAL_NUM_OF_DICE = 5;

  private Dice[] diceSet;
  /*private Random rand;*/

  /**
   * Get the dice set.
   *
   * @return the dice [ ]
   */
  public Dice[] getDiceSet() {
    Dice[] copyArray = new Dice[this.diceSet.length];
    for (int i = 0; i < diceSet.length; i++) {
      copyArray[i] = new Dice();
      copyArray[i].setValue(diceSet[i].getValue());
    }
    return copyArray;
  }

  /**
   * Instantiates a new Set of dice.
   */
  public SetOfDice() {
    diceSet = new Dice[TOTAL_NUM_OF_DICE];
    for (int i = ZERO; i < TOTAL_NUM_OF_DICE; i++) {
      diceSet[i] = new Dice();
    }
    //rand = new Random();
  }

  /**
   * Roll all dice.
   */
  public void rollAllDice() {
    for (int i = ZERO; i < TOTAL_NUM_OF_DICE; i++) {
      this.diceSet[i].roll();
    }
  }

  /**
   * Roll selected dice.
   *
   * @param diceSelection the dice selection
   */
  public void rollSelectedDice(int[] diceSelection) {
    for (int j = ZERO; j < TOTAL_NUM_OF_DICE; j++) {
      if (!this.contains(diceSelection, j + 1)) {
        this.diceSet[j].roll();
      }
    }

  }

  /**
   * Find if target item is in the array.
   *
   * @param arr the arr
   * @param key the index for the target
   * @return the boolean
   */
  public static boolean contains(final int[] arr, final int key) {
    return Arrays.stream(arr).anyMatch(index -> index == key);
  }

  /**
   * Gets count of given value.
   *
   * @param val the value
   * @return the count of value
   */
  public int getCountOfValue(int val) {
    int counter = ZERO;
    for (int i = ZERO; i < TOTAL_NUM_OF_DICE; i++) {
      if (this.diceSet[i].getValue() == val) {
        counter++;
      }
    }
    return counter;
  }

  /**
   * Gets total value.
   *
   * @return the total value
   */
  public int getTotalValue() {
    int total = ZERO;
    for (int i = ZERO; i < TOTAL_NUM_OF_DICE; i++) {
      total += this.diceSet[i].getValue();
    }
    return total;
  }

  /**
   * Get an array of dice values.
   *
   * @return the integer array
   */
  public int[] getDiceValues() {
    int[] diceArray = new int[FIVE];
    for (int i = ZERO; i < TOTAL_NUM_OF_DICE; i++) {
      diceArray[i] = diceSet[i].getValue();
    }
    return diceArray;
  }

  /**
   * Check if the provided set contains valid indices.
   *
   * @param diceChoice string input of the dice choice
   * @return boolean
   */
  public boolean checkValidSelection(String diceChoice) {
    try {
      int[] keep = Arrays.stream(diceChoice.split(" ")).mapToInt(Integer::parseInt).toArray();
      for (int i : keep) {
        if (i < 0 || i >= 6) {
          return false;
        }
      }
      return true;
    } catch (Exception e) {
      return false;
    }

  }

  /**
   * Sets values for the set of dice.
   *
   * @param sod the sod
   */
  public void setSod(int[] sod) {
    for (int i = 0; i < TOTAL_NUM_OF_DICE; i++) {
      this.diceSet[i].setValue(sod[i]);
    }
  }

  @Override
  public String toString() {
    return this.diceSet[ZERO].getValue() + " "
        + this.diceSet[ONE].getValue() + " "
        + this.diceSet[TWO].getValue() + " "
        + this.diceSet[THREE].getValue() + " "
        + this.diceSet[FOUR].getValue();
  }
}
