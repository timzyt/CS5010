package edu.neu.ccs.cs5010.lab1;

/**
 * This class represents a 2D point. This point is denoted in Cartesian coordinates as (x,y).
 */
public class Point2D {

  private double xcord;
  private double ycord;

  /**
   * Construct a 2d point with the given coordinates.
   *
   * @param xcord the x-coordinate of this point
   * @param ycord the y-coordinate of this point
   */
  public Point2D(double xcord, double ycord) {
    this.xcord = xcord;
    this.ycord = ycord;
  }

  /**
   * Compute and return the Euclidean distance of this point to the origin.
   *
   * @return the euclidean distance
   */

  public double distToOrigin() {
    return Math.sqrt(xcord * xcord + ycord * ycord);
  }

  /**
   * Return the x-coordinate of this point.
   *
   * @return x-coordinate of this point
   */
  public double getX() {
    return xcord;
  }

  /**
   * Return the y-coordinate of this point.
   *
   * @return y-coordinate of this point
   */
  public double getY() {
    return ycord;
  }
}