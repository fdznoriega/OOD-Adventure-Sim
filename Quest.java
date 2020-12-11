
// state pattern
// the quest is not changing; its state is!
// that means we can keep track of our heroes here!
// if at any point our quest has no leader, we stop

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Quest {

  private static Quest_State state;
  private List<Hero> heroes = new ArrayList<Hero>();

  // an empty quest
  public Quest(Quest_State s) {
    this.state = s;
  }

  public Quest(Quest_State s, List<Hero> h) {

    // if no leader, fail quest
    if(Hero.getLeader() == null) {
      System.out.println("Caution: There is no leader!");
    }
    else {
      this.state = s;
      this.heroes = h;
    }

  }

  public Quest_State getState() {
    return state.getState();
  }

  public List<Hero> getHeroes() {
    return heroes;
  }

  public int getTotalHeroDamage() {
    int dmg = 0;
    for(Hero h : heroes) {
      dmg += h.getWeapon().getDamage();
    }
    return dmg;
  }

  // THIS IS THE ONLY WAY OF ADDING HEROES TO A QUEST
  // THEREFORE WE CAN RESTRICT BY: LEADER, WEAPON
  public void recruit(List<Hero> heroList) {
    if(Hero.getLeader() == null) {
      System.out.println("Caution: There must be a leader to go on a quest!");
      return;
    }
    for(Hero hero : heroList) {
      if(hero.getWeapon() != null) {
        this.heroes.add(hero);
      }
      else {
        System.out.println("Caution: " + hero.getName() +
          " was not added to the quest because they must have a weapon");
      }

    }
  }

  public void retire(Hero heroToRemove) {
    if(this.heroes == null) {
      System.out.println("Caution: There are no heroes recruited");
      return;
    }
    if(Hero.getLeader() == heroToRemove && heroes.size() > 1) {
      System.out.println("Caution: You cannot remove the leader from the quest");
      return;
    }
    this.heroes.remove(heroToRemove);
  }

  public void retireAll() {
    this.heroes = null;
  }

  @Override
  public String toString() {
    String str = "Quest: " + state.getName();
    if(heroes == null) {
      return str;
    }
    else {
      return str + "\n" + "Heroes: " + heroes.toString();
    }

  }

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
