package edu.neu.ccs.cs5010.gameutil.scores;

import static org.junit.Assert.assertTrue;

import edu.neu.ccs.cs5010.game.SetOfDice;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * ChanceScore Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Dec 3, 2018</pre>
 */
public class ChanceScoreTest {

  ChanceScore chanceScore = new ChanceScore();
  SetOfDice sod = new SetOfDice();
  SetOfDice sod2 = new SetOfDice();
  int[] diceValues = {1, 2, 1, 1, 3};
  int[] diceValues2 = {3, 3, 4, 4, 5};
  int res;

  @Before
  public void before() throws Exception {
    sod.setSod(diceValues);
  }

  @After
  public void after() throws Exception {
  }

  /**
   * Method: chooseThisPattern(SetOfDice dSet)
   */
  @Test
  public void testChooseThisPattern() throws Exception {
    assertTrue(8 == chanceScore.chooseThisPattern(sod));
  }


} 
