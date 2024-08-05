package org.diegovelu.hibernateapp;

import jakarta.persistence.EntityManager;
import org.diegovelu.hibernateapp.entity.Cliente;
import org.diegovelu.hibernateapp.util.JpaUtil;

import java.util.List;

public class HibernateFetchResultList {
    public static void main(String[] args) {

        EntityManager em = JpaUtil.getEntityManager();
        List<Cliente> clientes = em.createQuery("select distinct c from Cliente c left outer join fetch c.direcciones left join fetch c.detalle", Cliente.class)
                .getResultList();
        clientes.forEach(c-> System.out.println(c.getNombre() + " " + c.getDirecciones()));

        em.close();
    }

}
