
package Quests;

// state pattern

public class Quest_Battle2 implements Quest_State {

  private Boolean solved = false;

  public String getName() {
    return "Battle2";
  }
  public Quest_State getState() {
    return this;
  }
  public Quest_State changeState() {
    return new Quest_Complete();
  }

  public Boolean isBlacksmithAvailable() {
    return false;
  }

  public String getSolution() {
    return "FIGHT";
  }
  public Boolean isSolved() {
    return solved;
  }
  public void setSolved(Boolean b) {
    solved = b;
  }
  public String getScenario() {
    return
      "> You explore deeper into the cavern and reach the promised treasure! \n" +
      "> Alas, a mighty dragon rests on the gold. Once more: fight or flight?";
  }

}
