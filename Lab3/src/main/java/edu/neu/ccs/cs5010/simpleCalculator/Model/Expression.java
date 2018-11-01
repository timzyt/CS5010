package edu.neu.ccs.cs5010.simpleCalculator.Model;

/**
 *
 */
public interface Expression {

  /**
   * Evaluate this expression and return the final value
   *
   * @return result of evaluating this expression
   */
  Val eval(Context ctx);

  /**
   * Return the expression as a human readable string.
   * @param ctx
   * @return human readable string for the expression.
   */
  String asString(Context ctx);

}
