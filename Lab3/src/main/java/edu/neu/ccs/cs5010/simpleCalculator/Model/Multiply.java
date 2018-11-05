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
    System.out.println(
        "visited Multiply! leftExp now is " + this.left + ", rightExp now is " + this.right);
    System.out.println("expression now is: " + this.asString());
    return new Num(this.left.eval(ctx).getVal() * this.right.eval(ctx).getVal());
  }

  @Override
  public String asString() {
    return this.addQuotes().replace("operand", "*");
  }
}
