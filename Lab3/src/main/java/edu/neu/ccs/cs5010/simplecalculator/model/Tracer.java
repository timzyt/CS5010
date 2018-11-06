package edu.neu.ccs.cs5010.simplecalculator.model;

import java.util.Observable;
import java.util.Observer;

/**
 * Constructs and instantiates a tracer class.
 */
public class Tracer implements Observer {

  Integer counter = 1;

  /**
   * Print to the console of the step by step evaluation of the expression.
   */
  @Override
  public void update(Observable obj, Object arg) {
    if (arg instanceof Expression) {
      System.out.printf("%-3s%s%n", counter + ".", ((Expression) arg).asString());
      System.out.printf("%-3s%s%n", "", ((Op) arg).next().asString());
      counter++;
    }

  }

}
