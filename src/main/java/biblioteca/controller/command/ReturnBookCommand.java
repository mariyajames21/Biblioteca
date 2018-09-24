package biblioteca.controller.command;

import biblioteca.model.ItemType;
import biblioteca.model.Library;
import biblioteca.model.User;
import biblioteca.view.InputDriver;
import biblioteca.view.OutputDriver;

public class ReturnBookCommand implements Command {

    public void perform(Library library, InputDriver inputDriver, OutputDriver outputDriver) {
        outputDriver.print("Enter the name of the book");
        String message = library.returnItem(inputDriver.readString(), ItemType.BOOK) ? "Thank you for returning the book" : "That is not a valid book to return";
        outputDriver.print(message);
    }

}
