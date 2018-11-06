package edu.neu.ccs.cs5010.simplecalculator.model;

import java.util.HashMap;
import java.util.Map;

/**
 * CtxHashMap class.
 */
public class CtxHashMap implements Context {

  private Map<Var, Val> ctx;

  public CtxHashMap() {
    this.ctx = new HashMap<Var, Val>();
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public boolean contains(Var variable) {
    return this.ctx.containsKey(variable);
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public void add(Var variable, Val value) {
    this.ctx.put(variable, value);
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public Val get(Var variable) {
    return this.ctx.get(variable);
  }

}
