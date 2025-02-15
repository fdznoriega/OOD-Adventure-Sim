
package Quests;
// state pattern

public class Quest_Complete implements Quest_State {

  private Boolean solved = true;

  public String getName() {
    return "COMPLETE";
  }
  public Quest_State getState() {
    return this;
  }
  public Quest_State changeState() {
    return null;
  }
  public Boolean isBlacksmithAvailable() {
    return false;
  }

  public String getSolution() {
    return "";
  }
  public Boolean isSolved() {
    return solved;
  }
  public void setSolved(Boolean b) {
    solved = b;
  }
  public String getScenario() {
    return
      "> Congradulations, you've defeated the dragon!\n" +
      "> Your party is rich forevermore.";
  }

}
