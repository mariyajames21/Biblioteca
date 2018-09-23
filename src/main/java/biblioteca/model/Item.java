package biblioteca.model;


import java.util.List;

public interface Item {
    List<String> getDetails();
    ItemType getType();
    boolean checkTitle(String title);
}
