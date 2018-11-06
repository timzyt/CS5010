package edu.neu.ccs.cs5010.simplecalculator.model;

/**
 * Main class.
 */
public class Main {

  /**
   * @param args main method argument.
   */
  public static void main(String[] args) {
    Val num1 = new Num(1);
    Val num2 = new Num(2);
    Val num3 = new Num(3);
    Context emptyCtx = Context.emptyCtx();

    System.out.println(num1.eval(emptyCtx)); // 1
    System.out.println(new Addition(num1, num2).eval(emptyCtx)); // 3
    System.out.println(new Subtraction(num3, new Addition(num1, num2)).eval(emptyCtx)); // 0

    System.out.println(emptyCtx.contains(new Var("x")));
    System.out.println(new Define(new Var("x"), new Num(23)).eval(emptyCtx));
    System.out.println(emptyCtx.contains(new Var("x")));
    System.out.println(new Var("x").eval(emptyCtx));
    System.out.println(new Addition(new Num(10), new Var("x")).eval(emptyCtx));
  }

}
