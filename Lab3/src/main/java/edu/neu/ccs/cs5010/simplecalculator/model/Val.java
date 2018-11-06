package edu.neu.ccs.cs5010.simplecalculator.model;

/**
 * abstract class Val.
 */
abstract class Val implements Expression {

  /**
   * return the integer value of the variable.
   *
   * @return integer
   */
  abstract Integer getVal();

}
