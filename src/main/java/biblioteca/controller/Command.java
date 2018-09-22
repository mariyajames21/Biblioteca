package biblioteca.controller;

import biblioteca.model.Library;
import biblioteca.view.InputDriver;
import biblioteca.view.OutputDriver;

public interface Command {
    void perform(Library library, OutputDriver outputDriver, InputDriver inputDriver);
}
