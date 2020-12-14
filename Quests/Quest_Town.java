
package Quests;

// state pattern

public class Quest_Town implements Quest_State {

  private Boolean solved = true;

  public String getName() {
    return "TOWN";
  }
  public Quest_State getState() {
    return this;
  }
  public Quest_State changeState() {
    return new Quest_Ocean();
  }

  public Boolean isBlacksmithAvailable() {
    return true;
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
      "> Welcome to the humble town of OOD. Your objective is to make it \n" +
      "> to the treasure hidden at a nearby dungeon. I recommend visiting \n" +
      "> the blacksmith first. Type 'help' for more options.";

  }

}
