package biblioteca.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class UserListTest {

    private UserList userList;
    @BeforeEach
    void init(){
        userList= new UserList(Arrays.asList(new User(name, email, pnoneNumber, "123-4567","qwertyuiop"),new User(name, email, pnoneNumber, "098-7654","fghjkl")));
    }
    @DisplayName("returns true if the usernumber and password are correct")
    @Test
    void testForCorrectUserDetails(){
        User user=new User(name, email, pnoneNumber, "123-4567","qwertyuiop");
        assertEquals(user,userList.containsUser(user));
    }

    @DisplayName("returns false if the usernumber and password are incorrect")
    @Test
    void testForWrongUserDetails(){
        User user = new User(name, email, pnoneNumber, "345-6789","xcvbn");
        assertNull(userList.containsUser(user));
    }

}