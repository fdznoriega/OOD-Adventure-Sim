
// test quest (state pattern)
// test hero and leader (singleton)

package Tests;

import Quests.*;
import Weapons.*;
import People.*;
import Commands.*;
import UI.*;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class CommandTester {
  public static void main(String[] args) {

    String playerName = "Andres";

    Blacksmith blacksmith = Blacksmith.hire("Daedalus");

    Hero h1 = new Hero(playerName, blacksmith.create(WeaponType.SWORD));
    Hero h2 = new Hero("Carolina", blacksmith.create(WeaponType.AXE));
    Hero h3 = new Hero("Valeria", blacksmith.create(WeaponType.STAFF));
    Hero h4 = new Hero("Alfred", blacksmith.create(WeaponType.AXE));

    Hero.assignLeader(h1);

    List<Hero> party = new ArrayList<Hero>(Arrays.asList(h1, h2, h3, h4));

    Quest_State q_state = new Quest_Town();
    Quest q = new Quest(q_state);
    q.recruit(party);

    UI ui = new CLI(q, playerName);

    System.out.println("Start simulation in CommandTester");

    // present scenario before entering game loop
    ui.showScenario();

    while(!ui.getQuitGame() && !ui.getGameOver()) {
      ui.getInput();
    }

    if(ui.getGameOver()) {
      ui.showGameOver();
    }

  }
}
