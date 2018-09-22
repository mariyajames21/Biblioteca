package biblioteca.controller;

import biblioteca.model.Library;
import biblioteca.view.InputDriver;
import biblioteca.view.OutputDriver;

import java.util.Arrays;

public class ListBooksCommand implements Command {

    public void perform(Library library, OutputDriver outputDriver, InputDriver inputDriver) {
        outputDriver.print(Arrays.asList("Title", "Author", "Year"));
        outputDriver.printHorizontalLine(115);
        outputDriver.printAsColumns(library.getBooks());
    }
}
