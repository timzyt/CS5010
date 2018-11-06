package edu.neu.ccs.cs5010.simplecalculator.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class OpTest {
  UnaryMinus newUnaryMinus;


  @Before
  public void setUp() throws Exception {
    newUnaryMinus = new UnaryMinus(new Num(7));
  }

  @Test
  public void testNext() {
    assertTrue(newUnaryMinus.next().equals(new Num(-7)));
  }
}