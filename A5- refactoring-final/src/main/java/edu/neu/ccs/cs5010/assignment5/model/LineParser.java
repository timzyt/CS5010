package edu.neu.ccs.cs5010.assignment5.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The type Line parser.
 */
public class LineParser {

  /**
   * The Tokens.
   */
  String[] tokens;
  /**
   * List of String result.
   */
  List<String> resultList;

  /**
   * Parse list.
   *
   * @param line the line
   * @return the list
   */
  public List<String> parse(String line) {
    //Pattern csvPattern1 = Pattern.compile(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
    tokens = line.split(",(?=(?:[^\\\"]*\\\"[^\\\"]*\\\")*[^\\\"]*$)", -1);
    List<String> tempArrayTokens = new ArrayList<String>(Arrays.asList(tokens));
    //trim the quotes for each string item
    resultList = new ArrayList<>();
    for (String str : tempArrayTokens) {
      resultList.add(str.replace("\"", ""));
    }
    return resultList;
  }

}
