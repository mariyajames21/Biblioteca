package biblioteca;

import biblioteca.controller.LibraryManagementSystem;
import biblioteca.model.*;
import biblioteca.view.InputDriver;
import biblioteca.view.OutputDriver;
import java.util.ArrayList;
import java.util.List;

public class BibliotecaApplication {
    public static void main(String[] args) {
        List<Item> items = new ArrayList<>();
        items.add(new Book("The Hobbit", "J R R Tolkien", "1937"));
        items.add(new Book("The  Fault in our stars", "John Green", "2014"));
        items.add(new Movie("Movie 1","2015","Director 1",7));
        items.add( new Movie("Movie 2","1990","Director 2",0));
        ItemList itemList = new ItemList(items);
        Library library = new Library(itemList);
        OutputDriver outputDriver = new OutputDriver();
        InputDriver inputDriver = new InputDriver();
        LibraryManagementSystem libraryManagementSystem = new LibraryManagementSystem(outputDriver,inputDriver,library);
        libraryManagementSystem.printWelcomeMessage();
        libraryManagementSystem.showMenu();
    }
}
