package edu.neu.ccs.cs5010.simplecalculator.model;

/**
 * The Subtraction class.
 */
public class Subtraction extends BinOp {

  /**
   * Constructs and Instantiates a new Subtraction operand.
   *
   * @param left the left
   * @param right the right
   */
  public Subtraction(Expression left, Expression right) {
    super(left, right);
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public Val eval(Context ctx) {
    return new Num(this.left.eval(ctx).getVal() - this.right.eval(ctx).getVal());
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
