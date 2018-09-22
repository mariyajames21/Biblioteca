package biblioteca.controller;

import biblioteca.model.Library;
import biblioteca.view.InputDriver;
import biblioteca.view.OutputDriver;

import java.util.Arrays;

public enum Menu {

    EXIT("Exit from application") {
        @Override
        public void act(Library library, OutputDriver outputDriver, InputDriver inputDriver) {
            outputDriver.print("Quiting...");
        }
    },

    LIST_OF_BOOKS("List of books") {
        @Override
        public void act(Library library, OutputDriver outputDriver, InputDriver inputDriver) {
            outputDriver.print(Arrays.asList("Title", "Author", "Year"));
            outputDriver.printHorizontalLine(115);
            outputDriver.printAsColumns(library.getBooks());
        }
    },
    CHECKOUT_BOOKS("Checkout books") {
        @Override
        public void act(Library library, OutputDriver outputDriver, InputDriver inputDriver) {
            outputDriver.print("Enter the name of the book.");
            inputDriver.readString();
            String message = library.checkOut(inputDriver.readString()) ? "Thank you! Enjoy the book" : "That book is not available";
            outputDriver.print(message);
        }
    }, RETURN_BOOK("Return book") {
        @Override
        public void act(Library library, OutputDriver outputDriver, InputDriver inputDriver) {
            outputDriver.print("Enter the name of the book");
            inputDriver.readString();
            String message = library.returnBook(inputDriver.readString()) ? "Thank you for returning the book" : "That is not a valid book to return";
            outputDriver.print(message);
        }
    };

    private String displayString;

    Menu(String displayString) {
        this.displayString = displayString;
    }

    public String display() {
        return this.ordinal() + "." + displayString;
    }

    public void act(Library library, OutputDriver outputDriver, InputDriver inputDriver) {
    }
}
