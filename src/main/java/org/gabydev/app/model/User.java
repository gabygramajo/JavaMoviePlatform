package org.gabydev.app.model;

import org.gabydev.app.repository.ISearchRepository;
import org.gabydev.app.repository.MovieRepository;
import org.gabydev.app.repository.UserRepository;

import static org.gabydev.app.util.ValidateData.*;

import jakarta.persistence.*;
import java.util.List;


/**
 * Entidad Usuario relacionada con la tabla users
 * @author Gabriel Gramajo
 * @version 1.0.0
 * @see <a href="https://github.com/gabygramajo">mi github</a>
 */
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "fullname")
    private String fullName;
    @Column(name = "nickname")
    private String nickName;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;


    public User() {
    }

    public Integer getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    private void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getNickName() {
        return nickName;
    }

    private void setNickName(String nickName) {
        this.nickName = nickName;
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

    /**
     * Método para actualizar su nombre completo.
     * @param newFullName Nuevo nombre a agregar.
     */
    public void updateFullName(String newFullName) {
        UserRepository userRepository = new UserRepository();
        if (validateStr(newFullName, 4)) {
            setFullName(newFullName);
            userRepository.updateUserData(this);
        }
    }

   /**
     * Método para actualizar su nickname.
     * @param newNickname Nuevo nickname a agregar.
     */
    public void updateNickname(String newNickname) {
        UserRepository userRepository = new UserRepository();
        if (validateStr(newNickname, 4)) {
            setNickName(newNickname);
            userRepository.updateUserData(this);
        }
    }

   /**
     * Método para actualizar el email.
     * @param newEmail Nuevo email a agregar.
     */
    public void updateEmail(String newEmail) {
        UserRepository userRepository = new UserRepository();
        if (validateEmail(newEmail)) {
            setEmail(newEmail);
            userRepository.updateUserData(this);
        } else {
            throw new Error("El email no es válido");
        }
    }

   /**
     * Método para actualizar la contraseña.
     * @param newPassword Nueva contraseña a agregar.
     */
    public void updatePassword(String newPassword) {
        UserRepository userRepository = new UserRepository();
        if (validatePassword(newPassword)) {
            setPassword(newPassword);
            userRepository.updateUserData(this);
        } else {
            throw new Error("Contraseña no válida, debe tener al menos un número, una minúscula, una mayúscula , un carácter especial y una longitud mayor a 8.");
        }
    }

    /**
     * Método para obtener todas las películas en la lista de favoritos.
     * @return retorna una Lista de tipo Movie o null en caso de se haya encontrado.
     */
    public List<Movie> getMyFavoriteMovies() {
        UserRepository userRepository = new UserRepository();
        return userRepository.getFavoriteMovies(this.fullName);
    }

    /**
     * Método para agregar una nueva película a la lista de favoritos.
     * @param idMovie Identificador de la película a agregar.
     */
    public void addToFavoriteMovieList(int idMovie) {

        UserRepository userRepository = new UserRepository();
        ISearchRepository<Movie> movieRepositoty = new MovieRepository();
        FavoriteMovie movieToAdd = new FavoriteMovie();
        movieToAdd.setUser(this);
        movieToAdd.setMovie(movieRepositoty.findMovieById(idMovie));

        userRepository.addFavoriteMovie(movieToAdd);
    }

    /**
     * Método para eliminar una película a la lista de favoritos.
     * @param idMovie Identificador de la película a eliminar.
     */
    public void deleteFavoriteMovieToList(int idMovie) {
        UserRepository userRepository = new UserRepository();
        userRepository.deleteFavoriteMovie(idMovie);
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", fullname= " + fullName +
                ", nickname= " + nickName +
                ", email= " + email +
                ", password= " + password;
    }
}
