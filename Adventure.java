
// custom adventure imports
import Quests.*;
import Weapons.*;
import People.*;
import Commands.*;
import UI.*;
// java utils
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;

public class Adventure {

  // the following are defined in setup.
  private String playerName;
  private WeaponType playerWeaponType;

  private void setup() {
    Scanner scanner = new Scanner(System.in);
    System.out.println(" ******* SETTING UP ADVENTURE SIMULATION ******* ");
    // set the player's name
    System.out.println("> Let's get you set up!");
    System.out.println("> Please enter your name (12 chars or less): ");
    if(scanner.hasNext()) {
      String str = scanner.nextLine().toUpperCase().replaceAll(" ", "");
      if(str.length() >= 12) {
        playerName = str.substring(0, 12);
      }
      else {
        playerName = str;
      }
      System.out.println("> Nice to meet you, " + playerName + "!");
    }

    while(true) {
      System.out.println("> Would you like a: SWORD, AXE, or STAFF?");
      if(scanner.hasNext()) {
        String input = scanner.nextLine().replaceAll("\\s", "").toUpperCase();

        if(input.equals("SWORD")) {
          playerWeaponType = WeaponType.SWORD;
          break;
        }
        else if(input.equals("AXE")) {
          playerWeaponType = WeaponType.AXE;
          break;
        }
        else if(input.equals("STAFF")) {
          playerWeaponType = WeaponType.STAFF;
          break;
        }
        else {
          System.out.println("> Something wrong? Let's try that again.");
        }
      }

    }

    System.out.println("> All done! I'll see you in a bit...\n\n\n");
  }

  public void start() {
    // run setup function to grab name and weapon type
    this.setup();
    // begin advnture
    Blacksmith blacksmith = Blacksmith.hire("Daedalus");

    Hero h1 = new Hero(playerName, blacksmith.create(playerWeaponType));
    Hero h2 = new Hero("Carolina", blacksmith.create(WeaponType.AXE));
    Hero h3 = new Hero("Valeria", blacksmith.create(WeaponType.STAFF));
    Hero h4 = new Hero("Alfred", blacksmith.create(WeaponType.AXE));

    Hero.assignLeader(h1);

    List<Hero> party = new ArrayList<Hero>(Arrays.asList(h1, h2, h3, h4));

    Quest_State q_state = new Quest_Town();
    Quest q = new Quest(q_state);
    q.recruit(party);

    UI ui = new CLI(q, playerName);

    // present scenario before entering game loop
    ui.showScenario();

    while(!ui.getQuitGame() && !ui.getGameOver()) {
      ui.getInput();
    }

    if(ui.getGameOver()) {
      ui.showGameOver();
    }
  }

  public static void main(String[] args) {
    Adventure a = new Adventure();
    a.start();
  }
}
