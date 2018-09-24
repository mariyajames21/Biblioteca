package biblioteca.controller;

import biblioteca.controller.command.ReturnMovieCommand;
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

class ReturnMovieCommandTest {
    private Library library;
    private OutputDriver outputDriver;
    private InputDriver inputDriver;
    private ReturnMovieCommand returnMovieCommand;
    User user= new User(name, email, pnoneNumber, "123-4567","qwertyuiop");


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
        returnMovieCommand = new ReturnMovieCommand();

    }

    @DisplayName("expects to add movie  back to the library")
    @Test
    void testForReturnMovie() {
        when(inputDriver.readString()).thenReturn("Movie 1");
        returnMovieCommand.perform(library, inputDriver, outputDriver);
        assertTrue(library.containsItem("Movie 1", ItemType.MOVIE));
    }

    @DisplayName("expects to print message 'That is not a valid movie' if the title is wrong")
    @Test
    void testForInvalidReturnMovieTitle() {
        when(inputDriver.readString()).thenReturn("Spy");
        returnMovieCommand.perform(library, inputDriver, outputDriver);
        verify(outputDriver).print("Enter the name of the movie");
        verify(outputDriver).print("That is not a valid movie to return");
    }

    @DisplayName("expects to print message 'That is not a valid movie' if the movie has not already been checked out")
    @Test
    void testForInvalidReturnMovie() {
        when(inputDriver.readString()).thenReturn("Movie 1");
        returnMovieCommand.perform(library,  inputDriver, outputDriver);
        verify(outputDriver).print("Enter the name of the movie");
        verify(outputDriver).print("That is not a valid movie to return");
    }

}