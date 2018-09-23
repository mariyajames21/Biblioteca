package biblioteca.controller;

import biblioteca.model.ItemType;
import biblioteca.model.Library;
import biblioteca.view.InputDriver;
import biblioteca.view.OutputDriver;

import java.util.Arrays;

public class ListMoviesCommand implements Command {
    @Override
    public void perform(Library library, OutputDriver outputDriver, InputDriver inputDriver) {
        outputDriver.print(Arrays.asList("Title", "Year", "Director","Rating"));
        outputDriver.printHorizontalLine(160);
        outputDriver.printAsColumns(library.getDetails(ItemType.MOVIE));
    }
}
