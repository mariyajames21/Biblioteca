package biblioteca.controller;

import biblioteca.model.Library;
import biblioteca.view.InputDriver;
import biblioteca.view.OutputDriver;

public class LibraryManagementSystem {
    private OutputDriver outputDriver;
    private InputDriver inputDriver;
    private Library library;

    public LibraryManagementSystem(OutputDriver outputDriver, Library library) {
        this.inputDriver = new InputDriver();
        this.outputDriver = outputDriver;
        this.library = library;
    }

    public LibraryManagementSystem(Library library) {
        this.inputDriver = new InputDriver();
        this.outputDriver = new OutputDriver();
        this.library = library;
    }

    public void printWelcomeMessage() {
        outputDriver.print("Welcome to Biblioteca");
    }

    public void printListOfBooks() {
        outputDriver.print(library.getBooks());
    }

    public void printMenu() {
        outputDriver.printMenu();
        int choice = inputDriver.getMenuChoice();
        switch (choice){
            case 1: outputDriver.printMenu();
                    break;
            default:outputDriver.print("Wrong Choice");
        }
    }
}
