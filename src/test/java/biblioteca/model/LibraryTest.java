package biblioteca.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static biblioteca.model.ItemType.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LibraryTest {

    private Library library;
    private ItemList itemList;
    private User loggedInUser = new User();

    @BeforeEach
    void init() {
        List<Item> items = new ArrayList<>();
        items.add(new Book("The Hobbit", "J R R Tolkien", "1937"));
        items.add(new Book("The  Fault in our stars", "John Green", "2014"));
        items.add(new Movie("Movie 1", "2015", "Director 1", 7));
        items.add(new Movie("Movie 2", "1990", "Director 2", 0));
        itemList = new ItemList(items);
        library = new Library(itemList);
    }

    @DisplayName("expects to print the list of books")
    @Test
    void testForPrintListOfBooks() {
        List<List<String>> listOfBooks = Arrays.asList(Arrays.asList("The Hobbit", "J R R Tolkien", "1937"),
                Arrays.asList("The  Fault in our stars", "John Green", "2014"));
        assertEquals(listOfBooks, library.getDetails(BOOK));
    }

    @DisplayName("expects to print the an empty list ")
    @Test
    void testForPrintIfListOfBooksIsEmpty() {
        List<Item> items = new ArrayList<>();
        itemList = new ItemList(items);
        Library library = new Library(itemList);
        assertEquals(items, library.getDetails(BOOK));
    }

    @DisplayName("expects true if the book is in the library")
    @Test
    void testForContains() {
        String title = "The Hobbit";
        assertTrue(library.containsItem(title, BOOK));
    }

    @DisplayName("expects false if the book is in the library")
    @Test
    void testForNotContains() {
        String title = "Spy";
        assertFalse(library.containsItem(title, BOOK));
    }


    @DisplayName("expects to check out a book")
    @Test
    void testToCheckOutABook() {
        String title = "The Hobbit";
        assertTrue(library.checkOutItem(title, BOOK, loggedInUser));
        assertFalse(library.containsItem(title, BOOK));
    }

    @DisplayName("expects to return false if the book is not present in the library")
    @Test
    void testToCheckOutABookNotAvailable() {
        String title = "Spy";
        assertFalse(library.checkOutItem(title, BOOK, loggedInUser));
    }


    @DisplayName("expects to return the book")
    @Test
    void testToReturnBook() {
        String title = "The Hobbit";
        assertTrue(library.checkOutItem(title, BOOK, loggedInUser));
        assertFalse(library.containsItem(title, BOOK));
        library.returnItem(title, BOOK,loggedInUser);
        assertTrue(library.containsItem(title, BOOK));
    }

    @DisplayName("expects to return the details of all items")
    @Test
    void testToGetItemDetails() {
        List<List<String>> listOfItems = Arrays.asList(Arrays.asList("Movie 1", "2015", "Director 1", "7"),
                Arrays.asList("Movie 2", "1990", "Director 2", "Unrated"));
        assertEquals(listOfItems, library.getDetails(MOVIE));
    }

    @DisplayName("expects to print the an empty list ")
    @Test
    void testForPrintIfListOfItemsIsEmpty() {
        List<Item> items = new ArrayList<>();
        itemList = new ItemList(items);
        Library library = new Library(itemList);
        assertEquals(items, library.getDetails(MOVIE));
    }

    @DisplayName("expects true if the item is in the library")
    @Test
    void testForContainsItem() {
        String title = "Movie 1";
        assertTrue(library.containsItem(title,MOVIE));
    }

    @DisplayName("expects false if the item is in the library")
    @Test
    void testForNotContainsItem() {
        String title = "Spy";
        assertFalse(library.containsItem(title,MOVIE));
    }


    @DisplayName("expects to check out a item")
    @Test
    void testToCheckOutAItem() {
        String title = "Movie 1";
        assertTrue(library.checkOutItem(title,MOVIE, loggedInUser));
        assertFalse(library.containsItem(title,MOVIE));
    }

    @DisplayName("expects to return false if the item is not present in the library")
    @Test
    void testToCheckOutAItemNotAvailable() {
        String title = "Spy";
        assertFalse(library.checkOutItem(title, MOVIE, loggedInUser));
    }


    @DisplayName("expects to return the item")
    @Test
    void testToReturnItem() {
        String title = "Movie 1";
        assertTrue(library.checkOutItem(title,MOVIE, loggedInUser));
        assertFalse(library.containsItem(title,MOVIE));
        library.returnItem(title,MOVIE,loggedInUser);
        assertTrue(library.containsItem(title,MOVIE));
    }

    @DisplayName("ecpects to not return a item that was not in the library")
    @Test
    void testToNotReturnAWrongBook() {
        String title = "Movie";
        assertFalse(library.returnItem(title,MOVIE,loggedInUser));
    }
}