package org.diegovelu.hibernateapp;

import jakarta.persistence.EntityManager;
import org.diegovelu.hibernateapp.entity.Cliente;
import org.diegovelu.hibernateapp.util.JpaUtil;

public class HibernateFetchLazyOneToManyJoinFetch {
    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();


        Cliente cliente = em.createQuery("select c from Cliente c left outer join fetch c.direcciones left join fetch c.detalle where c.id=:id",Cliente.class)
                .setParameter("id", 1L)
                .getSingleResult();
        System.out.println(cliente.getNombre() + " " + cliente.getDirecciones());
        System.out.println(cliente.getNombre() + " " + cliente.getDetalle());

        em.close();

    }
}
