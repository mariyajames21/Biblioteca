package biblioteca.controller.command;

import biblioteca.model.ItemType;
import biblioteca.model.Library;
import biblioteca.model.User;
import biblioteca.view.InputDriver;
import biblioteca.view.OutputDriver;

public class ReturnMovieCommand implements Command {
    @Override
    public void perform(Library library, User user, InputDriver inputDriver, OutputDriver outputDriver) {
        outputDriver.print("Enter the name of the movie");
        String message = library.returnItem(inputDriver.readString(), ItemType.MOVIE) ? "Thank you for returning the movie" : "That is not a valid movie to return";
        outputDriver.print(message);
    }
}
