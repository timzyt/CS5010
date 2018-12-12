package edu.neu.ccs.cs5010.gameutil.scores;

import edu.neu.ccs.cs5010.game.SetOfDice;

/**
 * The abstract score class.
 */
public abstract class AbstractScore {

  /**
   * The Pattern string.
   */
  public String pattern;
  /**
   * The Score for the specific pattern.
   */
  protected int score = Integer.MIN_VALUE;
  /**
   * Boolean of whether the score is chosen.
   */
  protected boolean isChosen = false;
  /**
   * The String constant ACES.
   */
  public static final String ACES = "Aces";
  /**
   * The String constant TWOS.
   */
  public static final String TWOS = "Twos";
  /**
   * The String constant THREES.
   */
  public static final String THREES = "Threes";
  /**
   * The String constant FOURS.
   */
  public static final String FOURS = "Fours";
  /**
   * The String constant FIVES.
   */
  public static final String FIVES = "Fives";
  /**
   * The String constant SIXES.
   */
  public static final String SIXES = "Sixes";
  /**
   * The String constant THREE_OF_KIND.
   */
  public static final String THREE_OF_KIND = "ThreeOfKind";
  /**
   * The String constant FOUR_OF_KIND.
   */
  public static final String FOUR_OF_KIND = "FourOfKind";
  /**
   * The String constant FULL_HOUSE.
   */
  public static final String FULL_HOUSE = "FullHouse";
  /**
   * The String constant SMALL_STRAIGHT.
   */
  public static final String SMALL_STRAIGHT = "SmallStraight";
  /**
   * The String constant LARGE_STRAIGHT.
   */
  public static final String LARGE_STRAIGHT = "LargeStraight";
  /**
   * The String constant YAHTZEE.
   */
  public static final String YAHTZEE = "Yahtzee";
  /**
   * The String constant CHANCE.
   */
  public static final String CHANCE = "Chance";
  /**
   * The String constant FULL_HOUSE_SCORE.
   */
  public static final int FULL_HOUSE_SCORE = 25;
  /**
   * The String constant SMALL_STRAIGHT_SCORE.
   */
  public static final int SMALL_STRAIGHT_SCORE = 30;
  /**
   * The String constant LARGE_STRAIGHT_SCORE.
   */
  public static final int LARGE_STRAIGHT_SCORE = 40;
  /**
   * The String constant YAHTZEE_SCORE.
   */
  public static final int YAHTZEE_SCORE = 50;


  /**
   * Instantiates a new abstract score class.
   *
   * @param pattern the pattern
   */
  public AbstractScore(String pattern) {
    this.pattern = pattern;
  }

  /**
   * Gets pattern.
   *
   * @return the pattern
   */
  public String getPattern() {
    return this.pattern;
  }

  /**
   * Gets score.
   *
   * @return the score
   */
  public int getScore() {
    return this.score;
  }

  /**
   * Choose this pattern int.
   *
   * @param sod the set of dice
   * @return integer value of the calculated score
   * @throws Exception the exception
   */
  public abstract int chooseThisPattern(SetOfDice sod) throws Exception;

  /**
   * Check if this score pattern is chosen.
   *
   * @return the is chosen
   */
  public boolean isIsChosen() {
    return this.isChosen;
  }

  @Override
  public String toString() {
    String msg =
        "Current set of dice scores " + getScore() + " for the " + getPattern() + " pattern";
    if (isChosen) {
      return msg + ", and it's been chosen.";
    } else {
      return msg + ", and it hasn't been chosen.";
    }
  }
}
