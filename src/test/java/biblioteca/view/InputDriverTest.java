package biblioteca.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;

class InputDriverTest {

    @Test
    void testMenuInput() {
        setSystemIn("3\n");

        InputDriver inputDriver = new InputDriver();
        assertEquals(3, inputDriver.readMenuChoice());
    }

    @DisplayName("Should read a string")
    @Test
    void testForReadString() {
        setSystemIn("The Hobbit\n");
        InputDriver inputDriver = new InputDriver();
        assertEquals("The Hobbit", inputDriver.readString());

    }

    private void setSystemIn(String string) {
        System.setIn(new ByteArrayInputStream(string.getBytes()));
    }

    @AfterEach
    public void setup() {
        System.setIn(System.in);
    }

}