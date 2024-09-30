package Movie.Movie;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name =  "Movies")
public class MovieApp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String poster;
    public String getPoster() {
        return poster;
    }
    public MovieApp(String poster) {
        this.poster = poster;
    }
    public void setPoster(String poster) {
        this.poster = poster;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public MovieApp(int id, String title, String date, boolean release) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.release = release;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public boolean isRelease() {
        return release;
    }
    public void setRelease(boolean release) {
        this.release = release;
    }
    private String date;
    private boolean release;
}
