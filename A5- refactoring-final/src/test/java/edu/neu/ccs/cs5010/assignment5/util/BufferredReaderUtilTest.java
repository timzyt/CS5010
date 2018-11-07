package edu.neu.ccs.cs5010.assignment5.util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class BufferredReaderUtilTest {
  private BufferredReaderUtil newBRF = new BufferredReaderUtil();
  private String testFileName;
  private String nullTestFileName;
  private String nullLine;
  private String nonExistFileName;
  private List<String> testListResult;

  @Before
  public void setUp() throws Exception {
    testFileName = "insurance-company-members_test.csv";
    nullTestFileName = "nullTestFile.csv";
    nonExistFileName = "noSuchFile.csv";
  }

  @Test
  public void testLoadCustomers() throws Exception {
    System.out.println(System.getProperty("user.dir"));
    testListResult = newBRF.read(testFileName);
    for (int i = 0; i < testListResult.size(); i++) {
      System.out.println(testListResult.get(i));
    }
  }

  @Test
  public void testFileNotFound() throws Exception {
    newBRF.read(nonExistFileName);
  }

  @Test
  public void testNullFile() throws Exception {
    System.getProperty("user.dir");
    FileWriter newFileWriter = new FileWriter(nullTestFileName);
    newFileWriter.append(nullLine);
    newFileWriter.close();
    testListResult = newBRF.read(nullTestFileName);
    for (int i = 0; i < testListResult.size(); i++) {
      System.out.println(testListResult.get(i));
    }
  }

  @Test
  public void testIOException() throws IOException {
    final RandomAccessFile raFile = new RandomAccessFile(testFileName, "rw");
    raFile.getChannel().lock();
    newBRF.read(testFileName);
//    raFile.getChannel().lock().close();
  }
}