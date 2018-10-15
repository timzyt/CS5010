import junit.framework.TestCase;
import org.junit.Assert;

public class AuthorTest {

  private Author jane;

  @org.junit.Before
  public void setUp() throws Exception {
    this.jane = new Author("Jane Doe", "j@a.com", "222 Main St, Seattle, WA, 98980");
  }

  @org.junit.Test
  public void getName() {
    Assert.assertEquals("Jane Doe", this.jane.getName());
  }

  @org.junit.Test
  public void getEmail() {
    Assert.assertEquals("j@a.com", this.jane.getEmail());
  }

  @org.junit.Test
  public void getAddress() {
    Assert.assertEquals("222 Main St, Seattle, WA, 98980", this.jane.getAddress());
  }
}