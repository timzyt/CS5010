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
  BufferredReaderUtil newBRU = new BufferredReaderUtil();
  LineParser newLP = new LineParser();
  Set<Map<String, String>> customerSet = new HashSet<>();
  List<String> fileContent = new ArrayList<>();
  List<String> header = new ArrayList<>();
  List<String> currCustomerList = new ArrayList<>();
  Integer zero = 0;

  public Set<Map<String, String>> loadCustomers(String fileName) {
    fileContent = newBRU.read(fileName);
    header = newLP.parse(fileContent.get(zero));
    for (int i = 1; i < fileContent.size(); i++) {
      currCustomerList = newLP.parse(fileContent.get(i));
      Map<String, String> currCustomerMap = new HashMap<>();
      for (int j = 0; j < header.size(); j++) {
        currCustomerMap.put(header.get(j), currCustomerList.get(j));
      }
      customerSet.add(currCustomerMap);
    }
    return customerSet;
  }
}
