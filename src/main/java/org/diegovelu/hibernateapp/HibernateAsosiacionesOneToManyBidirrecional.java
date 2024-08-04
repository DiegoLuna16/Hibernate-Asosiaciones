package org.diegovelu.hibernateapp;

import jakarta.persistence.EntityManager;
import org.diegovelu.hibernateapp.entity.Cliente;
import org.diegovelu.hibernateapp.entity.Factura;
import org.diegovelu.hibernateapp.util.JpaUtil;

public class HibernateAsosiacionesOneToManyBidirrecional {

    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();

        try {
            em.getTransaction().begin();
            Cliente cliente = new Cliente("Xavier", "Luna");
            cliente.setFormaPago("paypal");

            Factura f1 = new Factura("xbox", 100L);
            Factura f2 = new Factura("play", 200L);

            cliente.addFactura(f1);
            cliente.addFactura(f2);

            em.persist(cliente);
            em.getTransaction().commit();
            System.out.println(cliente);

            em.getTransaction().begin();

            //Factura f3 = em.find(Factura.class, 1L);
            Factura f3 = new Factura("xbox", 100L);
            f3.setId(1L);
            cliente.removeFactura(f3);
            em.getTransaction().commit();

        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }

    }

}
