
public class Hero {

  // ******** LEADER SINGLETON **********
  // there must only be ONE leader and everyone MUST know who it is
  private static Hero leader;

  public static void assignLeader(Hero h) {
    if(leader == null) {
      leader = h;
    }
    else {
      // exception handle in the future?
      System.out.println("Caution: There's already a leader!");
      return;
    }
  }

  public static void retireLeader() {
    if(leader != null) {
      leader = null;
    }
    else {
      System.out.println("Caution: No leader to retire!");
    }
  }

  public static Hero getLeader() {
    return leader;
  }

  // *******************************

  // ******** HERO CLASS ********

  private String name;
  private Weapon weapon;

  public Hero(String n) {
    this.name = n;
  }

  public Hero(String n, Weapon w) {
    this.name = n;
    this.weapon = w;
  }

  // getters
  public String getName() {
    return this.name;
  }

  public Weapon getWeapon() {
    return this.weapon;
  }

  public void upgradeWeapon(int d) {
    this.weapon.upgrade(d);
  }

  public void degradeWeapon(int d) {
    this.weapon.degrade(d);
  }

  // setters (name is NEVER edited)
  public void setWeapon(Weapon w) {
    this.weapon = w;
  }

  public String toString() {
    String str = "";
    // add special character if this person is a designated leader
    if(leader == this) {
      str += "**";
    }
    str += name;
    // do they have a weapon?
    if(this.weapon == null) {
      return str;
    }
    else {
      return str + " " + weapon.toString();
    }
  }
}
