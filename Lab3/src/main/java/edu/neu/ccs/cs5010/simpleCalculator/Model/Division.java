package edu.neu.ccs.cs5010.simpleCalculator.Model;

import edu.neu.ccs.cs5010.simpleCalculator.Exceptions.InvalidDenominatorException;

/**
 * The Multiplication class.
 */
public class Division extends BinOp {

  /**
   * Constructs and instantiates a new division operand.
   *
   * @param left the left subexpression
   * @param right the right subexpression
   */
  public Division(Expression left, Expression right) {
    super(left, right);
  }

  @Override
  public Val eval(Context ctx) {
    Integer leftEval = this.left.eval(ctx).getVal();
    Integer rightEval = this.right.eval(ctx).getVal();
    if (rightEval == 0) {
      throw new InvalidDenominatorException();
    }

    return new Num(leftEval / rightEval);
  }

  @Override
  public String asString() {
    return this.addQuotes().replace("operand", "/");
  }
}
