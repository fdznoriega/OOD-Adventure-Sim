/*
 * Andres Fernandez
 */

public class Book implements Cloneable
{
  private String title;
  private String author;
  private int year;

  private Book(String genre) throws UnknownGenreException {
    if(genre.equals("fantasy")) {
      this.title = "Harry Potter and the Philosopher's Stone";
      this.author = "Rowling";
      this.year = 1997;
    }
    else if(genre.equals("textbook")) {
      this.title = "Designing with Objects";
      this.author = "Kak";
      this.year = 2014;
    }
    else if(genre.equals("humor")) {
      this.title = "Inimitable Jeeves";
      this.author = "Wodehouse";
      this.year = 1923;
    }
    else {
      throw new UnknownGenreException("Could not find that genre");
    }
  }

  public static Book makeBook(String genre) {
    try {
      return new Book(genre);
    }
    catch(UnknownGenreException e) {
      System.out.println(e);
      return null;
    }

  }

  public void setTitle(String t) {
    this.title = t;
  }

  public void setYear(int y) {
    this.year = y;
  }

  @Override
  public Object clone() throws CloneNotSupportedException {
    return (Book) super.clone();
  }

  @Override
  public boolean equals(Object o) {
    if(o instanceof Book) {
      Book b = (Book) o;
      return
        (this.title.equals(b.title)) &&
        (this.author.equals(b.author)) &&
        (this.year == b.year);
    }
    return false;
  }

  public String toString() {
    return "{ " + this.title + ", " + this.author + ", " + this.year + " }";
  }


}
