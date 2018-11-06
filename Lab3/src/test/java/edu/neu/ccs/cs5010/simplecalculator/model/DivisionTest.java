package edu.neu.ccs.cs5010.simplecalculator.model;

import edu.neu.ccs.cs5010.simplecalculator.exceptions.InvalidDenominatorException;
import org.junit.Before;
import org.junit.Test;

public class DivisionTest {
  private Num left;
  private Num zero;
  private Division newDiv;
  private CtxHashMap newCtx;

  @Before
  public void setUp() throws Exception {
    left = new Num(2);
    zero = new Num(0);
    newDiv = new Division(left, zero);
    newCtx = new CtxHashMap();
  }

  @Test (expected = InvalidDenominatorException.class)
  public void testEval() {
    newDiv.eval(newCtx);
  }
}