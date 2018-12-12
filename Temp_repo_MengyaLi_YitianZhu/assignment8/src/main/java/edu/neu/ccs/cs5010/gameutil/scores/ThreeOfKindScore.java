package edu.neu.ccs.cs5010.gameutil.scores;

import static edu.neu.ccs.cs5010.game.SetOfDice.ONE;
import static edu.neu.ccs.cs5010.game.SetOfDice.THREE;
import static edu.neu.ccs.cs5010.game.SetOfDice.TOTAL_NUM_OF_DICE;
import static edu.neu.ccs.cs5010.game.SetOfDice.ZERO;

import edu.neu.ccs.cs5010.game.SetOfDice;

/**
 * Three of kind score pattern.
 */
public class ThreeOfKindScore extends AbstractScore {

  /**
   * Instantiates a new Three of kind score.
   */
  public ThreeOfKindScore() {
    super(THREE_OF_KIND);
  }

  /**
   * Choose this pattern and return the calculated score.
   * @param sod the set of dice.
   * @return int score value.
   */
  public int chooseThisPattern(SetOfDice sod) {
    for (int i = ONE; i <= TOTAL_NUM_OF_DICE; i++) {
      if (sod.getCountOfValue(i) >= THREE) {
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
