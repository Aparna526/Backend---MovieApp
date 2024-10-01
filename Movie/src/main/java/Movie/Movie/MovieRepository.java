package Movie.Movie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.NonNull; // Add this import for NonNull annotation
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;
import java.time.*;
import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<MovieApp, Long> {

    @Query("select m from movieapp m where m.genre1=:genre")
    @NonNull // Ensures that this method never returns null
    List<MovieApp> findByGenre1(@Param("genre") String genre);

    @Query("select m from movieapp m where m.popular=true")
    @NonNull
    List<MovieApp> findByIsPopularTrue();

    @Query("select m from movieapp m where m.name LIKE :name%")
    @NonNull
    List<MovieApp> findByName(@Param("name") String name);

    @NonNull
    List<MovieApp> findAll(); // Ensure that the method never returns null

    @Modifying
    @Transactional // Required for modifying queries
    @Query("DELETE FROM movieapp m WHERE m.name = :name")
    void deleteByName(@Param("name") String name);

    @Query("select m from movieapp m where m.Date>=:today")
    @NonNull
    List<MovieApp> upcoming(@Param("today") LocalDate today);

    @Query("select m from movieapp m where m.Date<=:today")
    @NonNull
    List<MovieApp> past(@Param("today") LocalDate today);

    @Query("select m from movieapp m where m.Date >=:today order by m.Date desc")
    @NonNull
    List<MovieApp> findupcoming(@Param("today") LocalDate today);

    @Query("SELECT m FROM movieapp m ORDER BY m.Date DESC")
    @NonNull
    List<MovieApp> findallmovies(@Param("today") LocalDate today);

    @Query("SELECT AVG(m.rating) FROM movieapp m")
    float findAverageRating();

    @Query("from movieapp")
    @NonNull
    List<MovieApp> findAllMovies();

    @Modifying
    @Transactional
    @Query("Update movieapp m set m.name=:name where m.id=:id")
    void updateMovie(@Param("name") String name, @Param("id") Long id);

    @Query("select m from movieapp m where m.rating >2.0  AND m.rating <= :avgrating")
    @NonNull
    List<MovieApp> findmoviesByRating(@Param("avgrating") float avgrating);

}