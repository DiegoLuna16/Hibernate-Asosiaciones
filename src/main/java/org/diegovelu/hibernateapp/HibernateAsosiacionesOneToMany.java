package org.diegovelu.hibernateapp;

import jakarta.persistence.EntityManager;
import org.diegovelu.hibernateapp.entity.Cliente;
import org.diegovelu.hibernateapp.entity.Direccion;
import org.diegovelu.hibernateapp.util.JpaUtil;

public class HibernateAsosiacionesOneToMany {
    public static void main(String[] args) {

        EntityManager em = JpaUtil.getEntityManager();
        try{
            em.getTransaction().begin();

            Cliente cliente = em.find(Cliente.class, 5L);

            Direccion d1 = new Direccion("San Carlo","12354");
            Direccion d2 = new Direccion("San Carl","1234");

            cliente.getDirecciones().add(d1);
            cliente.getDirecciones().add(d2);
            em.persist(cliente);
            em.getTransaction().commit();
            System.out.println(cliente);

            em.getTransaction().begin();
            cliente = em.find(Cliente.class, 5L);
            cliente.getDirecciones().remove(d1);
            em.getTransaction().commit();
            System.out.println(cliente);

            em.getTransaction().begin();
            cliente.getDirecciones().remove(d1);
            em.getTransaction().commit();
            System.out.println(cliente);

        } catch (Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}
