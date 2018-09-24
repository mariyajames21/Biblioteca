package biblioteca.controller;

import biblioteca.controller.command.CheckOutMoviesCommand;
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

class CheckOutMoviesCommandTest {

    private Library library;
    private OutputDriver outputDriver;
    private InputDriver inputDriver;
    private CheckOutMoviesCommand checkOutMoviesCommand;
    private User user= new User();

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
        checkOutMoviesCommand = new CheckOutMoviesCommand();

    }

    @DisplayName("expects to remove movie from library")
    @Test
    void testForCheckout() {
        when(inputDriver.readString()).thenReturn("Movie 1");
        checkOutMoviesCommand.perform(library, user, inputDriver, outputDriver);
        assertFalse(library.containsItem("Movie 1", ItemType.BOOK));
        verify(outputDriver).print("Enter the name of the movie.");
        verify(outputDriver).print("Thank you! Enjoy the movie");
    }

    @DisplayName("expects to print message 'That movie is not available'")
    @Test
    void testForCheckoutMovieNotAvailable() {
        when(inputDriver.readString()).thenReturn("Spy");
        checkOutMoviesCommand.perform(library, user, inputDriver, outputDriver);
        verify(outputDriver).print("Enter the name of the movie.");
        verify(outputDriver).print("That movie is not available");
    }
}