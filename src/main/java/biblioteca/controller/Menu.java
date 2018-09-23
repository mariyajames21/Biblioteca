package biblioteca.controller;

import biblioteca.model.Library;
import biblioteca.view.InputDriver;
import biblioteca.view.OutputDriver;

public enum Menu {

    EXIT("Exit from application",new ExitCommand()),
    LIST_OF_BOOKS("List of books", new ListBooksCommand()),
    CHECKOUT_BOOKS("Checkout books", new CheckOutBookCommand()) ,
    RETURN_BOOK("Return book", new ReturnBookCommand()),
    LIST_OF_MOVIES("List of movies",new ListMoviesCommand()),
    CHECK_OUT_MOVIES("Checkout movies",new CheckOutMoviesCommand()),
    RETURN_MOVIE("Return movie",new ReturnMovieCommand());

    private String displayString;
    private Command action;

    Menu(String displayString, Command action) {
        this.displayString = displayString;
        this.action=action;
    }

    public String display() {
        return this.ordinal() + "." + displayString;
    }

    public void perform(Library library, OutputDriver outputDriver, InputDriver inputDriver) {
        this.action.perform(library,outputDriver,inputDriver);
    }
}
