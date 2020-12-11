/*
 * test program for abstract factory pattern
 */

import java.util.*;

public class Bookstores
{
	public static void main (String [] args)
	{
    Factory bu = new BUFactory();
		List<Book> buOrders = new LinkedList<>();
		Book b1 = bu.deliverPrint("Designing with Objects");
		Book b2 = bu.deliverDigital("Effective Java");
		buOrders.add(b1);
		buOrders.add(b2);
		System.out.println("\nBU's orders:");
		for (Book b: buOrders)
		{
			System.out.println(b);
		}

    	Factory bc = new BCFactory();
		List<Book> bcOrders = new ArrayList<>();
		Book b3 = bc.deliverDigital("Designing with Objects");
		Book b4 = bc.deliverPrint("Head First Design Patterns");
		bcOrders.add(b3);
		bcOrders.add(b4);
		System.out.println("\nBC's orders:");
		for (Book b: bcOrders)
		{
			System.out.println(b);
		}
	}
}
