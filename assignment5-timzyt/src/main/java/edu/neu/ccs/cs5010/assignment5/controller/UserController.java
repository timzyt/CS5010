package edu.neu.ccs.cs5010.assignment5.controller;

import java.io.File;
import edu.neu.ccs.cs5010.assignment5.model.CmdProcessor;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;
import picocli.CommandLine;
import picocli.CommandLine.Help;

public class UserController {

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
        Scanner cmdInput = new Scanner(System.in, "UTF-8");
        /*BufferedReader cmdInput = new BufferedReader(new InputStreamReader(System.in))*/){
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
          System.out.printf("Error: %s provided but no %s was given.\r\n\r\n\t", key,
              cmdPairs.get(key));
          checkInput = true;

        }
      }
      if (checkInput) {
        CommandLine.usage(newCmdProcessor, System.out);
        System.exit(0);
      }
      //args = new String[] {"--email", "--email-template", "email-template.txt","--output-dir", "emails", "--csv-file", "customer.csv"};
      new CommandLine(newCmdProcessor).parse(newCmdInput);
      newCmdProcessor.runMailGenerator();
//      assert !newCmdProcessor.helpRequest;
//      assert newCmdProcessor.createEmail;
//      assert newCmdProcessor.emailTemplate.equals("email-template.txt");
//      assert newCmdProcessor.outputDir.equals("emails");
//      assert newCmdProcessor.csvFile.equals("insurance-company-customer.csv");

//      System.out.println(newCmdProcessor.emailTemplate);
//      System.out.println(newCmdProcessor.csvFile);
//      System.out.println(newCmdProcessor.outputDir);


    } catch (Exception e) {
      System.out.println(e.getMessage());
      e.printStackTrace();
    }
  }
}
