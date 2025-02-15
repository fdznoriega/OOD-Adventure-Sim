
package Quests;

// state pattern

public class Quest_Dungeon implements Quest_State {

  private Boolean solved = true;

  public String getName() {
    return "DUNGEON";
  }
  public Quest_State getState() {
    return this;
  }
  public Quest_State changeState() {
    return new Quest_Battle2();
  }
  public Boolean isBlacksmithAvailable() {
    return false;
  }
  public String getSolution() {
    return "TRAVEL";
  }
  public Boolean isSolved() {
    return solved;
  }
  public void setSolved(Boolean b) {
    solved = b;
  }
  public String getScenario() {
    return
      "> You avoid the sea-creature and continue your journey. \n" +
      "> Along the coast, you spot a not-so-natural cave. Your party \n" +
      "> discovers torches scattered nearby. Here is the dungeon of legend.";
  }
}
