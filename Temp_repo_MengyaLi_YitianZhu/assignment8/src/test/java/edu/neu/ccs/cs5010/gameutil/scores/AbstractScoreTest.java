package edu.neu.ccs.cs5010.gameutil.scores;

import static edu.neu.ccs.cs5010.gameutil.scores.AbstractScore.ACES;
import static org.junit.Assert.assertTrue;

import edu.neu.ccs.cs5010.game.SetOfDice;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * AbstractScore Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Dec 3, 2018</pre>
 */
public class AbstractScoreTest {

  AbstractScore as;
  SetOfDice sod = new SetOfDice();

  int[] diceValues = {1, 2, 1, 1, 3};


  @Before
  public void before() throws Exception {
    as = new AcesScore();
    sod.setSod(diceValues);
  }

  @After
  public void after() throws Exception {
  }

  /**
   * Method: getPattern()
   */
  @Test
  public void testGetPattern() throws Exception {

    assertTrue(ACES.contentEquals(as.getPattern()));
  }

  /**
   * Method: getScore()
   */
  @Test
  public void testGetScore() throws Exception {
    as.chooseThisPattern(sod);
    assertTrue(3 == as.getScore());
  }

  /**
   * Method: chooseThisPattern(SetOfDice dSet)
   */
  @Test
  public void testChooseThisPattern() throws Exception {
    as.chooseThisPattern(sod);
    assertTrue(3 == as.getScore());
  }

  /**
   * Method: isChosen()
   */
  @Test
  public void testIsChosen() throws Exception {
    as.chooseThisPattern(sod);
    assertTrue(as.isIsChosen());
  }

  /**
   * Method: toString()
   */
  @Test
  public void testToString() throws Exception {
    as.chooseThisPattern(sod);
    System.out.println(as.toString());
  }

  @Test
  public void testToStringBeforeChosen() throws Exception {
    System.out.println(as.toString());
  }

} 
