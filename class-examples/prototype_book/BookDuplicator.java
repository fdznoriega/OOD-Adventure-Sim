/*
 * Andres Fernandez
 */

public final class BookDuplicator
{

  private final Book FANTASY_BOOK = Book.makeBook("fantasy");
  private final Book HUMOR_BOOK = Book.makeBook("humor");
  private final Book TEXTBOOK_BOOK = Book.makeBook("textbook");

  public static BookDuplicator bookDuplicator;

  private BookDuplicator() {
    if(this.bookDuplicator == null) {
      this.bookDuplicator = this;
    }

  }
  public static BookDuplicator makeBookDuplicator() {
    return new BookDuplicator();
  }

  public Book duplicateFantasy() {
    try {
      return (Book) FANTASY_BOOK.clone();
    }
    catch(CloneNotSupportedException e) {
      System.out.println(e);
    }

    return null;

  }
  public Book duplicateHumor() {
    try {
      return (Book) HUMOR_BOOK.clone();
    }
    catch(CloneNotSupportedException e) {
      System.out.println(e);
    }

    return null;
  }
  public Book duplicateTextbook() {
    try {
      return (Book) TEXTBOOK_BOOK.clone();
    }
    catch(CloneNotSupportedException e) {
      System.out.println(e);
    }

    return null;
  }

  public Book duplicateBook(String genre) throws UnknownGenreException {
    if(genre.equals("fantasy")) {
      return duplicateFantasy();
    }
    else if(genre.equals("humor")) {
      return duplicateHumor();
    }
    else if(genre.equals("textbook")) {
      return duplicateTextbook();
    }
    else {
      throw new UnknownGenreException("Could not find a book of that genre to clone");
    }
  }
}
