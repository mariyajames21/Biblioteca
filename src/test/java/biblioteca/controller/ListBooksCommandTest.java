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
import java.util.Arrays;
import java.util.List;

import static biblioteca.controller.Menu.EXIT;
import static biblioteca.controller.Menu.LIST_OF_BOOKS;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class ListBooksCommandTest {

    private Library library;
    private OutputDriver outputDriver;
    private InputDriver inputDriver;
    private ListBooksCommand listBooksCommand;


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
        listBooksCommand = new ListBooksCommand();
    }


    @DisplayName("expects to print the booklist")
    @Test
    void testForPrintListOfBooks() {
        List<List<String>> stringList = Arrays.asList(Arrays.asList("The Hobbit", "J R R Tolkien", "1937"), Arrays.asList("The Fault in our stars", "John Green", "2012"));
        listBooksCommand.perform(library, outputDriver, inputDriver);
        verify(outputDriver).printAsColumns(stringList);
    }

}