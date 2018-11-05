package edu.neu.ccs.cs5010.simpleCalculator.Model;

/**
 * the Unary Minus class.
 */
public class UnaryMinus extends Op {

  private Expression exp;

  /**
   * Construct and instantiate a unary minus operand.
   *
   * @param exp the only Integer argument.
   */
  public UnaryMinus(Expression exp) {
    this.exp = exp;
  }

  @Override
  public Val eval(Context ctx) {
    return new Num(-1 * this.exp.eval(ctx).getVal());
  }

  @Override
  public String asString() {
    StringBuilder strBdr = new StringBuilder();
    strBdr.append("-").append(this.exp.asString());
    return strBdr.toString();
  }

  @Override
  public Integer evaluate() {
    CtxHashMap newCtx = new CtxHashMap();
    Num newNum = new Num(-1 * this.exp.eval(newCtx).getVal());
    return newNum.getVal();
  }
}
