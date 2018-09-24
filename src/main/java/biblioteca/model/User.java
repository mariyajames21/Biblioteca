package biblioteca.model;

import java.util.Objects;

public class User {

    private String userNumber;
    private String password;
    private ItemList listOfCheckedOutItems;

    public User(String userNumber, String password) {
        this.userNumber = userNumber;
        this.password = password;
        listOfCheckedOutItems = new ItemList();
    }

    public User() {
        listOfCheckedOutItems = new ItemList();
    }

    public Item returnItemIfCheckedOut(String title, ItemType type) {
        return listOfCheckedOutItems.removeItemIfPresent(title, type);
    }

    public void addItem(Item checkedOutItem) {
        this.listOfCheckedOutItems.addItem(checkedOutItem);
    }

    @Override
    public boolean equals(Object o) {
        User user = (User) o;
        return Objects.equals(userNumber, user.userNumber) &&
                Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userNumber, password);
    }
}
