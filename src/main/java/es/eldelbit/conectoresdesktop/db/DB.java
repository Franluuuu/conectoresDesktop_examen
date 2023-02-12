/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.eldelbit.conectoresdesktop.db;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 *
 * @author virtualbox
 */
public class DB {

    private static EntityManagerFactory emf;

    static {

        emf = Persistence.createEntityManagerFactory("default");

    }

    public static EntityManager createEntityManager() {

        return emf.createEntityManager();

    }

    public static void closeEntityManager(EntityManager em) {

        if (em != null) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            em.close();
        }

    }

}
