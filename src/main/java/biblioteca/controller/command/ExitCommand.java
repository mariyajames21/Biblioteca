package biblioteca.controller.command;

import biblioteca.model.Library;
import biblioteca.model.User;
import biblioteca.view.InputDriver;
import biblioteca.view.OutputDriver;

public class ExitCommand implements Command {
    public void perform(Library library, User user, InputDriver inputDriver, OutputDriver outputDriver) {
        outputDriver.print("Quiting...");
    }

}
