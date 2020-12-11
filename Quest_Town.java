
// state pattern

public class Quest_Town implements Quest_State {

  public String getState() {
    return "TOWN";
  }

  public Quest_State changeState() {
    return new Quest_Ocean();
  }

}
