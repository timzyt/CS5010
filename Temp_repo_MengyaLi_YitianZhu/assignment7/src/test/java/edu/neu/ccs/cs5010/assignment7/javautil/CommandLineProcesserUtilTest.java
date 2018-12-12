package edu.neu.ccs.cs5010.assignment7.javautil;

import org.junit.Before;
import org.junit.Test;

public class CommandLineProcesserUtilTest {

  @Test
  public void CommandlineProcess() {
    String[] args={"--inputFilePost",
        "WearableWorkloadDefault-Javatest-POSTraw.csv",
        "--inputFileGet",
        "WearableWorkloadDefault-Javatest-GETraw.csv",
        "--output-dir",
        "output",
        "--concurrent",
        "--combined",
        "--splitNumber",
        "5",
        "--latency",
        "--threshold",
        "50"};
    try {
      CommandLineProcesserUtil commandLineProcesserUtil = new CommandLineProcesserUtil(args);
      commandLineProcesserUtil.commandlineProcess();
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
    CommandLineProcesserUtil commandLineProcesserUtil1 = new CommandLineProcesserUtil(args1);
    try {
      commandLineProcesserUtil1.commandlineProcess();
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
    CommandLineProcesserUtil commandLineProcesserUtil2 = new CommandLineProcesserUtil(args2);
    try {
      commandLineProcesserUtil2.commandlineProcess();
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
    CommandLineProcesserUtil commandLineProcesserUtil3 = new CommandLineProcesserUtil(args3);
    try {
      commandLineProcesserUtil3.commandlineProcess();
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
    CommandLineProcesserUtil commandLineProcesserUtil4 = new CommandLineProcesserUtil(args4);
    try {
      commandLineProcesserUtil4.commandlineProcess();
    } catch (Exception e) {
      e.getMessage();
    }
  }

  @Test
  public void commandlineProcess5() {
    String[] args5={"1", "2"};
    CommandLineProcesserUtil commandLineProcesserUtil5 = new CommandLineProcesserUtil(args5);
    try {
      commandLineProcesserUtil5.commandlineProcess();
    } catch (Exception e) {
      e.getMessage();
    }
  }


  @Test
  public void commandlineProcess6() {
    String[] args6={"--output-dir",
        "output"};
    CommandLineProcesserUtil commandLineProcesserUtil6 = new CommandLineProcesserUtil(args6);
    try {
      commandLineProcesserUtil6.commandlineProcess();
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
        "--splitNumber",
        "5",
        "--combined",
        "--threshold",
        "20"};
    CommandLineProcesserUtil commandLineProcesserUtil7 = new CommandLineProcesserUtil(args7);
    try {
      commandLineProcesserUtil7.commandlineProcess();
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
    CommandLineProcesserUtil commandLineProcesserUtil8 = new CommandLineProcesserUtil(args8);
    try {
      commandLineProcesserUtil8.commandlineProcess();
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
        "--splitNumber",
        "5",
        "--threshold",
        "5000"};
    CommandLineProcesserUtil commandLineProcesserUtil8 = new CommandLineProcesserUtil(args8);
    try {
      commandLineProcesserUtil8.commandlineProcess();
    } catch (Exception e) {
      e.getMessage();
      System.out.println(e.getMessage());
    }
  }

  @Test
  public void commandlineProcess10() {
    String[] args8={
        "--inputFileGet",
        "WearableWorkloadDefault-Javatest-GETraw.csv",
        "--output-dir",
        "output",
        "--concurrent",
        "--splitNumber",
        "5",
        "--combined"
    };
    CommandLineProcesserUtil commandLineProcesserUtil10 = new CommandLineProcesserUtil(args8);
    try {
      commandLineProcesserUtil10.commandlineProcess();
    } catch (Exception e) {
      e.getMessage();
    }
  }

  @Test
  public void commandlineProcess11() {
    String[] args8={
        "--inputFilePost",
        "WearableWorkloadDefault-Javatest-POSTraw.csv",
        "--output-dir",
        "output",
        "--concurrent",
        "--splitNumber",
        "5",
        "--combined"
    };
    CommandLineProcesserUtil commandLineProcesserUtil8 = new CommandLineProcesserUtil(args8);
    try {
      commandLineProcesserUtil8.commandlineProcess();
    } catch (Exception e) {
      e.getMessage();
    }
  }

  @Test
  public void commandlineProcess12() {
    String[] args8={
        "--inputFileGet",
        "WearableWorkloadDefault-Javatest-GETraw.csv",
        "--output-dir",
        "output",
        "--concurrent"
    };
    CommandLineProcesserUtil commandLineProcesserUtil10 = new CommandLineProcesserUtil(args8);
    try {
      commandLineProcesserUtil10.commandlineProcess();
    } catch (Exception e) {
      e.getMessage();
    }
  }

  @Test
  public void commandlineProcess13() {
    String[] args8={
        "--inputFileGet",
        "WearableWorkloadDefault-Javatest-GETraw.csv",
        "--output-dir",
        "output",
        "--concurrent",
        "--splitNumber",
        "5"
    };
    CommandLineProcesserUtil commandLineProcesserUtil10 = new CommandLineProcesserUtil(args8);
    try {
      commandLineProcesserUtil10.commandlineProcess();
    } catch (Exception e) {
      e.getMessage();
    }
  }

  @Test
  public void commandlineProcess14() {
    String[] args8={
        "--inputFilePost",
        "WearableWorkloadDefault-Javatest-POSTraw.csv",
        "--output-dir",
        "output",
        "--concurrent",
        "--splitNumber",
        "5"
    };
    CommandLineProcesserUtil commandLineProcesserUtil10 = new CommandLineProcesserUtil(args8);
    try {
      commandLineProcesserUtil10.commandlineProcess();
    } catch (Exception e) {
      e.getMessage();
    }
  }

  @Test
  public void commandlineProcess15() {
    String[] args8={
        "--inputFilePost",
        "WearableWorkloadDefault-Javatest-POSTraw.csv",
        "--output-dir",
        "output",
        "--concurrent",
        "--splitNumber",
        "5",
        "--threshold",
        "50"
    };
    CommandLineProcesserUtil commandLineProcesserUtil10 = new CommandLineProcesserUtil(args8);
    try {
      commandLineProcesserUtil10.commandlineProcess();
    } catch (Exception e) {
      e.getMessage();
    }
  }

  @Test
  public void commandlineProcess16() {
    String[] args3={"--inputFileGet",
        "WearableWorkloadDefault-Javatest-GETraw.csv",
        "--output-dir",
        "output"
    };
    CommandLineProcesserUtil commandLineProcesserUtil3 = new CommandLineProcesserUtil(args3);
    try {
      commandLineProcesserUtil3.commandlineProcess();
    } catch (Exception e) {
      e.getMessage();
    }
  }

  @Test
  public void commandlineProcess17() {
    String[] args3={"--inputFilePost",
        "WearableWorkloadDefault-Javatest-POSTraw.csv",
        "--output-dir",
        "output"
    };
    CommandLineProcesserUtil commandLineProcesserUtil3 = new CommandLineProcesserUtil(args3);
    try {
      commandLineProcesserUtil3.commandlineProcess();
    } catch (Exception e) {
      e.getMessage();
    }
  }
}