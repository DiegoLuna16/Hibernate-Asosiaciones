package org.diegovelu.hibernateapp;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.*;
import org.diegovelu.hibernateapp.entity.Cliente;
import org.diegovelu.hibernateapp.entity.Factura;
import org.diegovelu.hibernateapp.util.JpaUtil;

import java.util.List;

public class HibernateFetchManyToOneCriteria {
    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Factura> query = cb.createQuery(Factura.class);
        Root<Factura> root = query.from(Factura.class);
        Join<Factura, Cliente> cliente = (Join) root.fetch("cliente", JoinType.LEFT);
        cliente.fetch("detalle", JoinType.LEFT);
        query.select(root).where(cb.equal(cliente.get("id"),1L));
        List<Factura> facturas = em.createQuery(query).getResultList();
        facturas.forEach(f-> System.out.println(f.getDescripcion() + ", cliente: " + f.getCliente().getNombre()));
        em.close();
    }
}
