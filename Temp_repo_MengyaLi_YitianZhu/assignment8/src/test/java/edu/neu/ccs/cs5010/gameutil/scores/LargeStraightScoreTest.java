package edu.neu.ccs.cs5010.gameutil.scores;

import static org.junit.Assert.assertTrue;

import edu.neu.ccs.cs5010.game.SetOfDice;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * LargeStraightScore Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Dec 3, 2018</pre>
 */
public class LargeStraightScoreTest {

  LargeStraightScore lss = new LargeStraightScore();
  SetOfDice sod = new SetOfDice();
  SetOfDice sod2 = new SetOfDice();
  SetOfDice sod3 = new SetOfDice();
  int[] diceValues = {1, 2, 3, 4, 5};
  int[] diceValues2 = {3, 3, 4, 4, 5};
  int[] diceValues3 = {1, 1, 2, 3, 4};
  int res;

  @Before
  public void before() throws Exception {
    sod.setSod(diceValues);
    sod2.setSod(diceValues2);
    sod3.setSod(diceValues3);
  }

  @After
  public void after() throws Exception {
  }

  /**
   * Method: chooseThisPattern(SetOfDice dSet)
   */
  @Test
  public void testLargeStraight() throws Exception {
    res = lss.chooseThisPattern(sod);
    System.out.println(res);
    assertTrue(res == 40);
  }

  @Test
  public void testNoLargeStraight() throws Exception {
    res = lss.chooseThisPattern(sod2);
    System.out.println(res);
    assertTrue(res == 0);
  }


  @Test
  public void testLargeNumbers() throws Exception {
    res = lss.chooseThisPattern(sod3);
    System.out.println(res);
    assertTrue(res == 0);
  }


} 
