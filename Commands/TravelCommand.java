
package Commands;

import UI.UI;

public class TravelCommand implements Command {

  private UI ui;

  public TravelCommand(UI ui) {
    this.ui = ui;
  }

  public void execute() {
    ui.updateQuest();
  }

}
