package edu.neu.ccs.cs5010.assignment4.ridesharemodel.driver.ridersharemodel.driver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import edu.neu.ccs.cs5010.assignment4.exceptions.InvalidConstructorArgumentException;
import edu.neu.ccs.cs5010.assignment4.ridesharemodel.driver.Name;
import org.junit.Test;
import org.junit.Before;

/**
 * Name Tester.
 *
 * @author timzyt
 * @version 1.0
 * @since <pre>Oct 13, 2018</pre>
 */
public class NameTest {

  private String firstName;
  private String lastName;
  private String firstName2;
  private String lastName2;
  private String nullFirstName;
  private String nullLastName;
  private String emptyFirstName;
  private String emptyLastName;

  private Name name;

  @Before
  public void before() throws Exception {
    firstName = "Tim";
    lastName = "Zhu";
    firstName2 = "Jack";
    lastName2 = "Ma";
    emptyFirstName = "";
    emptyLastName = "";

    name = new Name(firstName, lastName);
  }

  /**
   * Method: setFirstName(String firstName)
   */
  @Test(expected = InvalidConstructorArgumentException.class)
  public void testNullFirstName() throws Exception {
    Name name3 = new Name(nullFirstName, lastName);
  }

  @Test(expected = InvalidConstructorArgumentException.class)
  public void testNullLastName() throws Exception {
    Name name4 = new Name(firstName, nullLastName);
  }

  @Test(expected = InvalidConstructorArgumentException.class)
  public void testEmptyFirstName() throws Exception {
    Name name5 = new Name(emptyFirstName, lastName);
  }

  @Test(expected = InvalidConstructorArgumentException.class)
  public void testEmptyLastName() throws Exception {
    Name name6 = new Name(firstName, emptyLastName);
  }

  /**
   * Method: setFirstName(String firstName)
   */
  @Test
  public void testSetFirstName() throws Exception {
    name.setFirstName(firstName2);
    assertEquals(firstName2, name.getFirstName());
  }

  /**
   * Method: setFirstName(String firstName)
   */
  @Test(expected = InvalidConstructorArgumentException.class)
  public void testSetFirstName2() throws Exception {
    name.setFirstName(emptyFirstName);
  }

  /**
   * Method: setFirstName(String firstName)
   */
  @Test(expected = InvalidConstructorArgumentException.class)
  public void testSetFirstName3() throws Exception {
    name.setFirstName(nullFirstName);
  }

  /**
   * Method: setLastName(String lastName)
   */
  @Test
  public void testSetLastName() throws Exception {
//TODO: Test goes here...
    name.setLastName(lastName2);
    assertEquals(lastName2, name.getLastName());
  }

  /**
   * Method: setLastName(String lastName)
   */
  @Test (expected = InvalidConstructorArgumentException.class)
  public void testSetLastName2() throws Exception {
    name.setLastName(nullLastName);
  }

  /**
   * Method: setLastName(String lastName)
   */
  @Test (expected = InvalidConstructorArgumentException.class)
  public void testSetLastName3() throws Exception {
    name.setLastName(emptyLastName);
  }

  /**
   * Method: getFirstName()
   */
  @Test
  public void testGetFirstName() throws Exception {
//TODO: Test goes here...
    assertEquals(firstName, name.getFirstName());
  }

  /**
   * Method: getLastName()
   */
  @Test
  public void testGetLastName() throws Exception {
//TODO: Test goes here...
    assertEquals(lastName, name.getLastName());
  }

  /**
   * Method: equals(Object o)
   */
  @Test
  public void testEquals() throws Exception {
//TODO: Test goes here...
    Name name2 = new Name(firstName2, lastName2);
    name.setFirstName(firstName2);
    name.setLastName(lastName2);
    assertTrue(name.equals(name2) && name2.equals(name));
    assertTrue(name.equals(name));
    assertFalse(name.equals(firstName));
  }

  /**
   * Method: hashCode()
   */
  @Test
  public void testHashCode() throws Exception {
//TODO: Test goes here...
    Name name2 = new Name(firstName2, lastName2);
    name.setFirstName(firstName2);
    name.setLastName(lastName2);
    assertTrue(name.hashCode() == name2.hashCode());
  }

  /**
   * Method: toString()
   */
  @Test
  public void testToString() throws Exception {
    String printString = "Tim Zhu";
    assertEquals(printString,name.toString());

  }


} 
