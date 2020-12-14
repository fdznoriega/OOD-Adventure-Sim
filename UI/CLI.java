package UI;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
// import commands!
import Commands.*;
import Quests.*;
import People.*;
import Weapons.*;

public class CLI implements UI {

  private Scanner scanner;
  private Boolean quitGame;
  private Boolean gameOver;
  private String playerInput;
  private Quest quest;
  private String playerName;

  // the command line interface always uses the scanner
  public CLI(Quest q, String name) {
    scanner = new Scanner(System.in);
    quitGame = false;
    gameOver = false;
    playerInput = "";
    quest = q;
    playerName = name;
  }

  // this is for any input
  public void getInput() {
    // prepare command to execute
    Command c;
    if(scanner.hasNext()) {
      // compare player input to command types
      playerInput = scanner.nextLine().replaceAll("\\s", "").toUpperCase();
      // CHECK FOR COMMANDS
      // if else chain to check for commands
      if(playerInput.equals("EXIT")) {
        quitGame = true;
        return;
      }
      else if(playerInput.equals("QUEST")) {
        c = new QuestCommand(this, quest);
        c.execute();
      }
      else if(playerInput.equals("BLACKSMITH")) {
        // display blacksmith availability
        c = new BlacksmithCommand(this, quest);
        c.execute();
        // check blacksmith available
        if(quest.isBlacksmithAvailable()) {
          // player has been prompted to equip
          playerInput = scanner.nextLine().replaceAll("\\s", "").toUpperCase();
          if(playerInput.equals("EQUIP")) {
            // display equip options
            this.showEquipmentOptions();
            // fetch last player input
            playerInput = scanner.nextLine().replaceAll("\\s", "").toUpperCase();
            c = new EquipCommand(this, quest, playerName, playerInput);
            c.execute();
          }
          else {
            return;
          }
        }

      }
      else if(playerInput.equals("HELP")) {
        c = new HelpCommand(this);
        c.execute();
      }
      else if(playerInput.equals("TRAVEL")) {
        // check if can travel
        if(quest.isSolved()) {
          c = new TravelCommand(this);
          c.execute();  // takes us to update quest
        }
      }
      else if(playerInput.equals("PARTY")) {
        c = new PartyCommand(this);
        c.execute();
      }
      else if(playerInput.equals("FIGHT")) {
        if(quest.getSolution().equals("FIGHT")) {
          quest.setSolved(true);
          c = new TravelCommand(this);
          c.execute();
        }
        else if(quest.getSolution().equals("FLIGHT")) {
          gameOver = true;
        }
        else {
          // ignore this input
        }
      }
      else if(playerInput.equals("FLIGHT")) {
        if(quest.getSolution().equals("FLIGHT")) {
          quest.setSolved(true);
          c = new TravelCommand(this);
          c.execute();
        }
        else if(quest.getSolution().equals("FIGHT")) {
          gameOver = true;
        }
        else {
          // ignore this input
        }
      }

      // ARE WE IN A FIGHT OR FLIGHT SECTION?
      if(
          (this.quest.getSolution().equals("FIGHT") || this.quest.getSolution().equals("FLIGHT")) &&
          (!playerInput.equals("FIGHT") || !playerInput.equals("FLIGHT"))) {
            this.showFightOrFlight();
        }


    }
  }

  public void showQuest(Quest q) {
    System.out.println("> CURRENT QUEST: " + q.getName());
  }

  public void showFightOrFlight() {
    System.out.println("> Your fate awaits. Fight or flight?");
  }

  public void updateQuest() {
    // get current state
    Quest_State q_state = quest.getState();
    // check if next state is not null
    if(q_state.changeState() != null) {
      Quest_State prev_state = q_state;
      q_state = q_state.changeState();
      quest = new Quest(q_state, quest.getHeroes());
      // show new quest scenario
      this.showScenario();
      // check if there are no more scenarios
      if(q_state.changeState() == null) {
        gameOver = true;
      }
    }
  }

  public void showScenario() {
    System.out.println(quest.getScenario());
  }

  public void showEquipmentOptions() {
    // use a helper function to get the fixed output we want
    System.out.println("> You may equip one of these three:");
    // fetch weapon stats
    Weapon sword, axe, staff;
    sword = Blacksmith.getInstance().create(WeaponType.SWORD);
    axe = Blacksmith.getInstance().create(WeaponType.AXE);
    staff = Blacksmith.getInstance().create(WeaponType.STAFF);
    System.out.println(
    "[ SWORD | " + sword.getDamage() + " DMG ] " +
    "[ AXE | " + axe.getDamage() + " DMG ] " +
    "[ STAFF " + staff.getDamage() + " DMG ]");
  }

  public void showEquipSuccessful() {
    System.out.println("> Enjoy your new equipment!");
    // first adventurer is always player/leader
    System.out.println("> " + quest.getHeroes().get(0));
  }

  public void showParty() {
    System.out.println("> PARTY: " + quest.getHeroes());
  }

  public void showEquipUnsuccessful() {
    System.out.println("> The blacksmith didn't understand...no changes made.");
  }

  public void showBlacksmith() {
    System.out.println("> Looks like Blacksmith " + Blacksmith.getInstance().getName() + " is available!");
    System.out.println("> Do you want to equip something?");
    System.out.println("> Enter 'EQUIP' if you'd like.");
  }

  public void showBlacksmithUnavailable() {
    System.out.println("> The blacksmith not available at this time!");
  }

  public void showAllPossibleCommands() {
    System.out.println("> COMMANDS: ");
    System.out.println("> HELP | QUEST | PARTY | BLACKSMITH | TRAVEL | EXIT");
  }

  // more of a client command
  public Boolean getQuitGame() {
    return quitGame;
  }

  public Boolean getGameOver() {
    return gameOver;
  }

  public void showGameOver() {
    System.out.println("> Game Over! Restart to play again!");
  }

}
