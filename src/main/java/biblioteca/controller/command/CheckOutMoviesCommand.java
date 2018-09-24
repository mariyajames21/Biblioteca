package biblioteca.controller.command;

import biblioteca.model.ItemType;
import biblioteca.model.Library;
import biblioteca.model.User;
import biblioteca.view.InputDriver;
import biblioteca.view.OutputDriver;

public class CheckOutMoviesCommand implements Command {
    @Override
    public void perform(Library library, InputDriver inputDriver, OutputDriver outputDriver) {
        outputDriver.print("Enter the name of the movie.");
        String message = library.checkOutItem(inputDriver.readString(), ItemType.MOVIE) ? "Thank you! Enjoy the movie" : "That movie is not available";
        outputDriver.print(message);
    }

}
