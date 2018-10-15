package assignment1.problem3;

import java.util.Objects;

/**
 * Created by timzyt on 9/13/2018. Name class uses for construct and store information for first
 * name and last name.
 */
public class Name {

  private String firstName;
  private String lastName;

  public Name(String fname, String lname) {
    this.firstName = fname;
    this.lastName = lname;
  }


  /**
   *
   * @return firstName first name of this artist.
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * set the first name of this artist.
   * @param firstName first name of this artist.
   */
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  /**
   *
   * @return lastName last name of this artist.
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * set the last name of this artist.
   * @param lastName last name of this artist.
   */
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  /**************************************************************************
   *
   * @param obj object.
   * @return boolean.
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Name name = (Name) obj;
    return Objects.equals(firstName, name.firstName)
        && Objects.equals(lastName, name.lastName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstName, lastName);
  }
}
