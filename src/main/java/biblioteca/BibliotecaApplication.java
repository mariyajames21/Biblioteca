package biblioteca;

import biblioteca.controller.LibraryManagementSystem;
import biblioteca.model.Book;
import biblioteca.model.Library;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaApplication {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        books.add(new Book("The Hobbit", "J R R Tolkein", "1937"));
        books.add(new Book("The  Fault in our stars", "John Green", "2014"));
        Library library = new Library(books);
        LibraryManagementSystem libraryManagementSystem = new LibraryManagementSystem(library);
        libraryManagementSystem.printWelcomeMessage();
        libraryManagementSystem.printMenu();
    }
}
