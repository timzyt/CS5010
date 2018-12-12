package edu.neu.ccs.cs5010.server;

import edu.neu.ccs.cs5010.client.YahtzeeClient;
import edu.neu.ccs.cs5010.game.Player;
import edu.neu.ccs.cs5010.game.YahtzeeGame;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;


/**
 * YahtzeeServer Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Dec 3, 2018</pre>
 */
public class YahtzeeServerTest {

  private YahtzeeServer server;
  //private YahtzeeClient client;
  private String localhost = "localhost";
  private int portNumber = 1200;
  private String DEV = "DEV";
  private int playerNum = 1;
  private String userInput1;
  private String userInput2;
  private String userInput3;
  private String userInput4;

  private YahtzeeGame game;
  private Player player1;
  private Player player2;

  private String[] serverArgs;
  private String[] clientArgs;
  private ByteArrayInputStream inContent;
  private InputStream originalIn;

  @Before
  public void before() throws Exception {
    server = new YahtzeeServer();
    //client = new YahtzeeClient();
    game = new YahtzeeGame(playerNum);
    player1 = new Player(0);
    userInput1 = "1 2 3\r\n1 2\r\nAces";
    userInput2 = "quit\r\n";
    userInput3 = "7\r\n1 2\r\n1\r\nAces";
    userInput4 = "1 2\r\n1\r\nABC\r\nAces";

    serverArgs = new String[]{String.valueOf(portNumber), String.valueOf(playerNum), DEV};
    clientArgs = new String[]{localhost, String.valueOf(portNumber)};

  }

  @After
  public void restoreStreams() {
    System.setIn(originalIn);
  }


  /**
   * Method: initServer(int portNumber, int numPlayer, boolean devMode)
   */
  @Test
  public void testInitServer() throws Exception {

//TODO: Test goes here... 
  }

  /**
   * Method: main(String[] args)
   */
  @Test
  public void testOneRoundInDEVMode() throws Exception {
    inContent = new ByteArrayInputStream(userInput1.getBytes());
    InputStream savedUserInput1 = System.in;
    System.setIn(inContent);
    //server.main(serverArgs);
    new YahtzeeClient().main(clientArgs);
    System.setIn(savedUserInput1);
  }


  /**
   * Method: main(String[] args)
   */
  @Test
  public void testQuit() throws Exception {
    inContent = new ByteArrayInputStream(userInput2.getBytes());
    InputStream savedUserInput1 = System.in;
    System.setIn(inContent);
    //server.main(serverArgs);
    new YahtzeeClient().main(clientArgs);
    System.setIn(savedUserInput1);
  }


  /**
   * Method: main(String[] args)
   */
  @Test
  public void testInvalidKeepDice() throws Exception {
    inContent = new ByteArrayInputStream(userInput3.getBytes());
    InputStream savedUserInput1 = System.in;
    System.setIn(inContent);
    //server.main(serverArgs);
    new YahtzeeClient().main(clientArgs);
    System.setIn(savedUserInput1);
  }


  /**
   * Method: main(String[] args)
   */
  @Test
  public void testInvalidChooseScore() throws Exception {
    inContent = new ByteArrayInputStream(userInput4.getBytes());
    InputStream savedUserInput1 = System.in;
    System.setIn(inContent);
    //server.main(serverArgs);
    new YahtzeeClient().main(clientArgs);
    System.setIn(savedUserInput1);
  }

  @Test
  public void testInvalidClientArgs() throws Exception {
    ExpectedSystemExit exit = ExpectedSystemExit.none();
    exit.expectSystemExit();
    inContent = new ByteArrayInputStream(userInput4.getBytes());
    InputStream savedUserInput1 = System.in;
    System.setIn(inContent);
    //server.main(serverArgs);
    new YahtzeeClient().main(clientArgs);
    System.setIn(savedUserInput1);
  }


  /**
   * Method: hearAll(String str)
   */
  @Test
  public void testHearAll() throws Exception {
//TODO: Test goes here... 
/* 
try { 
   Method method = YahtzeeServer.getClass().getMethod("hearAll", String.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
  }

  /**
   * Method: notifyAll(String str)
   */
  @Test
  public void testNotifyAll() throws Exception {
//TODO: Test goes here... 
/* 
try { 
   Method method = YahtzeeServer.getClass().getMethod("notifyAll", String.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
  }

} 
