package edu.neu.ccs.cs5010.gameutil.scores;

import static edu.neu.ccs.cs5010.game.SetOfDice.FOUR;
import static edu.neu.ccs.cs5010.game.SetOfDice.THREE;
import static edu.neu.ccs.cs5010.game.SetOfDice.TOTAL_NUM_OF_DICE;
import static edu.neu.ccs.cs5010.game.SetOfDice.TWO;
import static edu.neu.ccs.cs5010.game.SetOfDice.ZERO;

import edu.neu.ccs.cs5010.game.SetOfDice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Small straight score pattern.
 */
public class SmallStraightScore extends AbstractScore {

  private boolean hasStraight;

  /**
   * Instantiates a new Small straight score.
   */
  public SmallStraightScore() {
    super(SMALL_STRAIGHT);
  }

  /**
   * Choose this pattern and return the calculated score.
   * @param sod the set of dice.
   * @return int score value.
   */
  public int chooseThisPattern(SetOfDice sod) throws Exception {
    int[] diceValues = sod.getDiceValues();

    Arrays.sort(diceValues);

    int minValue = diceValues[ZERO];

    Set<Integer> diceValueSet = new HashSet<>();

    // insert dice values into the HashSet
    for (int i = ZERO; i < TOTAL_NUM_OF_DICE; i++) {
      diceValueSet.add(diceValues[i]);
    }

    if (minValue > THREE) {
      hasStraight = false;
    } else {
      for (int i = ZERO; i < TWO; i++) {
        if (hasStraight) {
          break;
        }
        Set<Integer> tempSet = new HashSet<>(diceValueSet);
        hasStraight = true;
        for (int j = ZERO; j < FOUR; j++) {
          Integer currValue = diceValues[i] + j;
          if (tempSet.contains(currValue)) {
            tempSet.remove(currValue);
          } else {
            hasStraight = false;
            break;
          }

        }
      }
    }
    if (hasStraight) {
      this.score = SMALL_STRAIGHT_SCORE;
    } else {
      this.score = ZERO;
    }
    this.isChosen = true;
    return this.score;
  }
}
