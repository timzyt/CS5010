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

  public void setData(Expression exp) {
    setChanged();
  }
}
