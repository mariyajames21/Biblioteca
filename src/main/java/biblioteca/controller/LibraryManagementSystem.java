package biblioteca.controller;

import biblioteca.model.Library;
import biblioteca.model.User;
import biblioteca.model.UserList;
import biblioteca.view.InputDriver;
import biblioteca.view.OutputDriver;

import java.util.Arrays;

public class LibraryManagementSystem {
    private OutputDriver outputDriver;
    private InputDriver inputDriver;
    private Library library;
    private User user;


    public LibraryManagementSystem(OutputDriver outputDriver, InputDriver inputDriver, Library library) {
        this.inputDriver = inputDriver;
        this.outputDriver = outputDriver;
        this.library = library;
        user = new User();
    }


    public void printWelcomeMessage() {
        outputDriver.print(" Welcome to Biblioteca");
        outputDriver.printHorizontalLine(15);
    }

    public void showMenu() {
        int choice;
        do {
            Menu[] menu = Menu.values();
            printMenu(menu);
            choice = inputDriver.readMenuChoice();
            if(choice<menu.length){
                Menu menuOption = menu[choice];
                menuOption.perform(library,user,outputDriver, inputDriver);

            } else {
                outputDriver.print("Select a valid option!");
            }

        } while (choice != 0);
    }

    private void printMenu(Menu[] menu) {
        for (Menu menuItem : menu) {
            outputDriver.print(menuItem.display());
        }
    }
}
