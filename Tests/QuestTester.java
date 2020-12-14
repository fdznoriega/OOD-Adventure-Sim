
// test quest (state pattern)
// test hero and leader (singleton)

package Tests;

import Quests.*;
import Weapons.*;
import People.*;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class QuestTester {
  public static void main(String[] args) {
    // starting state
    Quest_State q_state = new Quest_Town();
    System.out.println("Create quest");
    Quest q = new Quest(q_state);
    // immediately try retire a hero

    // create heroes!
    Hero h1 = new Hero("Valeria");
    Hero h2 = new Hero("Andres", new Sword());
    Hero h3 = new Hero("Carolina", new Sword());
    Hero h4 = new Hero("Alfred", new Axe());

    List<Hero> heroesToHire = new ArrayList<Hero>(Arrays.asList(h1, h2, h3, h4));

    System.out.println("Let's add heroes to the quest");
    q.recruit(heroesToHire);
    System.out.println(q);
    System.out.println("Assign a leader");
    Hero.assignLeader(h1);
    System.out.println(h1);
    System.out.println("Assign a leader with weapon");
    Hero.assignLeader(h3);
    System.out.println("Recruit again");
    q.recruit(heroesToHire);
    System.out.println(q);
    System.out.println("Try retire the leader");
    q.retire(h3);
    System.out.println(q);
    System.out.println("Retire Andres...");
    q.retire(h2);
    System.out.println(q);
    System.out.println("Start the quest");

    // iterate through states
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


  }
}
