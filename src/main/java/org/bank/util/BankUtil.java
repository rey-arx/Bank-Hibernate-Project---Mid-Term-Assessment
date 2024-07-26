package org.bank.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class BankUtil {
    public static EntityManager createEntityManager(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("test1");
        EntityManager em = emf.createEntityManager();
        return em;
    }
}
