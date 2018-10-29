package edu.neu.ccs.cs5010;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import edu.neu.ccs.cs5010.assignment5.model.TemplateReader;
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

  TemplateReader newTemplateReader = new TemplateReader();

  @Before
  public void before() throws Exception {
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
    System.out.println(newTemplateReader.run("email-template.txt"));
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
