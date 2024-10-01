package Movie.Movie;

import java.util.*;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

import java.time.*;

@Service
public class MovieService {

    private final MovieRepository Movierepositorys;

    public MovieService(MovieRepository movierepositorys) {
        this.Movierepositorys = movierepositorys;
    }

    public MovieApp savedata(MovieApp movies) {
        return Movierepositorys.save(movies);
    }

    @Transactional
    public List<MovieApp> deleteMovieByName(String name) throws Exception {
        Movierepositorys.deleteByName(name);
        return Movierepositorys.findAll();
    }

    public List<MovieApp> savedbulk(List<MovieApp> movies) {
        return Movierepositorys.saveAll(movies);
    }

    public List<MovieApp> savebulk(List<MovieApp> movies) {
        return Movierepositorys.saveAll(movies);
    }

    public List<MovieApp> getMoviesByGenre(String genre) {
        return Movierepositorys.findByGenre1(genre);
    }

    public List<MovieApp> getPopularMovies() {
        return Movierepositorys.findByIsPopularTrue();
    }

    public List<MovieApp> getnames(String name) {
        return Movierepositorys.findByName(name);
    }

    public List<MovieApp> getnewmovies() {
        LocalDate id = LocalDate.now();
        return Movierepositorys.upcoming(id);

    }

    public List<MovieApp> getallmovies123() {
        return Movierepositorys.findAllMovies();
    }

    public List<MovieApp> getpast() {
        LocalDate id = LocalDate.now();
        return Movierepositorys.past(id);
    }

    public void updateMovieName(Long id, String newTitle) {
        Movierepositorys.updateMovie(newTitle, id); // Call the update method
    }

    public List<MovieApp> getmoviesupcoming() {
        LocalDate id = LocalDate.now();
        return Movierepositorys.findupcoming(id);
    }

    public List<MovieApp> getsmovies() {
        LocalDate id = LocalDate.now();
        return Movierepositorys.findallmovies(id);
    }

    public float getAvgMovieRating() {
        return Movierepositorys.findAverageRating();
    }

    public List<MovieApp> getmovierating() {
        float ar = Movierepositorys.findAverageRating();
        return Movierepositorys.findmoviesByRating(ar);
    }

}