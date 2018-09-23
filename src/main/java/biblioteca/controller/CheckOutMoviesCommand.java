package biblioteca.controller;

import biblioteca.model.ItemType;
import biblioteca.model.Library;
import biblioteca.view.InputDriver;
import biblioteca.view.OutputDriver;

public class CheckOutMoviesCommand implements Command {
    @Override
    public void perform(Library library, OutputDriver outputDriver, InputDriver inputDriver) {
        outputDriver.print("Enter the name of the movie.");
        String message = library.checkOutItem(inputDriver.readString(), ItemType.MOVIE) ? "Thank you! Enjoy the movie" : "That movie is not available";
        outputDriver.print(message);
    }
}
