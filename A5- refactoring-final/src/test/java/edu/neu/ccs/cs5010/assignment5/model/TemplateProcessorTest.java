package edu.neu.ccs.cs5010.assignment5.model;

import edu.neu.ccs.cs5010.assignment5.exceptions.EmptyArgumentException;
import edu.neu.ccs.cs5010.assignment5.exceptions.NullArgumentException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.junit.Test;
import org.junit.Before;

/**
 * TemplateProcessor Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Oct 22, 2018</pre>
 */
public class TemplateProcessorTest {

  private TemplateProcessor newTemplateProcessor;
  private String testEmailTemplate;
  private String testLetterTemplate;
  private String nullFileName;
  private String emptyFileName;
  private Map<Integer, String> resultMap;
  private Set<Integer> resultSet;

  @Before
  public void before() throws Exception {

    resultMap = new HashMap<>();
    resultSet = new HashSet<>();
    testEmailTemplate = "email-template.txt";
    testLetterTemplate = "letter-template.txt";
    newTemplateProcessor = new TemplateProcessor();
    emptyFileName = "";
  }


  @Test (expected = NullArgumentException.class)
  public void testNullFileNameInGetWhole() throws Exception {
    resultMap = newTemplateProcessor.getWholeParsedTemplate(nullFileName);
  }

  @Test (expected = EmptyArgumentException.class)
  public void testEmptyFileNameInGetWhole() throws Exception {
    resultMap = newTemplateProcessor.getWholeParsedTemplate(emptyFileName);
  }

  @Test (expected = NullArgumentException.class)
  public void testNullFileNameInGetKeys() throws Exception {
    resultMap = newTemplateProcessor.getWholeParsedTemplate(nullFileName);
  }

  @Test (expected = EmptyArgumentException.class)
  public void testEmptyFileNameInGetKeys() throws Exception {
    resultMap = newTemplateProcessor.getWholeParsedTemplate(emptyFileName);
  }

  @Test
  public void testParseTemplate() throws Exception {
    System.out.println(newTemplateProcessor.getWholeParsedTemplate("letter-template.txt"));
  }

  @Test
  public void testGetWholeParsedTemplateEmail() throws Exception {
    resultMap = newTemplateProcessor.getWholeParsedTemplate(testEmailTemplate);
    for (int i = 0; i < resultMap.size(); i++) {
      System.out.println("key #" + i + ": " + resultMap.get(i) );
    }
  }

  @Test
  public void testGetPlaceHolderKeysEmail() throws Exception {
    resultSet = newTemplateProcessor.getPlaceholderKeys(testEmailTemplate);
    for (Integer key : resultSet) {
      System.out.println(key);
    }
  }

  @Test
  public void testGetWholeParsedTemplateLetter() throws Exception {
    resultMap = newTemplateProcessor.getWholeParsedTemplate(testLetterTemplate);
    for (int i = 0; i < resultMap.size(); i++) {
      System.out.println("key #" + i + ": " + resultMap.get(i) );
    }
  }

  @Test
  public void testGetPlaceHolderKeysLetter() throws Exception {
    resultSet = newTemplateProcessor.getPlaceholderKeys(testLetterTemplate);
    for (Integer key : resultSet) {
      System.out.println(key);
    }
  }
}
