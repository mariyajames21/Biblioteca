package biblioteca.controller;

import biblioteca.controller.command.ReturnBookCommand;
import biblioteca.model.*;
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
    private User user= new User("User 1", "user1@gmail.com", "384975902", "123-4567","qwertyuiop");


    @BeforeEach
    void init() {
        List<Item> items = new ArrayList<>();
        items.add(new Book("The Hobbit", "J R R Tolkien", "1937"));
        items.add(new Book("The  Fault in our stars", "John Green", "2014"));
        items.add(new Movie("Movie 1", "2015", "Director 1", 7));
        items.add(new Movie("Movie 2", "1990", "Director 2", 0));
        ItemList itemList = new ItemList(items);
        library = new Library(itemList);
        library.login(user);
        outputDriver = mock(OutputDriver.class);
        inputDriver = mock(InputDriver.class);
        returnBookCommand = new ReturnBookCommand();

    }

    @DisplayName("expects to addItem the book back to the library")
    @Test
    void testForReturnBook() {
        when(inputDriver.readString()).thenReturn("The Hobbit");
        returnBookCommand.perform(library,  inputDriver, outputDriver);
        assertTrue(library.containsItem("The Hobbit", ItemType.BOOK));
    }

    @DisplayName("expects to print message 'That is not a valid book' if the title is wrong")
    @Test
    void testForInvalidReturnBookTitle() {
        when(inputDriver.readString()).thenReturn("Spy");
        returnBookCommand.perform(library,  inputDriver, outputDriver);
        verify(outputDriver).print("Enter the name of the book");
        verify(outputDriver).print("That is not a valid book to return");
    }

    @DisplayName("expects to print message 'That is not a valid book' if the book has not already been checked out")
    @Test
    void testForInvalidReturnBook() {
        when(inputDriver.readString()).thenReturn("The Hobbit");
        returnBookCommand.perform(library,  inputDriver, outputDriver);
        verify(outputDriver).print("Enter the name of the book");
        verify(outputDriver).print("That is not a valid book to return");
    }

}