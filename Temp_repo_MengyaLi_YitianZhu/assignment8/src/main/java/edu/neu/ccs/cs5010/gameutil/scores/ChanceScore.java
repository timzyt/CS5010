package edu.neu.ccs.cs5010.gameutil.scores;

import static edu.neu.ccs.cs5010.game.SetOfDice.TOTAL_NUM_OF_DICE;
import static edu.neu.ccs.cs5010.game.SetOfDice.ZERO;

import edu.neu.ccs.cs5010.game.SetOfDice;

/**
 * Chance score class.
 */
public class ChanceScore extends AbstractScore {

  /**
   * Instantiates a new Chance score.
   */
  public ChanceScore() {
    super(CHANCE);
  }

  /**
   * Choose this pattern and return the calculated score.
   * @param sod the set of dice.
   * @return int score value.
   */
  public int chooseThisPattern(SetOfDice sod) {
    for (int i = ZERO; i < TOTAL_NUM_OF_DICE; i++) {
      this.score = sod.getTotalValue();
    }

    this.isChosen = true;
    return this.score;
  }
}
