package edu.neu.ccs.cs5010.lab1;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RectangleTest {
  private Rectangle rectangle;
  @Before
  public void setUp() throws Exception {
    this.rectangle = new Rectangle(0, 0, 3, 4);
  }

  @Test
  public void area() {
    Assert.assertEquals(12, rectangle.area(), 0.001);
  }


  @Test
  public void perimeter() {
    Assert.assertEquals(14, rectangle.perimeter(), 0.001);
  }

  @Test
  public void resize() {
    Rectangle newRectangle = new Rectangle(0, 0, 6, 8);
    System.out.println(rectangle.resize(4).toString());
    newRectangle.equals(rectangle);
    Assert.assertEquals(newRectangle.toString(), rectangle.resize(4).toString());
  }

  @Test
  public void testToString() {
    String expected = "Rectangle: LL corner (0.000,0.000) width 3.000 height 4.000";
    String actual = rectangle.toString();
    Assert.assertEquals(expected, actual);
  }

}