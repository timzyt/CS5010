package edu.neu.ccs.cs5010.game;

import static org.junit.Assert.*;

import edu.neu.ccs.cs5010.exceptions.IllegalValueException;
import org.junit.Before;
import org.junit.Test;

public class DiceTest {

  private Dice die;
  private int six = 6;
  private int seven = 7;

  @Before
  public void testSetUp() throws Exception {
    die = new Dice();
  }

  @Test
  public void testGetValue() {
    die.setValue(six);
    assertTrue(six == die.getValue());
  }

  @Test
  public void testSetValue() {
    die.setValue(six);
    assertTrue(six == die.getValue());
  }

  @Test (expected = IllegalValueException.class)
  public void testSetValueException() {
    die.setValue(seven);
//    assertTrue(six == die.getValue());
  }

  @Test
  public void testRoll() {
    die.roll();
    System.out.println(die.toString());
  }

  @Test
  public void testToString() {
    String output = "Current dice is rolled to to value 0";
    assertTrue(output.contentEquals(die.toString()));
  }
}