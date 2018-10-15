package assignment1.problem3;

import static org.junit.Assert.*;

import java.util.Date;
import org.junit.Before;
import org.junit.Test;

public class AttributeListTest {

  private Integer idx1 = 1;
  private Integer idx2 = 2;
  private Date date1 = new Date(2011-04-23);
  private Date date2 = new Date(2018-01-01);
  private String itemName1 = "item1";
  private String itemName2 = "item2";
  private String Description1 = "des1";
  private String Description2 = "des2";
  private AttributeList entry;

  @Before
  public void setUp() throws Exception {
    entry = new AttributeList(idx1, date1, itemName1, Description1);
  }

  @Test
  public void getIndex() {
    assertEquals(idx1, entry.getIndex());
  }

  @Test
  public void setIndex() {
    entry.setIndex(idx2);
    assertEquals(idx2, entry.getIndex());
  }

  @Test
  public void getDate() {
    assertEquals(date1, entry.getDate());
  }

  @Test
  public void setDate() {
    entry.setDate(date2);
    assertEquals(date2, entry.getDate());
  }

  @Test
  public void getItemName() {
    assertEquals(itemName1, entry.getItemName());
  }

  @Test
  public void setItemName() {
    entry.setItemName(itemName2);
    assertEquals(itemName2, entry.getItemName());
  }

  @Test
  public void getDescription() {
    assertEquals(Description1, entry.getDescription());
  }

  @Test
  public void setDescription() {
    entry.setDescription(Description2);
    assertEquals(Description2, entry.getDescription());
  }
}