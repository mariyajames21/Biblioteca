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

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class ReturnBookCommandTest {
    private Library library;
    private OutputDriver outputDriver;
    private InputDriver inputDriver;
    private ReturnBookCommand returnBookCommand;


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
        returnBookCommand = new ReturnBookCommand();
    }

    @DisplayName("expects to addBook the book back to the library")
    @Test
    void testForReturnBook() {
        when(inputDriver.readString()).thenReturn("The Hobbit");
        returnBookCommand.perform(library,outputDriver,inputDriver);
        assertTrue(library.containsBook("The Hobbit"));
    }

    @DisplayName("expects to print message 'That is not a valid book' if the title is wrong")
    @Test
    void testForInvalidReturnBookTitle() {
        when(inputDriver.readString()).thenReturn("Spy");
        returnBookCommand.perform(library,outputDriver,inputDriver);
        verify(outputDriver).print("Enter the name of the book");
        verify(outputDriver).print("That is not a valid book to return");
    }

    @DisplayName("expects to print message 'That is not a valid book' if the book has not already been checked out")
    @Test
    void testForInvalidReturnBook() {
        when(inputDriver.readString()).thenReturn("The Hobbit");
        returnBookCommand.perform(library,outputDriver,inputDriver);
        verify(outputDriver).print("Enter the name of the book");
        verify(outputDriver).print("That is not a valid book to return");
    }

}