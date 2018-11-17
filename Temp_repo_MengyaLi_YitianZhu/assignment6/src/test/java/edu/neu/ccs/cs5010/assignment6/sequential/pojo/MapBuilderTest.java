package edu.neu.ccs.cs5010.assignment6.sequential.pojo;

import edu.neu.ccs.cs5010.assignment6.sequential.javautil.BufferedReaderUtil;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class MapBuilderTest {

  private String testPOSTFile;
  private BufferedReaderUtil bru;
  private MapBuilder mb;


  @Before
  public void setUp() throws Exception {
    testPOSTFile = "WearableWorkloadDefault-Javatest-GETraw.csv";
    bru = new BufferedReaderUtil();
    mb = new MapBuilder();
  }

  @Test
  public void buildMap() throws Exception {
    mb = bru.read(testPOSTFile);

    System.out.println("Map Size: " + mb.getDataMap().size());
    System.out.println("99 Percentile is: " + mb.getPercentile(99));
    System.out.println("Record Count: " + mb.getLatencyCount());
    System.out.println("Mean Latency: " + mb.getLatencySum() / mb.getLatencyCount());
    System.out.println("Test Length: " + (mb.getEndTime() - mb.getStartTime()) / 1000);

  }

  @Test
  public void testCalculation() {
    Long result = Long.valueOf((int) (1200L * ((100.00 - 87) / 100.00)));
    System.out.println(result);
    System.out.println(100 * 100.0f);
  }
}