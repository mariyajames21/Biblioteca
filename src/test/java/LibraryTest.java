import biblioteca.model.Book;
import biblioteca.model.BookList;
import biblioteca.model.Library;
import biblioteca.model.Movie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LibraryTest {

    private Library library;
    private BookList bookList;
    private List<Movie> movies;

    @BeforeEach
    void init() {
        List<Book> books = new ArrayList<>();
        movies = new ArrayList<>();
        books.add(new Book("The Hobbit", "J R R Tolkien", "1937"));
        books.add(new Book("The  Fault in our stars", "John Green", "2014"));
        bookList = new BookList(books);
        movies.add(new Movie("Movie 1","2015","Director 1",7));
        movies.add( new Movie("Movie 2","1990","Director 2",0));
        library = new Library(bookList, movies);
    }

    @DisplayName("expects to print the list of books")
    @Test
    void testForPrintListOfBooks() {
        List<List<String>> listOfBooks = Arrays.asList(Arrays.asList("The Hobbit", "J R R Tolkien", "1937"),
                Arrays.asList("The  Fault in our stars", "John Green", "2014"));
        assertEquals(listOfBooks, library.getBooks());
    }

    @DisplayName("expects to print the an empty list ")
    @Test
    void testForPrintIfListOfBooksIsEmpty() {
        List<Book> books = new ArrayList<>();
        bookList = new BookList(books);
        Library library = new Library(bookList, movies);
        assertEquals(books, library.getBooks());
    }

    @DisplayName("expects true if the book is in the library")
    @Test
    void testForContains() {
        String title = "The Hobbit";
        assertTrue(library.containsBook(title));
    }

    @DisplayName("expects false if the book is in the library")
    @Test
    void testForNotContains() {
        String title = "Spy";
        assertFalse(library.containsBook(title));
    }


    @DisplayName("expects to check out a book")
    @Test
    void testToCheckOutABook() {
        String title = "The Hobbit";
        assertTrue(library.checkOut(title));
        assertFalse(library.containsBook(title));
    }

    @DisplayName("expects to return false if the book is not present in the library")
    @Test
    void testToCheckOutABookNotAvailable() {
        String title = "Spy";
        assertFalse(library.checkOut(title));
    }


    @DisplayName("expects to return the book")
    @Test
    void testToReturnBook() {
        String title="The Hobbit";
        assertTrue(library.checkOut(title));
        assertFalse(library.containsBook(title));
        library.returnBook(title);
        assertTrue(library.containsBook(title));
    }

    @DisplayName("expects to return the details of all movies")
    @Test
    void testToGetMovieDetails(){
        List<List<String>> listOfMovies = Arrays.asList(Arrays.asList("Movie 1","2015","Director 1","7"),
                Arrays.asList("Movie 2","1990","Director 2","Unrated"));
        assertEquals(listOfMovies, library.getMovies());
    }

}