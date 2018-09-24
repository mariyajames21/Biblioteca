package biblioteca.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static biblioteca.model.ItemType.*;

//Details of a book
public class Book implements Item{
    private final String title;
    private String author;
    private String year;
    private final ItemType type;
    private User user;


    public Book(String title, String author, String year) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.type = BOOK;
    }

    public List<String> getDetails() {
        return new ArrayList<>(Arrays.asList(title, author, year));
    }

    @Override
    public ItemType getType() {
        return type;
    }

    public boolean checkTitle(String title) {
        return this.title.equals(title);
    }

    @Override
    public boolean equals(Object o) {
        if(this.getClass() == o.getClass()){
            Book book = (Book) o;
            return Objects.equals(title, book.title);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, year);
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", year='" + year + '\'' +
                '}';
    }
}
