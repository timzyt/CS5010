package edu.neu.ccs.cs5010.simpleCalculator.Model;

/**
 * The Num class.
 */
public class Num extends Val {

  private Integer val;

  /**
   * Constructs and instantiates a new Num.
   *
   * @param num the only Integer argument.
   */
  Num(Integer num) {
    this.val = num;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Val eval(Context ctx) {
    return this;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = (prime * result) + ((this.val == null) ? 0 : this.val.hashCode());
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
    Num other = (Num) obj;
    if (this.val == null) {
      if (other.val != null) {
        return false;
      }
    } else if (!this.val.equals(other.val)) {
      return false;
    }
    return true;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String toString() {
    return "Num [val=" + this.val + "]";
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Integer getVal() {
    return this.val;
  }

}
