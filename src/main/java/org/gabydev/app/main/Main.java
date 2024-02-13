package org.gabydev.app.main;

import org.gabydev.app.model.Genre;
import org.gabydev.app.model.Movie;
import org.gabydev.app.repository.ISearchRepository;
import org.gabydev.app.repository.MovieRepository;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        ISearchRepository<Movie> movieRepository = new MovieRepository();

        // buscar por director
        List<Movie> movieList = movieRepository.findByDirector("Christopher Nolan");
        System.out.println("---- BUSCAR por Director ----");
        movieList.forEach(System.out::println);

        // buscar por genero
        movieList = movieRepository.findByGenre(Genre.ACTION.getGenre());
        System.out.println("---- BUSCAR por Género ----");
        movieList.forEach(System.out::println);
    }
}
