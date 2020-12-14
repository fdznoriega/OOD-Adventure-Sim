
package Commands;

import UI.UI;
import Quests.Quest;
import People.*;
import Weapons.WeaponType;
import java.util.*;

public class EquipCommand implements Command {

  private UI ui;
  private Quest q;
  private String heroName;
  private String desiredEquipment;

  public EquipCommand(UI ui, Quest q, String hn, String desiredEquipment) {
    this.ui = ui;
    this.q = q;
    this.heroName = hn;
    this.desiredEquipment = desiredEquipment;
  }

  public void execute() {
    // check if instance is null just in case.
    if(Blacksmith.getInstance() == null) {
      System.out.println("CAUTION: Blacksmith not hired prior to this moment.");
    }

    // first, check that this hero is in the quest
    List<Hero> party = q.getHeroes();

    for(Hero h : party) {
      if(h.getName().equals(heroName)) {
        // this is the hero we want to equip something for!
        if(desiredEquipment.equals("SWORD")) {
          h.setWeapon(Blacksmith.getInstance().create(WeaponType.SWORD));
        }
        else if(desiredEquipment.equals("AXE")) {
          h.setWeapon(Blacksmith.getInstance().create(WeaponType.AXE));
        }
        else if(desiredEquipment.equals("STAFF")) {
          h.setWeapon(Blacksmith.getInstance().create(WeaponType.STAFF));
        }
        else {
          ui.showEquipUnsuccessful();
          return;
        }
        // if we reach here, it worked
        ui.showEquipSuccessful();

      }
    }


  }


}
