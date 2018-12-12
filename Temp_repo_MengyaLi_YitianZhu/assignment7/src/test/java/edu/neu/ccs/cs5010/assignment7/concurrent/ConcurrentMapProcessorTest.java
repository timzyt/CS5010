package edu.neu.ccs.cs5010.assignment7.concurrent;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ConcurrentMapProcessorTest {
  ConcurrentOutputObject corpus = new ConcurrentOutputObject();

  @Before
  public void setUp() throws Exception {


  }

  @Test
  public void getMaxSec() {
    assertTrue(Long.MIN_VALUE == corpus.getMaxSec());
  }

  @Test
  public void getMinSec() {
    assertTrue(Long.MAX_VALUE == corpus.getMinSec());
  }

  @Test
  public void getTotalSumLatency() {
    assertTrue(0L == corpus.getTotalSumLatency());
  }
}