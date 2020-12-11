
// state pattern

public class Quest_Ocean implements Quest_State {

  public String getState() {
    return "OCEAN";
  }
  public Quest_State changeState() {
    return new Quest_Dungeon();
  }
}
