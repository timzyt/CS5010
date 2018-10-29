package edu.neu.ccs.cs5010.assignment5.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

/**
 * The type Line parser.
 */
public class LineParser {

  /**
   * The Tokens.
   */
  String[] tokens;
  /**
   * The Csv pattern 1.
   */
  //Pattern csvPattern1;

  /**
   * Instantiates a new Line parser.
   */
  public LineParser() {

  }

  /**
   * Parse list.
   *
   * @param line the line
   * @return the list
   */
  public List<String> parse(String line) {
    //Pattern csvPattern1 = Pattern.compile(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
    tokens = line.split(",(?=(?:[^\\\"]*\\\"[^\\\"]*\\\")*[^\\\"]*$)", -1);
    List<String> arrayTokens = new ArrayList<String>(Arrays.asList(tokens));
    return arrayTokens;
  }

}
