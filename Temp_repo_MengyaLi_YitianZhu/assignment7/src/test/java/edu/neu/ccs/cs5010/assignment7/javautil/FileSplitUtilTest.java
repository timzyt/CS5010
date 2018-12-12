package edu.neu.ccs.cs5010.assignment7.javautil;

import edu.neu.ccs.cs5010.assignment7.concurrent.FileSplit;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.Before;

/**
 * FileSplitUtil Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Nov 20, 2018</pre>
 */
public class FileSplitUtilTest {
  private String fileName;
  private int count;
  private List<String> parts;

  private FileSplit fileSplit;

  @Before
  public void before() throws Exception {
    fileName = "WearableWorkloadDefault-Javatest-POSTraw.csv";
    count = 3;
    parts = new ArrayList<>();

    fileSplit = new FileSplit();

  }

  /**
   * Method: splitByCount(String fileName, int count)
   */
  @Test
  public void testSplitByCount() throws Exception {
    parts = fileSplit.splitByCount(fileName, count);
    System.out.println("original file is splited into the following files:");
    for (String part : parts) {
      System.out.println("fileName: " + part);
    }

  }

}
