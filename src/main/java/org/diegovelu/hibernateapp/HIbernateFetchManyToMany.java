package org.diegovelu.hibernateapp;

import jakarta.persistence.EntityManager;
import org.diegovelu.hibernateapp.entity.Alumno;
import org.diegovelu.hibernateapp.util.JpaUtil;
import org.hibernate.bytecode.enhance.internal.bytebuddy.EnhancerImpl;

import java.util.List;

public class HIbernateFetchManyToMany {
    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();
        List<Alumno> alumnos = em.createQuery("select distinct a from Alumno a left outer join fetch a.cursos", Alumno.class).getResultList();
        alumnos.forEach(a -> System.out.println(a.getNombre() + " " + a.getCurso()));
    }
}
