
package Quests;

// state pattern

public class Quest_Ocean implements Quest_State {

  public String getName() {
    return "OCEAN";
  }
  public Quest_State getState() {
    return this;
  }
  public Quest_State changeState() {
    return new Quest_Dungeon();
  }
}
