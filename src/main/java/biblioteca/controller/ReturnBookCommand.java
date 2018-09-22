package biblioteca.controller;

import biblioteca.model.Library;
import biblioteca.view.InputDriver;
import biblioteca.view.OutputDriver;

public class ReturnBookCommand implements Command {

    public void perform(Library library, OutputDriver outputDriver, InputDriver inputDriver) {
        outputDriver.print("Enter the name of the book");
        inputDriver.readString();
        String message = library.returnBook(inputDriver.readString()) ? "Thank you for returning the book" : "That is not a valid book to return";
        outputDriver.print(message);
    }
}
