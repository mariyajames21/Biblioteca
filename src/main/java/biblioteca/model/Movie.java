package biblioteca.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static biblioteca.model.ItemType.*;

public class Movie implements Item {
    private final String title;
    private final String year;
    private final String director;
    private final int rating;
    private final ItemType type;

    public Movie(String title, String year, String director, int rating) {
        this.title = title;
        this.year = year;
        this.director = director;
        this.rating = rating;
        this.type = MOVIE;
    }

    public List<String> getDetails() {
        List<String> movieDetails = new ArrayList<>(Arrays.asList(title, year, director));
        movieDetails.add(rating == 0 ? "Unrated" : Integer.toString(rating));
        return movieDetails;
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
        if(this.getClass()==o.getClass()){
            Movie movie = (Movie) o;
            return this.title.equals(movie.title);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, year, director, rating);
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", year='" + year + '\'' +
                ", director='" + director + '\'' +
                ", rating=" + rating +
                ", type=" + type +
                '}';
    }
}
