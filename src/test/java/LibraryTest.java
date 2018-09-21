import biblioteca.model.Book;
import biblioteca.model.Library;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LibraryTest {

    private Library library;
    List<Book> books;
    @BeforeEach
    void init() {
        books = new ArrayList<>();
        books.add(new Book("The Hobbit", "J R R Tolkien", "1937"));
        books.add(new Book("The  Fault in our stars", "John Green", "2014"));
        library = new Library(books);
    }

    @DisplayName("expects to print the list of books")
    @Test
    void testForPrintListOfBooks() {
        List<List<String>> listOfBooks = Arrays.asList(Arrays.asList("The Hobbit", "J R R Tolkien", "1937"), Arrays.asList("The  Fault in our stars", "John Green", "2014"));
        assertEquals(listOfBooks, library.getBooks());
    }

    @DisplayName("expects to print the an empty list ")
    @Test
    void testForPrintIfListOfBooksIsEmpty() {
        List<Book> books = new ArrayList<>();
        Library library = new Library(books);
        assertEquals(books, library.getBooks());
    }

    @DisplayName("expects true if the book is in the library")
    @Test
    void testForContains() {
        String title = "The Hobbit";
        assertTrue(library.contains(title));
    }

    @DisplayName("expects false if the book is in the library")
    @Test
    void testForNotContains() {
        String title = "Spy";
        assertFalse(library.contains(title));
    }


    @DisplayName("expects to check out a book")
    @Test
    void testToCheckOutABook() {
        String title = "The Hobbit";
        library.checkOut(title);
        assertFalse(library.contains(title));
    }



}