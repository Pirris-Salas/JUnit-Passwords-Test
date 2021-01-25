package javatests.util.movies.data;

import javatests.util.movies.model.Movie;

import java.util.Collection;

public interface MovieRepository {

    Movie findById(long id);
    Collection<Movie> findAll();
    void saveOrUpadate(Movie movie);
}
