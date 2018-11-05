package edu.neu.ccs.cs5010.simpleCalculator.Model;

import edu.neu.ccs.cs5010.simpleCalculator.Model.*;
import edu.neu.ccs.cs5010.simpleCalculator.Model.Expression;
import edu.neu.ccs.cs5010.simpleCalculator.Model.Subtraction;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

public class SubtractionTest {

  private CtxHashMap newctx = new CtxHashMap();
  Expression left = new Multiply(new Num(2), new Num(5));
  Expression right = new Subtraction(new Num(3), new Num(4));
  Addition newAdditiona = new Addition(left, right);

  @Before
  public void setUp() throws Exception {

  }

  @Test
  public void eval() {

    System.out.println(newAdditiona.eval(newctx));
  }

  @Test
  public void asString() {
    System.out.println(newAdditiona.asString());
  }

  @Test
  public void evaluate() {
    ExpressionVisitor visitor = new ExpressionVisitorImpl();
    newAdditiona.trace(visitor);
//    System.out.println(newAdditiona.asString());
  }
}


