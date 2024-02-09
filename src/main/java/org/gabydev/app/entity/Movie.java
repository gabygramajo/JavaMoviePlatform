package org.gabydev.app.entity;

import javax.persistence.*;

@Entity
@Table(name="movies")
public class Movie {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private String title;
    @Column(name = "year")
    private Integer year;
    @Column(name = "stars")
    private Integer stars;
    @Column(name = "category_id")
    private Integer category;
    @Column(name = "director_id")
    private Integer director;

    public Movie() {
    }

    public Integer getId() {
        return id;
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

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public Integer getDirector() {
        return director;
    }

    public void setDirector(Integer director) {
        this.director = director;
    }

    @Override
    public String toString() {
        return "title='" + title + '\'' +
                ", year='" + year + '\'' +
                ", stars=" + stars +
                ", category='" + category + '\'' +
                ", director='" + director + '\'';
    }
}
