package edu.neu.ccs.cs5010.assignment7.javautil;

import edu.neu.ccs.cs5010.assignment7.sequential.exception.IllegalColumnNumberException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The Line Parser Utility class.
 */
public class LineParserUtil {

  public static final Integer RAW_FILE_COLUMN = 4;

  public static final Integer RESULT_FILE_COLUMN = 3;

  /**
   * the index of latency count in the arrayList.
   */
  public static final Integer INDEX_OF_TIMESTAMP = 0;

  /**
   * the index of mean latency in the arrayList.
   */
  public static final Integer INDEX_OF_LATENCY = 1;

  public static final Integer VALUE_ARRAY_SIZE = 2;

  /**
   * The String list tokens. Store the result immediately after each line parse.
   */
  private String[] tokens;

  /**
   * The Long list resultList. Store the extracted result from the line parse.
   */
  private Long[] resultList;

  /**
   * The regex pattern 1 for GET-raw file.
   */
  private String getPattern = "\",\"";

  /**
   * The regex pattern 2 for POST-raw file.
   */
  private String postPattern = ",";

  /**
   * Parse one line of String. Verify whether this line came from GET or POST file by checking if.
   * this line contains post pattern separator (",") or not.
   *
   * @param line the line
   * @return the list
   * @throws Exception the exception
   */
  public Long[] parseLine(String line) throws Exception {

    if (line.contains(getPattern)) {
      //if the line contains the get pattern separator ","
      //split the line by get pattern.
      tokens = line.split(getPattern);
    }
    if (!line.contains(postPattern)) {
      //if the line does not even contain the post pattern
      //means this line is from the result file
      //which uses space as separator.
      tokens = line.split("\\s+");
    } else {
      //if else, the line must be of post pattern
      //so separate the line by ,
      tokens = line.split(postPattern);
    }

    List<String> tempArrayTokens = new ArrayList<String>(Arrays.asList(tokens));
    return extractResult(tempArrayTokens);
  }

  /**
   * Extract result from the raw line parse output and store in an Long list. Per assignment
   * requirement, only "Start Time" for each latency test, and the latency value need to be
   * processed.
   *
   * @param arrayTokens the array tokens
   * @return the Long []
   * @throws Exception the exception
   */
  public Long[] extractResult(List<String> arrayTokens) throws Exception {
    if (arrayTokens.size() > RAW_FILE_COLUMN) {
      throw new IllegalColumnNumberException("Provided row contains more than 4 columns.");
    }
    //if the input arrayList size is 3, means this input is from a result file
    if (arrayTokens.size() == RESULT_FILE_COLUMN) {
      resultList = new Long[RESULT_FILE_COLUMN];
      for (int i = 0; i < RESULT_FILE_COLUMN; i++) {
        //trim the double quotes for each splitted String
        //then convert each to Long type
        System.out.println(tokens[i].replace("\"", ""));
        resultList[i] = Long.valueOf(tokens[i].replace("\"", ""));
      }
    } else if (arrayTokens.size() == RAW_FILE_COLUMN) {
      //construct new Long list to store parsed line.
      resultList = new Long[VALUE_ARRAY_SIZE];
      //trim the quotes for each string item
      //the first Long in the list represents the Start Time in seconds.
      resultList[INDEX_OF_TIMESTAMP] = Long
          .valueOf(arrayTokens.get(INDEX_OF_TIMESTAMP).replace("\"", ""));
      //the second Long in the list represents the latency in milliseconds.
      resultList[INDEX_OF_LATENCY] = Long
          .valueOf(arrayTokens.get(VALUE_ARRAY_SIZE).replace("\"", ""));
    }
    //make a copy of the internal variable resultList
    Long[] copyResult = new Long[resultList.length];
    System.arraycopy(resultList, 0, copyResult, 0, resultList.length);
    return copyResult;
  }
}
