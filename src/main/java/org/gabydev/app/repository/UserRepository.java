package org.gabydev.app.repository;

import org.gabydev.app.model.FavoriteMovie;
import org.gabydev.app.model.Movie;
import org.gabydev.app.model.User;
import org.gabydev.app.util.UtilEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import java.util.List;

public abstract class UserRepository extends MovieRepository implements IUserRepository{

    public UserRepository() {
    }

    private static EntityManager getConnection() {
        return UtilEntity.getEntityManager();
    }


    public static User getUserById(Integer id) {
        return getConnection()
                .createQuery("SELECT u FROM User u WHERE u.id = :id", User.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public void updateUserData(User user) {

        EntityManager em = getConnection();

        em.getTransaction().begin();
        em.merge(user);
        em.getTransaction().commit();

    }

    @Override
    public List<Movie> getFavoriteMovies(String name) {
        String query = "SELECT f.movie " +
                "FROM FavoriteMovie f " +
                "JOIN f.user u " +
                "WHERE u.fullname = :name";

        return getConnection()
                .createQuery(query, Movie.class)
                .setParameter("name", name)
                .getResultList();
    }

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
