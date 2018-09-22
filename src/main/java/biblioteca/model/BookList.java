package biblioteca.model;

import java.util.ArrayList;
import java.util.List;

public class BookList {

    private final List<Book> bookList;

    public BookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public List<List<String>> getBooks() {
        List<List<String>> listOfBooks = new ArrayList<>();
        bookList.forEach(book -> listOfBooks.add(book.getBookDetails()));
        return listOfBooks;
    }

    public Book removeBookIfPresent(String title) {
        for (Book book : bookList) {
            if (book.checkTitle(title)) {
                bookList.remove(book);
                return book;
            }
        }
        return null;
    }

    public void addBook(Book book) {
        this.bookList.add(book);
    }

    public boolean containsBook(String title) {
        for (Book book : bookList) {
            if (book.checkTitle(title)) {
                return true;
            }
        }
        return false;
    }

}
