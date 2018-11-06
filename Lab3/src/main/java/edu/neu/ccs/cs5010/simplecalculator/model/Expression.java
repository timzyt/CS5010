package edu.neu.ccs.cs5010.simplecalculator.model;

/**
 * Expression interface.
 */
public interface Expression {

  /**
   * Evaluate this expression and return the final value.
   *
   * @return result of evaluating this expression
   */
  Val eval(Context ctx);

  /**
   * Return the expression as a human readable string.
   *
   * @return human readable string for the expression.
   */
  String asString();

  /**
   * Return the answer of the expression's evaluation.
   *
   * @return the integer value of the answer.
   */
  Integer evaluate();
}
