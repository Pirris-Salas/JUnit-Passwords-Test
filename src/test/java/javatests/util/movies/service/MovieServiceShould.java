package javatests.util.movies.service;

import javatests.util.movies.data.MovieRepository;
import javatests.util.movies.data.MovieRepositoryJdbc;
import javatests.util.movies.model.Genre;
import javatests.util.movies.model.Movie;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.ScriptUtils;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
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
                        new Movie(1,"Dark Knight", 152, Genre.ACTION, "Salas"),
                        new Movie(2,"Memento", 113, Genre.THRILLER, "Luis"),
                        new Movie(3,"There's Something About Mary", 119, Genre.COMEDY, "Mary"),
                        new Movie(4,"Super 8", 112, Genre.THRILLER, "Super Man"),
                        new Movie(5,"Scream", 111, Genre.HORROR, "Fernando"),
                        new Movie(6,"Home Alone", 103, Genre.COMEDY, "Salgado"),
                        new Movie(8,"Matrix", 136, Genre.ACTION, "Luis")
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

    @Test
    public void when_using_id(){
        Collection<Movie> movies = movieService.findByTemplate(new Movie(2,null,null,Genre.ACTION, null));
        assertEquals(Collections.singletonList(2), getMovieIds(movies));
    }

    @Test(expected = IllegalArgumentException.class)
    public void when_using_negative_minutes(){
        movieService.findByTemplate(new Movie(null,null,-15, Genre.ACTION,null));
    }

    @Test
    public void when_using_genre_and_minutes(){
        Collection<Movie> movies = movieService.findByTemplate(new Movie(null, null, 112, Genre.THRILLER, null));
        assertEquals(Collections.singletonList(4), getMovieIds(movies));
    }

    @Test
    public void using_name_and_minutes(){
        Collection<Movie> movies = movieService.findByTemplate(new Movie(null, "Matrix", 180, null,null));
        assertEquals(Collections.singletonList(8), getMovieIds(movies));
    }

    @Test
    public void using_director_and_minutes(){
        Collection<Movie> movies = movieService.findByTemplate(new Movie(null, null, 160, null, "Luis"));
        assertEquals(Arrays.asList(2,8), getMovieIds(movies));
    }


    private List<Integer> getMovieIds(Collection<Movie> movies) {
        return movies.stream().map(Movie::getId).collect(Collectors.toList());
    }
}