package edu.neu.ccs.cs5010.simplecalculator.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BinOpTest {
  private Addition newAdd;
  private Integer nullInt;
  private Num leftNull;
  private Num rightNull;
  private Num leftNum;
  private Num rightNum;
  private Num anotherRightNum;
  private Addition leftNullAdd;
  private Addition rightNullAdd;
  private Addition anotherAdd;

  @Before
  public void setUp() throws Exception {
    newAdd = new Addition(new Num(3), new Num(4));
    leftNum = new Num(3);
    rightNum = new Num(4);
    anotherRightNum = new Num(5);
    leftNullAdd = new Addition(leftNull, rightNum);
    rightNullAdd = new Addition(leftNum, rightNull);
    anotherAdd = new Addition(leftNum, anotherRightNum);
  }

  @Test
  public void next() {
    Num next = new Num(7);
    assertTrue(next.equals(newAdd.next()));
  }

  @Test
  public void testHashCode() {
    Num left = new Num(3);
    Num right = new Num(4);
    assertTrue(newAdd.hashCode() == (new Addition(left, right)).hashCode());
  }

  @Test
  public void testLeftNullHashCode() {
    System.out.println(leftNullAdd.hashCode());
  }

  @Test
  public void testRightNullHashCode() {
    System.out.println(rightNullAdd.hashCode());
  }

  @Test
  public void testEqualsNull() {
    assertFalse(newAdd.equals(null));
  }

  @Test
  public void testNotNullEqualsLeftNull() {
    assertFalse(newAdd.equals(leftNullAdd));
  }

  @Test
  public void testLeftNullEqualsNotNull() {
    assertFalse(leftNullAdd.equals(newAdd));
  }

  @Test
  public void testNotNullEqualsRightNull() {
    assertFalse(newAdd.equals(rightNullAdd));
  }

  @Test
  public void testRightNullEqualsNotNull() {
    assertFalse(rightNullAdd.equals(newAdd));
  }

  @Test
  public void testNotNullEqualsDifferentRight() {
    assertFalse(newAdd.equals(anotherAdd));
  }

  @Test
  public void testEqualsSelf() {
    Num left = new Num(3);
    Num right = new Num(4);
    Num lefty = new Num(5);
    assertTrue(newAdd.equals(newAdd));
  }


  @Test
  public void testEqualsSameNewObject() {
    Num left = new Num(3);
    Num right = new Num(4);
    assertTrue(newAdd.equals(new Addition(left, right)));
  }

  @Test
  public void testNotEqualsDifferentTypeOfObject() {
    Num left = new Num(3);
    assertFalse(newAdd.equals(left));
  }

  @Test
  public void testNotEqualsDifferentSameTypeOfObject() {
    Num right = new Num(4);
    Num lefty = new Num(5);
    assertFalse(newAdd.equals(new Addition(lefty, right)));
  }

  @Test
  public void testToString() {
    System.out.println(newAdd.toString());
  }
}