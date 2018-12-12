package edu.neu.ccs.cs5010.assignment7.sequential.pojo;

import edu.neu.ccs.cs5010.assignment7.sequential.exception.NullArgumentException;

import java.util.PriorityQueue;

/**
 * The get percentile class.
 */
public class GetPercentile {

  public static final Integer ZERO = 0;
  public static final Integer HUNDRED = 100;
  private Integer heapSize;
  private Integer counter;
  private PriorityQueue<Long> minHeap;

  /**
   * Constructs and Instantiates a new get percentile object.
   *
   * @param mapSize the input map size
   * @param percentile the percentile
   */
  public GetPercentile(Long mapSize, int percentile) {
    if (mapSize == null) {
      throw new NullArgumentException("Provided mapSize is null.");
    }
    if (mapSize <= ZERO) {
      throw new IllegalArgumentException("Provided mapSize is equal or less than ZERO.");
    }
    if (percentile <= ZERO) {
      throw new IllegalArgumentException("Provided percentile is equal or less than ZERO.");
    }
    heapSize = (int) (mapSize * (HUNDRED - percentile) / HUNDRED);
    this.minHeap = new PriorityQueue<>(heapSize);
    this.counter = ZERO;
  }

  /**
   * Add entry into the minmum heap (priority queue).
   *
   * @param input the input
   */
  public void add(Long input) {
    if (this.counter <= heapSize) {
      this.minHeap.offer(input);
      this.counter++;
    } else if (input > this.minHeap.peek()) {
      this.minHeap.poll();
      this.minHeap.offer(input);
    }
  }

  /**
   * Gets percentile.
   *
   * @return the percentile
   */
  public Long getPercentile() {
    return this.minHeap.poll();
  }
}
