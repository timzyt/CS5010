package edu.neu.ccs.cs5010.assignment2;

import static org.junit.Assert.*;

import edu.neu.ccs.cs5010.assignment2.SealType;
import org.junit.Before;
import org.junit.Test;

public class SealTypeTest {

  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void testValueOf() {
    assertEquals(SealType.Sealed, SealType.valueOf("Sealed"));
  }
}