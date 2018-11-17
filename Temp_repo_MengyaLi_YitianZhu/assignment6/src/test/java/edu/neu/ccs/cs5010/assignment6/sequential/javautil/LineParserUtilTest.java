package edu.neu.ccs.cs5010.assignment6.sequential.javautil;

import edu.neu.ccs.cs5010.assignment6.sequential.exception.IllegalColumnNumberException;
import org.junit.Before;
import org.junit.Test;

public class LineParserUtilTest {
  String testGetLine;
  String testPostLine;
  String illegalLine;
  String testResultLine;
  Long[] parseResult;

  LineParserUtil lpu = new LineParserUtil();

  @Before
  public void setUp() throws Exception {
    testGetLine = "\"1541348500077\",\"GET\",\"189\",\"200\"";
    testPostLine = "1541348501585,POST,160,200";
    testResultLine = "1541348499   14   1224   ";
    illegalLine = "1541348501585,POST,160,200,201";
  }

  @Test
  public void testParseLine() throws Exception {
    parseResult = lpu.parseLine(testGetLine);
    for (Long entry : parseResult) {
      System.out.println(entry);
    }
    parseResult = lpu.parseLine(testPostLine);
    for (Long entry : parseResult) {
      System.out.println(entry);
    }
    parseResult = lpu.parseLine(testResultLine);
    for (Long entry : parseResult) {
      System.out.println(entry);
    }
  }

  @Test (expected = IllegalColumnNumberException.class)
  public void testException() throws Exception {
    lpu.parseLine(illegalLine);
  }
}