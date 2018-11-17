package edu.neu.ccs.cs5010.assignment6.sequential.javautil;

import static org.junit.Assert.*;

import edu.neu.ccs.cs5010.assignment6.sequential.exception.IllegalThresholdException;
import org.junit.Before;
import org.junit.Test;

public class CommandLineProcessorTest {

  private CommandLineProcessor commandLineProcessor;

  @Before
  public void setUp() throws Exception {
    String[] args={"--inputFilePost",
        "WearableWorkloadDefault-Javatest-POSTraw.csv",
        "--inputFileGet",
        "WearableWorkloadDefault-Javatest-GETraw.csv",
        "--output-dir",
        "output",
        "--concurrent",
        "--combined"};
    this.commandLineProcessor = new CommandLineProcessor(args);
  }

  @Test
  public void testNullCommandlineProcess() {
    try {
      this.commandLineProcessor.commandlineProcess();
    } catch (Exception e) {
      e.getMessage();
    }
  }

  @Test
  public void commandlineProcess1() {
    String[] args1={"--inputFilePost",
        "WearableWorkloadDefault-Javatest-POSTraw.csv",
        "--inputFileGet",
        "WearableWorkloadDefault-Javatest-GETraw.csv",
        "--output-dir",
        "output"};
    CommandLineProcessor commandLineProcessor1 = new CommandLineProcessor(args1);
    try {
      commandLineProcessor1.commandlineProcess();
    } catch (Exception e) {
      e.getMessage();
    }
  }

  @Test
  public void commandlineProcess2() {
    String[] args2={"--inputFilePost",
        "WearableWorkloadDefault-Javatest-POSTraw.csv",
        "--inputFileGet",
        "WearableWorkloadDefault-Javatest-GETraw.csv",
        "--output-dir",
        "output",
        "--combined"};
    CommandLineProcessor commandLineProcessor2 = new CommandLineProcessor(args2);
    try {
      commandLineProcessor2.commandlineProcess();
    } catch (Exception e) {
      e.getMessage();
    }
  }

  @Test
  public void commandlineProcess3() {
    String[] args3={"--inputFileGet",
        "WearableWorkloadDefault-Javatest-GETraw.csv",
        "--output-dir",
        "output",
        "--combined"};
    CommandLineProcessor commandLineProcessor3 = new CommandLineProcessor(args3);
    try {
      commandLineProcessor3.commandlineProcess();
    } catch (Exception e) {
      e.getMessage();
    }
  }

  @Test
  public void commandlineProcess4() {
    String[] args4={"--inputFilePost",
        "WearableWorkloadDefault-Javatest-POSTraw.csv",
        "--output-dir",
        "output",
        "--combined"};
    CommandLineProcessor commandLineProcessor4 = new CommandLineProcessor(args4);
    try {
      commandLineProcessor4.commandlineProcess();
    } catch (Exception e) {
      e.getMessage();
    }
  }

  @Test
  public void commandlineProcess5() {
    String[] args5={"1", "2"};
    CommandLineProcessor commandLineProcessor5 = new CommandLineProcessor(args5);
    try {
      commandLineProcessor5.commandlineProcess();
    } catch (Exception e) {
      e.getMessage();
    }
  }


  @Test
  public void commandlineProcess6() {
    String[] args6={"--output-dir",
        "output"};
    CommandLineProcessor commandLineProcessor6 = new CommandLineProcessor(args6);
    try {
      commandLineProcessor6.commandlineProcess();
    } catch (Exception e) {
      e.getMessage();
    }
  }


  @Test
  public void commandlineProcess7() {
    String[] args7={"--inputFilePost",
        "WearableWorkloadDefault-Javatest-POSTraw.csv",
        "--inputFileGet",
        "WearableWorkloadDefault-Javatest-GETraw.csv",
        "--output-dir",
        "output",
        "--concurrent",
        "--combined",
        "--threshold",
        "20"};
    CommandLineProcessor commandLineProcessor7 = new CommandLineProcessor(args7);
    try {
      commandLineProcessor7.commandlineProcess();
    } catch (Exception e) {
      e.getMessage();
    }
  }

  @Test
  public void commandlineProcess8() {
    String[] args8={"--inputFilePost",
        "WearableWorkloadDefault-Javatest-POSTraw.csv",
        "--inputFileGet",
        "WearableWorkloadDefault-Javatest-GETraw.csv",
        "--output-dir",
        "output",
        "--combined",
        "--threshold",
        "20"};
    CommandLineProcessor commandLineProcessor8 = new CommandLineProcessor(args8);
    try {
      commandLineProcessor8.commandlineProcess();
    } catch (Exception e) {
      e.getMessage();
    }
  }

  @Test
  public void testHighThresholdCommandlineProcess8() {
    String[] args8={"--inputFilePost",
        "WearableWorkloadDefault-Javatest-POSTraw.csv",
        "--inputFileGet",
        "WearableWorkloadDefault-Javatest-GETraw.csv",
        "--output-dir",
        "output",
        "--combined",
        "--concurrent",
        "--threshold",
        "5000"};
    CommandLineProcessor commandLineProcessor8 = new CommandLineProcessor(args8);
    try {
      commandLineProcessor8.commandlineProcess();
    } catch (Exception e) {
      e.getMessage();
      System.out.println(e.getMessage());
    }
  }

}