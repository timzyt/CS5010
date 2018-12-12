package edu.neu.ccs.cs5010.gameutil.scores;

import static org.junit.Assert.*;

import edu.neu.ccs.cs5010.game.SetOfDice;
import org.junit.Before;
import org.junit.Test;

public class SmallStraightScoreTest {

  SmallStraightScore sss = new SmallStraightScore();
  SetOfDice sod = new SetOfDice();
  SetOfDice sod2 = new SetOfDice();
  SetOfDice sod3 = new SetOfDice();
  int[] diceValues = {4, 3, 2, 4, 1};
  int[] diceValues2 = {1, 1, 2, 4, 1};
  int[] diceValues3 = {4, 4, 4, 4, 4};
  int res;

  @Before
  public void setUp() throws Exception {
    sod.setSod(diceValues);
    sod2.setSod(diceValues2);
    sod3.setSod(diceValues3);
  }

  @Test
  public void testHasSmallStraight() throws Exception {
    res = sss.chooseThisPattern(sod);
    System.out.println(res);
    assertTrue(res == 30);
  }

  @Test
  public void testNoSmallStraight() throws Exception {
    res = sss.chooseThisPattern(sod2);
    System.out.println(res);
    assertTrue(res == 0);
  }

  @Test
  public void testLargeNumberSet() throws Exception {
    res = sss.chooseThisPattern(sod3);
    System.out.println(res);
    assertTrue(res == 0);
  }
}