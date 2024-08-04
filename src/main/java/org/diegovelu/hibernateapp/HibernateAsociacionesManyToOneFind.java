package org.diegovelu.hibernateapp;

import jakarta.persistence.EntityManager;
import org.diegovelu.hibernateapp.entity.Cliente;
import org.diegovelu.hibernateapp.entity.Factura;
import org.diegovelu.hibernateapp.util.JpaUtil;

public class HibernateAsociacionesManyToOneFind {
    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();

        try{
            em.getTransaction().begin();
            Cliente cliente = em.find(Cliente.class, 1L);

            Factura factura = new Factura("juegos", 100L);
            factura.setCliente(cliente);
            em.persist(factura);
            System.out.println(factura);

            em.getTransaction().commit();

        }   catch (Exception e){

            em.getTransaction().rollback();
            e.printStackTrace();

        }   finally {

        em.close();
        }

    }
}
