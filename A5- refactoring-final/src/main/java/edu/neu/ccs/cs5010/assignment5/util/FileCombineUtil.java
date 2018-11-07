package edu.neu.ccs.cs5010.assignment5.util;

import edu.neu.ccs.cs5010.assignment5.exceptions.EmptyArgumentException;
import edu.neu.ccs.cs5010.assignment5.exceptions.NullArgumentException;

import java.util.List;
import java.util.Map;

public class FileCombineUtil {

  /**
   * Combine strings stored in a List into one complete string.
   *
   * @param stringList List containing strings.
   * @return string value of combined strings.
   * @throws Exception NullArgumentException
   */
  public String combineStringList(List<String> stringList) throws Exception {
    StringBuilder strBdr = new StringBuilder();
    if (stringList == null) {
      throw new NullArgumentException("Provided list of string argument is null.");
    }
    if (stringList.size() == 0) {
      throw new EmptyArgumentException("Provided list of string argument is empty.");
    }
    for (int i = 0; i < stringList.size(); i++) {
      strBdr.append(stringList.get(i)).append(System.lineSeparator());
    }
    strBdr.deleteCharAt(strBdr.length() - 1);
    return strBdr.toString();
  }

  /**
   * Combine strings stored in a Map into one complete string.
   *
   * @param stringMap Map containing strings.
   * @return String value of combined strings.
   * @throws Exception NullArgumentException
   */
  public String combineStringMap(Map<Integer, String> stringMap) throws Exception {
    StringBuilder strBdr = new StringBuilder();
    if (stringMap == null) {
      throw new NullArgumentException("Provided list of string argument is null.");
    }
    if (stringMap.size() == 0) {
      throw new EmptyArgumentException("Provided list of string argument is empty.");
    }
    for (int i = 0; i < stringMap.size(); i++) {
      strBdr.append(stringMap.get(i));
    }
    return strBdr.toString();
  }
}
