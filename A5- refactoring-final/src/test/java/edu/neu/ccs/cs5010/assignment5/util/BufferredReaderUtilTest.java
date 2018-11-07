package edu.neu.ccs.cs5010.assignment5.util;

import static org.junit.Assert.*;

import java.io.FileWriter;
import java.io.IOException;
import org.junit.Before;
import org.junit.Test;

public class BufferredReaderUtilTest {
  BufferredReaderUtil newBRF = new BufferredReaderUtil();
  private String testFileName;
  private String badFileName;

  @Before
  public void setUp() throws Exception {
    testFileName = "testFile.csv";
    badFileName = "noSuchFile.csv";
  }

  @Test
  public void testFileNotFound() throws Exception {
    newBRF.read(badFileName);
  }

  @Test
  public void testRead() throws IOException {
    System.getProperty("user.dir");
    FileWriter newFileWriter = new FileWriter(testFileName);
    newFileWriter.close();
  }
}