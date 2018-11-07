package edu.neu.ccs.cs5010.assignment5.util;

import edu.neu.ccs.cs5010.assignment5.exceptions.EmptyArgumentException;
import edu.neu.ccs.cs5010.assignment5.exceptions.NullArgumentException;
import java.util.List;

public class PlaceholderFinderUtil {
  String startQuote = "\\[\\[";
  String endQuote = "\\]\\]";
  List<Integer> startQuotePos;
  List<Integer> endQuotePos;
  List<Integer[]> placeholderPositions;
  Integer startPosition = 0;
  Integer endPosition = 1;
  Integer positionLength = 2;

  public List<Integer[]> findAllPlaceholdersPosition(String mainContent) throws Exception {
    if (mainContent == null) {
      throw new NullArgumentException("Provided string argument is null.");
    }
    if (mainContent.length() == 0) {
      throw new EmptyArgumentException("Provided string argument is empty.");
    }
    for (int i = -1;
        (i = mainContent.indexOf(startQuote, i + 1)) != -1; i++) {
      startQuotePos.add(i);
    }

    for (int i = -1;
        (i = mainContent.indexOf(endQuote, i + 1)) != -1; i++)  {
      endQuotePos.add(i + endQuote.length());
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
