package edu.neu.ccs.cs5010.simpleCalculator;

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
    System.out.println(new Add(n1, n2).eval(emptyCtx)); // 3
    System.out.println(new Diff(n3, new Add(n1, n2)).eval(emptyCtx)); // 0

    System.out.println(emptyCtx.contains(new Var("x")));
    System.out.println(new Define(new Var("x"), new Num(23)).eval(emptyCtx));
    System.out.println(emptyCtx.contains(new Var("x")));
    System.out.println(new Var("x").eval(emptyCtx));
    System.out.println(new Add(new Num(10), new Var("x")).eval(emptyCtx));
  }

}
