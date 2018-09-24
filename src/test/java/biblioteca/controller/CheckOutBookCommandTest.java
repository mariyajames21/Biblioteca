package biblioteca.controller;

import biblioteca.controller.command.CheckOutBookCommand;
import biblioteca.model.*;
import biblioteca.view.InputDriver;
import biblioteca.view.OutputDriver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class CheckOutBookCommandTest {

    private Library library;
    private OutputDriver outputDriver;
    private InputDriver inputDriver;
    private CheckOutBookCommand checkOutBookCommand;
    User user = new User("123-4567","qwertyuiop");

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
        checkOutBookCommand = new CheckOutBookCommand();
        library.login(user);

    }

    @DisplayName("expects to remove book from library")
    @Test
    void testForCheckout() {
        when(inputDriver.readString()).thenReturn("The Hobbit");
        checkOutBookCommand.perform(library,  inputDriver, outputDriver);
        assertFalse(library.containsItem("The Hobbit", ItemType.BOOK));
        verify(outputDriver).print("Enter the name of the book.");
        verify(outputDriver).print("Thank you! Enjoy the book");
    }

    @DisplayName("expects to print message 'That book is not available'")
    @Test
    void testForCheckoutBookNotAvailable() {
        when(inputDriver.readString()).thenReturn("Spy");
        checkOutBookCommand.perform(library,  inputDriver, outputDriver);
        verify(outputDriver).print("Enter the name of the book.");
        verify(outputDriver).print("That book is not available");
    }


}