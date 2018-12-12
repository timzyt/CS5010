//package edu.neu.ccs.cs5010.client;
//
//import edu.neu.ccs.cs5010.game.Player;
//import edu.neu.ccs.cs5010.game.YahtzeeGame;
//import edu.neu.ccs.cs5010.server.YahtzeeServer;
//import java.io.ByteArrayInputStream;
//
//import org.junit.Test;
//import org.junit.Before;
//import org.junit.After;
//
//
///**
// * YahtzeeClient Tester.
// *
// * @author <Authors name>
// * @version 1.0
// * @since <pre>Dec 3, 2018</pre>
// */
//public class YahtzeeClientTest {
//
//  private YahtzeeClient client;
//  private String localhost = "localhost";
//  private int portNumber = 1200;
//  private String DEV = "DEV";
//  private int playerNum = 1;
//  private String userInput1;
//  private String userInput2;
//
//
//  private YahtzeeGame game;
//  private Player player1;
//  private Player player2;
//
//
//  private ByteArrayInputStream inContent;
//
//  @Before
//  public void before() throws Exception {
//    client = new YahtzeeClient();
//    game = new YahtzeeGame(playerNum);
//    player1 = new Player(0);
//
//    userInput1 = "1 2 3\r\n1 2\r\nAces";
//    userInput2 = "quit\r\n";
//
//  }
//
//  @After
//  public void after() throws Exception {
//  }
//
//  /**
//   * Method: main(String[] args)
//   */
//  @Test
//  public void testMain() throws Exception {
////    inContent = new ByteArrayInputStream(userInput1.getBytes());
////    InputStream savedUserInput1 = System.in;
////    System.setIn(inContent);
////    //server.main(serverArgs);
////    //mockServer.main(serverArgs);
////    client.main(clientArgs);
////    System.setIn(savedUserInput1);
//  }
//
//
//  /**
//   * Method: runClient(String hostName, int portNumber)
//   */
//  @Test
//  public void testRunClient() throws Exception {
////TODO: Test goes here...
///*
//try {
//   Method method = YahtzeeClient.getClass().getMethod("runClient", String.class, int.class);
//   method.setAccessible(true);
//   method.invoke(<Object>, <Parameters>);
//} catch(NoSuchMethodException e) {
//} catch(IllegalAccessException e) {
//} catch(InvocationTargetException e) {
//}
//*/
//  }
//
//  /**
//   * Method: processClientAction(String inmsg)
//   */
//  @Test
//  public void testProcessClientAction() throws Exception {
////TODO: Test goes here...
///*
//try {
//   Method method = YahtzeeClient.getClass().getMethod("processClientAction", String.class);
//   method.setAccessible(true);
//   method.invoke(<Object>, <Parameters>);
//} catch(NoSuchMethodException e) {
//} catch(IllegalAccessException e) {
//} catch(InvocationTargetException e) {
//}
//*/
//  }
//
//  /**
//   * Method: getResponse(String fromServer)
//   */
//  @Test
//  public void testGetResponse() throws Exception {
////TODO: Test goes here...
///*
//try {
//   Method method = YahtzeeClient.getClass().getMethod("getResponse", String.class);
//   method.setAccessible(true);
//   method.invoke(<Object>, <Parameters>);
//} catch(NoSuchMethodException e) {
//} catch(IllegalAccessException e) {
//} catch(InvocationTargetException e) {
//}
//*/
//  }
//
//  /**
//   * Method: getKeepScore(String fromServer)
//   */
//  @Test
//  public void testGetKeepScore() throws Exception {
////TODO: Test goes here...
///*
//try {
//   Method method = YahtzeeClient.getClass().getMethod("getKeepScore", String.class);
//   method.setAccessible(true);
//   method.invoke(<Object>, <Parameters>);
//} catch(NoSuchMethodException e) {
//} catch(IllegalAccessException e) {
//} catch(InvocationTargetException e) {
//}
//*/
//  }
//
//  /**
//   * Method: getKeepDiceFrame(String userIn)
//   */
//  @Test
//  public void testGetKeepDiceFrame() throws Exception {
////  try {
////     Method method = YahtzeeClient.getClass().getMethod("getKeepDiceFrame", String.class);
////     method.setAccessible(true);
////     method.invoke(<Object>, <Parameters>);
////  } catch(NoSuchMethodException e) {
////  } catch(IllegalAccessException e) {
////  } catch(InvocationTargetException e) {
////  }
//  }
//
//}
