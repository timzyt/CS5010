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
//    System.out.println("visited Sub eval! leftExp now is " + this.left + ", rightExp now is " + this.right);
//    System.out.println("expression now is: " + this.asString());
    return new Num(this.left.eval(ctx).getVal() - this.right.eval(ctx).getVal());
  }

  @Override
  public String asString() {
    System.out.println("visited Sub asString! leftExp now is " + this.left + ", rightExp now is " + this.right);
    System.out.println("expression now is: " + this.toString());
    return this.addQuotes().replace("operand", "-");
  }

}
