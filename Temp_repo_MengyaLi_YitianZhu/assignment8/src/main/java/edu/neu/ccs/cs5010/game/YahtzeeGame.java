package edu.neu.ccs.cs5010.game;

import java.util.ArrayList;
import java.util.List;


/**
 * class to store all the game data including playerData and the associated socket.
 */
public class YahtzeeGame {

  /**
   * The Game data.
   */
  public List<Player> gameData;
  /**
   * The Num player.
   */
  public int numPlayer;

  //public boolean finished;

  /**
   * Instantiates a new Yahtzee game.
   *
   * @param numPlayer the num player
   */
  public YahtzeeGame(int numPlayer) {
    this.numPlayer = numPlayer;
    this.gameData = new ArrayList<>();
  }

  /**
   * Check finish status boolean.
   *
   * @return the boolean
   */
  public boolean checkFinishStatus(boolean devMode) {
    boolean res = true;
    for (Player player : this.gameData) {
      if (player.quit == true) {
        return true;
      }
      if ((devMode && player.getScoredPattern() != 3)
          || (!devMode && player.getScoredPattern() != 13)) {
        res = false;
      }
    }
    return res;
  }

  /**
   * Play.
   *
   * @param curPlayer the cur player
   */
  public void play(int curPlayer) {
    this.gameData.get(curPlayer).run();

  }
}
