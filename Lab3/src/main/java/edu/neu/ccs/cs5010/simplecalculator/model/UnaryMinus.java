package edu.neu.ccs.cs5010.simplecalculator.model;

/**
 * the Unary Minus class.
 */
public class UnaryMinus extends Op {

  protected Expression exp;

  /**
   * Construct and instantiate a unary minus operand.
   *
   * @param exp the only Integer argument.
   */
  public UnaryMinus(Expression exp) {
    this.exp = exp;
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public Val eval(Context ctx) {
    return new Num(-1 * this.exp.eval(ctx).getVal());
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public String asString() {
    ExpressionVisitor newVisitor = new ExpressionVisitorImpl();
    return newVisitor.visit(this);
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public Integer evaluate() {
    CtxHashMap newCtx = new CtxHashMap();
    Num newNum = new Num(-1 * this.exp.eval(newCtx).getVal());
    return newNum.getVal();
  }
}
