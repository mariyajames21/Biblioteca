package biblioteca.model;

import java.util.ArrayList;
import java.util.List;

public class UserList {

    private List<User> userList;

    public UserList(List<User> userList) {
        this.userList = userList;
    }

    public UserList() {
        this.userList = new ArrayList<>();
    }

    public User containsUser(User user) {
        for (User user1:userList) {
            if(user.equals(user1)){
                return user1;
            }
        }
        return null;
    }
}
