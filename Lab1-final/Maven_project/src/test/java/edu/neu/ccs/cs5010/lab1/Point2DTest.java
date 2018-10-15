package edu.neu.ccs.cs5010.lab1;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Point2DTest {
  private Point2D point;
  @Before
  public void setUp() throws Exception {
    this.point = new Point2D(3,4);

  }

  @Test
  public void distToOrigin() throws Exception {
    Assert.assertEquals(5, this.point.distToOrigin(), 0.0001);
  }

  @Test
  public void getX() throws Exception {
    Assert.assertEquals(3, this.point.getX(), 0.0001);
  }

  @Test
  public void getY() throws Exception {
    Assert.assertEquals(4, this.point.getY(), 0.0001);
  }
}