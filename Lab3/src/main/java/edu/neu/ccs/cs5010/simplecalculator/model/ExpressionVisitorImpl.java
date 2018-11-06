package edu.neu.ccs.cs5010.simplecalculator.model;

/**
 * Implementation of the ExpressionVisitor interface.
 */
public class ExpressionVisitorImpl implements ExpressionVisitor {

  /**
   * {@inheritDoc}.
   */
  @Override
  public String visit(Num num) {
    if (num.getVal() < 0) {
      return "(" + num.getVal() + ")";
    }
    return num.getVal().toString();
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public String visit(UnaryMinus unaryMinus) {
    StringBuilder strBdr = new StringBuilder();
    strBdr.append("(").append("-").append(unaryMinus.exp.asString()).append(")");
    return strBdr.toString();
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public String visit(Addition add) {
    StringBuilder strBdr = new StringBuilder();
    Expression leftExp = add.left;
    Expression riteExp = add.right;
    strBdr.append("(").append(leftExp.asString()).append(" + ").append(riteExp.asString())
        .append(")");
    return strBdr.toString();
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public String visit(Subtraction sub) {
    StringBuilder strBdr = new StringBuilder();
    Expression leftExp = sub.left;
    Expression riteExp = sub.right;
    strBdr.append("(").append(leftExp.asString()).append(" - ").append(riteExp.asString())
        .append(")");
    return strBdr.toString();
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public String visit(Multiply multiply) {
    StringBuilder strBdr = new StringBuilder();
    Expression leftExp = multiply.left;
    Expression riteExp = multiply.right;
    strBdr.append("(").append(leftExp.asString()).append(" * ").append(riteExp.asString())
        .append(")");
    return strBdr.toString();
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public String visit(Division division) {
    StringBuilder strBdr = new StringBuilder();
    Expression leftExp = division.left;
    Expression riteExp = division.right;
    strBdr.append("(").append(leftExp.asString()).append(" / ").append(riteExp.asString())
        .append(")");
    return strBdr.toString();
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public String visit(Exponent exponent) {
    StringBuilder strBdr = new StringBuilder();
    Expression leftExp = exponent.left;
    Expression riteExp = exponent.right;
    strBdr.append("(").append(leftExp.asString()).append("^").append(riteExp.asString())
        .append(")");
    return strBdr.toString();
  }
}
