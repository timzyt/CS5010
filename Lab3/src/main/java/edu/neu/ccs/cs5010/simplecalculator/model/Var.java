package edu.neu.ccs.cs5010.simplecalculator.model;

/**
 * class Var.
 */
public class Var extends Val {

  private String var;


  /**
   * Constructs and instantiates a varStr class.
   * @param varStr variable
   */
  public Var(String varStr) {
    this.var = varStr;
  }


  /**
   * {@inheritDoc}.
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = (prime * result) + ((this.var == null) ? 0 : this.var.hashCode());
    return result;
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Var other = (Var) obj;
    if (this.var == null) {
      if (other.var != null) {
        return false;
      }
    } else if (!this.var.equals(other.var)) {
      return false;
    }
    return true;
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public String toString() {
    return "Var [var=" + this.var + "]";
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public Val eval(Context ctx) {
    return ctx.get(this);
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public String asString() {
    return this.var.toString();
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public Integer evaluate() {
    return null;
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public Integer getVal() {
    throw new IllegalArgumentException("This is variable!");
  }
}
