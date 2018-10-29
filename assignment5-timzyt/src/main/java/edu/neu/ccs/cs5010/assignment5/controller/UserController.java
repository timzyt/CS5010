package edu.neu.ccs.cs5010.assignment5.controller;

import edu.neu.ccs.cs5010.assignment5.model.CmdProcessor;

import picocli.CommandLine;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


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
      CmdProcessor newCmdProcessor = new CmdProcessor();
      //boolean variable to indicate whether input is found having error
      boolean checkInput = false;
      String newCmdInputStr = cmdInput.nextLine();
      final String[] newCmdInput = newCmdInputStr.split(" ");
      if (!newCmdInputStr.contains(email) && !newCmdInputStr.contains(letter)) {
        System.err.printf("Error: Missing command %s or %s.%n%n", email, letter);
        System.exit(0);
      }
      if (!newCmdInputStr.contains(outputDir)) {
        System.err.printf("Error: Missing command %s.%n%n", outputDir);
        System.exit(0);
      }
      if (!newCmdInputStr.contains(csvFile)) {
        System.err.printf("Error: Missing command %s.%n%n", csvFile);
        checkInput = true;
        System.exit(0);
      }
      for (Map.Entry<String, String> entry : cmdPairs.entrySet()) {
        String key = entry.getKey();
        if (newCmdInputStr.contains(key) && !newCmdInputStr.contains(cmdPairs.get(key))) {
          System.err.printf("Error: %s provided but no %s was given.%n%n", key,
              cmdPairs.get(key));
          checkInput = true;

        }
      }
      if (newCmdInputStr.contains(email) && newCmdInputStr.contains(letter)) {
        System.err.println("Error: Conflicting command line argument was provided.%n%n");
        checkInput = true;
        System.exit(0);
      }
      if (checkInput) {
        CommandLine.usage(newCmdProcessor, System.out);
        System.exit(0);
      }

      new CommandLine(newCmdProcessor).parse(newCmdInput);
      newCmdProcessor.runMailGenerator();


    } catch (RuntimeException rte) {
      System.out.println(rte.getMessage());
      rte.printStackTrace();
    } catch (Exception e) {
      System.out.println(e.getMessage());
      e.printStackTrace();
    }
  }
}
