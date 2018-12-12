package edu.neu.ccs.cs5010.game;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * SetOfDice Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Dec 2, 2018</pre>
 */
public class SetOfDiceTest {

  SetOfDice sd;
  String validSelectionStr = "1, 4";
  int[] validSelection = {1, 4};
  String invalidSelectionStr = "1, 7";
  int[] invalidSelection = {1, 7};
  int[] diceValues = {1, 2, 1, 1, 3};

  @Before
  public void before() throws Exception {
    sd = new SetOfDice();
  }

  @After
  public void after() throws Exception {
  }

  /**
   * Method: getDiceSet()
   */
  @Test
  public void testGetDiceSet() throws Exception {
    sd.rollAllDice();
    sd.getDiceSet();
  }

  /**
   * Method: rollAllDice()
   */
  @Test
  public void testRollAllDice() throws Exception {
    sd.rollAllDice();
  }

  /**
   * Method: rollSelectedDice(int[] diceSelection)
   */
  @Test
  public void testRollSelectedDice() throws Exception {
    sd.rollAllDice();
    int[] res1 = sd.getDiceValues();
    sd.rollSelectedDice(validSelection);
    int[] res2 = sd.getDiceValues();
    assertTrue(res1 != res2);
  }

  /**
   * Method: contains(final int[] arr, final int key)
   */
  @Test
  public void testContains() throws Exception {
    sd.setSod(diceValues);
    assertTrue(sd.contains(validSelection, 4));
  }

  /**
   * Method: getCountOfValue(int val)
   */
  @Test
  public void testGetCountOfValue() throws Exception {
    sd.setSod(diceValues);
    assertTrue(3 == sd.getCountOfValue(1));
  }

  /**
   * Method: getTotalValue()
   */
  @Test
  public void testGetTotalValue() throws Exception {
    sd.setSod(diceValues);
    assertTrue(8 == sd.getTotalValue());
  }

  /**
   * Method: getDiceValues()
   */
  @Test
  public void testGetDiceValues() throws Exception {
    sd.rollAllDice();
    sd.getDiceValues();
  }

  /**
   * Method: checkValidSelection(int[] s)
   */
  @Test
  public void testCheckValidSelection() throws Exception {
    assertFalse(sd.checkValidSelection(validSelectionStr));
  }

  @Test
  public void testCheckInvalidSelection() throws Exception {
    assertFalse(sd.checkValidSelection(invalidSelectionStr));
  }

  /**
   * Method: toString()
   */
  @Test
  public void testToString() throws Exception {
    sd.setSod(diceValues);
    sd.toString();
  }


} 
