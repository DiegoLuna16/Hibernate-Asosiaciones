package org.diegovelu.hibernateapp;

import jakarta.persistence.EntityManager;
import org.diegovelu.hibernateapp.entity.Cliente;
import org.diegovelu.hibernateapp.entity.ClienteDetalle;
import org.diegovelu.hibernateapp.util.JpaUtil;

public class HibernateAsosiacionesOneToOneBidirrecionalFind {
    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();

        try{
            em.getTransaction().begin();

            Cliente cliente = em.find(Cliente.class, 1L);

            ClienteDetalle detalle = new ClienteDetalle(4000L,true);
            cliente.addDetalle(detalle);

            em.getTransaction().commit();

            System.out.println(cliente);
        } catch(Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}
