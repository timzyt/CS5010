package edu.neu.ccs.cs5010.simplecalculator.model;

import org.junit.Before;
import org.junit.Test;

public class SubtractionTest {

  private CtxHashMap newctx = new CtxHashMap();
  Expression leftLeft = new Multiply(new Num(2), new Num(5));
  Expression left = new UnaryMinus(leftLeft);
  Expression rightLeft = new Exponent(new Num(4), new Num(2));
  Expression rightRight = new Division(new Num(10), new Num(5));
  Expression right = new Addition(rightLeft, rightRight);
  Subtraction newExpression = new Subtraction(left, right);

  @Before
  public void setUp() throws Exception {

  }

  @Test
  public void eval() {

    System.out.println(newExpression.eval(newctx));
  }

  @Test
  public void asString() {
    System.out.println(newExpression.asString());
  }

  @Test
  public void evaluate() {
    Tracer tracer = new Tracer();
    newExpression.addObserver(tracer);
    newExpression.trace();
  }
}


