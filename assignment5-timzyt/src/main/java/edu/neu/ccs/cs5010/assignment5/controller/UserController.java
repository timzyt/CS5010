package edu.neu.ccs.cs5010.assignment5.controller;

import edu.neu.ccs.cs5010.assignment5.model.CmdProcessor;

import java.util.HashMap;
import java.util.Scanner;

import picocli.CommandLine;

/**
 * The User controller class.
 */
public class UserController {

  /**
   * The main class, entry point of application.
   *
   * @param args the input arguments from user input.
   */
  public static void main(String[] args) {
    String email = "--email";
    String letter = "--letter";
    String emailTemplate = "--email-template";
    String letterTemplate = "--letter-template";
    String outputDir = "--output-dir";
    String csvFile = "--csv-file";

    HashMap<String, String> cmdPairs = new HashMap<>();
    cmdPairs.put(email, emailTemplate);
    cmdPairs.put(letter, letterTemplate);

    System.out.println(System.getProperty("user.dir"));

    try (
        Scanner cmdInput = new Scanner(System.in, "UTF-8")) {
      boolean checkInput = false;
      String newCmdInputStr = cmdInput.nextLine();
      String[] newCmdInput = newCmdInputStr.split(" ");
      CmdProcessor newCmdProcessor = new CmdProcessor();
      if (!newCmdInputStr.contains(outputDir)) {
        System.out.printf("Error: Missing command %s.\r\n\r\n", outputDir);
      }
      if (!newCmdInputStr.contains(csvFile)) {
        System.out.printf("Error: Missing command %s.\r\n\r\n", csvFile);
        checkInput = true;
      }
      if (newCmdInputStr.contains(email) && newCmdInputStr.contains(letter)) {
        System.out.println("Error: Conflicting command line argument was provided.\r\n\r\n");
        checkInput = true;
      }
      for (String key : cmdPairs.keySet()) {
        if (newCmdInputStr.contains(key) && !newCmdInputStr.contains(cmdPairs.get(key))) {
          System.out.printf("Error: %s provided but no %s was given.\r\n\r\n", key,
              cmdPairs.get(key));
          checkInput = true;

        }
      }
      if (checkInput) {
        CommandLine.usage(newCmdProcessor, System.out);
        System.exit(0);
      }

      new CommandLine(newCmdProcessor).parse(newCmdInput);
      newCmdProcessor.runMailGenerator();


    } catch (Exception e) {
      System.out.println(e.getMessage());
      e.printStackTrace();
    }
  }
}
