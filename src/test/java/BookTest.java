import biblioteca.model.Book;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @DisplayName("should return 'The Hobbit' ")
    @Test
    void testForgetTitle() {
        Book book = new Book("The Hobbit","J R R Tolkien", "1937");
        assertEquals("The Hobbit J R R Tolkien 1937", book.getBookDetails());
    }

    @DisplayName("should return 'The fault in our stars'")
    @Test
    void testForGetTitleTwo() {
        Book book = new Book("The fault in our stars", "John Green", "2012");
        assertEquals("The fault in our stars John Green 2012", book.getBookDetails());
    }

}