package biblioteca.controller;

import biblioteca.model.Library;
import biblioteca.view.InputDriver;
import biblioteca.view.OutputDriver;

public class ExitCommand implements Command {
    public void perform(Library library, OutputDriver outputDriver, InputDriver inputDriver) {
        outputDriver.print("Quiting...");
    }
}
