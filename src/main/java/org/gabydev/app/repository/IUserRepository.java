package org.gabydev.app.repository;

import org.gabydev.app.model.Movie;

public interface IUserRepository {

    void updateFullname(String newFullName);

    void updateNickname(String newNickname);

    void updateEmail(String newEmail);

    void updatePassword(String newPassword);

    String getFavoriteMovies();

    void addFavoriteMovies(Movie m);

    void deleteFavoriteMovies(Movie m);
}
