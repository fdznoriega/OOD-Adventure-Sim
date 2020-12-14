
package Commands;

import UI.UI;

public class HelpCommand implements Command {

  // need a UI to display this command
  private UI ui;

  public HelpCommand(UI ui) {
    this.ui = ui;
  }

  public void execute() {
    ui.showAllPossibleCommands();
  }

}
