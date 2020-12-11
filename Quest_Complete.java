
// state pattern

public class Quest_Complete implements Quest_State {

  public String getState() {
    return "COMPLETE";
  }
  public Quest_State changeState() {
    return null;
  }

}
