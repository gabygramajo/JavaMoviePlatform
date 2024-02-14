package org.gabydev.app.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Utilidad para conectar a con la unidad de persistencia.
 * @author Gabriel Gramajo
 * @version 1.0.0
 * @see <a href="https://github.com/gabygramajo">mi github</a>
 */
public class UtilEntity {

    // EntityManagerFactory es quien funcionará como la puerta a la BD
    private static final EntityManagerFactory entityManagerFactory = buildEntityManagerFactory();

    /**
     * Vincula la unidad de persistencia definida en persistence.xml.
     * @return retorna un EntityManagerFactory, es quien funcionará como la puerta a la BD.
     */
    private static EntityManagerFactory buildEntityManagerFactory() {
        return Persistence.createEntityManagerFactory("appPersistenceUnit");
    }

    /**
     * Método para obtener el EntityManager.
     * @return retorna un EntityManager, permitirá realizar las operaciones en la BD.
     */
    public static EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }

}
