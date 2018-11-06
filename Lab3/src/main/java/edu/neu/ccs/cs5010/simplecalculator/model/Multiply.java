package edu.neu.ccs.cs5010.simplecalculator.model;

/**
 * The Multiplication class.
 */
public class Multiply extends BinOp {

  /**
   * Constructs and instantiates a new multiplication operand.
   *
   * @param left the left subexpression
   * @param right the right subexpression
   */
  public Multiply(Expression left, Expression right) {
    super(left, right);
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public Val eval(Context ctx) {
    return new Num(this.left.eval(ctx).getVal() * this.right.eval(ctx).getVal());
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
