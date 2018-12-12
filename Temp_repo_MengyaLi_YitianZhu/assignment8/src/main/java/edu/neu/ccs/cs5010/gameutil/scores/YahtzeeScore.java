package edu.neu.ccs.cs5010.gameutil.scores;

import static edu.neu.ccs.cs5010.game.SetOfDice.ONE;
import static edu.neu.ccs.cs5010.game.SetOfDice.TOTAL_NUM_OF_DICE;
import static edu.neu.ccs.cs5010.game.SetOfDice.ZERO;

import edu.neu.ccs.cs5010.game.SetOfDice;

/**
 * Yahtzee score pattern.
 */
public class YahtzeeScore extends AbstractScore {

  /**
   * Instantiates a new Yahtzee score.
   */
  public YahtzeeScore() {
    super(YAHTZEE);
  }

  /**
   * Choose this pattern and return the calculated score.
   * @param sod the set of dice.
   * @return int score value.
   */
  @Override
  public int chooseThisPattern(SetOfDice sod) throws Exception {
    int[] vals = sod.getDiceValues();

    int firstValue = vals[ZERO];

    for (int i = ONE; i < TOTAL_NUM_OF_DICE; ++i) {
      if (vals[i] != firstValue) {
        this.score = ZERO;
        break;
      }
    }
    if (this.score != ZERO) {
      this.score = YAHTZEE_SCORE;
    }
    this.isChosen = true;
    return this.score;
  }
}
