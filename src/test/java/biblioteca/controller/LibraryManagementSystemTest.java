package biblioteca.controller;

import biblioteca.model.Book;
import biblioteca.model.Library;
import biblioteca.view.OutputDriver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class LibraryManagementSystemTest {
    private LibraryManagementSystem libraryManagementSystem;
    private OutputDriver outputDriver;
    private Library library;
    private List<Book> books;


    @BeforeEach
    void init() {
        outputDriver = mock(OutputDriver.class);
        libraryManagementSystem = new LibraryManagementSystem(outputDriver,library);
        books = new ArrayList<>();
        books.add(new Book("The Hobbit", "J R R Tolkien", "1937"));
        books.add(new Book("The  Fault in our stars", "John Green", "2012"));
        library=new Library(books);
    }

    @DisplayName("expects to print the welcome message")
    @Test
    void testForPrintWelcomeMessage() {
        libraryManagementSystem.printWelcomeMessage();
        verify(outputDriver).print("Welcome to Biblioteca");

    }

    @DisplayName("Expects to call the print funciton of the output driver with the list of titles")
    @Test
    void testForPrintListOfBooks() {
        List<String> listOfBooks = Arrays.asList("Title Author Year","The Hobbit J R R Tolkien 1937","The  Fault in our stars John Green 2012");
        libraryManagementSystem.printListOfBooks();
        verify(outputDriver).print(listOfBooks);
    }

}