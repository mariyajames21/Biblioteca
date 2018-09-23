package biblioteca.controller;

import biblioteca.model.*;
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
        List<Item> items = new ArrayList<>();
        items.add(new Book("The Hobbit", "J R R Tolkien", "1937"));
        items.add(new Book("The  Fault in our stars", "John Green", "2014"));
        items.add(new Movie("Movie 1", "2015", "Director 1", 7));
        items.add(new Movie("Movie 2", "1990", "Director 2", 0));
        ItemList itemList = new ItemList(items);
        library = new Library(itemList);
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
        LIST_OF_BOOKS.perform(library, outputDriver, inputDriver);
        verify(outputDriver).printAsColumns(stringList);
    }

    @DisplayName("expects to remove book from library")
    @Test
    void testForCheckout() {
        when(inputDriver.readString()).thenReturn("The Hobbit");
        CHECKOUT_BOOKS.perform(library, outputDriver, inputDriver);
        assertFalse(library.containsItem("The Hobbit", ItemType.BOOK));
        verify(outputDriver).print("Enter the name of the book.");
        verify(outputDriver).print("Thank you! Enjoy the book");
    }

    @DisplayName("expects to print message 'That book is not available'")
    @Test
    void testForCheckoutBookNotAvailable() {
        when(inputDriver.readString()).thenReturn("Spy");
        CHECKOUT_BOOKS.perform(library, outputDriver, inputDriver);
        verify(outputDriver).print("Enter the name of the book.");
        verify(outputDriver).print("That book is not available");
    }

    @DisplayName("expects to addItem the book back to the library")
    @Test
    void testForReturnBook() {
        when(inputDriver.readString()).thenReturn("The Hobbit");
        CHECKOUT_BOOKS.perform(library, outputDriver, inputDriver);
        Menu.RETURN_BOOK.perform(library, outputDriver, inputDriver);
        assertTrue(library.containsItem("The Hobbit", ItemType.BOOK));
    }

    @DisplayName("expects to print message 'That is not a valid book' if the title is wrong")
    @Test
    void testForInvalidReturnBookTitle() {
        when(inputDriver.readString()).thenReturn("Spy");
        Menu.RETURN_BOOK.perform(library, outputDriver, inputDriver);
        verify(outputDriver).print("Enter the name of the book");
        verify(outputDriver).print("That is not a valid book to return");
    }

    @DisplayName("expects to print message 'That is not a valid book' if the book has not already been checked out")
    @Test
    void testForInvalidReturnBook() {
        when(inputDriver.readString()).thenReturn("The Hobbit");
        Menu.RETURN_BOOK.perform(library, outputDriver, inputDriver);
        verify(outputDriver).print("Enter the name of the book");
        verify(outputDriver).print("That is not a valid book to return");
    }

}