package edu.neu.ccs.cs5010.assignment7.sequential.pojo;

import static org.junit.Assert.*;

import edu.neu.ccs.cs5010.assignment7.sequential.exception.NullArgumentException;
import java.util.Arrays;
import java.util.PriorityQueue;
import org.junit.Before;
import org.junit.Test;

public class GetPercentileTest {

  private Long mapSize = 100L;
  private Long getPctResult;

  private PriorityQueue<Long> pq;
  private GetPercentile newGPct;

  @Before
  public void setUp() throws Exception {
    pq = new PriorityQueue<>();
  }

  @Test
  public void testAdd() {
    pq = new PriorityQueue<Long>(Arrays.asList(new Long[]{2L,3L,4L,5L}));
    pq.add(1L);
    assertTrue(1L == pq.peek());
    System.out.println("The size of current priority queue is: " + pq.size());
  }

  @Test
  public void testGetPercentile() {
    newGPct = new GetPercentile(mapSize, 99);
    for (Long i  = 1L; i <= mapSize; i++) {
      newGPct.add(i);
    }
    getPctResult = newGPct.getPercentile();
    System.out.println(getPctResult);
    assertTrue(99 == getPctResult);
  }

  @Test (expected = NullArgumentException.class)
  public void testNullMapSize() {
    newGPct = new GetPercentile(null, 99);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testSubZeroMapSize() {
    newGPct = new GetPercentile(-1L, 99);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testSubZeroPercentile() {
    newGPct = new GetPercentile(100L, -99);
  }
}