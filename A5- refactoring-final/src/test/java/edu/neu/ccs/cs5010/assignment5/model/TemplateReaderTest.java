package edu.neu.ccs.cs5010.assignment5.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import edu.neu.ccs.cs5010.assignment5.model.LineParser;
import edu.neu.ccs.cs5010.assignment5.model.TemplateReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * TemplateReader Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Oct 22, 2018</pre>
 */
public class TemplateReaderTest {

  TemplateReader newTemplateReader;
  StringBuilder cachedTemplate;
  LineParser lineParser;
  String templateFileName;
  String badFileName;
  String nullFile;
  String line;

  @Before
  public void before() throws Exception {

    cachedTemplate = new StringBuilder();
    lineParser = new LineParser();
    templateFileName = "email-template.txt";
    badFileName = "noSuchTemplate.txt";
    newTemplateReader = new TemplateReader();
  }

  @After
  public void after() throws Exception {
  }

  /**
   * Method: run(String templateName)
   */
  @Test
  public void testRun() throws Exception {
    //    assertTrue(newTemplateReader.run("email-template.txt").isEmpty());
    System.out.println(newTemplateReader.run("letter-template.txt"));
  }


  /**
   * test when input file name does not exist.
   * @throws FileNotFoundException
   */
  @Test //(expected = FileNotFoundException.class)
  public void testFileNotFound() throws Exception {
    System.getProperty("user.dir");
    String cachedTemplate = newTemplateReader.run(badFileName);
    //    try (BufferedReader inputFile = new BufferedReader(new FileReader(badFileName))) {
    //      String line;
    //      cachedTemplate.setLength(0);
    //      while ((line = inputFile.readLine()) != null) {
    //        //need to flush the StringBuilder object cachedTemplate
    //
    //        cachedTemplate.append(line).append("\r\n");
    //        System.out.println("Read : " + line);
    //      }
    //    } catch (FileNotFoundException fnfe) {
    //      String message = "noSuchFile.csv (The system cannot find the file specified)";
    //      //fnfe.printStackTrace();
    //      assertEquals(message, fnfe.getMessage());
    //    }
  }

    //  /**
    //   * test method to trim the empty space in the end of the cached template
    //   */
    //  @Test
    //  public void testTrimSpace() throws Exception {
    //    newTemplateReader.run("testTemplate2.txt");
    //  }

  /**
   * test when input file is null.
   * @throws Exception
   */
  @Test //(expected = FileNotFoundException.class)
  public void testNullFile() throws Exception {

    System.getProperty("user.dir");
    FileWriter newFileWriter = new FileWriter("testTemplate3.txt");
    newFileWriter.close();
    final RandomAccessFile raFile =  new RandomAccessFile("testTemplate3.txt", "rw");

  //    try (BufferedReader inputFile = new BufferedReader(new FileReader("testFile.csv"))) {
  //      String line;
  //      cachedTemplate.setLength(0);
  //      while ((line = inputFile.readLine()) != null) {
  //        //need to flush the StringBuilder object cachedTemplate
  //
  //        cachedTemplate.append(line).append("\r\n");
  //        System.out.println("Read : " + line);
  //      }
  //    } catch (FileNotFoundException fnfe) {
  //      String message = "noSuchFile.csv (The system cannot find the file specified)";
  //      assertEquals(message, fnfe.getMessage());
  //    }
  }

  /**
   * test when the input file is locked.
   * @throws Exception
   */
  @Test //(expected = IOException.class)
  public void testIOException() throws Exception {
    final RandomAccessFile raFile =  new RandomAccessFile(templateFileName, "rw");
    raFile.getChannel().lock();
    newTemplateReader.run(templateFileName);
  //    raFile.getChannel().lock().close();
  //    try (BufferedReader inputFile = new BufferedReader(new FileReader(templateFileName))) {
  //
  //      line = inputFile.readLine();
  //      raFile.getChannel().lock().close();
  //    } catch (IOException ioe) {
  //      String message = "The process cannot access the file because another process has locked a portion of the file";
  //      assertEquals(message, ioe.getMessage());
  //    }

  }


  /**
   * Method: equals(Object obj)
   */
  @Test
  public void testEquals() throws Exception {
    assertTrue(newTemplateReader.equals(newTemplateReader));
    assertTrue(newTemplateReader.equals(new TemplateReader()));
    assertFalse(newTemplateReader.equals("123"));
  }

  /**
   * Method: hashCode()
   */
  @Test
  public void testHashCode() throws Exception {
    assertTrue(newTemplateReader.hashCode() == new TemplateReader().hashCode());
  }

} 
