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
}
