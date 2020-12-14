

package Commands;

import UI.UI;
import Quests.Quest;

public class BlacksmithCommand implements Command {

  private UI ui;
  private Quest q;

  public BlacksmithCommand(UI ui, Quest q) {
    this.ui = ui;
    this.q = q;
  }

  public void execute() {
    if(q.isBlacksmithAvailable()) {
      ui.showBlacksmith();
    }
    else {
      ui.showBlacksmithUnavailable();
    }

  }


}
