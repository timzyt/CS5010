package edu.neu.ccs.cs5010.game;

import edu.neu.ccs.cs5010.gameutil.scores.ScoresFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Object class to store the playerData. Including playerName, the playerImpl's scorecard. set of
 * dice and the total score.
 */
public class Player {

  private int playerName;
  private int turn;
  private Map<String, Integer> scorecard;
  private SetOfDice sod;
  private ScoresFactory scoreFactory;
  private int totalScore = 0;
  //private boolean chooseScorePattern = false;
  /**
   * The Socket.
   */
  public Socket socket;
  /**
   * The Input.
   */
  public BufferedReader input;
  /**
   * The Output.
   */
  public PrintWriter output;
  /**
   * The Inmsg.
   */
  public String inmsg;
  /**
   * The Outmsg.
   */
  public String outmsg;
  /**
   * The Pattern.
   */
  public String[] pattern;
  /**
   * The Quit.
   */
  public boolean quit;


  /**
   * Instantiates a new Player.
   *
   * @param playerName the player name
   */
  public Player(int playerName) {
    this.playerName = playerName;
    this.quit = false;
    this.turn = 0;
    this.pattern = new String[]{"Aces", "Twos", "Threes", "Fours", "Fives", "Sixes", "ThreeOfKind",
        "FourOfKind",
        "FullHouse", "SmallStraight", "LargeStraight", "Yahtzee", "Chance"};
    this.scorecard = new HashMap<>();
    this.sod = new SetOfDice();
    this.scoreFactory = new ScoresFactory();
  }


  public int getPlayerName() {
    return playerName;
  }


  /**
   * Sets socket.
   *
   * @param socket the socket
   */
  public void setSocket(Socket socket) {
    this.socket = socket;
    try {
      this.input = new BufferedReader(
          new InputStreamReader(this.socket.getInputStream(), StandardCharsets.UTF_8));
      this.output = new PrintWriter(
          new OutputStreamWriter(this.socket.getOutputStream(), StandardCharsets.UTF_8), true);
    } catch (Exception e) {
      System.out.println("Player died: " + e);
    }
  }

  /**
   * Run method of the Thread class.
   */
  public void run() {
    try {
      // Repeatedly get commands from the client and process them.
      System.out.println("START_ROUND: " + (1 + this.scorecard.size()));
      System.out.println(this.socket);
      this.input = new BufferedReader(
          new InputStreamReader(this.socket.getInputStream(), StandardCharsets.UTF_8));
      this.output = new PrintWriter(
          new OutputStreamWriter(this.socket.getOutputStream(), StandardCharsets.UTF_8), true);
      this.inmsg = null;
      this.outmsg = null;
      this.turn = 0;
      output.println("START_ROUND: " + (1 + this.scorecard.size()));

      while ((this.inmsg = input.readLine()) != null) {
        if (this.outmsg != null /*&& this.inmsg != null*/
            && this.outmsg.indexOf("CHOOSE_DICE") != -1
            && this.inmsg.indexOf("ACK") != -1) {
          continue;
        }
        if (this.inmsg.indexOf("PRINT_GAME_STATE") != -1) {
          this.printGameState();
          output.println(this.outmsg);
          continue;
        }
        //System.out.println("\nFrom last server, " + this.outmsg);
        System.out.println("\nFrom client, " + this.inmsg);
        this.outmsg = this.processAction(this.inmsg, this.outmsg);
        output.println(this.outmsg);
        System.out.println("From server, " + this.outmsg);
        if (this.outmsg != null && (this.outmsg.indexOf("TURN_OVER") != -1
            || this.outmsg.indexOf("QUIT_GAME") != -1)) {
          break;
        }
      }
      this.outmsg = null;

    } catch (IOException e) {
      System.out.println("Player died: " + e);
    }
  }


