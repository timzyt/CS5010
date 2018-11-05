package edu.neu.ccs.cs5010.simpleCalculator.Model;


import org.junit.Before;
import org.junit.Test;



public class NumTest {

  Num newNum = new Num(3);
  private CtxHashMap newctx = new CtxHashMap();

  @Before
  public void setUp() throws Exception {

  }

  @Test
  public void eval() {
    System.out.println(newNum.eval(newctx));
  }

  @Test
  public void asString() {

  }
}
