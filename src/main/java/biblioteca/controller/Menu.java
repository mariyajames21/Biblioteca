package biblioteca.controller;

import biblioteca.controller.command.*;
import biblioteca.model.Library;
import biblioteca.model.User;
import biblioteca.view.InputDriver;
import biblioteca.view.OutputDriver;

public enum Menu {

    EXIT("Exit from application",new ExitCommand()),
    LIST_OF_BOOKS("List of books", new ListBooksCommand()),
    CHECKOUT_BOOKS("Checkout books", new AuthenticatorCommand(new CheckOutBookCommand())) ,
    RETURN_BOOK("Return book", new AuthenticatorCommand(new ReturnBookCommand())),
    LIST_OF_MOVIES("List of movies",new ListMoviesCommand()),
    CHECK_OUT_MOVIES("Checkout movies",new AuthenticatorCommand(new CheckOutMoviesCommand())),
    RETURN_MOVIE("Return movie",new AuthenticatorCommand(new ReturnMovieCommand())),
    LOG_OUT("Log out",new AuthenticatorCommand(new LogOutCommand())){
        @Override
        public String display(Library library) {
            if(library.isLoggedIn()){
                return this.ordinal() + "." +"Log out";
            }
            return "";
        }
    };

    private String displayString;
    private Command action;

    Menu(String displayString, Command action) {
        this.displayString = displayString;
        this.action=action;
    }

    public String display(Library library) {
        return this.ordinal() + "." + displayString;
    }

    public void perform(Library library ,OutputDriver outputDriver, InputDriver inputDriver) {
        this.action.perform(library, inputDriver, outputDriver);
    }
}