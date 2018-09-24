package biblioteca.controller.command;

import biblioteca.model.ItemType;
import biblioteca.model.Library;
import biblioteca.model.User;
import biblioteca.view.InputDriver;
import biblioteca.view.OutputDriver;

public class CheckOutBookCommand implements Command {

    public void perform(Library library, User user, InputDriver inputDriver, OutputDriver outputDriver) {
        outputDriver.print("Enter the name of the book.");
        String message = library.checkOutItem(inputDriver.readString(), ItemType.BOOK, user) ? "Thank you! Enjoy the book" : "That book is not available";
        outputDriver.print(message);
    }

}
