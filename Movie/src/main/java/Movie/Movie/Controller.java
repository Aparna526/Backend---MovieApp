package Movie.Movie;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController

public class Controller {
    private final MovieService ms;

    public Controller(MovieService ms) {
        this.ms = ms;
    }

    @PostMapping("saved")
    public MovieApp savedata(@RequestBody MovieApp entity) {

        return ms.savedata(entity);
    }

    @PostMapping("savebulk")
    public List<MovieApp> savebulk1(@RequestBody List<MovieApp> entity) {
        return ms.savebulk(entity);
    }

    @GetMapping("/{genre1}")
    public List<MovieApp> getMoviesByGenre(@PathVariable String genre1) throws Exception {
        return ms.getMoviesByGenre(genre1);
    }

    @GetMapping("/popular")
    public List<MovieApp> PopularMovies() {
        return ms.getPopularMovies();
    }

    @GetMapping("/allmovies1")
    public List<MovieApp> getallmovies432() {
        return ms.getallmovies123();
    }

    @PostMapping("/byname/{entity}")
    public List<MovieApp> postMethodName(@PathVariable String entity) {
        return ms.getnames(entity.toLowerCase());
    }

    @PutMapping("/movies/{id}/{newTitle}")
    public void updateMovieName(@PathVariable Long id, @PathVariable String newTitle) {
        ms.updateMovieName(id, newTitle); // Update movie title
    }

    @PostMapping("/delete/{name}")
    public List<MovieApp> deleteByName(@PathVariable String name) throws Exception {
        return ms.deleteMovieByName(name);
    }

    @GetMapping("/upcoming")
    public List<MovieApp> getMethodName() {
        return ms.getnewmovies();
    }

    @GetMapping("/pastmovies")
    public List<MovieApp> pastmovies() {
        return ms.getpast();
    }

    @GetMapping("/findupcoming")
    public List<MovieApp> getfindbyupcoming() {
        return ms.getmoviesupcoming();
    }

    @GetMapping("/allmovies")
    public List<MovieApp> getmovies() {
        return ms.getsmovies();
    }

    @GetMapping("/rating")
    public float getRating() {
        return ms.getAvgMovieRating();
    }

    @GetMapping("/avgrating")
    public List<MovieApp> getavgratings() {
        return ms.getmovierating();
    }

}