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
    System.out.println("visited Add! leftExp now is " + this.left + ", rightExp now is " + this.right);
    System.out.println("expression now is: " + this.asString());
    return new Num(this.left.eval(ctx).getVal() + this.right.eval(ctx).getVal());
  }

  public String asString() {
    return this.addQuotes().replace("operand", "+");
  }
}
