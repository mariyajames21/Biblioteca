package biblioteca.model;

import java.util.List;

public class UserList {

    private List<User> userList;

    public UserList(List<User> userList) {
        this.userList = userList;
    }

    public UserList() {

    }

    public boolean containsUser(User user) {
        for (User user1:userList) {
            if(user.equals(user1)){
                return true;
            }
        }
        return false;
    }
}
