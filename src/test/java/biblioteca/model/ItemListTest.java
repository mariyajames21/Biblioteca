package biblioteca.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ItemListTest {

    private ItemList itemList;

    @BeforeEach
    void init() {
        List<Item> item = new ArrayList<>();
        item.add(new Book("The Hobbit", "J R R Tolkien", "1937"));
        item.add(new Book("The  Fault in our stars", "John Green", "2014"));
        item.add(new Movie("Movie 1","2015","Director 1",7));
        item.add( new Movie("Movie 2","1990","Director 2",0));
        itemList = new ItemList(item);
    }

    @DisplayName("expects to print the list of books")
    @Test
    void testForPrintListOfBooks() {
        List<List<String>> listOfBooks = Arrays.asList(Arrays.asList("The Hobbit", "J R R Tolkien", "1937"),
                Arrays.asList("The  Fault in our stars", "John Green", "2014"));
        assertEquals(listOfBooks, itemList.getItem(ItemType.BOOK));
    }

    @DisplayName("expects to print the an empty list ")
    @Test
    void testForPrintIfListOfBooksIsEmpty() {
        List<Item> items = new ArrayList<>();
        itemList = new ItemList(items);
        assertEquals(items, itemList.getItem(ItemType.BOOK));
    }

    @DisplayName("expects true if the book is in the itemList")
    @Test
    void testForContains() {
        String title = "The Hobbit";
        assertTrue(itemList.containsItem(title, ItemType.BOOK));
    }

    @DisplayName("expects false if the book is in the itemList")
    @Test
    void testForNotContains() {
        String title = "Spy";
        assertFalse(itemList.containsItem(title, ItemType.BOOK));
    }


    @DisplayName("expects to check out a book")
    @Test
    void testToCheckOutABook() {
        String title = "The Hobbit";
        Book book = new Book("The Hobbit", "J R R Tolkien", "1937");
        assertEquals(book, itemList.removeItemIfPresent(title, ItemType.BOOK));
        assertFalse(itemList.containsItem(title, ItemType.BOOK));
    }

    @DisplayName("expects to return false if the book is not present in the itemList")
    @Test
    void testToCheckOutABookNotAvailable() {
        String title = "Spy";
        assertNull(itemList.removeItemIfPresent(title, ItemType.BOOK));
    }

    @DisplayName("expects to not check out a movie")
    @Test
    void testTotCheckOutAMovie() {
        String title = "The Hobbit";
        assertNull( itemList.removeItemIfPresent(title, ItemType.MOVIE));
        assertFalse(itemList.containsItem(title, ItemType.MOVIE));
    }

    @DisplayName("expects to check out a movie")
    @Test
    void testToCheckOutAMovie() {
        String title = "Movie 1";
        Movie movie =  new Movie("Movie 1","2015","Director 1",7);
        assertEquals(movie, itemList.removeItemIfPresent(title, ItemType.MOVIE));
    }
}