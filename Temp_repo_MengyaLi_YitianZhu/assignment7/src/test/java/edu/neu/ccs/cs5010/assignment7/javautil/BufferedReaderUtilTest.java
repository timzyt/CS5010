package edu.neu.ccs.cs5010.assignment7.javautil;

import edu.neu.ccs.cs5010.assignment7.sequential.pojo.MapBuilder;
import java.io.IOException;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

/**
 * The buffered reader util .
 */
public class BufferedReaderUtilTest {

  private String inFileName;
  private String badInFileName;
  private BufferedReaderUtil bru;
  private List<String> loadResult;

  /**
   * Sets up.
   *
   * @throws Exception the exception
   */
  @Before
  public void setUp() throws Exception {
    inFileName = "WearableWorkloadDefault-Javatest-GETraw.csv";
    badInFileName = "badCsv.csv";
    bru = new BufferedReaderUtil();
  }

  /**
   * Read.
   */
  @Test
  public void testRead() throws IOException {
    MapBuilder mapBdr = bru.read(inFileName);
    for (int i = 0; i < 10; i++) {
      System.out.println(mapBdr.getLatencyList().get(i));
    }
  }

  @Test
  public void testFNFE() throws IOException {
    bru.read(badInFileName);
  }
}