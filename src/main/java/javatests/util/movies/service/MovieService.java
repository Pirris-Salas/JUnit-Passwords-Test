package javatests.util.movies.service;

import javatests.util.movies.data.MovieRepository;
import javatests.util.movies.model.Genre;
import javatests.util.movies.model.Movie;

import java.util.Collection;
import java.util.stream.Collectors;

public class MovieService {

    private MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }

    public Collection<Movie> findMoviesByGenre(Genre genre) {

        return movieRepository.findAll().stream().filter(
                movie -> movie.getGenre() == genre).collect(Collectors.toList());
    }

    public Collection<Movie> findMoviesByMinutes(int minutes) {

        return movieRepository.findAll().stream().filter(
                movie -> movie.getMinutes() <= minutes).collect(Collectors.toList());
    }
}
