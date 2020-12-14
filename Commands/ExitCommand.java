
package Commands;

import UI.UI;
import UI.CLI;

public class ExitCommand implements Command {

  // need a UI to display this command
  private UI ui;

  public ExitCommand(UI ui) {
    this.ui = ui;
  }

  public void execute() {
    // ui.gamePaused();
    System.out.println("Exit was called");
  }

}
