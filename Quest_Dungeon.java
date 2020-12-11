
// state pattern

public class Quest_Dungeon implements Quest_State {
  public String getName() {
    return "DUNGEON";
  }
  public Quest_State getState() {
    return this;
  }
  public Quest_State changeState() {
    return new Quest_Complete();
  }
}
