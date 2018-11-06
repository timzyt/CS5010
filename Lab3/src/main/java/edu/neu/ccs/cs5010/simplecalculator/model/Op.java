package edu.neu.ccs.cs5010.simplecalculator.model;

import java.util.Observable;

/**
 * abstract class Op.
 */
abstract class Op extends Observable implements Expression {

  /**
   * {@inheritDoc}.
   */
  public Integer evaluate() {
    CtxHashMap newCtx = new CtxHashMap();
    Num newNum = new Num(this.eval(newCtx).getVal());
    return newNum.getVal();
  }

  /**
   * notify the Observer and print out to the console a trace of the evaluation.
   */
  public void setData(Expression exp) {
    setChanged();
    notifyObservers(exp);
  }

  /**
   * Return the next step evaluation of the given expression.
   *
   * @return expression.
   */
  public Expression next() {
    return new Num(this.evaluate());
  }

  /**
   * {@inheritDoc}.
   */
  public void trace() {
    Expression exp = this;
    while (exp instanceof Op) {
      this.setData(exp);
      exp = ((Op) exp).next();
    }
  }

}
