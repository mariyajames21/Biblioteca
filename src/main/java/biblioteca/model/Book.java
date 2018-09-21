package biblioteca.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

//Details of a book
public class Book {
    private final String title;
    private final String author;
    private String year;


    public Book(String title, String author, String year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public List<String> getBookDetails() {
        return new ArrayList<>(Arrays.asList(title,author,year));
    }

    public boolean checkTitle(String title) {
        return this.title.equals(title);
    }

    @Override
    public boolean equals(Object o) {
        Book book = (Book) o;
        return Objects.equals(title, book.title) &&
                Objects.equals(author, book.author) &&
                Objects.equals(year, book.year);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, year);
    }

}
