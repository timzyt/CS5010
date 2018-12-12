package edu.neu.ccs.cs5010.gameutil.scores;

import static org.junit.Assert.assertTrue;

import edu.neu.ccs.cs5010.game.SetOfDice;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * FourOfKindScore Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Dec 3, 2018</pre>
 */
public class FourOfKindScoreTest {

  FourOfKindScore fok = new FourOfKindScore();
  SetOfDice sod = new SetOfDice();
  int[] diceValues = {1, 5, 5, 5, 5};
  int[] diceValues2 = {1, 5, 5, 5, 3};
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
    assertTrue(21 == fok.chooseThisPattern(sod));
  }


  /**
   * Method: chooseThisPattern(SetOfDice dSet)
   */
  @Test
  public void testNoFourOfKind() throws Exception {
    sod.setSod(diceValues2);
    assertTrue(0 == fok.chooseThisPattern(sod));
  }


} 
