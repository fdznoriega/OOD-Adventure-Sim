
// state pattern

public class Quest_Town implements Quest_State {

  public String getName() {
    return "TOWN";
  }
  public Quest_State getState() {
    return this;
  }
  public Quest_State changeState() {
    return new Quest_Ocean();
  }

}
