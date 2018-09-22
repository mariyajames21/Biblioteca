package biblioteca.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BookListTest {

    private BookList bookList;
    private List<Movie> movies;

    @BeforeEach
    void init() {
        List<Book> books = new ArrayList<>();
        books.add(new Book("The Hobbit", "J R R Tolkien", "1937"));
        books.add(new Book("The  Fault in our stars", "John Green", "2014"));
        bookList = new BookList(books);
    }

    @DisplayName("expects to print the list of books")
    @Test
    void testForPrintListOfBooks() {
        List<List<String>> listOfBooks = Arrays.asList(Arrays.asList("The Hobbit", "J R R Tolkien", "1937"),
                Arrays.asList("The  Fault in our stars", "John Green", "2014"));
        assertEquals(listOfBooks, bookList.getBooks());
    }

    @DisplayName("expects to print the an empty list ")
    @Test
    void testForPrintIfListOfBooksIsEmpty() {
        List<Book> books = new ArrayList<>();
        bookList = new BookList(books);
        assertEquals(books, bookList.getBooks());
    }

    @DisplayName("expects true if the book is in the bookList")
    @Test
    void testForContains() {
        String title = "The Hobbit";
        assertTrue(bookList.containsBook(title));
    }

    @DisplayName("expects false if the book is in the bookList")
    @Test
    void testForNotContains() {
        String title = "Spy";
        assertFalse(bookList.containsBook(title));
    }


    @DisplayName("expects to check out a book")
    @Test
    void testToCheckOutABook() {
        String title = "The Hobbit";
        Book book = new Book("The Hobbit", "J R R Tolkien", "1937");
        assertEquals(book,bookList.removeBookIfPresent(title));
        assertFalse(bookList.containsBook(title));
    }

    @DisplayName("expects to return false if the book is not present in the bookList")
    @Test
    void testToCheckOutABookNotAvailable() {
        String title = "Spy";
        assertNull(bookList.removeBookIfPresent(title));
    }


}