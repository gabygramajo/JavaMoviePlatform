package org.gabydev.app.repository;

import org.gabydev.app.model.Movie;
import org.gabydev.app.util.UtilEntity;

import javax.persistence.EntityManager;
import java.util.List;

public abstract class MovieRepository implements ISearchRepository<Movie> {

    public MovieRepository() {
    }

    // Connection a la BD
    private EntityManager getConnection() {
        return UtilEntity.getEntityManager();
    }

    @Override
    public List<Movie> findAll() {
        return getConnection()
                .createQuery("SELECT m FROM Movie m", Movie.class)
                .getResultList();
        // Consulta HQL mediante la interfaz EntityManager
        // HQL no es sensible a mayúsculas/minúsculas (sólo para los nombres de clases y propiedades)
    }

    @Override
    public Movie findMovieById(Integer id) {
        String query = "SELECT m FROM Movie m WHERE m.id = :id" ;
        return getConnection()
                .createQuery(query, Movie.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public List<Movie> findByDirector(String name) {
        String query = "SELECT m FROM Movie m " +
                "JOIN m.director d " +
                "WHERE d.fullName = :name";

        return getConnection()
                .createQuery(query, Movie.class)
                .setParameter("name", name)
                .getResultList();
    }

    @Override
    public List<Movie> findByGenre(String genre) {
        String query = "SELECT m FROM Movie m " +
                "JOIN m.category c " +
                "WHERE c.nameCategory = :genre";

        return getConnection()
                .createQuery(query, Movie.class)
                .setParameter("genre", genre)
                .getResultList();
    }

}
