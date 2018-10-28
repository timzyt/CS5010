package edu.neu.ccs.cs5010.simpleCalculator;

/**
 * The Addition operand.
 */
public class Add extends BinOp {

  /**
   * Constructs and Instantiates a new Addition operand.
   *
   * @param left the left
   * @param right the right
   */
  public Add(Expression left, Expression right) {
    super(left, right);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Val eval(Context ctx) {

    return new Num(this.left.eval(ctx).getVal() + this.right.eval(ctx).getVal());
  }

}
