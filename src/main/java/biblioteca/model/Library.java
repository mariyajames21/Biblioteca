package biblioteca.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

//Books in a library
public class Library {

    private final ItemList itemList;
    private final UserList loggedInUserList;
    private ItemList checkedOutItemList;


    public Library(ItemList itemList) {
        this.itemList = itemList;
        checkedOutItemList = new ItemList(new ArrayList<>());
        loggedInUserList = new UserList();
    }


    public boolean containsItem(String title, ItemType type) {
        return itemList.containsItem(title, type);
    }

    public boolean checkOutItem(String title, ItemType type, User loggedInUser) {
        Item checkedOutItem = itemList.removeItemIfPresent(title, type);
        if (checkedOutItem != null) {
            loggedInUser.addItem(checkedOutItem);
            return true;
        }
        return false;
    }

    public boolean returnItem(String title, ItemType type) {
        Item returnedItem = checkedOutItemList.removeItemIfPresent(title, type);
        if (returnedItem != null) {
            itemList.addItem(returnedItem);
            return true;
        }
        return false;
    }

    public List<List<String>> getDetails(ItemType type) {
        return itemList.getItem(type);
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
