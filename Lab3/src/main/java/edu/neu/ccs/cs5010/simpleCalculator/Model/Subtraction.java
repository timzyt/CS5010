package edu.neu.ccs.cs5010.simpleCalculator.Model;

/**
 * The Subtraction class.
 */
public class Subtraction extends BinOp {

  /**
   * Constructs and Instantiates a new Subtraction operand.
   *
   * @param left
   * @param right
   */
  public Subtraction(Expression left, Expression right) {
    super(left, right);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Val eval(Context ctx) {
    return new Num(this.left.eval(ctx).getVal() - this.right.eval(ctx).getVal());
  }

  @Override
  public String asString(Context ctx) {
    return this.asString(ctx).replace("operand", "-");
  }

}
