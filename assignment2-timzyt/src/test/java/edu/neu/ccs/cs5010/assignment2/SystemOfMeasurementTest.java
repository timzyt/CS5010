package edu.neu.ccs.cs5010.assignment2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SystemOfMeasurementTest {

  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void testValueOf() {
    assertEquals(SystemOfMeasurement.Metric, SystemOfMeasurement.valueOf("Metric"));
  }
}