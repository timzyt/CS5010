package assignment1.problem3;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class NameTest {
  private String firstName;
  private String lastName;
  private String firstName2;
  private String lastName2;
  private Name name;

  @Before
  public void setUp() throws Exception {
    name = new Name(firstName, lastName);
  }

  @Test
  public void getFirstName() {
    assertEquals(firstName, name.getFirstName());
  }

  @Test
  public void setFirstName() {
    name.setFirstName(firstName2);
    assertEquals(firstName2, name.getFirstName());
  }

  @Test
  public void getLastName() {
    assertEquals(lastName, name.getLastName());
  }

  @Test
  public void setLastName() {
    name.setLastName(lastName2);
    assertEquals(lastName2, name.getLastName());
  }
}