package edu.neu.ccs.cs5010.gameutil.scores;

import static org.junit.Assert.assertTrue;

import edu.neu.ccs.cs5010.game.SetOfDice;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * ThreesScore Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Dec 3, 2018</pre>
 */
public class ThreesScoreTest {

  ThreesScore trees = new ThreesScore();
  SetOfDice sod = new SetOfDice();
  int[] diceValues = {1, 3, 4, 3, 5};
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
    assertTrue(6 == trees.chooseThisPattern(sod));
  }


} 
