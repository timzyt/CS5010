package edu.neu.ccs.cs5010.gameutil.scores;

import static edu.neu.ccs.cs5010.game.SetOfDice.THREE;
import static edu.neu.ccs.cs5010.game.SetOfDice.TOTAL_NUM_OF_DICE;
import static edu.neu.ccs.cs5010.game.SetOfDice.TWO;
import static edu.neu.ccs.cs5010.game.SetOfDice.ZERO;

import edu.neu.ccs.cs5010.game.SetOfDice;

/**
 * Full house score pattern.
 */
public class FullHouseScore extends AbstractScore {

  /**
   * Instantiates a new Full house score.
   */
  public FullHouseScore() {
    super(FULL_HOUSE);
  }

  /**
   * Choose this pattern and return the calculated score.
   * @param sod the set of dice.
   * @return int score value.
   */
  public int chooseThisPattern(SetOfDice sod) {
    int diceValue1 = Integer.MIN_VALUE;
    int diceValue2 = Integer.MIN_VALUE;

    for (int i = ZERO; i < TOTAL_NUM_OF_DICE; i++) {
      int currVal = sod.getDiceValues()[i];
      if (sod.getCountOfValue(currVal) == THREE) {
        diceValue1 = currVal;
        break;
      }
    }

    for (int i = ZERO; i < TOTAL_NUM_OF_DICE; i++) {
      int currVal = sod.getDiceValues()[i];
      if (sod.getCountOfValue(currVal) == TWO) {
        diceValue2 = currVal;
        break;
      }
    }

    if (diceValue1 > ZERO && diceValue2 > ZERO && diceValue1 != diceValue2) {
      this.score = FULL_HOUSE_SCORE;
    } else {
      this.score = ZERO;
    }
    this.isChosen = true;
    return this.score;
  }
}
