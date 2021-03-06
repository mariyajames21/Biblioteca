package biblioteca.controller;

import biblioteca.controller.command.ListMoviesCommand;
import biblioteca.model.*;
import biblioteca.view.InputDriver;
import biblioteca.view.OutputDriver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class ListMoviesCommandTest {
    private Library library;
    private OutputDriver outputDriver;
    private InputDriver inputDriver;
    private ListMoviesCommand listMoviesCommand;


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
        listMoviesCommand = new ListMoviesCommand();

    }


    @DisplayName("expects to print the booklist")
    @Test
    void testForPrintListOfBooks() {
        List<List<String>> stringList = Arrays.asList(Arrays.asList("Movie 1", "2015", "Director 1", "7"),
                Arrays.asList("Movie 2", "1990", "Director 2", "Unrated"));
        listMoviesCommand.perform(library,  inputDriver, outputDriver);
        verify(outputDriver).printAsColumns(stringList);
    }


}