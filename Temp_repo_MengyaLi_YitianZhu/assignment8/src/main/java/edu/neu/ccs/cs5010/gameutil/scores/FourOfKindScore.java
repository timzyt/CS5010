package edu.neu.ccs.cs5010.gameutil.scores;

import static edu.neu.ccs.cs5010.game.SetOfDice.FOUR;
import static edu.neu.ccs.cs5010.game.SetOfDice.ONE;
import static edu.neu.ccs.cs5010.game.SetOfDice.TOTAL_NUM_OF_DICE;
import static edu.neu.ccs.cs5010.game.SetOfDice.ZERO;

import edu.neu.ccs.cs5010.game.SetOfDice;

/**
 * Four of kind score pattern.
 */
public class FourOfKindScore extends AbstractScore{

  /**
   * Instantiates a new Four of kind score.
   */
  public FourOfKindScore() {
    super(FOUR_OF_KIND);
  }

  /**
   * Choose this pattern and return the calculated score.
   * @param sod the set of dice.
   * @return int score value.
   */
  public int chooseThisPattern(SetOfDice sod) throws Exception {
    for (int i = ONE; i <= TOTAL_NUM_OF_DICE; i++) {
      if (sod.getCountOfValue(i) >= FOUR) {
        this.score = sod.getTotalValue();
        this.isChosen = true;
        return this.score;
      }
    }
    this.score = ZERO;
    this.isChosen = true;
    return this.score;
  }
}
