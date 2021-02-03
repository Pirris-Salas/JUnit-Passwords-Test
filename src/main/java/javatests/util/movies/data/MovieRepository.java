package javatests.util.movies.data;

import javatests.util.movies.model.Movie;

import java.util.Collection;
import java.util.List;

public interface MovieRepository {

    Movie findById(long id);
    Collection<Movie> findAll();
    void saveOrUpadate(Movie movie);

    List<Movie> findByName(String name);

    List<Movie> findByDirectorName(String directorName);
}
