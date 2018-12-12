package edu.neu.ccs.cs5010.gameutil.scores;

import static edu.neu.ccs.cs5010.game.SetOfDice.ONE;
import static edu.neu.ccs.cs5010.game.SetOfDice.TOTAL_NUM_OF_DICE;
import static edu.neu.ccs.cs5010.game.SetOfDice.TWO;
import static edu.neu.ccs.cs5010.game.SetOfDice.ZERO;

import edu.neu.ccs.cs5010.game.SetOfDice;

import java.util.Arrays;

/**
 * Large straight score pattern.
 */
public class LargeStraightScore extends AbstractScore {

  /**
   * Instantiates a new Large straight score.
   */
  public LargeStraightScore() {
    super(LARGE_STRAIGHT);
  }

  /**
   * Choose this pattern and return the calculated score.
   * @param sod the set of dice.
   * @return int score value.
   */
  public int chooseThisPattern(SetOfDice sod) {
    int[] diceValues = sod.getDiceValues();

    Arrays.sort(diceValues);

    int minValue = diceValues[ZERO];

    if (minValue > TWO) {
      this.score = ZERO;
    } else {
      for (int i = ONE; i < TOTAL_NUM_OF_DICE; i++) {
        if (diceValues[i] != (diceValues[i - ONE] + ONE)) {
          this.score = ZERO;
          break;
        }
      }
      if (this.score != ZERO) {
        this.score = LARGE_STRAIGHT_SCORE;
      }
    }
    isChosen = true;
    return this.score;
  }
}
