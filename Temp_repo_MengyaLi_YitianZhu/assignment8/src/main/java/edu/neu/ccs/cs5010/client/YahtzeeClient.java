package edu.neu.ccs.cs5010.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * Yahtzee client class.
 */
public class YahtzeeClient {

  /**
   * The standard input.
   */
  public BufferedReader stdIn;

  private static final String CHOOSE_SCORE = "CHOOSE_SCORE";
  private static final String SCORE_CHOICE_INVALID = "SCORE_CHOICE_INVALID";
  private static final String INVALID_DICE_CHOISE = "INVALID_DICE_CHOICE";
  private static final String CHOOSE_DICE = "CHOOSE_DICE";
  private static final String ACK = "ACK";
  private static final String TURN_OVER = "TURN_OVER";
  private static final String GAME_OVER = "GAME_OVER";
  private String userIn;

  /**
   * The entry point of application.
   *
   * @param args the input arguments
   * @throws IOException the io exception
   */
  public static void main(String[] args) throws IOException {
    if (args.length != 2) {
      System.err.println("Usage: java GameClient <host name> <port number>");
      System.exit(1);
    }

    String hostName = args[0];
    int portNumber = Integer.parseInt(args[1]);
    YahtzeeClient client = new YahtzeeClient();
    client.runClient(hostName, portNumber);
  }

  /**
   * Instantiates a new Yahtzee client.
   */
  public YahtzeeClient() {
    this.stdIn = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
  }

  private void runClient(String hostName, int portNumber) {
    int msgCounter = 0;
    String inmsg = null;
    String outmsg = null;
    try {
      Socket socket = new Socket(hostName, portNumber);
      PrintWriter output = new PrintWriter(
          new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8), true);
      BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream(),
          StandardCharsets.UTF_8));

      while ((inmsg = input.readLine()) != null) {
        if (inmsg.equals("")) {
          continue;
        }
        System.out.println("\nFrom Server: " + msgCounter + " " + inmsg);
        msgCounter += 1;
        outmsg = this.processClientAction(inmsg);
        if (this.userIn != null && this.userIn.indexOf("PRINT_GAME_STATE") != -1) {
          outmsg = this.userIn;
        }
        System.out.println("From Client: " + msgCounter + " " + outmsg);
        msgCounter += 1;
        if (outmsg != null) {
          output.println(outmsg);
        }
        /*
        if (outmsg.indexOf("QUIT_GAME") != -1) {
          outmsg = null;
          output.println(outmsg);
        }
        */
        if (inmsg.indexOf("GAME_OVER") != -1) {
          break;
        }
      }
      output.println("CLIENT_QUIT_SUCCESSFULLY");
      System.out.println("closing socket");
      socket.close();
    } catch (Exception ie) {
      System.out.println(inmsg);
      ie.printStackTrace();
    }
  }

  private String processClientAction(String inmsg) throws Exception {
    return getResponse(inmsg);
  }

  private String getResponse(String fromServer) {
    String state = fromServer.split(": ")[0];
    switch (state) {
      case TURN_OVER:
        return "";
      case CHOOSE_SCORE:
        return this.getKeepScore(fromServer);
      case SCORE_CHOICE_INVALID:
        return this.getKeepScore(fromServer);
      case CHOOSE_DICE:
        return this.getKeepDiceFrame();
      case INVALID_DICE_CHOISE:
        return this.getKeepDiceFrame();
      case GAME_OVER:
        return GAME_OVER;
      default:
        return ACK;
    }
  }

  private String getKeepScore(String fromServer) {
    try {
      System.out.println("Enter the Score you want to take:  " + fromServer);

      this.userIn = this.stdIn.readLine();
      if (this.userIn.isEmpty()) {
        this.userIn = "A";
      }
      if (this.userIn.equals("quit")) {
        return "QUIT_GAME";
      }
      return "SCORE_CHOICE: " + this.userIn;
    } catch (IOException ie) {
      ie.printStackTrace();
      return "2: 1 1 1 1 1";
    } catch (NullPointerException ie) {
      ie.printStackTrace();
      return "2: 1 1 1 1 1";
    }
  }

  /*private String getKeepDiceFrame(String fromServer, String userIn) {*/
  private String getKeepDiceFrame() {
    try {
      System.out.println("Enter numbers for the ones you want to keep, 1-5. ");
      if ((this.userIn = this.stdIn.readLine()) != null) {
        this.userIn = this.userIn.trim();
      }

      if (this.userIn.isEmpty()) {
        this.userIn = "";
      }
      if (this.userIn.equals("quit")) {
        return "QUIT_GAME";
      }
      return "KEEP_DICE: " + this.userIn;
    } catch (IOException ie) {
      ie.printStackTrace();
      return "2: 1 1 1 1 1";
    } catch (NullPointerException ie) {
      ie.printStackTrace();
      return "2: 1 1 1 1 1";
    }
  }
}
