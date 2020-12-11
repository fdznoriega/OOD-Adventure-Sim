
// state pattern

public class Quest_Complete implements Quest_State {
  public String getName() {
    return "COMPLETE";
  }
  public Quest_State getState() {
    return this;
  }
  public Quest_State changeState() {
    return null;
  }

}
