package biblioteca.model;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

//Books in a library
public class Library {

    private User currentUser;
    private final ItemList itemList;
    private UserList userList;


    public Library(ItemList itemList) {
        currentUser = null;
        this.itemList = itemList;
        createDummyUsers();
    }

    private void createDummyUsers() {
        userList = new UserList(Arrays.asList(new User("123-4567", "qwertyuiop"),
                new User("098-7654", "password")));
    }

    public boolean containsItem(String title, ItemType type) {
        return itemList.containsItem(title, type);
    }

    public boolean checkOutItem(String title, ItemType type) {
        Item checkedOutItem = itemList.removeItemIfPresent(title, type);
        if (checkedOutItem != null) {
            currentUser.addItem(checkedOutItem);
            userList.containsUser(currentUser).addItem(checkedOutItem);
            return true;
        }
        return false;
    }

    public boolean returnItem(String title, ItemType type) {
        User currentUserInLibrary = userList.containsUser(currentUser);
        Item returnedItem = currentUserInLibrary.returnItemIfCheckedOut(title, type);
        if (returnedItem != null) {
            itemList.addItem(returnedItem);
            return true;
        }
        return false;
    }

    public List<List<String>> getDetails(ItemType type) {
        return itemList.getItem(type);
    }

    public boolean isLoggedIn() {
        return currentUser==null;
    }

    public void logout() {
        currentUser=null;
    }

    public boolean login(User user){
        if (userList.containsUser(user)==null) {
            return false;
        }
        currentUser = user;
        return true;
    }

    @Override
    public boolean equals(Object o) {
        Library library = (Library) o;
        return Objects.equals(itemList, library.itemList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemList);
    }

}
