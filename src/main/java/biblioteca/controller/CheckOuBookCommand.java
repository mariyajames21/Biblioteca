package biblioteca.controller;

import biblioteca.model.Library;
import biblioteca.view.InputDriver;
import biblioteca.view.OutputDriver;

public class CheckOuBookCommand implements Command {

    public void perform(Library library, OutputDriver outputDriver, InputDriver inputDriver) {
        outputDriver.print("Enter the name of the book.");
        inputDriver.readString();
        String message = library.checkOut(inputDriver.readString()) ? "Thank you! Enjoy the book" : "That book is not available";
        outputDriver.print(message);
    }
}
