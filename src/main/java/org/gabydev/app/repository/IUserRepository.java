package org.gabydev.app.repository;

import org.gabydev.app.model.FavoriteMovie;
import org.gabydev.app.model.Movie;
import org.gabydev.app.model.User;

import java.util.List;

public interface IUserRepository{

    void updateUserData(User user);

    List<Movie> getFavoriteMovies(String name);

    void addFavoriteMovie(FavoriteMovie movieToAdd);

    void deleteFavoriteMovie(int movieId);
}
