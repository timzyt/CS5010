package edu.neu.ccs.cs5010.assignment5.model;

import edu.neu.ccs.cs5010.assignment5.exceptions.EmptyArgumentException;
import edu.neu.ccs.cs5010.assignment5.exceptions.NullArgumentException;
import edu.neu.ccs.cs5010.assignment5.util.BufferredReaderUtil;
import edu.neu.ccs.cs5010.assignment5.util.FileCombineUtil;
import edu.neu.ccs.cs5010.assignment5.util.PlaceholderFinderUtil;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Template Processor class.
 */
public class TemplateProcessor {

  /**
   * Bufferred Reader utility.
   */
  BufferredReaderUtil newBru = new BufferredReaderUtil();
  /**
   * List of strings to host result from Bufferred Reader utility.
   */
  List<String> rawTemplate;
  /**
   * Placeholder Finder utility.
   */
  PlaceholderFinderUtil newFinder = new PlaceholderFinderUtil();
  /**
   * File Combine utility.
   */
  FileCombineUtil fileCombineUtil = new FileCombineUtil();
  /**
   * String to host the result from File Combine utility.
   */
  String completeTemplate;
  /**
   * List of all the pairs of the placeholders' starting and closing bracket positions.
   */
  List<Integer[]> placeholderPositions;
  /**
   * The complete breakdown of the template string.
   */
  Map<Integer, String> wholeParsedTemplate;
  /**
   * The set of indexes only for placeholders.
   */
  Set<Integer> placeholderKeys;
  /**
   * The Counter.
   */
  Integer counter;
  /**
   * Representation for integer 0.
   */
  Integer zero = 0;
  /**
   * Representation for integer 0 for the index of the starting bracket.
   */
  Integer startingQuote = 0;
  /**
   * Representation for integer 1 for the index of the closing bracket.
   */
  Integer closingQuote = 1;

  /**
   * Return the complete breakdown of the string template stored in HashMap.
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

  /**
   * Given the template file name, return only the list of positions for placeholders.
   *
   * @param fileName String value of the template file name.
   * @return Set of all the positions of placeholders.
   * @throws Exception NullArgumentException or EmptyArgumentException.
   */
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
   * Given a template file name, break down the template into placeholders and non-placeholders
   *
   * @param fileName String value of the template file name.
   * @throws Exception NullArgumentException or EmptyArgumentException.
   */
  public void parseTemplate(String fileName) throws Exception {
    rawTemplate = new ArrayList<>();
    wholeParsedTemplate = new HashMap<>();
    placeholderKeys = new HashSet<>();
    counter = 0;

    rawTemplate = newBru.read(fileName);
    completeTemplate = fileCombineUtil.combineStringList(rawTemplate);
    placeholderPositions = newFinder.findAllPlaceholdersPosition(completeTemplate);

    if (placeholderPositions.get(zero)[startingQuote].equals(zero)) {
      wholeParsedTemplate.put(counter,
          completeTemplate.substring(placeholderPositions.get(zero)[startingQuote],
              placeholderPositions.get(zero)[closingQuote]));
      placeholderKeys.add(zero);
    } else {
      wholeParsedTemplate.put(counter,
          completeTemplate.substring(zero, placeholderPositions.get(zero)[startingQuote]));
      counter++;
      wholeParsedTemplate.put(counter,
          completeTemplate.substring(placeholderPositions.get(zero)[startingQuote],
              placeholderPositions.get(zero)[closingQuote]));
      placeholderKeys.add(counter);
    }
    counter++;

    for (int i = 1; i < placeholderPositions.size(); i++) {
      Integer prevPlaceholderClosingPos = placeholderPositions.get(i - 1)[closingQuote];
      Integer currPlaceholderStartingPos = placeholderPositions.get(i)[startingQuote];
      Integer currPlaceholderClosingPos = placeholderPositions.get(i)[closingQuote];

      if (prevPlaceholderClosingPos.equals(currPlaceholderStartingPos)) {
        wholeParsedTemplate.put(counter,
            completeTemplate.substring(currPlaceholderStartingPos, currPlaceholderClosingPos));
        placeholderKeys.add(counter);
      } else {
        wholeParsedTemplate.put(counter,
            completeTemplate.substring(prevPlaceholderClosingPos, currPlaceholderStartingPos));
        counter++;
        wholeParsedTemplate.put(counter,
            completeTemplate.substring(currPlaceholderStartingPos, currPlaceholderClosingPos));
        placeholderKeys.add(counter);
      }
      counter++;
    }

    Integer lastPlaceholderClosingQuote = placeholderPositions
        .get(placeholderPositions.size() - 1)[closingQuote];

    if (lastPlaceholderClosingQuote != completeTemplate.length()) {
      wholeParsedTemplate.put(counter,
          completeTemplate.substring(lastPlaceholderClosingQuote, completeTemplate.length() - 1));
    }
  }
}

