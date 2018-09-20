package biblioteca.model;

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

    public String getBookDetails() {
        return title + " " + author + " " + year;
    }
}
