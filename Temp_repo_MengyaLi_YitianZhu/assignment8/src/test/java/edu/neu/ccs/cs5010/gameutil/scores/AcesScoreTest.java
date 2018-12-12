package edu.neu.ccs.cs5010.gameutil.scores;

import static org.junit.Assert.assertTrue;

import edu.neu.ccs.cs5010.game.SetOfDice;
import edu.neu.ccs.cs5010.gameutil.scores.AcesScore;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * AcesScore Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Dec 3, 2018</pre>
 */
public class AcesScoreTest {

  AcesScore acesScore = new AcesScore();
  SetOfDice sod = new SetOfDice();
  SetOfDice sod2 = new SetOfDice();
  int[] diceValues = {1, 2, 1, 1, 3};
  int[] diceValues2 = {3, 3, 4, 4, 5};
  int res;

  @Before
  public void before() throws Exception {
    sod.setSod(diceValues);
    sod2.setSod(diceValues2);
  }

  @After
  public void after() throws Exception {
  }

  /**
   * Method: chooseThisPattern(SetOfDice dSet)
   */
  @Test
  public void testChooseThisPattern() throws Exception {
    res = acesScore.chooseThisPattern(sod);
    System.out.println(res);
    assertTrue(res == 3);
  }


} 
