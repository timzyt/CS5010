package assignment1.problem3;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by timzyt on 9/13/2018. Artists class uses for construct and store information for
 * artist.
 */
public class Artist {

  private String artistid;
  private Name name;
  private Integer age;
  private Genre genre;
  private ArrayList<AttributeList> awards;
  private ArrayList<AttributeList> movies;
  private ArrayList<AttributeList> tvSeries;
  private ArrayList<AttributeList> otherMedia;

  public Artist(String newid) throws IllegalArgumentException {
    this.artistid = newid;
    this.awards = new ArrayList<>();
  }

  /**
   * @return artistid.
   */
  public String getArtistid() {
    return artistid;
  }

  /**
   * set the id for this artist.
   *
   * @param artistid artist id.
   */
  public void setArtistid(String artistid) {
    this.artistid = artistid;
  }

  /**
   * @return name.
   */
  public Name getName() {
    return name;
  }

  /**
   * set the name of this artist.
   *
   * @param name name of this artist.
   */
  public void setName(Name name) {
    this.name = name;
  }

  /**
   * @return age age of this artist.
   */
  public Integer getAge() {
    return age;
  }

  /**
   * set the age of this artist.
   *
   * @param age age of this artist.
   */
  public void setAge(Integer age) {
    if (age <= 0 || age > 128) {
      throw new IllegalArgumentException("age of this artist is out of range.");
    } else {
      this.age = age;
    }
  }

  /**
   * @return genre genre of this artist.
   */
  public Genre getGenre() {
    return genre;
  }

  /**
   * set the genre of this artist.
   *
   * @param genre genre of this artist.
   */
  public void setGenre(Genre genre) {
    this.genre = genre;
    if (this.genre.equals(Genre.Actor) || this.genre.equals(Genre.Filmmaker)
        || this.genre.equals(Genre.Dancer)) {
      movies = new ArrayList<AttributeList>();
      tvSeries = new ArrayList<AttributeList>();
      otherMedia = new ArrayList<AttributeList>();
    } else {
      this.movies = null;
      this.tvSeries = null;
      this.otherMedia = null;
    }
  }

  /**
   * @return list of movies that this artist is in.
   */
  public ArrayList<AttributeList> getMovieList() {
    return this.movies;
  }

  /**
   * add instance into the list of movies that this artist is in.
   *
   * @param movie one movie that this artist is in.
   */
  public void setMovieList(AttributeList movie) throws IllegalArgumentException {
    if (this.genre.equals(Genre.Actor) || this.genre.equals(Genre.Filmmaker) || this.genre
        .equals(Genre.Dancer)) {
      this.movies.add(movie);
    } else {
      System.out.println("This artist does not have a movie record.");
    }
  }

  /**
   * add instance into the list of TV series that this artist is in.
   *
   * @param tvSeries one TV series that this artist is in.
   */
  public void settvList(AttributeList tvSeries) throws IllegalArgumentException {
    if (this.genre.equals(Genre.Actor) || this.genre.equals(Genre.Filmmaker) || this.genre
        .equals(Genre.Dancer)) {
      this.tvSeries.add(tvSeries);
    } else {
      throw new IllegalArgumentException("This artist does not have a TV series record.");
    }
  }

  /**
   * add instance into the list of other multimedia that this artist is in.
   *
   * @param otherMedia one other multimedia that this artist is in.
   */
  public void setOtherMedia(AttributeList otherMedia) throws IllegalArgumentException {
    if (this.genre.equals(Genre.Actor) || this.genre.equals(Genre.Filmmaker) || this.genre
        .equals(Genre.Dancer)) {
      this.otherMedia.add(otherMedia);
    } else {
      throw new IllegalArgumentException(
          "This artist does not have a record for other multimedia.");
    }
  }

  /**********************************************************************************************
   * equals and hashCode methods.
   * @param object object.
   * @return object.
   */
  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null || getClass() != object.getClass()) {
      return false;
    }
    Artist artist = (Artist) object;
    return Objects.equals(artistid, artist.artistid)
        && Objects.equals(name, artist.name)
        && Objects.equals(age, artist.age)
        && genre == artist.genre
        && Objects.equals(awards, artist.awards)
        && Objects.equals(movies, artist.movies)
        && Objects.equals(tvSeries, artist.tvSeries)
        && Objects.equals(otherMedia, artist.otherMedia);
  }

  @Override
  public int hashCode() {
    return Objects.hash(artistid, name, age, genre, awards, movies, tvSeries, otherMedia);
  }


}
