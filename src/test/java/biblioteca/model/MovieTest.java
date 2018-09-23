package biblioteca.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static biblioteca.model.ItemType.MOVIE;
import static org.junit.jupiter.api.Assertions.*;

class MovieTest {

    private Movie movie1;
    private Movie movie2;

    @BeforeEach
    void init() {
        movie1 = new Movie("Movie 1", "2015", "Director 1", 7);
        movie2 = new Movie("Movie 2", "1990", "Director 2", 0);
    }

    @DisplayName("should return the details of a book")
    @Test
    void testToGetDetails() {
        List<String> expectedMovieDetails = Arrays.asList("Movie 1", "2015", "Director 1", "7");
        assertEquals(expectedMovieDetails, movie1.getDetails());
    }

    @DisplayName("should return the details of a book")
    @Test
    void testToGetDetailsOfUnrated() {
        List<String> expectedMovieDetails = Arrays.asList("Movie 2", "1990", "Director 2", "Unrated");
        assertEquals(expectedMovieDetails, movie2.getDetails());
    }

    @DisplayName("return type MOVIE")
    @Test
    void TEstForType() {
        assertEquals(MOVIE,movie1.getType());
    }

}