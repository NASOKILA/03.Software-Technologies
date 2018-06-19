package imdb.entity;

import javax.persistence.*;

@Entity
@Table(name = "films")
public class Film {

    // ZA ID-to NIKOGA NE IZPOLZVAI int, VINAGI Integer ZASHTOTO TAKA PRAVIM REFERENCIQ
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = true)
    private String name;

    @Column(nullable = true)
    private String genre;

    @Column(nullable = true)
    private String director;

    @Column(nullable = true)
    private Integer year;

    public Film() {
    }

    public Film(String name, String genre, String director, Integer year) {
        this.name = name;
        this.genre = genre;
        this.director = director;
        this.year = year;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}
