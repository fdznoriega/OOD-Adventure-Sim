/*
 * test program for Prototype design pattern
 */

public class SouthSpringsLibrary
{
    public static void main(String[] args)
	{
		try
		{
			System.out.println("\nHere are the copies available for "
				+ "book club members to borrow:");

      BookDuplicator bd = BookDuplicator.makeBookDuplicator();
      Book b1 = bd.duplicateBook("fantasy");
      System.out.println("\nb1   " + b1);
      Book b2 = bd.duplicateBook("textbook");
      System.out.println("b2   " + b2);
      Book b3 = bd.duplicateBook("humor");
      System.out.println("b3   " + b3);
			Book b4 = bd.duplicateBook("fantasy");
      System.out.println("b4   " + b4);
			System.out.println("\nAre books b1 and b4 the same? " +
				(b1 == b4 ? " yes" : " no"));
			System.out.println("Do the two books have the same properties? "
				+ (b1.equals(b4) ? " yes" : " no"));
			System.out.println("\nIt seems the first book is the U.S. edition, "
				+ "so let's update its title and year of publication");
			b1.setTitle("Harry Potter and the Sorcerer's Stone");
			b1.setYear(1998);
      System.out.println("\nb1   " + b1);
			System.out.println("\nTrying to borrow a mystery book");
			Book b5 = bd.duplicateBook("mystery");
		}

		catch (UnknownGenreException e)
		{
			System.out.println(e.getMessage());
		}
	}
}
