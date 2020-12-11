/*
* Andrés Fernández
 */

import java.util.List;
import java.util.LinkedList;

public class Book
{
  // instance variable
  private String title;

  // static class which is always referenced
  protected static Book book;
  private static List<Book> signedOut = new LinkedList<Book>();
  private static final int UPPER_LIMIT = 2;

  protected Book(String t) {
    this.title = t;
  }

  public static Book borrowBook(String t) throws BookLimitException {
    if(signedOut.size() < UPPER_LIMIT) {
      book = new Book(t);   // assign static class
      signedOut.add(book);  // update signedOut list
      return book;
    }
    else {
      throw new BookLimitException("You can only check out " + UPPER_LIMIT + " book(s) at once");
    }
  }

  public static boolean returnBook(String t) {
    // cycle through list matching by TITLE now object
    for(Book b : signedOut) {
      if(b.title.equals(t)) {
        signedOut.remove(b); // remove from signed out
        return true;
      }
    }
    return false;
  }

  public static List<Book> signedOut() {
    return signedOut;
  }

  // getter function for UPPER_LIMIT constant instead of hardcoding '2'.
  public static int getUpperLimit() {
    return UPPER_LIMIT;
  }

  public String getTitle() {
    return this.title;
  }

  public String toString() {
    return this.title;
  }

  public static void main(String[] args) {
    try {
      System.out.println("Trying to borrow a book");
      Book.borrowBook("Head First Design Patterns");
      System.out.println(book);
      System.out.println("Here's what we have signed out: ");
      System.out.println(Book.signedOut());
      System.out.println("Return it");
      Book.returnBook("Head First Design Patterns");
      System.out.println(Book.signedOut());
    }
    catch(Exception e) {
      System.out.println(e);
    }

  }
}
