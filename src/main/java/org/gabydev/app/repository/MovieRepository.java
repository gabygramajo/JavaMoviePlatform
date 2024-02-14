package org.gabydev.app.repository;

import org.gabydev.app.model.Movie;
import org.gabydev.app.model.User;
import org.gabydev.app.util.UtilEntity;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Repositorio con los métodos para realizar búsquedas de películas mediante la clase {@link User}.
 * @author Gabriel Gramajo
 * @version 1.0.0
 * @see <a href="https://github.com/gabygramajo">mi github</a>
 */
public abstract class MovieRepository implements ISearchRepository<Movie> {

    public MovieRepository() {
    }

    /**
     * Método para conectar a la Base de datos.
     * @return devuelve un objeto EntityManager para realizar operaciones con la Base de datos
     */
    private EntityManager getConnection() {
        return UtilEntity.getEntityManager();
    }

    /**
     * Devuelve el catálogo completo de películas
     * @return retorna una Lista de tipo Movie.
     */
    @Override
    public List<Movie> findAll() {

        return getConnection()
                .createQuery("SELECT m FROM Movie m", Movie.class)
                .getResultList();
    }

    /**
     * Devuelve una película mediante su ID.
     * @param id identificador de la Película a encontrar.
     * @return retorna un Objeto de tipo Movie o null en caso de se haya encontrado.
     */
    @Override
    public Movie findMovieById(Integer id) {
        String query = "SELECT m FROM Movie m WHERE m.id = :id" ;
        return getConnection()
                .createQuery(query, Movie.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    /**
     * Devuelve todas las películas que tengan el mismo director.
     * @param name nombre del director.
     * @return retorna una lista con Objetos de tipo Movie o null en caso de se haya encontrado.
     */
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

    /**
     * Devuelve todas las películas que tengan sean del mismo género.
     * @param genre nombre del género de películas a encontrar.
     * @return retorna una lista con Objetos de tipo Movie o null en caso de se haya encontrado.
     */
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
