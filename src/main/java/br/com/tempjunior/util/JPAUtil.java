package br.com.tempjunior.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
    private static final EntityManagerFactory FACTORY = Persistence
            .createEntityManagerFactory("atletas");

    public static EntityManager getEntityManager(){
        return FACTORY.createEntityManager();
    }
}
