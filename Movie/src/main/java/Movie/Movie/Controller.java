package Movie.Movie;




import java.util.List;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/movies")
public class Controller {

    private final MovieService movieService;

    public Controller(MovieService movieService) {
        this.movieService = movieService;
    }
    @PostMapping("saveMovies")
    public Movie saved(@RequestBody Movie m){
        return movieService.saved(m);

    }
    @PostMapping("saveBulk")
    public List<Movie>saveBulk(@RequestBody List<Movie>m){
        return movieService.savebulk(m);
    }

    
    @GetMapping("/popular")
    public List<Movie> getPopularMovies() {
        return movieService.getPopularMovies();
    }

    @GetMapping("/genre/{genre}")
    public List<Movie> getMoviesByGenre(@PathVariable String genre) {
        return movieService.getMoviesByGenre(genre);
    }
    @GetMapping("findbyname/{name}")
    public Movie getbyname(@PathVariable String name){
        return movieService.findbyName(name);
    }
    @GetMapping("Search/{name}")
    public List<Movie>getSimilar(@PathVariable String name){
        return movieService.search(name);
    }
    @GetMapping("/upcoming")
    public List<Movie> getUpcomingMovies() {
        return movieService.getUpcomingMovies();
    }
    @GetMapping("/desc")
    public List<Movie> getMoviesBasedondesc(){
        return movieService.getMoviesbydesc();
    }
    @DeleteMapping("/del/{id}")
    public String deletemovie(@PathVariable Long id){
        return movieService.deletemovie(id);
    }

}