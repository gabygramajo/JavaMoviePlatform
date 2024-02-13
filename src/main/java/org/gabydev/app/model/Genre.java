package org.gabydev.app.model;

public enum Genre {
    DRAMA("Drama"),
    ACTION("Action"),
    COMEDY("Comedy"),
    SCIENCE_FICTION("Science Fiction"),
    ANIMATION("Animation"),
    ROMANCE("Romance"),
    FANTASY("Fantasy"),
    THRILLER("Thriller"),
    MYSTERY("Mystery"),
    ADVENTURE("Adventure"),
    HORROR("Horror"),
    MUSICAL("Musical"),
    WESTERN("Western"),
    CRIME("Crime"),
    BIOGRAPHY("Biography"),
    DRAMA_COMEDY("Drama Comedy"),
    WAR("War");

    private final String genre;

    Genre(String genre) {
        this.genre = genre;
    }

    public  String getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return genre;
    }
}
