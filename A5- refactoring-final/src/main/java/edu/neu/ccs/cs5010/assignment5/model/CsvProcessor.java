package edu.neu.ccs.cs5010.assignment5.model;

import edu.neu.ccs.cs5010.assignment5.util.BufferredReaderUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The csv reader class.
 */
public class CsvProcessor{
  BufferredReaderUtil newBru = new BufferredReaderUtil();
  LineParser newLineparser = new LineParser();
  Set<Map<String, String>> customerSet = new HashSet<>();
  List<String> fileContent = new ArrayList<>();
  List<String> header = new ArrayList<>();
  List<String> currCustomerList = new ArrayList<>();
  Integer zero = 0;

  /**
   * Load csv file by file name, and return a Set of Maps where customer information is stored.
   * @param fileName csv file name.
   * @return Set a set of customer information.
   */
  public Set<Map<String, String>> loadCustomers(String fileName) {
    fileContent = newBru.read(fileName);
    header = newLineparser.parse(fileContent.get(zero));
    for (int i = 1; i < fileContent.size(); i++) {
      currCustomerList = newLineparser.parse(fileContent.get(i));
      Map<String, String> currCustomerMap = new HashMap<>();
      for (int j = 0; j < header.size(); j++) {
        currCustomerMap.put("[[" + header.get(j) + "]]", currCustomerList.get(j));
      }
      customerSet.add(currCustomerMap);
    }
    return customerSet;
  }
}
