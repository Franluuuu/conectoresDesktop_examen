/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.eldelbit.conectoresdesktop.repositories;

import es.eldelbit.conectoresdesktop.models.Cliente;
import jakarta.persistence.EntityManager;
import java.util.List;

/**
 *
 * @author virtualbox
 */
public class ClienteRepository {

    public static Cliente find(EntityManager em, Long id) {

        return em.find(Cliente.class, id);
    }

    public static List<Cliente> get(EntityManager em) {

        return em.createQuery("SELECT c FROM Cliente c", Cliente.class).getResultList();
    }

    public static void insert(EntityManager em, Cliente cliente) {

        // TODO: Intentar quitar esta línea, debería hacerlo con anotaciones
        cliente.setId(null);

        em.persist(cliente); // aquí cliente.id ya tiene valor

    }
}
