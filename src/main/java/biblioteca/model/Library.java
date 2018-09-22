package biblioteca.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

//Books in a library
public class Library {
    private final List<Book> books;
    private List<Book> checkedOutBooks;

    public Library(List<Book> books) {
        this.books = books;
        this.checkedOutBooks = new ArrayList<>();
    }

    public List<List<String>> getBooks() {
        List<List<String>> listOfBooks = new ArrayList<>();
        books.forEach(book -> listOfBooks.add(book.getBookDetails()));
        return listOfBooks;
    }

    public boolean checkOut(String title) {
        for (Book book : books) {
            if (book.checkTitle(title)) {
                checkedOutBooks.add(book);
                books.remove(book);
                return true;
            }
        }
        return false;
    }

    public boolean contains(String title) {
        for (Book book : books) {
            if (book.checkTitle(title)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        Library library = (Library) o;
        return Objects.equals(books, library.books);
    }

    @Override
    public int hashCode() {
        return Objects.hash(books);
    }

    public void returnBook(String title) {
        for (Book book:checkedOutBooks) {
            if(book.checkTitle(title)){
                checkedOutBooks.remove(book);
                books.add(book);
                return;
            }
        }
    }
}
