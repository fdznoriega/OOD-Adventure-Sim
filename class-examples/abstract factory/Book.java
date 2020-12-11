/*
 * Andrés Fernández
 */

public abstract class Book
{
  private String title;
  private String format;
  private String cover;


  public Book(String t, String format, String c) {
    this.title = t;
    this.format = format;
    this.cover = c;
  }

  public Book(String t, String format) {
    this.title = t;
    this.format = format;
  }

  public String toString() {
    String str = title + ", " + format;

    if(cover != null) {
      return str + ", " + cover;
    }
    else {
      return str;
    }
  }

  public String getTitle() {
    return this.title;
  }
}
