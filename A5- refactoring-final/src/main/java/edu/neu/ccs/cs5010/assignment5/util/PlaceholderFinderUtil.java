package edu.neu.ccs.cs5010.assignment5.util;

import edu.neu.ccs.cs5010.assignment5.exceptions.EmptyArgumentException;
import edu.neu.ccs.cs5010.assignment5.exceptions.NullArgumentException;

import java.util.ArrayList;
import java.util.List;

/**
 * Placeholder Finder utility class.
 */
public class PlaceholderFinderUtil {

  /**
   * The string value of starting square brackets.
   */
  String startQuote = "[[";
  /**
   * The string value of closing square brackets.
   */
  String closeQuote = "]]";
  /**
   * Positions of all the starting square brackets.
   */
  List<Integer> startQuotePos;
  /**
   * Positions of all the closing square brackets.
   */
  List<Integer> endQuotePos;
  /**
   * All the pairs of starting and closing square brackets.
   */
  List<Integer[]> placeholderPositions;
  /**
   * Represents the index of starting square bracket in each Integer pair, which is 0.
   */
  Integer startPosition = 0;
  /**
   * Represents the index of closing square bracket in each Integer pair, which is 1.
   */
  Integer endPosition = 1;
  /**
   * The length of each bracket pair, which is 2.
   */
  Integer positionLength = 2;

  /**
   * Find all placeholders position in the provided string, and return all the pairs of them.
   *
   * @param mainContent the main content
   * @return the list
   * @throws Exception the exception
   */
  public List<Integer[]> findAllPlaceholdersPosition(String mainContent) throws Exception {
    if (mainContent == null) {
      throw new NullArgumentException("Provided string argument is null.");
    }
    if (mainContent.length() == 0) {
      throw new EmptyArgumentException("Provided string argument is empty.");
    }

    placeholderPositions = new ArrayList<>();
    startQuotePos = new ArrayList<>();
    endQuotePos = new ArrayList<>();

    for (int i = -1;
        (i = mainContent.indexOf(startQuote, i + 1)) != -1; i++) {
      startQuotePos.add(i);
    }

    for (int i = -1;
        (i = mainContent.indexOf(closeQuote, i + 1)) != -1; i++) {
      endQuotePos.add(i + closeQuote.length());
    }

    for (int k = 0; k < startQuotePos.size(); k++) {
      Integer[] currQuotePos = new Integer[positionLength];
      currQuotePos[startPosition] = startQuotePos.get(k);
      currQuotePos[endPosition] = endQuotePos.get(k);
      placeholderPositions.add(currQuotePos);
    }

    return placeholderPositions;
  }
}
