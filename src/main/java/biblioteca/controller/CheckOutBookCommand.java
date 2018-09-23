package biblioteca.controller;

import biblioteca.model.ItemType;
import biblioteca.model.Library;
import biblioteca.view.InputDriver;
import biblioteca.view.OutputDriver;

public class CheckOutBookCommand implements Command {

    public void perform(Library library, OutputDriver outputDriver, InputDriver inputDriver) {
        outputDriver.print("Enter the name of the book.");
        String message = library.checkOutItem(inputDriver.readString(), ItemType.BOOK) ? "Thank you! Enjoy the book" : "That book is not available";
        outputDriver.print(message);
    }
}
