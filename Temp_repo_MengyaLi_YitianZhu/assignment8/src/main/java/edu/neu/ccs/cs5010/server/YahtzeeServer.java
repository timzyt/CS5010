package edu.neu.ccs.cs5010.server;

import static edu.neu.ccs.cs5010.game.SetOfDice.ONE;

import edu.neu.ccs.cs5010.game.Player;
import edu.neu.ccs.cs5010.game.YahtzeeGame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * The Yahtzee server class.
 */
public class YahtzeeServer {

  static final String DEV_OPTION = "DEV";
  /**
   * The constant DEFAULT_PLAYER_NUMBER.
   */
  public static final int DEFAULT_PLAYER_NUMBER = 2;
  /**
   * The Num player.
   */
  public int numPlayer;
  /**
   * The Cur player.
   */
  public int curPlayer;
  /**
   * The Game.
   */
  public YahtzeeGame game;

  /**
   * Instantiates a new Yahtzee server.
   */
  public YahtzeeServer() {
    //this.game = new YahtzeeGame(numPlayer);
  }

  /**
   * Initiate server.
   *
   * @param portNumber the port number
   * @param numPlayer the num player
   */
  public void initServer(int portNumber, int numPlayer, boolean devMode) {
    this.numPlayer = numPlayer;
    this.curPlayer = 0;
    try {
      ServerSocket serverSocket = new ServerSocket(portNumber);
      System.out.println("Starting server.....");
      System.out.println("Waiting for clients.......");
      this.game = new YahtzeeGame(numPlayer);
      System.out.println(numPlayer);
      while (game.gameData.size() != game.numPlayer) {
        Socket client = serverSocket.accept();
        game.gameData.add(new Player(this.curPlayer));
        game.gameData.get(curPlayer).setSocket(client);
        curPlayer++;
        System.out.println(game.gameData.size() + " player(s) joined, expect " + game.numPlayer
            + " play(s) to start game.");
      }
      this.notifyAll("START_GAME: ");
      //System.out.println("Finished status, " + game.checkFinishStatus(devMode));
      while (!game.checkFinishStatus(devMode) || !this.hearAll("CLIENT_QUIT")) {
        for (int curPlayer = 0; curPlayer < this.numPlayer; curPlayer++) {
          System.out.println("Current PLayer is " + curPlayer);
          game.play(curPlayer);
          //System.out.println("Finishing status is: " + game.checkFinishStatus(devMode));
          if (game.checkFinishStatus(devMode)) {
            this.notifyAll("GAME_OVER: ");
            Player winner = new Player(0);
            int curScore = winner.getTotalScore();
            for (Player player : game.gameData) {
              if (player.getTotalScore() > curScore) {
                winner = player;
                curScore = player.getTotalScore();
              }
            }
            System.out.println("The winner is: " + winner.getPlayerName());
            System.out.println("The total score is " + curScore);
          }
        }
      }
      TimeUnit.SECONDS.sleep(2);
      serverSocket.close();

    } catch (IOException | InterruptedException e) {
      System.out.println("Game Over");
    }
  }

  private boolean hearAll(String str) throws IOException, InterruptedException {
    ArrayList<String> response = new ArrayList<>();
    for (Player player : this.game.gameData) {
      BufferedReader userIn = new BufferedReader(
          new InputStreamReader(player.socket.getInputStream(), StandardCharsets.UTF_8));
      String input;
      if ((input = userIn.readLine()) != null && input.indexOf(str) != -1) {
        response.add(input);
      }
    }
    return response.size() == this.game.numPlayer;
  }

  private void notifyAll(String str) throws IOException, InterruptedException {
    for (Player player : this.game.gameData) {
      PrintWriter output = player.output;
      System.out.println(player.getPlayerName() + " : " + str);
      output.println(player.getPlayerName() + " - " + str);
    }
  }

  /**
   * The entry point of application.
   *
   * @param args the input arguments
   */
  public static void main(String[] args) {
    if (args.length < ONE) {
      System.err.println("Usage: java YahtzeeServer <port number>");
      System.exit(ONE);
    }
    int numPlayer = DEFAULT_PLAYER_NUMBER;

    boolean devMode = false;

    //portNumber + playerNum
    if (args.length == 2
        && (!args[1].contentEquals(DEV_OPTION))) {
      numPlayer = Integer.parseInt(args[1]);
    }

    //portNumber + DEV
    if (args.length == 2
        && (args[1].contentEquals(DEV_OPTION))) {
      devMode = true;
    }

    //portNumber + DEV + playerNum
    if (args.length == 3) {
      numPlayer = Integer.parseInt(args[1]);
      devMode = true;
    }
    int portNumber = Integer.parseInt(args[0]);
    YahtzeeServer server = new YahtzeeServer();
    server.initServer(portNumber, numPlayer, devMode);

  }
}