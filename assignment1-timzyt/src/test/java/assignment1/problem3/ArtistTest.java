package assignment1.problem3;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class ArtistTest {

  private Artist musician;
  private String artistID1 = "musician001";
  private String firstName1 = "Benjamin";
  private String lastName1 = "Haggerty";
  private Name name1 = new Name(firstName1, lastName1);
  private Integer age1 = 35;
  private Genre genre1 = Genre.Musician;
  private AttributeList movie1;
  private Artist actor;
  private String artistID2 = "actor001";
  private String firstName2 = "Bruce";
  private String lastName2 = "Lee";
  private Name name2 = new Name(firstName2, lastName2);
  private Integer age2 = -1;
  private Genre genre2 = Genre.Actor;
  private AttributeList movie2 = null;

  @Before
  public void setUp() throws Exception {
    musician = new Artist(artistID1);
    musician.setName(name1);
    musician.setAge(age1);
    musician.setGenre(genre1);
    actor = new Artist(artistID2);
    actor.setName(name2);
    actor.setGenre(genre2);
  }

  @Test
  public void testGetName() throws Exception {
    assertEquals(firstName2, actor.getName().getFirstName());
    assertEquals(lastName2, actor.getName().getLastName());
  }

  @Test
  public void getArtistid() {
    actor.setArtistid(artistID1);
    assertEquals(artistID1, actor.getArtistid());
  }

  @Test
  public void setArtistid() {
    actor.setArtistid(artistID1);
    assertEquals(artistID1, actor.getArtistid());
  }

  @Test
  public void getAge() {
    actor.setAge(age1);
    assertEquals(age1, actor.getAge());
  }


  @Test
  public void testSetAge() throws Exception {
    try {
      actor.setAge(age2);
    } catch (Exception e) {
      final String msg = "age of this artist is out of range.";
      assertEquals(msg, e.getMessage());
    }
  }

  @Test
  public void testGetGenre() throws Exception {
    assertEquals(Genre.Actor, actor.getGenre());
  }

  @Test
  public void testNoMovieForMusician() throws Exception {
    assertEquals(null, musician.getMovieList());
  }

  @Test
  public void testActorHasMovie() throws Exception {
    actor.getMovieList().add(movie2);
  }

  @Test
  public void testSetMovieList() throws Exception {
    try {
      musician.setMovieList(movie1);
    } catch (Exception e) {
      final String msg = "This artist does not have a movie record.";
      assertEquals(msg, e.getMessage());
    }
  }

  @Test
  public void testSetMovieList2() throws Exception {
    actor.setMovieList(movie2);
    ArrayList<AttributeList> movieList2 = new ArrayList<AttributeList>();
    movieList2.add(movie2);
    assertEquals(movieList2, actor.getMovieList());
  }
}