package biblioteca;

import biblioteca.controller.LibraryManagementSystem;
import biblioteca.model.Book;
import biblioteca.model.BookList;
import biblioteca.model.Library;
import biblioteca.model.Movie;
import biblioteca.view.InputDriver;
import biblioteca.view.OutputDriver;
import java.util.ArrayList;
import java.util.List;

public class BibliotecaApplication {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        books.add(new Book("The Hobbit", "J R R Tolkien", "1937"));
        books.add(new Book("The  Fault in our stars", "John Green", "2014"));
        BookList bookList = new BookList(books);
        List<Movie> movies= new ArrayList<>();
        movies.add(new Movie("Movie 1","2015","Director 1",7));
        movies.add( new Movie("Movie 2","1990","Director 2",0));
        Library library = new Library(bookList, movies);
        OutputDriver outputDriver = new OutputDriver();
        InputDriver inputDriver = new InputDriver();
        LibraryManagementSystem libraryManagementSystem = new LibraryManagementSystem(outputDriver,inputDriver,library);
        libraryManagementSystem.printWelcomeMessage();
        libraryManagementSystem.showMenu();
    }
}
