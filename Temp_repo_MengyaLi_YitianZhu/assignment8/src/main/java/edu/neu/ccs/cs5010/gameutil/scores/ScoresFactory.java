package edu.neu.ccs.cs5010.gameutil.scores;

import static edu.neu.ccs.cs5010.gameutil.scores.AbstractScore.ACES;
import static edu.neu.ccs.cs5010.gameutil.scores.AbstractScore.CHANCE;
import static edu.neu.ccs.cs5010.gameutil.scores.AbstractScore.FIVES;
import static edu.neu.ccs.cs5010.gameutil.scores.AbstractScore.FOURS;
import static edu.neu.ccs.cs5010.gameutil.scores.AbstractScore.FOUR_OF_KIND;
import static edu.neu.ccs.cs5010.gameutil.scores.AbstractScore.FULL_HOUSE;
import static edu.neu.ccs.cs5010.gameutil.scores.AbstractScore.LARGE_STRAIGHT;
import static edu.neu.ccs.cs5010.gameutil.scores.AbstractScore.SIXES;
import static edu.neu.ccs.cs5010.gameutil.scores.AbstractScore.SMALL_STRAIGHT;
import static edu.neu.ccs.cs5010.gameutil.scores.AbstractScore.THREES;
import static edu.neu.ccs.cs5010.gameutil.scores.AbstractScore.THREE_OF_KIND;
import static edu.neu.ccs.cs5010.gameutil.scores.AbstractScore.TWOS;
import static edu.neu.ccs.cs5010.gameutil.scores.AbstractScore.YAHTZEE;

/**
 * Scores factory class.
 */
public class ScoresFactory {

  /**
   * Make concrete score class.
   *
   * @param pattern the pattern string
   * @return the abstract score type
   */
  public AbstractScore makeScore(String pattern) {
    if (ACES.contentEquals(pattern)) {
      return new AcesScore();
    } else if (TWOS.contentEquals(pattern)) {
      return new TwosScore();
    } else if (THREES.contentEquals(pattern)) {
      return new ThreesScore();
    } else if (FOURS.contentEquals(pattern)) {
      return new FoursScore();
    } else if (FIVES.contentEquals(pattern)) {
      return new FivesScore();
    } else if (SIXES.contentEquals(pattern)) {
      return new SixesScore();
    } else if (THREE_OF_KIND.contentEquals(pattern)) {
      return new ThreeOfKindScore();
    } else if (FOUR_OF_KIND.contentEquals(pattern)) {
      return new FourOfKindScore();
    } else if (SMALL_STRAIGHT.contentEquals(pattern)) {
      return new SmallStraightScore();
    } else if (LARGE_STRAIGHT.contentEquals(pattern)) {
      return new LargeStraightScore();
    } else if (FULL_HOUSE.contentEquals(pattern)) {
      return new FullHouseScore();
    } else if (YAHTZEE.contentEquals(pattern)) {
      return new YahtzeeScore();
    } else if (CHANCE.contentEquals(pattern)) {
      return new ChanceScore();
    }
    return null;
  }
}
