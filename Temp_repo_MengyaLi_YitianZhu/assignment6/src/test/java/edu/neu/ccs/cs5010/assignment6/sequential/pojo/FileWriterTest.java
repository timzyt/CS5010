package edu.neu.ccs.cs5010.assignment6.sequential.pojo;

import edu.neu.ccs.cs5010.assignment6.sequential.exception.NullArgumentException;
import java.io.FileNotFoundException;
import org.junit.Before;
import org.junit.Test;

public class FileWriterTest {

  private String outputDir;
  private String inNameSmallGet;
  private String inNameSmallPost;
  private String inNameBigGet;
  private String inNameBigPost;
  private String inNameGetResult;
  private String inNamePostResult;
  private String inBadName;
  private FileWriter fw;

  @Before
  public void setUp() throws Exception {
    outputDir = "output";
    inNameSmallGet = "WearableWorkloadDefault-Javatest-GETraw.csv";
    inNameSmallPost = "WearableWorkloadDefault-Javatest-POSTraw.csv";

    inNameBigGet = "WearableWorkloadDefault-1024-1000i-CPUrelaxed-long-Python-GETraw.csv";
    inNameBigPost = "WearableWorkloadDefault-1024-1000i-CPUrelaxed-long-Python-POSTraw.csv";

    inNameGetResult = "WearableWorkloadDefault-Javatest-GETresult.csv";
    inNamePostResult = "WearableWorkloadDefault-Javatest-POSTresult.csv";

    inBadName = "WearableWorkloadDefault-Javatest-GETbad.csv";
    
    fw =  new FileWriter();

  }

  @Test
  public void writeSingleFile() throws Exception {
    fw.writeSingleFile(inNameSmallGet, outputDir);
    //fw.writeSingleFile(inNameSmallPost, outputDir);

    //fw.writeSingleFile(inNameBigGet, outputDir);
    //fw.writeSingleFile(inNameBigPost, outputDir);
  }

  @Test
  public void mergeFiles() throws Exception {

    fw.mergeFiles(inNameSmallGet, inNameSmallPost, outputDir);
    //fw.mergeFiles(inNameBigGet, inNameBigPost, outputDir);
  }

  @Test (expected = NullArgumentException.class)
  public void writeSingleFileFNFE() throws Exception {
  //outputDir = System.getProperty("user.dir") + File.separator + "output";
    fw.writeSingleFile(inBadName, outputDir);
  }

  @Test (expected = NullArgumentException.class)
  public void mergeFilesFNFE() throws Exception {
    //outputDir = System.getProperty("user.dir") + File.separator + "output";
    fw.mergeFiles(inBadName,inBadName, outputDir);
  }

}