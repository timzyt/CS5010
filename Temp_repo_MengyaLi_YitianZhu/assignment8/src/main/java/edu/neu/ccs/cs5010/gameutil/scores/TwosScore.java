package edu.neu.ccs.cs5010.gameutil.scores;

import static edu.neu.ccs.cs5010.game.SetOfDice.TOTAL_NUM_OF_DICE;
import static edu.neu.ccs.cs5010.game.SetOfDice.TWO;
import static edu.neu.ccs.cs5010.game.SetOfDice.ZERO;

import edu.neu.ccs.cs5010.game.SetOfDice;

/**
 * Twos score pattern.
 */
public class TwosScore extends AbstractScore {

  private int patternValue = TWO;

  /**
   * Instantiates a new Twos score.
   */
  public TwosScore() {
    super(TWOS);
  }

  /**
   * Choose this pattern and return the calculated score.
   * @param sod the set of dice.
   * @return int score value.
   */
  public int chooseThisPattern(SetOfDice sod) {
    for (int i = ZERO; i < TOTAL_NUM_OF_DICE; i++) {
      this.score = sod.getCountOfValue(patternValue) * patternValue;
    }

    this.isChosen = true;
    return this.score;
  }
}
