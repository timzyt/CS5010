package edu.neu.ccs.cs5010.assignment5.model;

import edu.neu.ccs.cs5010.assignment5.exceptions.EmptyArgumentException;
import edu.neu.ccs.cs5010.assignment5.exceptions.NullArgumentException;
import edu.neu.ccs.cs5010.assignment5.util.BufferredReaderUtil;
import edu.neu.ccs.cs5010.assignment5.util.PlaceholderFinderUtil;
import edu.neu.ccs.cs5010.assignment5.util.FileCombineUtil;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The type Template reader.
 */
public class TemplateProcessor {

  BufferredReaderUtil newBRU = new BufferredReaderUtil();
  List<String> rawTemplate;
  PlaceholderFinderUtil newFinder = new PlaceholderFinderUtil();
  FileCombineUtil fileCombineUtil = new FileCombineUtil();
  String completeTemplate;
  List<Integer[]> placeholderPositions;
  Map<Integer, String> wholeParsedTemplate = new HashMap<>();
  Set<Integer> placeholderKeys = new HashSet<>();
  Integer counter = 0;
  Integer zero = 0;
  Integer startingQuote = 0;
  Integer closingQuote = 1;

  /**
   * Return the whole parsed template stored in HashMap
   *
   * @param fileName String value of the template file name.
   * @return Map containing whole parsed template.
   * @throws Exception NullArgumentException or EmptyArgumentException.
   */
  public Map<Integer, String> getWholeParsedTemplate(String fileName) throws Exception {
    if (fileName == null) {
      throw new NullArgumentException("Provided fileName is null.");
    }
    if (fileName.length() == 0) {
      throw new EmptyArgumentException("Provided fileName is empty.");
    }
    this.parseTemplate(fileName);
    return this.wholeParsedTemplate;
  }

  public Set<Integer> getPlaceholderKeys(String fileName) throws Exception {
    if (fileName == null) {
      throw new NullArgumentException("Provided fileName is null.");
    }
    if (fileName.length() == 0) {
      throw new EmptyArgumentException("Provided fileName is empty.");
    }

    this.parseTemplate(fileName);
    return this.placeholderKeys;
  }

  /**
   * Return a HashSet of all the keys for placeholders in tye whole parsed template HashMap.
   *
   * @param fileName String value of the template file name.
   * @throws Exception NullArgumentException
   */
  public void parseTemplate(String fileName) throws Exception {
    rawTemplate = newBRU.read(fileName);
    completeTemplate = fileCombineUtil.combineStringList(rawTemplate);
    placeholderPositions = newFinder.findAllPlaceholdersPosition(completeTemplate);

    if (placeholderPositions.get(zero)[startingQuote] == zero) {
      wholeParsedTemplate.put(counter
          , completeTemplate.substring(placeholderPositions.get(zero)[startingQuote]
              , placeholderPositions.get(zero)[closingQuote]));
      placeholderKeys.add(zero);
    } else {
      wholeParsedTemplate.put(counter
          , completeTemplate.substring(zero, placeholderPositions.get(zero)[startingQuote]));
      counter++;
      wholeParsedTemplate.put(counter
          , completeTemplate.substring(placeholderPositions.get(zero)[startingQuote]
              , placeholderPositions.get(zero)[closingQuote]));
      placeholderKeys.add(counter);
    }
    counter++;

    for (int i = 1; i < placeholderPositions.size(); i++) {
      Integer prevPHClosingPos = placeholderPositions.get(i - 1)[closingQuote];
      Integer currPHStartingPos = placeholderPositions.get(i)[startingQuote];
      Integer currPlaceholderClosingPos = placeholderPositions.get(i)[closingQuote];

      if (prevPHClosingPos == currPHStartingPos) {
        wholeParsedTemplate.put(counter
            , completeTemplate.substring(currPHStartingPos, currPlaceholderClosingPos));
        placeholderKeys.add(counter);
      } else {
        wholeParsedTemplate.put(counter
            , completeTemplate.substring(prevPHClosingPos, currPHStartingPos));
        counter++;
        wholeParsedTemplate.put(counter
            , completeTemplate.substring(currPHStartingPos, currPlaceholderClosingPos));
        placeholderKeys.add(counter);
      }
      counter++;
    }

    Integer lastPHClosingQuote = placeholderPositions
        .get(placeholderPositions.size() - 1)[closingQuote];

    if (lastPHClosingQuote != completeTemplate.length()) {
      wholeParsedTemplate.put(counter
          , completeTemplate.substring(lastPHClosingQuote, completeTemplate.length() - 1));
    }
  }
}

