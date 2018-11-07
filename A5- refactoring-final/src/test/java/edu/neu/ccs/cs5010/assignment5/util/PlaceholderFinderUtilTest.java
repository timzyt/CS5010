package edu.neu.ccs.cs5010.assignment5.util;

import edu.neu.ccs.cs5010.assignment5.exceptions.EmptyArgumentException;
import edu.neu.ccs.cs5010.assignment5.exceptions.NullArgumentException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class PlaceholderFinderUtilTest {
  private PlaceholderFinderUtil newPFU = new PlaceholderFinderUtil();
  private BufferredReaderUtil newBRU = new BufferredReaderUtil();
  private FileCombineUtil newFCU = new FileCombineUtil();
  private String testFileName;
  private String testMainContent;
  private String nullMainContent;
  private String emptyMainContent;
  private List<Integer[]> resultList;


  @Before
  public void setUp() throws Exception {
    testFileName = "email-template.txt";
    testMainContent = newFCU.combineStringList(newBRU.read(testFileName));
    resultList = new ArrayList<>();
    emptyMainContent = "";
  }


  @Test (expected = NullArgumentException.class)
  public void testNullMainContent() throws Exception {
    resultList = newPFU.findAllPlaceholdersPosition(nullMainContent);
  }

  @Test (expected = EmptyArgumentException.class)
  public void testEmptyMainContent() throws Exception {
    resultList = newPFU.findAllPlaceholdersPosition(emptyMainContent);
  }

  @Test
  public void testFindAllPlaceholdersPosition() throws Exception {
    resultList = newPFU.findAllPlaceholdersPosition(testMainContent);
    System.out.println(resultList.size());
    for (int i = 0; i < resultList.size(); i++) {
      System.out.println("Placeholder #" + i +": [ " + resultList.get(i)[0] + ", " +resultList.get(i)[1] + " ] placeholder is: " + testMainContent.substring(resultList.get(i)[0],resultList.get(i)[1]));
    }
  }
}