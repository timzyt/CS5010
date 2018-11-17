package edu.neu.ccs.cs5010.assignment6.concurrent;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import org.junit.Before;
import org.junit.Test;

public class ConcurrentProcessTest {

  private ConcurrentProcess concurrentProcess;

  @Before
  public void setUp() throws Exception {
    this.concurrentProcess = new ConcurrentProcess("test.csv");
  }

  @Test
  public void multiThreadProcess() {
    try {
      concurrentProcess.multiThreadProcess();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (ExecutionException e) {
      e.printStackTrace();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}