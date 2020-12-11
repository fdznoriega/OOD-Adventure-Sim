
// state pattern

public class Quest_Dungeon implements Quest_State {

  public String getState() {
    return "DUNGEON";
  }
  public Quest_State changeState() {
    return new Quest_Complete();
  }
}
