package edu.neu.ccs.cs5010.simpleCalculator.Model;

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

  @Override
  public Val eval(Context ctx) {
//    Integer leftEval = this.left.eval(ctx).getVal();
//    Integer rightEval = this.right.eval(ctx).getVal();
//    Integer absLeftEval = Math.abs(leftEval);
//    Integer absRightEval = Math.abs(rightEval);
//    Integer product = zero;
//
//    if (leftEval == zero || rightEval == zero) {
//      return new Num(product);
//    }
//    boolean isNegative = false;
//    if ((leftEval < zero && rightEval > zero) || (leftEval > zero && rightEval < zero)) {
//      isNegative = true;
//    }
//    if (isNegative) {
//      return new Num(new UnaryMinus(
//          new Multiply(new Num(absLeftEval), new Num(absRightEval))).eval(ctx).getVal());
//    }
//    while (absRightEval != zero) {
//      product = new Add(new Num(absLeftEval), new Num(absLeftEval)).eval(ctx).getVal();
//      absRightEval -= 1;
//    }
    return new Num(this.left.eval(ctx).getVal() - this.right.eval(ctx).getVal());
  }
}
