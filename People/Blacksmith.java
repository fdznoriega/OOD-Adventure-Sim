
// FACTORY x SINGLETON
// singleton: only one blacksmith can exist to aid the heroes
// factory: only the blacksmith can create weapons for our heroes
// other: only the blacksmith can upgrade weapons

package People;

import Weapons.*;

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

}
