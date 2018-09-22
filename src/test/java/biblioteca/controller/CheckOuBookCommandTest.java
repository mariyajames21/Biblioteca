package biblioteca.controller;

import biblioteca.model.Book;
import biblioteca.model.BookList;
import biblioteca.model.Library;
import biblioteca.model.Movie;
import biblioteca.view.InputDriver;
import biblioteca.view.OutputDriver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static biblioteca.controller.Menu.CHECKOUT_BOOKS;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class CheckOuBookCommandTest {

    private Library library;
    private OutputDriver outputDriver;
    private InputDriver inputDriver;
    private CheckOuBookCommand checkOuBookCommand;

    @BeforeEach
    void init() {
        List<Book> books = new ArrayList<>();
        List<Movie> movies = new ArrayList<>();
        books.add(new Book("The Hobbit", "J R R Tolkien", "1937"));
        books.add(new Book("The Fault in our stars", "John Green", "2012"));
        BookList bookList = new BookList(books);
        movies.add(new Movie("Movie 1", "2015", "Director 1", 7));
        movies.add(new Movie("Movie 2", "1990", "Director 2", 0));
        library = new Library(bookList, movies);
        outputDriver = mock(OutputDriver.class);
        inputDriver = mock(InputDriver.class);
        checkOuBookCommand = new CheckOuBookCommand();
    }

    @DisplayName("expects to remove book from library")
    @Test
    void testForCheckout() {
        when(inputDriver.readString()).thenReturn("The Hobbit");
        checkOuBookCommand.perform(library, outputDriver, inputDriver);
        assertFalse(library.containsBook("The Hobbit"));
        verify(outputDriver).print("Enter the name of the book.");
        verify(outputDriver).print("Thank you! Enjoy the book");
    }

    @DisplayName("expects to print message 'That book is not available'")
    @Test
    void testForCheckoutBookNotAvailable() {
        when(inputDriver.readString()).thenReturn("Spy");
        checkOuBookCommand.perform(library, outputDriver, inputDriver);
        verify(outputDriver).print("Enter the name of the book.");
        verify(outputDriver).print("That book is not available");
    }


}