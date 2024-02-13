package org.gabydev.app.repository;

import org.gabydev.app.model.Movie;
import org.gabydev.app.util.UtilEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

public class UserRepository {

    public UserRepository() {
    }

    private EntityManager getConnection() {
        return UtilEntity.getEntityManager();
    }

    public void save(Movie movie) {
        EntityManager em = getConnection();
        try {
            em.getTransaction().begin();
            em.persist(movie);
            em.getTransaction().commit();
        } catch (PersistenceException e) {
            System.out.println("Por favor ingrese los datos correctamente");
            e.printStackTrace();
        }
    }


    public void delete(Integer id) {
        EntityManager em = getConnection();
        try {
            Movie movieToDelete = em.find(Movie.class, id);

            em.getTransaction().begin();
            em.remove(movieToDelete);
            em.getTransaction().commit();
            em.close();

        } catch (Exception e) {
            System.out.println("Pelicula no existente");
            e.printStackTrace();
        }
    }
}
