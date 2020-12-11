
// FACTORY x SINGLETON
// singleton: only one blacksmith can exist to aid the heroes
// factory: only the blacksmith can create weapons for our heroes
// other: only the blacksmith can upgrade weapons

public class Blacksmith {

  private static String name;
  private static Blacksmith unique;

  private Blacksmith(String n) {
    this.name = n;
  }

  public static Blacksmith hire(String n) {
    if(unique == null) {
      unique = new Blacksmith(n);
    }
    else {
      System.out.println("Caution: There's already a blacksmith!");
    }
    return unique;
  }

  public static void retire() {
    unique = null;
    name = null;
  }

  @Override
  public String toString() {
    if(name == null && unique == null) {
      return "No blacksmith assigned";
    }
    else {
      return "The current blacksmith is " + name;
    }

  }

  // factory method
  public Weapon create(WeaponType wt) {
    if(wt == WeaponType.SWORD) {
      return new Sword();
    }
    else if(wt == WeaponType.AXE) {
      return new Axe();
    }
    else if(wt == WeaponType.STAFF) {
      return new Staff();
    }
    else {
      return null;
    }
  }



  // Test singleton & factory features
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
