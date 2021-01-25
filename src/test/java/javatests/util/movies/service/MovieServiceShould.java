package javatests.util.movies.service;

import javatests.util.movies.data.MovieRepository;
import javatests.util.movies.model.Genre;
import javatests.util.movies.model.Movie;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class MovieServiceShould {

    private MovieService movieService;
    @Before
    public void setUp(){
        MovieRepository movieRepository = Mockito.mock(MovieRepository.class);

        Mockito.when(movieRepository.findAll()).thenReturn(
                Arrays.asList(
                        new Movie(1,"Dark Knight", 152, Genre.ACTION),
                        new Movie(2,"Memento", 113, Genre.THRILLER),
                        new Movie(3,"There's Something About Mary", 119, Genre.COMEDY),
                        new Movie(4,"Super 8", 112, Genre.THRILLER),
                        new Movie(5,"Scream", 111, Genre.HORROR),
                        new Movie(6,"Home Alone", 103, Genre.COMEDY),
                        new Movie(1,"Matrix", 136, Genre.ACTION)
                )
        );
        movieService = new MovieService(movieRepository);
    }


    @Test
    public void find_movies_by_genre() {

        Collection<Movie> movies = movieService.findMoviesByGenre(Genre.COMEDY);

        assertThat(getMovieIds(movies), is(Arrays.asList(3,6)));
    }


    @Test
    public void find_movies_by_minutes(){
        Collection<Movie> movies = movieService.findMoviesByMinutes(119);

        assertThat(getMovieIds(movies), is(Arrays.asList(2,3,4,5,6)));
    }

    private List<Integer> getMovieIds(Collection<Movie> movies) {
        return movies.stream().map(Movie::getId).collect(Collectors.toList());
    }
}