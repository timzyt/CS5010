package edu.neu.ccs.cs5010.simpleCalculator.Model;

/**
 *
 */
public class Var extends Val {

  private String var;


  /**
   * @param var
   */
  public Var(String var) {
    this.var = var;
  }


  /**
   * {@inheritDoc}
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = (prime * result) + ((this.var == null) ? 0 : this.var.hashCode());
    return result;
  }

  /**
   * {@inheritDoc}
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
   * {@inheritDoc}
   */
  @Override
  public String toString() {
    return "Var [var=" + this.var + "]";
  }

  @Override
  public Val eval(Context ctx) {
    return ctx.get(this);
  }

  @Override
  public String asString() {
    return this.var.toString();
  }

  @Override
  public Integer getVal() {
    throw new IllegalArgumentException("This is variable!");
  }
}
