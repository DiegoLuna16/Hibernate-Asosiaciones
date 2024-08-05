package org.diegovelu.hibernateapp;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.*;
import org.diegovelu.hibernateapp.entity.Cliente;
import org.diegovelu.hibernateapp.entity.Factura;
import org.diegovelu.hibernateapp.util.JpaUtil;

import java.util.List;

public class HibernateFetchOneToManyCriteria {
    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Cliente> query = cb.createQuery(Cliente.class);
        Root<Cliente> root = query.from(Cliente.class);
        root.fetch("direcciones", JoinType.LEFT);
        root.fetch("detalle", JoinType.LEFT);
        query.select(root).distinct(true);

        List<Cliente> clientes = em.createQuery(query).getResultList();
        em.close();

        clientes.forEach( c-> System.out.println(c.getNombre() + " " + c.getDirecciones()));
        clientes.forEach( c-> System.out.println(c.getNombre() + " " + c.getDetalle()));
    }
}
