package edu.neu.ccs.cs5010.simpleCalculator.Model;

/**
 * The Addition operand.
 */
public class Addition extends BinOp {

  /**
   * Constructs and Instantiates a new Addition operand.
   *
   * @param left the left
   * @param right the right
   */
  public Addition(Expression left, Expression right) {
    super(left, right);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Val eval(Context ctx) {

    return new Num(this.left.eval(ctx).getVal() + this.right.eval(ctx).getVal());
  }

  public String asString(Context ctx) {
    return this.asString(ctx).replace("operand", "+");
  }
}
