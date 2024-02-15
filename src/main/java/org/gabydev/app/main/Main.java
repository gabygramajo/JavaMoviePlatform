package org.gabydev.app.main;

import org.gabydev.app.model.Genre;
import org.gabydev.app.model.Movie;
import org.gabydev.app.model.User;

public class Main {
    public static void main(String[] args) {

        User user = User.getUserById(3);

        // Listar catálogo
        System.out.println("------ Catálogo de películas ------");
        user.findAll()
                .forEach(System.out::println);

        // Encontrar película por id
        System.out.println("\n------ Película por id ------");
        Movie movie = user.findMovieById(16);
        System.out.println("movie: " + movie);

        // Listar películas por director
        System.out.println("\n------ Película por director ------");
        String director = movie.getDirector().getFullName();
        user.findByDirector(director)
                .forEach(System.out::println);

        // Listar películas por género
        System.out.println("\n------ Película por género ------");
        user.findByGenre(Genre.ACTION.getGenre())
                .forEach(System.out::println);

        // Usuario a modificar
        System.out.println("\n------ User a modificar ------");
        System.out.println(user);

        // Modificar datos
        user.updateFullName("Andrea González");
        user.updateNickname("Andrea");
        user.updateEmail("andrea23@mail.com");
        user.updatePassword("@Rman1212");

        System.out.println("\n------ Datos Actualizados ------");
        System.out.println(user);

        // Mostrar lista de películas favoritas
        System.out.println("\n------ Lista de películas favoritas ------");
        user.getMyFavoriteMovies()
                .forEach(System.out::println);

        user.deleteFavoriteMovie(11);
        // Agregar películas a la Lista de favoritos
        user.addToFavoriteMovieList(11);
        user.addToFavoriteMovieList(27);

        System.out.println("\n------ Lista de películas favoritas Actualizada ------");
        user.getMyFavoriteMovies()
                .forEach(System.out::println);

        // Eliminar película de la Lista de favoritos
        user.deleteFavoriteMovie(27);

        System.out.println("\n------ Lista de películas favoritas Actualizada ------");
        user.getMyFavoriteMovies()
                .forEach(System.out::println);

    }
}
