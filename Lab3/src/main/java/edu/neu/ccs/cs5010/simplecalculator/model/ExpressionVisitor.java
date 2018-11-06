package edu.neu.ccs.cs5010.simplecalculator.model;

/**
 * ExpressionVisitor interface.
 */
interface ExpressionVisitor {

  /**
   * visit UnaryMinus class.
   *
   * @param unaryMinus expression
   * @return string
   */
  String visit(UnaryMinus unaryMinus);

  /**
   * visit Num class.
   *
   * @param num expression
   * @return string
   */
  String visit(Num num);

  /**
   * visit Addition class.
   *
   * @param add expression
   * @return string
   */
  String visit(Addition add);

  /**
   * visit Subtraction class.
   *
   * @param sub expression
   * @return string
   */
  String visit(Subtraction sub);

  /**
   * visit Multiply class.
   *
   * @param multiply expression
   * @return string
   */
  String visit(Multiply multiply);

  /**
   * visit Division class.
   *
   * @param division expression
   * @return string
   */
  String visit(Division division);

  /**
   * visit Exponent class.
   *
   * @param exponent expression
   * @return string
   */
  String visit(Exponent exponent);
}
