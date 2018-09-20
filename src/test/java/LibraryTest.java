import biblioteca.controller.LibraryManagementSystem;
import biblioteca.model.Book;
import biblioteca.model.Library;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class LibraryTest {

    @DisplayName("expects to print the list of books")
    @Test
    void testForPrintListOfBooks() {
        List<Book> books = new ArrayList<>();
        books.add(new Book("The Hobbit", "J R R Tolkien", "1937"));
        books.add(new Book("The  Fault in our stars", "John Green", "2014"));
        List<String> listOfBooks = Arrays.asList("Title Author Year","The Hobbit J R R Tolkien 1937","The  Fault in our stars John Green 2014");
        LibraryManagementSystem libraryManagementSystem = mock(LibraryManagementSystem.class);
        Library library = new Library(books);
        assertEquals(listOfBooks,library.getBooks());
    }

    @DisplayName("expects to print the an empty list ")
    @Test
    void testForPrintIfListOfBooksIsEmpty() {
        List<Book> books = new ArrayList<>();
        List<String> listOfBooks = Arrays.asList("Title Author Year");
        LibraryManagementSystem libraryManagementSystem = mock(LibraryManagementSystem.class);
        Library library = new Library(books);
        assertEquals(listOfBooks,library.getBooks());
    }


}