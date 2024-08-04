package org.diegovelu.hibernateapp;

import jakarta.persistence.EntityManager;
import org.diegovelu.hibernateapp.entity.Cliente;
import org.diegovelu.hibernateapp.entity.ClienteDetalle;
import org.diegovelu.hibernateapp.util.JpaUtil;

public class HibernateAsosiacionesOneToOneBidirrecional {
    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();

        try{
            em.getTransaction().begin();

            Cliente cliente = new Cliente("Xavi", "Gamez");
            cliente.setFormaPago("debito");

            ClienteDetalle detalle = new ClienteDetalle(400L,true);
            cliente.addDetalle(detalle);

            em.persist(cliente);
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
