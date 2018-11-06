package edu.neu.ccs.cs5010.simplecalculator.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class VarTest {

  private Var var;
  private Var anotherVar;
  private Var randomVar;
  private Var nullVar;
  private String varString;
  private String anotherVarString;
  private String randomVarString;
  private String nullStr;
  private Integer oneInt;
  private Context newCtx;

  @Before
  public void setUp() throws Exception {
    varString = "newVariable";
    anotherVarString = "newVariable";
    randomVarString = "what";
    var = new Var(varString);
    anotherVar = new Var(anotherVarString);
    randomVar = new Var(randomVarString);
    nullVar = new Var(nullStr);
    oneInt = 7;
    newCtx = new CtxHashMap();
  }

  @Test
  public void testHashCode() {
    assertTrue(var.hashCode() == anotherVar.hashCode());
  }

  @Test
  public void testDifferentClassHashCode() {
    assertFalse(var.hashCode() == varString.hashCode());
  }

  @Test
  public void testNullHashCode() {
    assertTrue(nullVar.hashCode() == 31);
  }

  @Test
  public void testEqualsSelf() {
    assertTrue(var.equals(var));
  }

  @Test
  public void testEqualsNull() {
    assertFalse(var.equals(null));
  }

  @Test
  public void testNullVarAndNotNullVar() {
    assertFalse(nullVar.equals(var));
  }

  @Test
  public void testEqualsNewSelf() {
    assertTrue(var.equals(anotherVar));
  }

  @Test
  public void testNotEqualDifferentTypeOfObject() {
    assertFalse(varString.equals(oneInt));
  }

  @Test
  public void testNotEqualSameTypeOfObject() {
    assertFalse(var.equals(randomVar));
  }

  @Test
  public void testToString() {
    System.out.println(var.toString());

  }

  @Test
  public void testEval() {
    assertNull(var.eval(newCtx));
  }

  @Test
  public void testAsString() {
    assertTrue(var.asString().equals(varString));
  }

  @Test
  public void testEvaluate() {
    assertNull(var.evaluate());
  }

  @Test (expected = IllegalArgumentException.class)
  public void testGetVal() {
    var.getVal();
  }
}