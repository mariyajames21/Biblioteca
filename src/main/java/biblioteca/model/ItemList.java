package biblioteca.model;

import java.util.ArrayList;
import java.util.List;

public class ItemList {

    private final List<Item> itemList;

    public ItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    public ItemList() {
        itemList = new ArrayList<>();
    }

    public List<List<String>> getItem(ItemType type) {
        List<List<String>> listOfItems = new ArrayList<>();
        for (Item item : itemList) {
            if (item.getType() == type) {
                listOfItems.add(item.getDetails());

            }
        }
        return listOfItems;
    }

    public Item removeItemIfPresent(String title, ItemType type) {
        for (Item item : itemList) {
            if (item.checkTitle(title) && item.getType() == type) {
                itemList.remove(item);
                return item;
            }
        }
        return null;
    }

    public void addItem(Item item) {
        this.itemList.add(item);
    }

    public boolean containsItem(String title, ItemType type) {
        for (Item item : itemList) {
            if (item.getType() == type) {
                if (item.checkTitle(title) && item.getType() == type) {
                    return true;
                }

            }
        }
        return false;
    }

}
