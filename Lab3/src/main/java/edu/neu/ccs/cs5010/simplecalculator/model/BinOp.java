package edu.neu.ccs.cs5010.simplecalculator.model;

/**
 * abstract class BinOp.
 */
abstract class BinOp extends Op {

  protected Expression left;
  protected Expression right;

  /**
   * Constructs and instantiates a binary expression.
   *
   * @param left the left subexpression
   * @param right the right subexpression
   */
  public BinOp(Expression left, Expression right) {
    this.left = left;
    this.right = right;
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public Expression next() {
    if (this.left instanceof Num && this.right instanceof Num) {
      return new Num(this.evaluate());
    } else {
      if (!(this.left instanceof Num)) {
        this.left = new Num(this.left.evaluate());
      } else {
        this.right = new Num(this.right.evaluate());
      }
      return this;
    }
  }

  /**
   * {@inheritDoc}.
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = (prime * result) + ((this.left == null) ? 0 : this.left.hashCode());
    result = (prime * result) + ((this.right == null) ? 0 : this.right.hashCode());
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
    BinOp other = (BinOp) obj;
    if (this.left == null) {
      if (other.left != null) {
        return false;
      }
    } else if (!this.left.equals(other.left)) {
      return false;
    }
    if (this.right == null) {
      if (other.right != null) {
        return false;
      }
    } else if (!this.right.equals(other.right)) {
      return false;
    }
    return true;
  }


  /**
   * {@inheritDoc}.
   */
  @Override
  public String toString() {
    return "BinOp [left=" + this.left + ", right=" + this.right + "]";
  }


}
