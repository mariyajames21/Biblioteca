package biblioteca.controller;

import biblioteca.model.Book;
import biblioteca.model.Library;
import biblioteca.view.InputDriver;
import biblioteca.view.OutputDriver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static biblioteca.controller.Menu.CHECKOUT_BOOKS;
import static biblioteca.controller.Menu.EXIT;
import static biblioteca.controller.Menu.LIST_OF_BOOKS;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class MenuTest {

    private Library library;
    private OutputDriver outputDriver;
    private InputDriver inputDriver;


    @BeforeEach
    void init() {
        List<Book> books = new ArrayList<>();
        books.add(new Book("The Hobbit", "J R R Tolkien", "1937"));
        books.add(new Book("The Fault in our stars", "John Green", "2012"));
        library = new Library(books);
        outputDriver = mock(OutputDriver.class);
        inputDriver = mock(InputDriver.class);
    }

    @DisplayName("expects to return 'List of books' for LIST_OF_BOOKS enum")
    @Test
    void testForListOfBooks() {
        assertEquals("1.List of books", LIST_OF_BOOKS.display());
    }

    @DisplayName("expects to return 'Exit from application' for LIST_OF_BOOKS enum")
    @Test
    void testForExitFromApplication() {
        assertEquals("0.Exit from application", EXIT.display());
    }

    @DisplayName("expects to print the booklist")
    @Test
    void testForPrintListOfBooks() {
        List<List<String>> stringList = Arrays.asList(Arrays.asList("The Hobbit", "J R R Tolkien", "1937"), Arrays.asList("The Fault in our stars", "John Green", "2012"));
        LIST_OF_BOOKS.act(library, outputDriver, inputDriver);
        verify(outputDriver).printAsColumns(stringList);
    }

    @DisplayName("expects to remove book from library")
    @Test
    void testForCheckout() {
        when(inputDriver.readString()).thenReturn("The Hobbit");
        CHECKOUT_BOOKS.act(library,outputDriver,inputDriver);
        assertFalse(library.contains("The Hobbit"));
        verify(outputDriver).print("Enter the name of the book.");
        verify(outputDriver).print("Thank you! Enjoy the book");
    }

    @DisplayName("expects to print message 'That book is not available'")
    @Test
    void testForCheckoutBookNotAvailable() {
        when(inputDriver.readString()).thenReturn("Spy");
        CHECKOUT_BOOKS.act(library,outputDriver,inputDriver);
        verify(outputDriver).print("Enter the name of the book.");
        verify(outputDriver).print("That book is not available");
    }

}