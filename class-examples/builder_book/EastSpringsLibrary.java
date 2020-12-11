/*
 * test program for Builder design pattern
 */

public class EastSpringsLibrary
{
	public static void main (String [] args)
	{
		System.out.println("\nWe don't have the year of publication for this "
			+ "old book from the mid-1800s");
		Book b1 = new Book.Builder("Paul Clifford", 472).author("Bulwer-Lytton").build();
		System.out.println(b1);
		System.out.println("\nThis book was published anonymously: ");
		Book b2 = new Book.Builder("Primary Colors", 384).year(1996).build();
		System.out.println(b2);
		System.out.println("\nWe have all the information for this book: ");
		Book b3 = new Book.Builder("Harry Potter and the Philosopher's Stone", 223).year(1997).author("Rowling").build();
		System.out.println(b3);
	}
}
