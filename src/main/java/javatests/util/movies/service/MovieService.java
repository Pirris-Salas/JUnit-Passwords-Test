package javatests.util.movies.service;

import javatests.util.movies.data.MovieRepository;
import javatests.util.movies.model.Genre;
import javatests.util.movies.model.Movie;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MovieService {

    private MovieRepository movieRepository;
    private JdbcTemplate jdbcTemplate;


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

  public Movie findById (int id){
       List<Movie> myMovie = movieRepository.findAll().stream().filter(
               movie -> movie.getId() == id).collect(Collectors.toList());

      return myMovie.get(0);
  }


    public Collection<Movie> findByTemplate(Movie template){
        if(template.getId() != null){
            Movie movie = findById(template.getId());
            return movie != null ? Collections.singletonList(movie) : new ArrayList<>();
        }

        if(template.getMinutes() < 0){
            throw new IllegalArgumentException("Duration must be greater or equal than zero");
        }

        List<Predicate<Movie>> filters = new ArrayList<>();

        if(template.getName() != null){
            filters.add(movie ->
                    movie.getName().toLowerCase().contains(template.getName().toLowerCase().trim()));
        }

        if(template.getMinutes() != null){
            filters.add(movie ->
                    movie.getMinutes() <= template.getMinutes());
        }
        if (template.getGenre() != null){
            filters.add(movie ->
                    movie.getGenre().equals(template.getGenre()));
        }
        if (template.getDirector() != null){
            filters.add(movie ->
                    movie.getDirector().toLowerCase().contains(template.getDirector().toLowerCase().trim()));
        }

        return movieRepository.findAll().stream().filter(movie -> filters.stream().allMatch(filter ->
                filter.test(movie))).collect(Collectors.toList());
    }
}
