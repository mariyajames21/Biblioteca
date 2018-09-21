import biblioteca.model.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {
    private Book book1;
    private Book book2;
    private List<String> bookList;
    @BeforeEach
    void init(){
        book1 = new Book("The Hobbit","J R R Tolkien", "1937");
        book2 = new Book("The fault in our stars", "John Green", "2012");
    }

    @DisplayName("should return 'The Hobbit' ")
    @Test
    void testForGetDetails() {
        bookList = Arrays.asList("The Hobbit","J R R Tolkien", "1937");
        assertEquals(bookList, book1.getBookDetails());
    }

    @DisplayName("should return 'The fault in our stars'")
    @Test
    void testForGetDetailsTwo() {
        List<String> bookList = Arrays.asList("The fault in our stars", "John Green", "2012");
        assertEquals(bookList, book2.getBookDetails());
    }

    @DisplayName("expects two books with same title to be equal")
    @Test
    void testTrueForSameTitle() {
        assertTrue(book1.checkTitle("The Hobbit"));
    }

    @DisplayName("expects two books with different title to be notnequal")
    @Test
    void testFalseForDifferentTitle() {
        assertFalse(book2.checkTitle("The Hobbit"));
    }

}