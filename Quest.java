
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
    this.state = s;

    if(Hero.getLeader() == null) {
      System.out.println("Caution: There is no leader!");
    }
    else {
      this.heroes = h;
    }

  }

  public String getState() {
    return state.getState();
  }

  public List<Hero> getHeroes() {
    return heroes;
  }

  // recruit heroes and ensure there is a leader
  public void recruit(List<Hero> heroList) {
    if(Hero.getLeader() == null) {
      System.out.println("Caution: There must be a leader!");
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
      return;
    }
    this.heroes.remove(heroToRemove);
  }

  @Override
  public String toString() {
    String str = "Quest: " + state.getState();
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
    Hero h2 = new Hero("Andres");
    Hero h3 = new Hero("Carolina");
    Hero h4 = new Hero("Alfred");

    System.out.println("Try retire a hero right away!");
    q.retire(h1);
    System.out.println(q);
    // recruit many heroes
    System.out.println("Let's heroes to the quest");

    List<Hero> heroesToHire = new ArrayList<Hero>(Arrays.asList(h3, h4));

    q.recruit(heroesToHire);

    System.out.println("Retire Andres...");
    q.retire(h2);
    System.out.println("Iterate through all states:");

    // iterate through states
    while(true) {
      // check the next state to see if we're at the last one or not
      if(q_state.changeState() != null) {
        q_state = q_state.changeState();
        q = new Quest(q_state, q.getHeroes());
        System.out.println(q);
      }
      else {
        break;
      }
    }

    System.out.println("You've completed your quest!");
    System.out.println("Congradulations: " + q.getHeroes());



  }
}
