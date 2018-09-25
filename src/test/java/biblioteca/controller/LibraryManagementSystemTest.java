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

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class LibraryManagementSystemTest {
    private LibraryManagementSystem libraryManagementSystem;
    private OutputDriver outputDriver;
    private InputDriver inputDriver;
    private Library library;
    User user = new User("User 1", "user1@gmail.com", "384975902","123-4567","qwertyuiop");


    @BeforeEach
    void init() {
        outputDriver = mock(OutputDriver.class);
        inputDriver = mock(InputDriver.class);
        List<Item> items = new ArrayList<>();
        items.add(new Book("The Hobbit", "J R R Tolkien", "1937"));
        items.add(new Book("The Fault in our stars", "John Green", "2012"));
        items.add(new Movie("Movie 1", "2015", "Director 1", 7));
        items.add(new Movie("Movie 2", "1990", "Director 2", 0));
        ItemList itemList = new ItemList(items);
        library = new Library(itemList);
        library.login(user);
        libraryManagementSystem = new LibraryManagementSystem(outputDriver,inputDriver,library);
    }

    @DisplayName("expects to print the welcome message")
    @Test
    void testForPrintWelcomeMessage() {
        libraryManagementSystem.printWelcomeMessage();
        verify(outputDriver).print(" Welcome to Biblioteca");
        verify(outputDriver).printHorizontalLine(15);

    }

    @DisplayName("Print the menu and take the action when option 0 is selected")
    @Test
    void testForPrintMenuAndExit(){
        when(inputDriver.readMenuChoice()).thenReturn(0);
        libraryManagementSystem.showMenu();
        verify(outputDriver).print("0.Exit from application");
        verify(outputDriver).print("1.List of books");
        verify(outputDriver).print("Quiting...");

    }

    @DisplayName("Print the menu and take the action when option 1 is selected")
    @Test
    void testForPrintMenuAndBookList(){
        List<List<String>> stringList = Arrays.asList(Arrays.asList("The Hobbit", "J R R Tolkien", "1937"),
                Arrays.asList("The Fault in our stars", "John Green", "2012"));
        when(inputDriver.readMenuChoice()).thenReturn(1).thenReturn(0);
        libraryManagementSystem.showMenu();
        verify(outputDriver,times(2)).print("0.Exit from application");
        verify(outputDriver,times(2)).print("1.List of books");
        verify(outputDriver).printAsColumns(stringList);
    }

    @DisplayName("Print the menu and take the action when an invalid option  is selected")
    @Test
    void testForInvalidOption(){
        when(inputDriver.readMenuChoice()).thenReturn(9).thenReturn(0);
        libraryManagementSystem.showMenu();
        verify(outputDriver,times(2)).print("0.Exit from application");
        verify(outputDriver,times(2)).print("1.List of books");
        verify(outputDriver,times(2)).print("2.Checkout books");
        verify(outputDriver,times(2)).print("3.Return book");
        verify(outputDriver,times(2)).print("4.List of movies");
        verify(outputDriver,times(2)).print("5.Checkout movies");
        verify(outputDriver,times(2)).print("6.Return movie");
        verify(outputDriver,times(2)).print("7.Get your details");
        verify(outputDriver).print("Select a valid option!");
    }

    @DisplayName("Print the menu and take the action when option 2 is selected")
    @Test
    void testForCheckOutBook(){
        when(inputDriver.readMenuChoice()).thenReturn(2).thenReturn(0);
        when(inputDriver.readString()).thenReturn("The Hobbit");
        libraryManagementSystem.showMenu();
        verify(outputDriver,times(2)).print("0.Exit from application");
        verify(outputDriver,times(2)).print("1.List of books");
        verify(outputDriver).print("Thank you! Enjoy the book");
        assertFalse(library.containsItem("The Hobbit", ItemType.BOOK));
    }

    @DisplayName("Print the menu and take the action to return book when option 3 is selected")
    @Test
    void testForReturnBook(){
        when(inputDriver.readMenuChoice()).thenReturn(2).thenReturn(3).thenReturn(0);
        when(inputDriver.readString()).thenReturn("The Hobbit");
        libraryManagementSystem.showMenu();
        verify(outputDriver,times(3)).print("0.Exit from application");
        verify(outputDriver,times(3)).print("1.List of books");
        verify(outputDriver,times(3)).print("2.Checkout books");
        verify(outputDriver,times(3)).print("3.Return book");
        verify(outputDriver).print("Thank you! Enjoy the book");
        assertTrue(library.containsItem("The Hobbit", ItemType.BOOK));
    }
}