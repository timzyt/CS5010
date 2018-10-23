package edu.neu.ccs.cs5010.assignment5.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class LineParser {

  String[] tokens;
  Pattern csvPattern1;

  public LineParser() {

  }

  public ArrayList<String> parse(String line) {
//    Pattern csvPattern1 = Pattern.compile(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
    tokens = line.split(",", -1);
    ArrayList<String> arrayTokens = new ArrayList<String>(Arrays.asList(tokens));
    return arrayTokens;
  }

}
