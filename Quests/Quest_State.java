
package Quests;

// state pattern
// TOWN -> OCEAN -> DUNGEON -> COMPLETE


public interface Quest_State {
  public String getName();
  public Quest_State getState();
  public Quest_State changeState();
}
