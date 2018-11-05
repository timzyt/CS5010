package edu.neu.ccs.cs5010.simpleCalculator.Model;


import java.util.LinkedList;
import java.util.Queue;


public class ExpressionVisitorImpl implements ExpressionVisitor  {
  Queue<Expression> queue = new LinkedList<>();
  @Override
  public void visit(Op op) {
    queue.offer(op);
    while (!queue.isEmpty()) {
      Expression exp = queue.poll();
      System.out.println(exp.asString());
      System.out.println(exp.evaluate());
    }
  }

  @Override
  public void visit(Val val) {

  }
}
