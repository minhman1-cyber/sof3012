package com.example.sof3012;

import com.example.sof3012.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
        System.out.println("DOne::");

        em.createQuery("select s from Student s", Student.class).getResultList().forEach(System.out::println);
    }
}
