package edu.neu.ccs.cs5010.gameutil.scores;

import static edu.neu.ccs.cs5010.game.SetOfDice.FIVE;
import static edu.neu.ccs.cs5010.game.SetOfDice.TOTAL_NUM_OF_DICE;
import static edu.neu.ccs.cs5010.game.SetOfDice.ZERO;

import edu.neu.ccs.cs5010.game.SetOfDice;

/**
 * Fives score pattern.
 */
public class FivesScore extends AbstractScore {

  private int patternValue = FIVE;

  /**
   * Instantiates a new Fives score.
   */
  public FivesScore() {
    super(FIVES);
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
