package test.edu.neu.ccs.cs5010.assignment5.model;

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


} 
