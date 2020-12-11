/*
 * Andres Fernandez
 */

public class Book
{
  public static class Builder {

    Book b = new Book(this);

    public Builder(String title, int pages) {
      b.title = title;
      b.pages = pages;
    }

    public Builder author(String a) {
      b.author = a;
      return this;
    }

    public Builder year(int y) {
      b.year = y;
      return this;
    }

    public Book build() {
      return b;
    }
  }

  private String title;
  private int pages;
  private String author;
  private int year;

  private Book(Builder builder) {
    super();
  }

  public String toString() {
    String s = "{ " + this.title + ", " + this.pages + " pages";

    if(this.author != null) {
      s += ", " + this.author;
    }

    if(this.year > 0) {
      s += ", " + this.year;
    }

    s += " }";

    return s;
  }



}