  /**
   * Process action string.
   *
   * @param inmsg the inmsg
   * @param outmsg the outmsg
   * @return the string
   */
  public String processAction(String inmsg, String outmsg) {
    System.out.println("Now is player, " + this.playerName);
    System.out.println("Turn, " + this.turn);
    //System.out.println("InputMSG, " + inmsg);
    //System.out.println("OutputMSG, " + outmsg);

    if ((inmsg != null && inmsg.indexOf("ACK") != -1) || inmsg == null) {
      if (outmsg == null) {
        outmsg = "START_TURN: ";
      } else if (outmsg.indexOf("START_TURN: ") != -1) {
        sod.rollAllDice();
        outmsg = "CHOOSE_DICE: " + sod.toString();
        System.out.println("ACK then CHOOSE DICE");
      } else if (outmsg.indexOf("SCORE_CHOICE_VALID") != -1) {
        outmsg = "TURN_OVER: ";
      }
    } else if (inmsg.indexOf("KEEP_DICE") != -1) {
      System.out.println(inmsg);
      String[] toKeep = inmsg.split(": ");
      if (toKeep.length != 2) {
        sod.rollAllDice();
        outmsg = "CHOOSE_DICE: " + sod.toString();
        this.turn += 1;
      } else {
        if (sod.checkValidSelection(toKeep[1]) != true) {
          outmsg = "INVALID_DICE_CHOICE: ";
        } else {
          int[] keep = Arrays.stream(toKeep[1].split(" ")).mapToInt(Integer::parseInt).toArray();
          sod.rollSelectedDice(keep);
          outmsg = "CHOOSE_DICE: " + sod.toString();
          this.turn += 1;

        }
      }
      if (this.turn == 2) {
        outmsg = "CHOOSE_SCORE: " + sod.toString() + this.validPattern();
      }
    } else if (inmsg.indexOf("SCORE_CHOICE") != -1) {
      String scoreChoice = inmsg.split("SCORE_CHOICE: ")[1];
      if (!this.checkValidScores(scoreChoice)) {
        outmsg = "SCORE_CHOICE_INVALID: ";
      } else {
        try {
          this.chooseScore(scoreChoice);
        } catch (Exception e) {
          e.printStackTrace();
        }
        outmsg = "SCORE_CHOICE_VALID: " + this.printPatterns() + "Total " + this.totalScore;
      }
    } else if (inmsg.equalsIgnoreCase("QUIT_GAME")) {
      System.out.println("updating QUIT_Status");
      this.quit = true;
      outmsg = "QUIT_GAME";
    }
    //System.out.println("Final Outmsg, " + outmsg);

    return outmsg;
  }

  /**
   * Valid pattern string.
   *
   * @return the string
   */
  public String validPattern() {
    StringBuilder res = new StringBuilder();
    for (String str : this.pattern) {
      if (!this.scorecard.containsKey(str)) {
        res.append(" ").append(str);
      }
    }
    return res.toString();
  }

  /**
   * Check if provide string of score selection is valid.
   *
   * @param str the string
   * @return the boolean
   */
  public boolean checkValidScores(String str) {
    return !this.scorecard.containsKey(str) && Arrays.asList(this.pattern).contains(str);
  }

  /**
   * Choose score.
   *
   * @param pattern the pattern
   * @throws Exception the exception
   */
  public void chooseScore(String pattern) throws Exception {
    int patternScore = scoreFactory.makeScore(pattern).chooseThisPattern(sod);
    scorecard.put(pattern, patternScore);
    this.totalScore += patternScore;
  }

  /**
   * Print patterns string.
   *
   * @return the string
   */
  public String printPatterns() {
    StringBuilder res = new StringBuilder();
    for (String p : this.pattern) {
      if (this.scorecard.containsKey(p)) {
        res.append(p).append(" ").append(this.scorecard.get(p)).append(" ");
      } else {
        res.append(p).append(" ").append("-1 ");
      }
    }
    return res.toString();
  }

  /**
   * Gets scored pattern.
   *
   * @return the scored pattern
   */
  public int getScoredPattern() {
    return this.scorecard.size();
  }

  /**
   * Print the game state.
   */
  public void printGameState() {
    System.out.println("\n******* YAHTZEE Game State *******");
    System.out.println("Current round: " + this.scorecard.size() + 1);
    System.out.println("Current player: " + this.playerName);
    System.out.println("Num Rolls so far: " + this.turn);
    System.out.println("Current Dice Values: " + this.sod.toString());
    System.out.println("---------------------------------------------------------------");
    System.out.println("Player " + this.playerName + " Scorecard");
    for (String p : this.pattern) {
      if (this.scorecard.containsKey(p)) {
        System.out.print(p + " " + this.scorecard.get(p) + " ");
      } else {
        System.out.print(p + " -1 ");
      }
    }
    System.out.println("\nTotal Score: " + this.totalScore);
    System.out.println("---------------------------------------------------------------");
  }

  /**
   * Get totalScore of the player.
   *
   * @return totalScore
   */
  public int getTotalScore() {
    return totalScore;
  }
}