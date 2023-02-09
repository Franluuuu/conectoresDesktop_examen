/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.eldelbit.conectoresdesktop.repositories;

import es.eldelbit.conectoresdesktop.models.Cliente;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author virtualbox
 */
public class ClienteRepository {

    public static Cliente find(Session s, Long id) {
        return s.find(Cliente.class, id);
    }

    public static List<Cliente> get(Session s) {
        return s.createQuery("SELECT c FROM Cliente c", Cliente.class).getResultList();
    }
}
