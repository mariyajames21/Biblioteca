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
        userList= new UserList(Arrays.asList(new User("User 1", "user1@gmail.com", "384975902", "123-4567","qwertyuiop"),new User("User 2", "user2@gmail.com", "384975902","098-7654","fghjkl")));
    }
    @DisplayName("returns true if the usernumber and password are correct")
    @Test
    void testForCorrectUserDetails(){
        User user=new User("User 1", "user1@gmail.com", "384975902", "123-4567","qwertyuiop");
        assertEquals(user,userList.containsUser(user));
    }

    @DisplayName("returns false if the usernumber and password are incorrect")
    @Test
    void testForWrongUserDetails(){
        User user = new User("User 1", "user1@gmail.com", "384975902", "345-6789","xcvbn");
        assertNull(userList.containsUser(user));
    }

}