package edu.neu.ccs.cs5010.lab1;

import java.util.Objects;

/**
 * This class represents a rectangle.  It defines all the operations mandated by the Shape
 * interface
 */
public class Rectangle extends AbstractShape {

  private double width;
  private double height;

  /**
   * Constructs a rectangle object with the given location of its lower-left corner and dimensions.
   *
   * @param xcord x coordinate of the lower-left corner of this rectangle
   * @param ycord y coordinate of the lower-left corner of this rectangle
   * @param width width of this rectangle
   * @param height height of this rectangle
   */
  public Rectangle(double xcord, double ycord, double width, double height) {
    super(new Point2D(xcord, ycord));
    this.width = width;
    this.height = height;
  }

  @Override
  public double area() {
    return this.width * this.height;
  }

  @Override
  public double perimeter() {
    return 2 * (this.width + this.height);
  }

  @Override
  public Shape resize(double factor) {
    double sqrtFactor = Math.sqrt(factor);
    return new Rectangle(
        this.reference.getX(),
        this.reference.getY(), sqrtFactor * this.width,
        sqrtFactor * this.height);
  }

  /**
   * Return String description of the rectangle's coordinates and its width and length.
   *
   * @return String description of the rectangle's coordinates and its width and length.
   */
  @Override
  public String toString() {
    return String.format("Rectangle: LL corner (%.3f,%.3f) width %.3f height " + "%.3f",
        this.reference.getX(), this.reference.getY(), this.width, this
            .height);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Rectangle rectangle = (Rectangle) obj;
    return Double.compare(rectangle.width, width) == 0
        && Double.compare(rectangle.height, height) == 0;
  }

  @Override
  public int hashCode() {
    return Objects.hash(width, height);
  }
}