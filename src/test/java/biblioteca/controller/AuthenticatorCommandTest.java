package biblioteca.controller;

import biblioteca.controller.command.AuthenticatorCommand;
import biblioteca.controller.command.CheckOutBookCommand;
import biblioteca.model.*;
import biblioteca.view.InputDriver;
import biblioteca.view.OutputDriver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


class AuthenticatorCommandTest {
    private Library library;
    private OutputDriver outputDriver;
    private InputDriver inputDriver;
    private AuthenticatorCommand authenticatorCommand;
    private User user= new User();

    @BeforeEach
    void init() {
        List<Item> items = new ArrayList<>();
        items.add(new Book("The Hobbit", "J R R Tolkien", "1937"));
        items.add(new Book("The  Fault in our stars", "John Green", "2014"));
        items.add(new Movie("Movie 1", "2015", "Director 1", 7));
        items.add(new Movie("Movie 2", "1990", "Director 2", 0));
        ItemList itemList = new ItemList(items);
        library = new Library(itemList);
        outputDriver = mock(OutputDriver.class);
        inputDriver = mock(InputDriver.class);
        authenticatorCommand = new AuthenticatorCommand(new CheckOutBookCommand());

    }


    @DisplayName("Should authenticate if the usernumber and password are correct")
    @Test
    void testUserDetailsTrue() {
        when(inputDriver.readString()).thenReturn("123-4567").thenReturn("qwertyuiop");
        authenticatorCommand.perform(library, user, inputDriver, outputDriver);
        verify(outputDriver).print("You are not logged in. Please log in");
        verify(outputDriver).print("Enter you user name");
        verify(outputDriver).print("Enter Password");
        verify(outputDriver).print("Enter the name of the book.");

    }

    @DisplayName("Should not authenticate if the usernumber and password are correct")
    @Test
    void testUserDetailsFalse() {
        when(inputDriver.readString()).thenReturn("123-4560").thenReturn("qwertyuiop");
        authenticatorCommand.perform(library, user, inputDriver, outputDriver);
        verify(outputDriver).print("You are not logged in. Please log in");
        verify(outputDriver).print("Enter you user name");
        verify(outputDriver).print("Enter Password");
        verify(outputDriver).print("Incorrect usernumber or password");

    }

}