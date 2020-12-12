
package Quests;

// state pattern
// the quest is not changing; its state is!
// that means we can keep track of our heroes here!
// if at any point our quest has no leader, we stop

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import People.Hero;

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


}
