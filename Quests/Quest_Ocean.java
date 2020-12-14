
package Quests;

// state pattern

public class Quest_Ocean implements Quest_State {

  private Boolean solved = true;

  public String getName() {
    return "OCEAN";
  }
  public Quest_State getState() {
    return this;
  }

  public Quest_State changeState() {
    return new Quest_Battle1();
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
      "> Your travels take you to the ocean. A boundless sea awaits.\n" +
      "> As the waves crash against your ship, you can't help but feel\n" +
      "> something's awry.";
  }

}
