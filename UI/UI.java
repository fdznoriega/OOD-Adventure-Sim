
package UI;

import Quests.*;

public interface UI {
  public void getInput();
  public void showQuest(Quest q);
  public void updateQuest();
  public void showBlacksmith();
  public void showBlacksmithUnavailable();
  public void showEquipmentOptions();  // this one is a constant
  public void showEquipSuccessful();
  public void showEquipUnsuccessful();
  public Boolean getQuitGame();
  public Boolean getGameOver();
  public void showGameOver();
  public void showAllPossibleCommands();
  public void showFightOrFlight();
  public void showScenario();
  // public void showEquip();
  // public void showTravel();
  // public void showFight();
  // public void showFlight();

}
