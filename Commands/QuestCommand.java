
package Commands;

import UI.UI;
import Quests.Quest;

public class QuestCommand implements Command {

  // need a UI to display this command
  private UI ui;
  private Quest q;

  public QuestCommand(UI ui, Quest q) {
    this.ui = ui;
    this.q = q;
  }

  public void execute() {
    ui.showQuest(q);

  }


}
