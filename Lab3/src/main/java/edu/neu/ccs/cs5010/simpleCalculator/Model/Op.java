package edu.neu.ccs.cs5010.simpleCalculator.Model;

import java.util.Observable;

/**
 *
 */
abstract class Op extends Observable implements Expression {

  @Override
  public void accept(ExpressionVisitor visitor) {
    visitor.visit(this);
  }

  public Integer evaluate() {
    CtxHashMap newCtx = new CtxHashMap();
    Num newNum = new Num(this.eval(newCtx).getVal());
    return newNum.getVal();
  }

  public void setData(Expression exp) {
    setChanged();
    notifyObservers(exp);
  }
}
