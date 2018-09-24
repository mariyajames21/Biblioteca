package biblioteca.controller.command;

import biblioteca.model.ItemType;
import biblioteca.model.Library;
import biblioteca.model.User;
import biblioteca.view.InputDriver;
import biblioteca.view.OutputDriver;

import java.util.Arrays;

public class ListBooksCommand implements Command {

    public void perform(Library library,  InputDriver inputDriver, OutputDriver outputDriver) {
        outputDriver.print(Arrays.asList("Title", "Author", "Year"));
        outputDriver.printHorizontalLine(115);
        outputDriver.printAsColumns(library.getDetails(ItemType.BOOK));
    }

}
