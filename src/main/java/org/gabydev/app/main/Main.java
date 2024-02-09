package org.gabydev.app.main;

import org.gabydev.app.entity.Movie;
import org.gabydev.app.util.UtilEntity;

import javax.persistence.EntityManager;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        EntityManager em = UtilEntity.getEntityManager();

        // Consulta HQL mediante la interfaz EntityManager
        // HQL no es sensible a mayúsculas/minúsculas (sólo para los nombres de clases y propiedades)
        List<Movie> movies = em.createQuery("SELECT m FROM Movie m", Movie.class).getResultList();

        //List<String> movies = em.createQuery("SELECT m.title FROM Movie m", String.class).getResultList();

        movies.forEach(m -> {
            System.out.println( m.getId() + ")" + m.getTitle());
        });

    }
}
