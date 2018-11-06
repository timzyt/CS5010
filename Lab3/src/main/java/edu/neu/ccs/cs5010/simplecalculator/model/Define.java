package edu.neu.ccs.cs5010.simplecalculator.model;

/**
 * Define class.
 */
public class Define implements Expression {

  private Var lval;
  private Expression rval;


  /**
   * Constructs and instantiates a define class.
   * @param lval variable name.
   * @param rval variable expression.
   */
  public Define(Var lval, Expression rval) {
    this.lval = lval;
    this.rval = rval;
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public Val eval(Context ctx) {
    ctx.add(this.lval, this.rval.eval(ctx));
    return new Num(42);
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public String asString() {
    return null;
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public Integer evaluate() {
    return null;
  }
}
