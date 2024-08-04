package org.diegovelu.hibernateapp;

import jakarta.persistence.EntityManager;
import org.diegovelu.hibernateapp.entity.Alumno;
import org.diegovelu.hibernateapp.entity.Curso;
import org.diegovelu.hibernateapp.util.JpaUtil;

public class HibernateAsosiacionesManyToManyFind {
    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();

        try{
            em.getTransaction().begin();

            Alumno a1 = em.find(Alumno.class,1L);
            Alumno a2 = em.find(Alumno.class,2L);

            Curso c1 = em.find(Curso.class,1L);
            Curso c2 = em.find(Curso.class,2L);

            a1.getCurso().add(c1);
            a1.getCurso().add(c2);

            a2.getCurso().add(c1);

            em.getTransaction().commit();

            System.out.println(a1);
            System.out.println(a2);

            em.getTransaction().begin();

            c2 = em.find(Curso.class,1L);
            a1.getCurso().remove(c2);


            em.getTransaction().commit();
            System.out.println(a1);


        } catch(Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();

        } finally {
            em.close();

        }

    }
}
