package biblioteca.controller.command;

import biblioteca.controller.command.Command;
import biblioteca.model.Library;
import biblioteca.model.User;
import biblioteca.view.InputDriver;
import biblioteca.view.OutputDriver;

public class LogOutCommand implements Command{
    @Override
    public void perform(Library library,  InputDriver inputDriver, OutputDriver outputDriver) {
        library.logout();
        outputDriver.print("Logging out...");
    }
}
