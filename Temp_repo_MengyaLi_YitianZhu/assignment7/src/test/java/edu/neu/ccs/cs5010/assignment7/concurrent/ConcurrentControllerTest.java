package edu.neu.ccs.cs5010.assignment7.concurrent;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import org.junit.Before;
import org.junit.Test;

public class ConcurrentControllerTest {

  private ConcurrentController concurrentController;

  @Before
  public void setUp() throws Exception {
    this.concurrentController = new ConcurrentController("test.csv", 1);
  }

  @Test
  public void multiThreadProcess() {
    try {
      concurrentController.multiThreadProcess();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}