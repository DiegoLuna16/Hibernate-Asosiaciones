package org.diegovelu.hibernateapp;

import jakarta.persistence.EntityManager;
import org.diegovelu.hibernateapp.entity.Alumno;
import org.diegovelu.hibernateapp.entity.Curso;
import org.diegovelu.hibernateapp.util.JpaUtil;

public class HibernateAsosiacionesManyToManyBidirrecional {
    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();

        try{
            em.getTransaction().begin();

            Alumno a1 = new Alumno("Luis", "Carbajal");
            Alumno a2 = new Alumno("Mike", "Carbajal");

            Curso c1 = new Curso("Java","Javier");
            Curso c2 = new Curso("Python","Luna");

            a1.addCurso(c1);
            a1.addCurso(c2);

            a2.addCurso(c1);

            em.persist(a1);
            em.persist(a2);




            em.getTransaction().commit();
            System.out.println(a1);
            System.out.println(a2);

            em.getTransaction().begin();


            c2 = em.find(Curso.class,3L);
            a1.getCurso().remove(c2);
            //a1.getCurso().remove(c2);


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
