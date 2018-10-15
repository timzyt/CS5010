package assignment1.problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DepositTest {

  private Integer dollar = 20;
  private Integer dollar2 = 2;
  private Integer cent = 75;
  private Integer cent2 = 123;
  private String fName = "Tim";
  private String lName = "Zhu";
  private Deposit newDeposit;

  @Before
  public void setUp() throws Exception {
    newDeposit = new Deposit(dollar, cent, fName, lName);
  }


  @Test
  public void setDollar() {
    newDeposit.setDollar(dollar);
    assertEquals(dollar, newDeposit.getDollar());
  }


  @Test
  public void setDollar2() {
    try {
      newDeposit.setDollar(dollar2);
      assertEquals(dollar, newDeposit.getDollar());
    } catch (Exception e) {
      final String msg = "dollar of this deposit is out of range";
      assertEquals(msg, e.getMessage());
      System.out.println(e.getMessage());
    }
  }

  @Test
  public void setCent() {
    newDeposit.setCent(cent);
    assertEquals(cent, newDeposit.getCent());
  }


  @Test
  public void setCent2() {
    try {
      newDeposit.setCent(cent2);
      assertEquals(cent, newDeposit.getCent());
    } catch (Exception e) {
      final String msg = "cent of this deposit is out of range";
      assertEquals(msg, e.getMessage());
      System.out.println(e.getMessage());
    }
  }

  @Test
  public void getDollar() {
    newDeposit.setDollar(dollar);
    assertEquals(dollar, newDeposit.getDollar());
  }

  @Test
  public void getCent() {
    newDeposit.setCent(cent);
    assertEquals(cent, newDeposit.getCent());
  }

  @Test
  public void getfName() {
    newDeposit.setFname("Tim");
    assertEquals("Tim", newDeposit.getFname());
  }

  @Test
  public void getlName() {
    newDeposit.setlName("Zhu");
    assertEquals("Zhu", newDeposit.getlName());
  }

  @Test
  public void setfName() {
    newDeposit.setFname("Tim");
    assertEquals("Tim", newDeposit.getFname());
  }

  @Test
  public void setlName() {
    newDeposit.setlName("Zhu");
    assertEquals("Zhu", newDeposit.getlName());
  }
}