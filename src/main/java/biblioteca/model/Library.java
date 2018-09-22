package biblioteca.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

//Books in a library
public class Library {

    private final BookList bookList;
    private BookList checkedOutBookList;
    private final List<Movie> movieList;

    public Library(BookList bookList, List<Movie> movieList) {
        this.bookList = bookList;
        this.movieList = movieList;
        checkedOutBookList = new BookList(new ArrayList<>());
    }

    public List<List<String>> getMovies() {
        List<List<String>> listOfMovies = new ArrayList<>();
        movieList.forEach(movie -> listOfMovies.add(movie.getDetails()));
        return listOfMovies;
    }

    public boolean containsBook(String title) {
        return bookList.containsBook(title);
    }

    public boolean checkOut(String title) {
        Book checkedOutBook = bookList.removeBookIfPresent(title);
        if(checkedOutBook!=null){
            checkedOutBookList.addBook(checkedOutBook);
            return true;
        }
        return false;
    }

    public boolean returnBook(String title) {
        Book returnedBook = checkedOutBookList.removeBookIfPresent(title);
        if(returnedBook!=null){
            bookList.addBook(returnedBook);
            return true;
        }
        return false;
    }

    public List<List<String>> getBooks() {
        return bookList.getBooks();
    }
    @Override
    public boolean equals(Object o) {
        Library library = (Library) o;
        return Objects.equals(bookList, library.bookList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookList);
    }


}
