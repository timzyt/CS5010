package edu.neu.ccs.cs5010.simpleCalculator;

/**
 * The Subtraction class.
 */
public class Diff extends BinOp {

  /**
   * Constructs and Instantiates a new Subtraction operand.
   *
   * @param left
   * @param right
   */
  public Diff(Expression left, Expression right) {
    super(left, right);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Val eval(Context ctx) {
    return new Num(this.left.eval(ctx).getVal() - this.right.eval(ctx).getVal());
  }

}
