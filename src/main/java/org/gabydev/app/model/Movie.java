package org.gabydev.app.model;

import javax.persistence.*;

@Entity
@Table(name="movies")
public class Movie {
    // Primary Key
    @Id
    //auto incremental
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private String title;
    @Column(name = "year")
    private Integer year;
    @Column(name = "stars")
    private Integer stars;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "director_id", referencedColumnName = "id")
    private Director director;

    public Movie() {
    }

    public Movie(Integer id, String title, Integer year, Integer stars, Category category, Director director) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.stars = stars;
        this.category = category;
        this.director = director;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getStars() {
        return stars;
    }

    public void setStars(Integer stars) {
        this.stars = stars;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    @Override
    public String toString() {
        return id +
                ": " + title +
                ", " + year +
                ", " + stars + " Stars" +
                ", Category: " + category.getNameCategory() +
                ", Director: " + director.getFullName();
    }
}
