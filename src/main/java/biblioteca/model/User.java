package biblioteca.model;

import java.util.Objects;

public class User {

    private String name;
    private String email;
    private String pnoneNumber;
    private String userNumber;
    private String password;
    private ItemList listOfCheckedOutItems;

    public User(String name, String email, String pnoneNumber, String userNumber, String password) {
        this.name = name;
        this.email = email;
        this.pnoneNumber = pnoneNumber;
        this.userNumber = userNumber;
        this.password = password;
        listOfCheckedOutItems = new ItemList();
    }

    public User(String userNumber,String password) {
        this.userNumber = userNumber;
        this.password = password;
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

    public String getDetails() {
        return this.name+" "+this.email+" "+this.pnoneNumber;
    }
}
