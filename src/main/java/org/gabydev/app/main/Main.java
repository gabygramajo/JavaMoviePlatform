package org.gabydev.app.main;

import org.gabydev.app.model.Genre;
import org.gabydev.app.model.User;
import org.gabydev.app.repository.MovieRepository;
import org.gabydev.app.repository.UserRepository;

public class Main {
    public static void main(String[] args) {

        MovieRepository movieRepository = new MovieRepository();
        User user = UserRepository.getUserById(3);

        System.out.println("--------- All Movies ---------");
        movieRepository.findAll().forEach(System.out::println);

        System.out.println("\n--------- Movies by id ---------");
        System.out.println(movieRepository.findMovieById(3));

        System.out.println("\n--------- Movies by Director ---------");
        System.out.println(movieRepository.findByDirector("Christopher Nolan"));

        System.out.println("\n--------- Movies by Genre ---------");
        System.out.println(movieRepository.findByGenre(Genre.ACTION.getGenre()));

        System.out.println("\n--------- User ---------");
        System.out.println(user);

//        System.out.println("\n--------- Update User ---------");
//        user.updateFullName("Shekina Valverde");
//        user.updateNickname("Sheki");
//        user.updateEmail("shekini@mail.com");
//        user.updatePassword("#SheniX456");
//        System.out.println(user);

        System.out.println("\n--------- User - Favorite Movies ---------");
        user.getMyFavoriteMovies().forEach(System.out::println);

//        System.out.println("\n--------- User - Delete Favorite Movies ---------");
//        user.deleteFavoriteMovieToList(10);
//        user.deleteFavoriteMovieToList(25);
//        user.deleteFavoriteMovieToList(11);

//        System.out.println("\n--------- User - Add Favorite Movies ---------");
//        user.addToFavoriteMovieList(17);
//        user.addToFavoriteMovieList(7);

        user.getMyFavoriteMovies().forEach(System.out::println);

    }
}
