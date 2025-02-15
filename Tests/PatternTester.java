
// this file tests all patterns but the command pattern
// in this project. the command pattern is tested
// in Adventure.java.
package Tests;
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

public class PatternTester {
  public static void main(String[] args) {
    System.out.println("\n\n\n ******** Welcome to the Adventure Design Pattern Tester! ********");
    // ****************** Blacksmith (Factory & Singleton) ******************
    System.out.println(" **** Blacksmith (Factory & Singleton) **** ");
    System.out.println("First, we will make a blacksmith (factory/singleton) to provide weapons for our heroes");
    System.out.println("We're going to make TWO (blacksmith and blacksmith2) and check for equality");
    System.out.println("Creating blacksmith 1");
    // Here is the blacksmith's singleton pattern
    Blacksmith blacksmith = Blacksmith.hire("Daedalus");
    System.out.println("Creating blacksmith 2");
    Blacksmith blacksmith2 = Blacksmith.hire("Madeon");
    System.out.println("Here's blacksmith 1: " + blacksmith);
    System.out.println("Here's blacksmith 2: " + blacksmith2);
    System.out.println("Are they equal? " + blacksmith.equals(blacksmith2));
    System.out.println("It's a singleton!");
    System.out.println("Let's test the factory portion of this pattern");
    Weapon w = blacksmith.create(WeaponType.SWORD);
    System.out.println("Here's a sword: " + w);
    System.out.println("Great, let's make our heroes!");
    // ****************** Heroes & Leader (Singleton) ******************
    System.out.println(" **** Heroes and Leader (Singleton) **** ");
    System.out.println("Creating 4 heroes. 3 with weapons, 1 without");
    // Here is the blacksmith's factory pattern
    Hero h1 = new Hero("Andres", blacksmith.create(WeaponType.SWORD));
    Hero h2 = new Hero("Carolina");
    Hero h3 = new Hero("Valeria", blacksmith.create(WeaponType.STAFF));
    Hero h4 = new Hero("Alfred", blacksmith.create(WeaponType.AXE));
    System.out.println(h1 + "\n" + h2 + "\n" + h3 + "\n" + h4);
    // Here is the hero's singleton pattern (leader)
    System.out.println("Let's test the hero singleton (leader)");
    System.out.println("Making Hero 1 the leader");
    Hero.assignLeader(h1);
    System.out.println("Making Hero 2 the leader");
    Hero.assignLeader(h2);
    System.out.println("Check the special leader character (**) to see who it is!");
    System.out.println("Who does hero 1 think the leader is? : " + h1.getLeader());
    System.out.println("Who does hero 4 think the leader is? : " + h4.getLeader());
    System.out.println("Let's try retire the leader");
    Hero.retireLeader();
    System.out.println("Who is the leader? " + h1.getLeader());
    System.out.println("Ok, let's make them a leader again");
    Hero.assignLeader(h1);
    System.out.println("Let's also upgrade their weapon's damage");
    h1.upgradeWeapon(1);
    System.out.println("Here's the leader of all heroes: " + Hero.getLeader());
    System.out.println("We're clear on who the leader is. Let's make a party!");
    List<Hero> party = new ArrayList<Hero>(Arrays.asList(h1, h2, h3, h4));
    System.out.println(party);
    System.out.println("Looks like our party is ready to go on a quest!");
    System.out.println(" **** Quest (State) **** ");
    Quest_State q_state = new Quest_Town();
    Quest q = new Quest(q_state);
    q.recruit(party);
    System.out.println("Out of curiosity, what's our party's total damage output?");
    System.out.println(q.getTotalHeroDamage());
    System.out.println("Here is information on the current quest: " + "\n" + q);
    System.out.println("Let's iterate through the rest of the quest");
    while(true) {
      // check the next state to see if we're at the last one or not
      if(q_state.changeState() != null) {
        Quest_State prev_state = q_state;
        q_state = q_state.changeState();
        q = new Quest(q_state, q.getHeroes());
        // if previous state and current are the same, you failed.
        if(q.getState() == prev_state) {
          q_state = prev_state;
          System.out.println("Failed the quest");
          break;
        }
      }
      else {
        System.out.println("You've completed your quest!");
        System.out.println("Congradulations: " + q.getHeroes());
        break;
      }
    }
    System.out.println(" ********** END OF PATTERN TESTING ********** \n\n\n");
  }
}
