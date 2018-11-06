package edu.neu.ccs.cs5010.simplecalculator.model;

/**
 * Context class.
 */
public interface Context {

  /**
   * Constructs and instantiates a new Context class.
   */
  static Context emptyCtx() {
    return new CtxHashMap();
  }

  /**
   * Check if the context hashmap contains provided variable.
   *
   * @param variable provided variable
   * @return boolean
   */
  boolean contains(Var variable);

  /**
   * Add a new variable into the context hashmap.
   *
   * @param variable provided variable
   */
  void add(Var variable, Val value);

  /**
   * Retrieve the variable from the context hashmap.
   */
  Val get(Var variable);
}
