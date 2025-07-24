package com.example.sof3012.repository;

import com.example.sof3012.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.Collections;
import java.util.List;

public class StudentRepo {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
    private EntityManager em = emf.createEntityManager();

    public List<Student> getStudents() {
        return em.createQuery("select s from Student s", Student.class).getResultList();
    }

    public Student getStudent(Long id) {
        return em.find(Student.class, id);
    }

    public void themStudent(Student student) {
        try{
            em.getTransaction().begin();
            em.persist(student);
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public void suaStudent(Student student) {
        try{
            em.getTransaction().begin();
            em.merge(student);
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public void xoa(Long id) {
        try{
            em.getTransaction().begin();
            em.remove(getStudent(id));
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public List<Student> getStudentsByPage(int page, int size) {
        return em.createQuery("SELECT s FROM Student s", Student.class)
                .setFirstResult((page - 1) * size)  // OFFSET
                .setMaxResults(size)                // LIMIT
                .getResultList();
    }

    public long countStudents() {
        return em.createQuery("SELECT COUNT(s) FROM Student s", Long.class)
                .getSingleResult();
    }

    public List<Student> getStudentsByNameAndPage(String name, int page, int size) {
        return em.createQuery("SELECT s FROM Student s WHERE s.name LIKE :name", Student.class)
                .setParameter("name", "%" + name + "%")
                .setFirstResult((page - 1) * size)
                .setMaxResults(size)
                .getResultList();
    }

    public long countStudentsByKeyword(String name) {
        return em.createQuery("SELECT COUNT(s) FROM Student s WHERE s.name LIKE :name", Long.class)
                .setParameter("name", "%" + name + "%")
                .getSingleResult();
    }

}
