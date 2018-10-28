package edu.neu.ccs.cs5010;

import edu.neu.ccs.cs5010.assignment5.model.LineParser;
import java.util.List;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* LineParser Tester. 
* 
* @author <Authors name> 
* @since <pre>Oct 22, 2018</pre> 
* @version 1.0 
*/ 
public class LineParserTest {

  LineParser newLineParser;

  String line = "\"first_name\",\"last_name\",\"company_name\",\"address\",\"city\",\"county\",\"state\",\"zip\",\"phone1\",\"phone2\",\"email\",\"web\"\n"
      + "\"James\",\"Butt\",\"Benton, John B Jr\",\"6649 N Blue Gum St\",\"New Orleans\",\"Orleans\",\"LA\",\"70116\",\"504-621-8927\",\"504-845-1427\",\"jbutt@gmail.com\",\"http://www.bentonjohnbjr.com\"\n"
      + "\"Josephine\",\"Darakjy\",\"Chanay, Jeffrey A Esq\",\"4 B Blue Ridge Blvd\",\"Brighton\",\"Livingston\",\"MI\",\"48116\",\"810-292-9388\",\"810-374-9840\",\"josephine_darakjy@darakjy.org\",\"http://www.chanayjeffreyaesq.com\"";

@Before
public void before() throws Exception {
  newLineParser = new LineParser();
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: parse(String line) 
* 
*/ 
@Test
public void testParse() throws Exception {
  List<String> tokens = newLineParser.parse(line);
  for (String str : tokens) {
    System.out.println(str);
  }
} 


} 
