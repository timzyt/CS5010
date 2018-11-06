package edu.neu.ccs.cs5010.simplecalculator.model;

/**
 * The Exponent class.
 */
public class Exponent extends BinOp {

  /**
   * Constructs and instantiates a new exponent operand.
   *
   * @param left the left subexpression
   * @param right the right subexpression
   */
  public Exponent(Expression left, Expression right) {
    super(left, right);
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public Val eval(Context ctx) {

    return new Num((int) Math.pow(this.left.eval(ctx).getVal(), this.right.eval(ctx).getVal()));
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public String asString() {
    ExpressionVisitor newVisitor = new ExpressionVisitorImpl();
    return newVisitor.visit(this);
  }
}
