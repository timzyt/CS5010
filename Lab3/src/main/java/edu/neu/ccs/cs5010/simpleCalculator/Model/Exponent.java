package edu.neu.ccs.cs5010.simpleCalculator.Model;

/**
 * The Exponent class.
 */
public class Exponent extends BinOp{

  /**
   * Constructs and instantiates a new exponent operand.
   *
   * @param left the left subexpression
   * @param right the right subexpression
   */
  public Exponent(Expression left, Expression right) {
    super(left, right);
  }

  @Override
  public Val eval(Context ctx) {

    return new Num((int) Math.pow(this.left.eval(ctx).getVal(), this.right.eval(ctx).getVal()));
  }

  @Override
  public String asString() {
    return this.addQuotes().replace(" operand ", "^");
  }
}
