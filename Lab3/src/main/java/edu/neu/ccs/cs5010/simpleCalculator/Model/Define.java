package edu.neu.ccs.cs5010.simpleCalculator.Model;

/**
 *
 */
public class Define implements Expression {
  private Var lval;
  private Expression rval;



  /**
   * @param lval
   * @param rval
   */
  public Define(Var lval, Expression rval) {
    this.lval = lval;
    this.rval = rval;
  }



  /**
   * {@inheritDoc}
   */
  @Override
  public Val eval(Context ctx) {
    ctx.add(this.lval, this.rval.eval(ctx));
    return new Num(42);
  }

  @Override
  public String asString() {
    return null;
  }

  @Override
  public Integer evaluate() {
    return null;
  }

  @Override
  public void accept(ExpressionVisitor visitor) {

  }

}
