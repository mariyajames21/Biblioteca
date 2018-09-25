package biblioteca.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static biblioteca.model.ItemType.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UserTest {
    User user;

    @BeforeEach
    void init() {
        user = new User("User 1", "user1@gmail.com", "384975902", "123-4567","password");
    }

    @DisplayName("should add an item to the checkedout item list")
    @Test
    void testForCheckedOutItemList() {
        user.addItem(new Book("The Hobbit", "J R R Tolkien", "1937"));
        assertEquals(user.returnItemIfCheckedOut("The Hobbit",BOOK),new Book("The Hobbit", "J R R Tolkien", "1937"));
    }

}