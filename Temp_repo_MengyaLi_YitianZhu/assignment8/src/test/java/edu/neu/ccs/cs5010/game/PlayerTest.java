package edu.neu.ccs.cs5010.game;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.net.ServerSocket;
import java.net.Socket;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * Player Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Dec 3, 2018</pre>
 */
public class PlayerTest {

  private Player player;
  private int playerName = 0;
  private String inmsg;
  private String outmsg;

  @Before
  public void before() throws Exception {
    player = new Player(playerName);
  }

  @After
  public void after() throws Exception {
  }

  /**
   * Method: getPlayerName()
   */
  @Test
  public void testGetPlayerName() throws Exception {
    assertTrue(playerName == player.getPlayerName());
  }

  /**
   * Method: setSocket(Socket socket)
   */
  @Test
  public void testSetSocket() throws Exception {
    ServerSocket serverSocket = new ServerSocket(1300);
    Socket clientSocket = new Socket("localhost", 1300);
    Socket client = serverSocket.accept();
    player.setSocket(client);
    serverSocket.close();
    clientSocket.close();
    client.close();
  }

  /**
   * Method: run()
   */
  @Test
  public void testRun() throws Exception {
//TODO: Test goes here... 
  }

  /**
   * Method: processAction(String inmsg, String outmsg)
   */
  @Test
  public void testProcessActionNullInNullOut() throws Exception {
    inmsg = null;
    outmsg = null;
    assertTrue("START_TURN: " == player.processAction(inmsg, outmsg));
  }

  @Test
  public void testProcessActionNullIn_ScoreChoiceValidOut() throws Exception {
    inmsg = null;
    outmsg = "SCORE_CHOICE_VALID";
    assertTrue("TURN_OVER: " == player.processAction(inmsg, outmsg));
  }

  @Test
  public void testProcessActionKeepDiceIn_ScoreChoiceValidOut() throws Exception {
    inmsg = "KEEP_DICE";
    outmsg = "SCORE_CHOICE_VALID";
//    player.processAction(inmsg, outmsg);
    assertTrue(player.processAction(inmsg, outmsg).contains("CHOOSE_DICE: "));
  }

  @Test
  public void testProcessActionKeepDiceIn_ValidDiceKeep() throws Exception {
    inmsg = "KEEP_DICE: 1 2";
    outmsg = "SCORE_CHOICE_VALID";
//    player.processAction(inmsg, outmsg);
    assertTrue(player.processAction(inmsg, outmsg).contains("CHOOSE_DICE: "));
  }

  @Test
  public void testProcessActionKeepDiceIn_InvalidDiceKeep() throws Exception {
    inmsg = "KEEP_DICE: 7 8";
    outmsg = "SCORE_CHOICE_VALID";
//    player.processAction(inmsg, outmsg);
    assertTrue(player.processAction(inmsg, outmsg).contains("INVALID_DICE_CHOICE:"));
  }

  @Test
  public void testProcessActionSecondTurn() throws Exception {
    inmsg = "KEEP_DICE: 1 2";
    outmsg = "SCORE_CHOICE_VALID";
    player.processAction(inmsg, outmsg);
    inmsg = "KEEP_DICE: 1 2";
    outmsg = "SCORE_CHOICE_VALID";
    assertTrue(player.processAction(inmsg, outmsg).contains("CHOOSE_SCORE: "));
  }

  @Test
  public void testProcessActionValidScoreChoice() throws Exception {
    inmsg = "SCORE_CHOICE: Aces";
    outmsg = "SCORE_CHOICE_VALID";
    assertTrue(player.processAction(inmsg, outmsg).contains("SCORE_CHOICE_VALID: "));
  }


  @Test
  public void testProcessActionInvalidScoreChoice() throws Exception {
    inmsg = "SCORE_CHOICE: ABCS";
    outmsg = "SCORE_CHOICE_VALID";
//    player.processAction(inmsg, outmsg);
    assertTrue(player.processAction(inmsg, outmsg).contains("SCORE_CHOICE_INVALID: "));
  }

  @Test
  public void testProcessActionQuitGame() throws Exception {
    inmsg = "QUIT_GAME";
    outmsg = "SCORE_CHOICE_VALID";
//    player.processAction(inmsg, outmsg);
    assertTrue(player.processAction(inmsg, outmsg).contains("QUIT_GAME"));
  }

  /**
   * Method: validPattern()
   */
  @Test
  public void testValidPattern() throws Exception {
//TODO: Test goes here... 
  }

  /**
   * Method: checkValidScores(String str)
   */
  @Test
  public void testCheckValidScores() throws Exception {
//TODO: Test goes here... 
  }

  /**
   * Method: chooseScore(String pattern)
   */
  @Test
  public void testChooseScore() throws Exception {
//TODO: Test goes here... 
  }

  /**
   * Method: printPatterns()
   */
  @Test
  public void testPrintPatterns() throws Exception {

  }

  /**
   * Method: getScoredPattern()
   */
  @Test
  public void testGetScoredPattern() throws Exception {
//TODO: Test goes here... 
  }

  /**
   * Method: printGameState()
   */
  @Test
  public void testPrintGameState() throws Exception {
    player.printGameState();
  }


} 
