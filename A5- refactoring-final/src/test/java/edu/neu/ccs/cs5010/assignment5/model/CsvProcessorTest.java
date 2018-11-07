package edu.neu.ccs.cs5010.assignment5.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.junit.Test;
import org.junit.Before;


/**
 * CsvProcessor Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Oct 23, 2018</pre>
 */
public class CsvProcessorTest {

  private String testFileName;
  private CsvProcessor newCsvProcessor;
  private Set<Map<String, String>> resultSet = new HashSet<>();


  @Before
  public void before() throws Exception {
    testFileName = "insurance-company-members_test.csv";
    newCsvProcessor = new CsvProcessor();
  }

  /**
   * Method: loadCustomers(String templateFileName)
   */
  @Test
  public void testloadCustomers() throws Exception {
    System.getProperty("user.dir");
    resultSet = newCsvProcessor.loadCustomers(testFileName);
    System.out.println("this result set has " + resultSet.size() + " sets of data");
    for (Map customerMap : resultSet) {
      Map<String, String> currMap = new HashMap<>(customerMap);
      System.out.println("---------------------------------------------");
      System.out.println("Current Map has " + currMap.size() + " sets of value.");
      for (String key : currMap.keySet()) {
        System.out.println("/key: " + key + " /Value: " + currMap.get(key));
      }
    }
  }
}
