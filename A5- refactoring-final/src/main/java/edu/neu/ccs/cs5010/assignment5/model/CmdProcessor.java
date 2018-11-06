package edu.neu.ccs.cs5010.assignment5.model;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

import java.io.IOException;

/**
 * The command line argument processor.
 */
@Command(name = "",
    sortOptions = false,
    headerHeading = "Usage:\r\n",
    descriptionHeading = "%nExamples:%n%n",
    description = "\t\t--email --email-template email-template.txt --output-dir\r\n"
        + "emails --csv-file customer.csv\r\n\r\n"
        + "\t\t--letter --letter-template letter-template.txt --output-\r\n"
        + "dir letters --csv-file customer.csv\r\n")
public class CmdProcessor {

  /**
   * The create email option. Returns a boolean value whether email creation has been triggered
   */
  @Option(names = "--email", description = "only generate emails messages")
  public boolean createEmail;

  /**
   * The email template option. Receives a string as the file name.
   */
  @Option(arity = "1", names = "--email-template", paramLabel = "email template",
      description = "accept a filename that holds the email template.\r\n\t"
          + "Required if --email is used.")
  public String emailTemplate;

  /**
   * The create letter option. Returns a boolean value whether email creation has been triggered.
   */
  @Option(names = "--letter", description = "only generate letters")
  public boolean createLetter;

  /**
   * The letter template option. Receives a string as the letter template name.
   */
  @Option(arity = "1", names = "--letter-template", paramLabel = "letter template",
      description = "accept a filename that holds the letter template.\r\n\t"
          + "Required if --letter is used.")
  public String letterTemplate;

  /**
   * The output directory option. Receives a string as the output sub-directory.
   */
  @Option(arity = "1", names = "--output-dir", paramLabel = "output directory",
      description = "accept the name of a folder, all output is placed in this folder.")
  public String outputDir;

  /**
   * The csv file option. Receives a string as the csv file name.
   */
  @Option(arity = "1", names = "--csv-file", paramLabel = "csv file",
      description = "accept the name of the csv file to process.")
  public String csvFile;

  //  /**
  //   * The help request option.
  //   * Returns a boolean value whether help is called.
  //   */
  //  @Option(names = "--help", usageHelp = true, description = "display this help and exit.")
  //  public boolean helpRequest = false;

  /**
   * Run mail generator method.
   *
   * @throws IOException the io exception
   */
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
