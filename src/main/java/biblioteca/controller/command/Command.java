package biblioteca.controller.command;

import biblioteca.model.Library;
import biblioteca.model.User;
import biblioteca.view.InputDriver;
import biblioteca.view.OutputDriver;

public interface Command {
    void perform(Library library, InputDriver inputDriver, OutputDriver outputDriver);
}
