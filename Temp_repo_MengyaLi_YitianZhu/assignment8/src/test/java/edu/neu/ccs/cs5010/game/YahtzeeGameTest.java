package edu.neu.ccs.cs5010.game;

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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import edu.neu.ccs.cs5010.client.YahtzeeClient;
import edu.neu.ccs.cs5010.server.YahtzeeServer;
import java.io.ByteArrayInputStream;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * YahtzeeGame Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Dec 3, 2018</pre>
 */
public class YahtzeeGameTest {

  private boolean devMode;
  private int playerNum = 1;
  private YahtzeeGame game;
  private Player player1;

  private String inMsg;
  private String outMsg;

  @Before
  public void before() {
    game = new YahtzeeGame(playerNum);
    player1 = new Player(0);

    game.gameData.add(player1);


    inMsg = "ACK";
    outMsg = "START_TURN: ";
  }

  @After
  public void after() {
  }

  /**
   * Method: checkFinishStatus()
   */
  @Test
  public void testCheckFinishStatusPlayerQuit() {
    player1.quit = true;
    devMode = false;
    assertTrue(game.checkFinishStatus(devMode));
  }

  @Test
  public void testCheckFinishFalse() throws Exception {
    player1.quit = false;
    devMode = false;
    player1.processAction(inMsg, outMsg);
    player1.chooseScore(ACES);
    assertFalse(game.checkFinishStatus(devMode));
  }

//  @Test
//  public void testCheckFinishStatusDevMode() throws Exception {
//    player1.quit = false;
//    devMode = true;
//    player1.processAction(inMsg, outMsg);
//    player1.chooseScore(ACES);
//    player1.processAction(inMsg, outMsg);
//    player1.chooseScore(ACES);
//    player1.processAction(inMsg, outMsg);
//    player1.chooseScore(ACES);
//    assertTrue(game.checkFinishStatus(devMode));
//  }

  @Test
  public void testCheckFinishWholeRounds() throws Exception {
    player1.quit = false;
    devMode = false;
    player1.processAction(inMsg, outMsg);
    player1.chooseScore(ACES);
    player1.processAction(inMsg, outMsg);
    player1.chooseScore(TWOS);
    player1.processAction(inMsg, outMsg);
    player1.chooseScore(THREES);
    player1.processAction(inMsg, outMsg);
    player1.chooseScore(FOURS);
    player1.processAction(inMsg, outMsg);
    player1.chooseScore(FIVES);
    player1.processAction(inMsg, outMsg);
    player1.chooseScore(SIXES);
    player1.processAction(inMsg, outMsg);
    player1.chooseScore(THREE_OF_KIND);
    player1.processAction(inMsg, outMsg);
    player1.chooseScore(FOUR_OF_KIND);
    player1.processAction(inMsg, outMsg);
    player1.chooseScore(SMALL_STRAIGHT);
    player1.processAction(inMsg, outMsg);
    player1.chooseScore(LARGE_STRAIGHT);
    player1.processAction(inMsg, outMsg);
    player1.chooseScore(FULL_HOUSE);
    player1.processAction(inMsg, outMsg);
    player1.chooseScore(CHANCE);
    player1.processAction(inMsg, outMsg);
    player1.chooseScore(YAHTZEE);
    assertTrue(game.checkFinishStatus(devMode));
  }

  /**
   * Method: play(int curPlayer)
   */
  @Test
  public void testPlay() {
//    client.main(clientArgs);
//    ServerSocket serverSocket = new ServerSocket(1300);
//    Socket clientSocket = new Socket("localhost", 1300);
//    Socket client = serverSocket.accept();
//    player1.setSocket(client);
//    game.gameData.get(0).run();
  }

  @Test
  public void getTotalScore() {
//    player1.quit = false;
//    devMode = false;
//    player1.processAction(inMsg, outMsg);
//    player1.chooseScore(ACES);
    assertTrue(0 == player1.getTotalScore());
  }
}
