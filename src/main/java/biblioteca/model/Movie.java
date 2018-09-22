package biblioteca.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Movie {
    private final String tile;
    private final String year;
    private final String director;
    private final int rating;

    public Movie(String title, String year, String director, int rating) {
        this.tile=title;
        this.year=year;
        this.director=director;
        this.rating=rating;
    }

    public List<String> getDetails() {
        List<String> movieDetails = new ArrayList<>(Arrays.asList(tile,year,director));
        movieDetails.add(rating == 0 ? "Unrated":Integer.toString(rating));
        return movieDetails;
    }
}
