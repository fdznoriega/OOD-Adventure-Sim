// state pattern
// TOWN -> OCEAN -> DUNGEON -> COMPLETE


public interface Quest_State {
  public String getState();    // what part of the quest are we on?
  public Quest_State changeState(); // moving on!
  // public List<String> getHeroes();
}
