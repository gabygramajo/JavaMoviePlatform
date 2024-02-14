package org.gabydev.app.model;

import org.gabydev.app.repository.UserRepository;

import static org.gabydev.app.util.ValidateData.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User extends UserRepository {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "fullname")
    private String fullname;
    @Column(name = "nickname")
    private String nickname;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public String getFullname() {
        return fullname;
    }

    private void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getNickname() {
        return nickname;
    }

    private void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    private void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    private void setPassword(String password) {
        this.password = password;
    }

    public void updateFullName(String newFullName) {
        if (validateStr(newFullName, 4)) {
            setFullname(newFullName);
            this.updateUserData(this);
        }
    }

    public void updateNickname(String newNickname) {
        if (validateStr(newNickname, 4)) {
            setNickname(newNickname);
            this.updateUserData(this);
        }
    }

    public void updateEmail(String newEmail) {
        if (validateEmail(newEmail)) {
            setEmail(newEmail);
            this.updateUserData(this);
        } else {
            throw new Error("El email no es válido");
        }
    }

    public void updatePassword(String newPassword) {
        if (validatePassword(newPassword)) {
            setPassword(newPassword);
            this.updateUserData(this);
        } else {
            throw new Error("Contraseña no válida, debe tener al menos un número, una minúscula, una mayúscula , un carácter especial y una longitud mayor a 8.");
        }
    }

    public List<Movie> getMyFavoriteMovies() {
        return getFavoriteMovies(this.fullname);
    }

    public void addToFavoriteMovieList(int idMovie) {

        FavoriteMovie movieToAdd = new FavoriteMovie();
        movieToAdd.setUser(this);
        movieToAdd.setMovie(this.findMovieById(idMovie));

        addFavoriteMovie(movieToAdd);
    }

    public void deleteFavoriteMovieToList(int idMovie) {
        deleteFavoriteMovie(idMovie);
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", fullname= " + fullname +
                ", nickname= " + nickname +
                ", email= " + email +
                ", password= " + password;
    }
}
