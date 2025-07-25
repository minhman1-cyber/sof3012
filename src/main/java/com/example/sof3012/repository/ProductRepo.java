package com.example.sof3012.repository;

import com.example.sof3012.entity.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class ProductRepo {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
    private EntityManager em = emf.createEntityManager();

    public List<Product> findAll() {
        return em.createQuery("select p from Product p", Product.class).getResultList();
    }



    public Product findById(Long id) {
        return em.find(Product.class, id);
    }

    public void them(Product product) {
        try{
            em.getTransaction().begin();
            em.persist(product);
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public void sua(Product product) {
        try{
            em.getTransaction().begin();
            em.merge(product);
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public void xoa(Long id) {
        try{
            em.getTransaction().begin();
            em.remove(findById(id));
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public Long countProductByKeyword(String keyword) {
        return em.createQuery("select count(p) from Product p where p.name like :keyword", Long.class)
                .setParameter("keyword", "%" + keyword + "%")
                .getSingleResult();
    }

    public Long countProduct(){
        return em.createQuery("select count(p) from Product p", Long.class).getSingleResult();
    }

    public List<Product> getProductByKeywordAndPage(String keyword, int page, int size) {
        return em.createQuery("select s from Product s where s.name like :keyword", Product.class)
                .setParameter("keyword", "%" + keyword + "%")
                .setFirstResult((page - 1) * size)
                .setMaxResults(size)
                .getResultList();
    }

    public List<Product> getProductByPage(int page, int size) {
        return em.createQuery("select s from Product s", Product.class)
                .setFirstResult((page - 1) * size)
                .setMaxResults(size)
                .getResultList();
    }
}
