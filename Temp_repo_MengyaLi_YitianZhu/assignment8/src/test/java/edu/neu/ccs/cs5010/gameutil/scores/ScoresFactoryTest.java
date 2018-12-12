package edu.neu.ccs.cs5010.gameutil.scores;

import static edu.neu.ccs.cs5010.gameutil.scores.AbstractScore.ACES;
import static edu.neu.ccs.cs5010.gameutil.scores.AbstractScore.CHANCE;
import static edu.neu.ccs.cs5010.gameutil.scores.AbstractScore.FIVES;
import static edu.neu.ccs.cs5010.gameutil.scores.AbstractScore.FOURS;
import static edu.neu.ccs.cs5010.gameutil.scores.AbstractScore.FOUR_OF_KIND;
import static edu.neu.ccs.cs5010.gameutil.scores.AbstractScore.FULL_HOUSE;
import static edu.neu.ccs.cs5010.gameutil.scores.AbstractScore.LARGE_STRAIGHT;
import static edu.neu.ccs.cs5010.gameutil.scores.AbstractScore.SIXES;
import static edu.neu.ccs.cs5010.gameutil.scores.AbstractScore.SMALL_STRAIGHT;
import static edu.neu.ccs.cs5010.gameutil.scores.AbstractScore.THREES;
import static edu.neu.ccs.cs5010.gameutil.scores.AbstractScore.THREE_OF_KIND;
import static edu.neu.ccs.cs5010.gameutil.scores.AbstractScore.TWOS;
import static edu.neu.ccs.cs5010.gameutil.scores.AbstractScore.YAHTZEE;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * ScoresFactory Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Dec 3, 2018</pre>
 */
public class ScoresFactoryTest {
  ScoresFactory sf;

  @Before
  public void before() throws Exception {
    sf = new ScoresFactory();
  }

  @After
  public void after() throws Exception {
  }

  /**
   * Method: makeScore(String pattern)
   */
  @Test
  public void testMakeScore() throws Exception {
    assertTrue( sf.makeScore(ACES) instanceof  AcesScore);
    assertTrue( sf.makeScore(TWOS) instanceof  TwosScore);
    assertTrue( sf.makeScore(THREES) instanceof  ThreesScore);
    assertTrue( sf.makeScore(FOURS) instanceof  FoursScore);
    assertTrue( sf.makeScore(FIVES) instanceof  FivesScore);
    assertTrue( sf.makeScore(SIXES) instanceof  SixesScore);
    assertTrue( sf.makeScore(THREE_OF_KIND) instanceof  ThreeOfKindScore);
    assertTrue( sf.makeScore(FOUR_OF_KIND) instanceof  FourOfKindScore);
    assertTrue( sf.makeScore(FULL_HOUSE) instanceof  FullHouseScore);
    assertTrue( sf.makeScore(SMALL_STRAIGHT) instanceof  SmallStraightScore);
    assertTrue( sf.makeScore(LARGE_STRAIGHT) instanceof  LargeStraightScore);
    assertTrue( sf.makeScore(YAHTZEE) instanceof  YahtzeeScore);
    assertTrue( sf.makeScore(CHANCE) instanceof  ChanceScore);
    assertTrue( sf.makeScore("123") == null);
  }


} 
