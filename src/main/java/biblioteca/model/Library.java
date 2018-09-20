package biblioteca.model;

import java.util.ArrayList;
import java.util.List;

//Books in a library
public class Library {
    private final List<Book> books;

    public Library(List<Book> books) {
        this.books = books;
    }

    public List<String> getBooks() {
        List<String> listOfBooks = new ArrayList<>();
        listOfBooks.add("Title Author Year");
        for (Book book : books) {
            listOfBooks.add(book.getBookDetails());
        }
        return listOfBooks;
    }
}
