package biblioteca.controller.command;

import biblioteca.model.ItemType;
import biblioteca.model.Library;
import biblioteca.model.User;
import biblioteca.view.InputDriver;
import biblioteca.view.OutputDriver;

import java.util.Arrays;

public class ListMoviesCommand implements Command {
    @Override
    public void perform(Library library,  InputDriver inputDriver, OutputDriver outputDriver) {
        outputDriver.print(Arrays.asList("Title", "Year", "Director","Rating"));
        outputDriver.printHorizontalLine(160);
        outputDriver.printAsColumns(library.getDetails(ItemType.MOVIE));
    }

}
