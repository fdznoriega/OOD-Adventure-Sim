

package Quests;

// state pattern

public class Quest_Battle1 implements Quest_State {

  private Boolean solved = false;

  public String getName() {
    return "Battle1";
  }
  public Quest_State getState() {
    return this;
  }
  public Quest_State changeState() {
    return new Quest_Dungeon();
  }

  public Boolean isBlacksmithAvailable() {
    return false;
  }
  public String getSolution() {
    return "FLIGHT";
  }
  public Boolean isSolved() {
    return solved;
  }
  public void setSolved(Boolean b) {
    solved = b;
  }
  public String getScenario() {
    return
      "> You gaze into the depths, and see a shadow of great size \n" +
      "> lurking below. You have two options: fight or flight \n" +
      "> The wrong choice will spell the end of your quest.";
  }

}
