
// Test Blacksmith (Factory & Singleton)

package Tests;

import People.Blacksmith;
import Weapons.Weapon;
import Weapons.WeaponType;

public class BlacksmithTester {
  public static void main(String[] args) {

    Blacksmith b = Blacksmith.hire("DAEDALUS");
    Blacksmith b2 = Blacksmith.hire("little john");

    System.out.println("=== Singleton test ===");
    System.out.println(b);
    System.out.println(b2);
    System.out.println("Is b equal to b2? " + b.equals(b2));
    System.out.println("Let's retire our blacksmith");
    b.retire();
    System.out.println("How do both variables look now?");
    System.out.println(b);
    System.out.println(b2);
    System.out.println("Hire a new blacksmith");
    b = Blacksmith.hire("Balthasar");


    System.out.println("=== Factory test ===");
    Weapon sword, axe, staff;
    sword = b.create(WeaponType.SWORD);
    axe = b.create(WeaponType.AXE);
    staff = b.create(WeaponType.STAFF);

    System.out.println(sword);
    System.out.println(axe);
    System.out.println(staff);


  }
}
