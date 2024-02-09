package org.gabydev.app.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UtilEntity {

    // EntityManagerFactory es quien funcionará como la puerta a la BD
    private static  final EntityManagerFactory entityManagerFactory = buildEntityManagerFactory();

    // vincula la unidad de persistencia definida en persistence.xml
    private static EntityManagerFactory buildEntityManagerFactory() {
        return Persistence.createEntityManagerFactory("appPersistenceUnit");
    }

    // EntityManager nos permitirá realizar las operaciones en la BD
    public static EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }

}
