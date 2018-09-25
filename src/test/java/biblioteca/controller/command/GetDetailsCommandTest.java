package biblioteca.controller.command;

import biblioteca.model.*;
import biblioteca.view.InputDriver;
import biblioteca.view.OutputDriver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class GetDetailsCommandTest {
    private Library library;
    private OutputDriver outputDriver;
    private InputDriver inputDriver;
    User user = new User("User 1", "user1@gmail.com", "384975902", "123-4567", "qwertyuiop");
    GetDetailsCommand getDetailsCommand;

    @BeforeEach
    void init() {
        List<Item> items = new ArrayList<>();
        items.add(new Book("The Hobbit", "J R R Tolkien", "1937"));
        items.add(new Book("The  Fault in our stars", "John Green", "2014"));
        items.add(new Movie("Movie 1", "2015", "Director 1", 7));
        items.add(new Movie("Movie 2", "1990", "Director 2", 0));
        ItemList itemList = new ItemList(items);
        library = new Library(itemList);
        library.login(user);
        outputDriver = mock(OutputDriver.class);
        inputDriver = mock(InputDriver.class);
        getDetailsCommand = new GetDetailsCommand();
    }

    @DisplayName("Should print the details of the current user")
    @Test
    void testForReturningTheUserDetails() {
        getDetailsCommand.perform(library,inputDriver,outputDriver);
        verify(outputDriver).print(library.getCurrentUserInformation());
    }

}