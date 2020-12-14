
package Quests;

// state pattern
// TOWN -> OCEAN -> DUNGEON -> COMPLETE

public interface Quest_State {
  public String getName();
  public Quest_State getState();
  public Quest_State changeState();
  public Boolean isBlacksmithAvailable();
  public String getSolution();
  public Boolean isSolved();
  public void setSolved(Boolean b);
  public String getScenario();
}
