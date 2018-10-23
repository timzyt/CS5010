package edu.neu.ccs.cs5010.assignment5.model;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import picocli.CommandLine;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

public class CmdProcessor {
  @Option(names = "--email", description = "only generate emails messages")
  public boolean createEmail;

  @Option(arity = "1", names = "--email-template", paramLabel = "email template", description = "accept a filename that holds the email template.\r\n\tRequired if --email is used.")
  public String emailTemplate;

  @Option(names = "--letter", description = "only generate letters")
  public boolean createLetter;

  @Option(arity = "1", names = "--letter-template", paramLabel = "letter template", description = "accept a filename that holds the letter template.\r\n\tRequired if --letter is used.")
  public String letterTemplate;

  @Option(arity = "1", names = "--output-dir", paramLabel = "output directory", description = "accept the name of a folder, all output is placed in this folder.")
  public String outputDir;

  @Option(arity = "1", names = "--csv-file", paramLabel =  "csv file", description = "accept the name of the csv file to process.")
  public String csvFile;

  @Option(names = "--help", usageHelp = true, description = "display this help and exit.")
  public boolean helpRequest = false;

  //run mailGenerator, pass in the arguments
  public void runMailGenerator() throws IOException {
    MailGenerator newMailGenerator = new MailGenerator();
    try {
      if (createEmail) {
        newMailGenerator.run("email", emailTemplate, csvFile, outputDir);
      }
      if (createLetter) {
        newMailGenerator.run("letter", letterTemplate, csvFile, outputDir);
      }

    } catch (Exception e) {
      System.out.println(e.getMessage());
      e.printStackTrace();
    }
  }
}
