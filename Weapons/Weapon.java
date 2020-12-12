
package Weapons;

// a 'weapon' is never created; it's a concept
// we create swords, axes, and staves.

public abstract class Weapon {

  private WeaponType weaponType;
  private int damage;

  public Weapon(WeaponType wt) {
    this.weaponType = wt;
  }

  public Weapon(WeaponType wt, int d) {
    this.weaponType = wt;
    this.damage = d;
  }

  // getters
  public WeaponType getWeaponType() {
    return this.weaponType;
  }

  public int getDamage() {
    return this.damage;
  }

  // note that type is NEVER set. only constructed.

  public void upgrade(int d) {
    this.damage += d;
  }

  public void degrade(int d) {
    if(this.damage - d < 1) {
      this.damage = 1;
    }
    else {
      this.damage -= d;
    }
  }

  @Override
  public String toString() {
    String str = "{ ";

    str += weaponType.toString();

    if(this.damage != 0) {
      str += " | " + this.damage;
    }

    str += " }";
    return str;

  }


}
