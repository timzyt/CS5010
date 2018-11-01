package edu.neu.ccs.cs5010.simpleCalculator.Model;

import edu.neu.ccs.cs5010.simpleCalculator.Model.Addition;
import edu.neu.ccs.cs5010.simpleCalculator.Model.Context;
import edu.neu.ccs.cs5010.simpleCalculator.Model.Define;
import edu.neu.ccs.cs5010.simpleCalculator.Model.Subtraction;
import edu.neu.ccs.cs5010.simpleCalculator.Model.Num;
import edu.neu.ccs.cs5010.simpleCalculator.Model.Val;
import edu.neu.ccs.cs5010.simpleCalculator.Model.Var;

/**
 *
 */
public class Main {

  /**
   * @param args
   */
  public static void main(String[] args) {
    Val n1 = new Num(1);
    Val n2 = new Num(2);
    Val n3 = new Num(3);
    Context emptyCtx = Context.emptyCtx();

    System.out.println(n1.eval(emptyCtx)); // 1
    System.out.println(new Addition(n1, n2).eval(emptyCtx)); // 3
    System.out.println(new Subtraction(n3, new Addition(n1, n2)).eval(emptyCtx)); // 0

    System.out.println(emptyCtx.contains(new Var("x")));
    System.out.println(new Define(new Var("x"), new Num(23)).eval(emptyCtx));
    System.out.println(emptyCtx.contains(new Var("x")));
    System.out.println(new Var("x").eval(emptyCtx));
    System.out.println(new Addition(new Num(10), new Var("x")).eval(emptyCtx));
  }

}
