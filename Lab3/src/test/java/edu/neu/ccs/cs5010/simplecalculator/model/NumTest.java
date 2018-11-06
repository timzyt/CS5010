package edu.neu.ccs.cs5010.simplecalculator.model;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class NumTest {
  private Integer val;
  private Num newNum = new Num(3);
  private Num anotherNum;
  private CtxHashMap newctx = new CtxHashMap();

  @Before
  public void setUp() throws Exception {
    anotherNum = new Num(val);
  }

  @Test
  public void testEval() {
    System.out.println(newNum.eval(newctx));
  }

  @Test
  public void testAsString() {
    assertTrue(newNum.asString().equals("3"));
  }

  @Test
  public void evaluate() {
    assertTrue(newNum.evaluate().equals(3));
  }

  @Test
  public void testValidHashCode() {
    assertTrue(newNum.hashCode() == new Num(3).hashCode());
  }

  @Test
  public void testInvalidHashCode() {
    assertTrue(anotherNum.hashCode() == 31);
  }

  @Test
  public void testEqualsSelf() {
    assertTrue(newNum.equals(newNum));
  }

  @Test
  public void testNullValNumAndNotNullNum() {
    assertFalse(anotherNum.equals(newNum));
  }


  @Test
  public void testEqualNull() {
    assertFalse(newNum.equals(null));
  }

  @Test
  public void testEqualsNewSelf() {
    assertTrue(newNum.equals(new Num(3)));
  }


  @Test
  public void testNotEqualsDifferentTypeOfObject() {
    assertFalse(newNum.equals(3));
  }


  @Test
  public void testNotEqualsDifferentSameTypeOfObject() {
    assertFalse(newNum.equals(new Num(7)));
  }

  @Test
  public void testToString() {
    assertTrue(newNum.toString().equals("Num [val=3]"));
  }

  @Test
  public void testGetVal() {
    assertTrue(newNum.getVal().equals(3));
  }
}
