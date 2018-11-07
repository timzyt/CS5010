package edu.neu.ccs.cs5010.assignment5.util;

import edu.neu.ccs.cs5010.assignment5.exceptions.EmptyArgumentException;
import edu.neu.ccs.cs5010.assignment5.exceptions.NullArgumentException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;

public class FileCombineUtilTest {
  private BufferredReaderUtil newBRU = new BufferredReaderUtil();
  private FileCombineUtil newFCU = new FileCombineUtil();
  private String testFileName;
  private List<String> nullList;
  private List<String> emptyList;
  private Map<Integer, String> testMap;
  private Map<Integer, String> nullMap;
  private Map<Integer, String> emptyMap;
  private List<String> resultStringList;
  private String result;

  @Before
  public void setUp() throws Exception {
    resultStringList = new ArrayList<>();
    testFileName = "email-template.txt";
    emptyList = new ArrayList<>();
    emptyMap = new HashMap<>();
    testMap = new HashMap<>();
    testMap.put(0, "abc\r\n");
    testMap.put(1, "def\r\n");
    testMap.put(2, "ghi\r\n");
  }

  @Test
  public void testCombineStringList() throws Exception {
    resultStringList = newBRU.read(testFileName);

    System.out.println(newFCU.combineStringList(resultStringList));
  }

  @Test
  public void combineStringMap() throws Exception {
    System.out.println(newFCU.combineStringMap(testMap));
  }

  @Test (expected = NullArgumentException.class)
  public void testNullArgumentInCombinStringList() throws Exception {
    result = newFCU.combineStringList(nullList);
  }

  @Test (expected = NullArgumentException.class)
  public void testNullArgumentInCombinStringMap() throws Exception {
    result = newFCU.combineStringMap(nullMap);
  }

  @Test (expected = EmptyArgumentException.class)
  public void testEmptyArgumentInCombinStringList() throws Exception {
    result = newFCU.combineStringList(emptyList);
  }

  @Test (expected = EmptyArgumentException.class)
  public void testEmptyArgumentInCombinStringMap() throws Exception {
    result = newFCU.combineStringMap(emptyMap);
  }

}