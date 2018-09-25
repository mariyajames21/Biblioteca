package biblioteca.controller;

import biblioteca.controller.command.*;
import biblioteca.model.Library;
import biblioteca.view.InputDriver;
import biblioteca.view.OutputDriver;

import static biblioteca.controller.command.Printable.ALWAYS;
import static biblioteca.controller.command.Printable.IFLOGGEDIN;

public enum Menu {

    EXIT("Exit from application", new ExitCommand(), ALWAYS),
    LIST_OF_BOOKS("List of books", new ListBooksCommand(), ALWAYS),
    CHECKOUT_BOOKS("Checkout books", new AuthenticatorCommand(new CheckOutBookCommand()), ALWAYS),
    RETURN_BOOK("Return book", new AuthenticatorCommand(new ReturnBookCommand()), ALWAYS),
    LIST_OF_MOVIES("List of movies", new ListMoviesCommand(), ALWAYS),
    CHECK_OUT_MOVIES("Checkout movies", new AuthenticatorCommand(new CheckOutMoviesCommand()), ALWAYS),
    RETURN_MOVIE("Return movie", new AuthenticatorCommand(new ReturnMovieCommand()), ALWAYS),
    USER_DETAILS("Get your details", new AuthenticatorCommand(new GetDetailsCommand()), IFLOGGEDIN),
    LOG_OUT("Log out", new AuthenticatorCommand(new LogOutCommand()), IFLOGGEDIN);

    private String displayString;
    private Command action;
    private Printable printable;

    Menu(String displayString, Command action, Printable printable) {
        this.displayString = displayString;
        this.action = action;
        this.printable = printable;
    }

    public String display() {
        return this.ordinal() + "." + displayString;
    }

    public void perform(Library library, OutputDriver outputDriver, InputDriver inputDriver) {
        this.action.perform(library, inputDriver, outputDriver);
    }

    public boolean isPrintable() {
        return printable.isPrintable();
    }
}