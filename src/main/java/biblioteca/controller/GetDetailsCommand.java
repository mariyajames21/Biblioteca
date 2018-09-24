package biblioteca.controller;

import biblioteca.controller.command.Command;
import biblioteca.model.Library;
import biblioteca.view.InputDriver;
import biblioteca.view.OutputDriver;

public class GetDetailsCommand implements Command {
    @Override
    public void perform(Library library, InputDriver inputDriver, OutputDriver outputDriver) {
        outputDriver.print(library.getCurrentUserInformation());
    }
}
