

package Commands;

import UI.UI;
import Quests.Quest;
import People.*;
import Weapons.WeaponType;
import java.util.*;

public class PartyCommand implements Command {

  private UI ui;

  public PartyCommand(UI ui) {
    this.ui = ui;
  }

  public void execute() {
    ui.showParty();
  }


}
