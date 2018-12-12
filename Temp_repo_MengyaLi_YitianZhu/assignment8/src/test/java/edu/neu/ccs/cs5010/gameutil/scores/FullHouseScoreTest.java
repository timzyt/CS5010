package edu.neu.ccs.cs5010.gameutil.scores;

import static org.junit.Assert.assertTrue;

import edu.neu.ccs.cs5010.game.SetOfDice;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * FullHouseScore Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Dec 3, 2018</pre>
 */
public class FullHouseScoreTest {
  FullHouseScore fh = new FullHouseScore();
  SetOfDice sod = new SetOfDice();
  SetOfDice sod2 = new SetOfDice();
  int[] diceValues = {3, 3, 3, 6, 6};
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
  public void testFullHouse() throws Exception {
    res = fh.chooseThisPattern(sod);
    System.out.println(res);
    assertTrue(res == 25);
  }

  @Test
  public void testNoFullHouse() throws Exception {
    res = fh.chooseThisPattern(sod2);
    System.out.println(res);
    assertTrue(res == 0);
  }


} 
