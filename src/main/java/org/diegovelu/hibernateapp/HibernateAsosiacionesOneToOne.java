package org.diegovelu.hibernateapp;

import jakarta.persistence.EntityManager;
import org.diegovelu.hibernateapp.entity.Cliente;
import org.diegovelu.hibernateapp.entity.ClienteDetalle;
import org.diegovelu.hibernateapp.util.JpaUtil;

public class HibernateAsosiacionesOneToOne {
    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();

        try{
            em.getTransaction().begin();
            Cliente cliente = new Cliente("Mike","Louie");
            cliente.setFormaPago("paypal");
            em.persist(cliente);

            ClienteDetalle detalle = new ClienteDetalle(500L,true);
            em.persist(detalle);

            cliente.setDetalle(detalle);

            em.getTransaction().commit();

        } catch(Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}
