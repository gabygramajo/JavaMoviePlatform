package org.gabydev.app.repository;

import org.gabydev.app.model.FavoriteMovie;
import org.gabydev.app.model.Movie;
import org.gabydev.app.model.User;
import org.gabydev.app.util.UtilEntity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceException;
import java.util.List;

/**
 * Repositorio con los métodos para realizar las acciones del Usuario {@link User}.
 * @author Gabriel Gramajo
 * @version 1.0.0
 * @see <a href="https://github.com/gabygramajo">mi github</a>
 */
public class UserRepository implements IUserRepository{

    public UserRepository() {
    }

    private static EntityManager getConnection() {
        return UtilEntity.getEntityManager();
    }

    /**
     * Obtener un usuario mediante su Identificador.
     * @param id Identificador del usuario a encontrar.
     * @return Retorna un objeto de tipo User o null en caso de se haya encontrado.
     */
    public static User getUserById(Integer id) {
        return getConnection()
                .createQuery("SELECT u FROM User u WHERE u.id = :id", User.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    /**
     * Actualiza los datos del usuario con su nombre, nickname, email o password en la Base de Datos.
     * @param user Usuario con los datos a actualizar.
     */
    @Override
    public void updateUserData(User user) {

        EntityManager em = getConnection();

        em.getTransaction().begin();
        em.merge(user);
        em.getTransaction().commit();

    }

    /**
     * Devuelve la lista de películas favoritas del usuario.
     * @param name Nombre del usuario
     * @return retorna una Lista de tipo Movie o null en caso de se haya encontrado.
     */
    @Override
    public List<Movie> getFavoriteMovies(String name) {
        String query = "SELECT f.movie " +
                "FROM FavoriteMovie f " +
                "JOIN f.user u " +
                "WHERE u.fullName = :name";

        return getConnection()
                .createQuery(query, Movie.class)
                .setParameter("name", name)
                .getResultList();
    }

    /**
     * Método para agregar una película a la lista de favoritos y agregarlo a la BD.
     * @param movieToAdd Obj con la película y usuario
     * @throws PersistenceException Lanza la PersistenceException en caso de que la película ya exista.
     */
    @Override
    public void addFavoriteMovie(FavoriteMovie movieToAdd) {
        EntityManager em = getConnection();

        try {
            em.getTransaction().begin();
            em.persist(movieToAdd);
            em.getTransaction().commit();
        } catch (PersistenceException pe) {
            System.out.println("ya se encuentra en la lista de favoritos");
        }
    }

    /**
     * Método para Eliminar una película a la lista de favoritos y de la BD.
     * @param movieId Identificador de la película a borrar.
     * @throws IllegalArgumentException Lanza la IllegalArgumentException en caso de que la película no exista en la lista de favoritos.
     */
    @Override
    public void deleteFavoriteMovie(int movieId) {
        EntityManager em = getConnection();
        
        String query = "SELECT fm " +
                "FROM FavoriteMovie fm " +
                "JOIN fm.movie m " +
                "WHERE m.id = :movieId";
        
        FavoriteMovie fieldToDelete = em.createQuery(query, FavoriteMovie.class)
                .setParameter("movieId", movieId)
                .getSingleResult();

        try {
            em.getTransaction().begin();
            em.remove(fieldToDelete);
            em.getTransaction().commit();
            em.close();
        } catch (IllegalArgumentException exception) {
            System.out.println("no existe en la lista de favoritos");
        }
    }
}
