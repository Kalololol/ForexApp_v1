package com.example.ForexApp_v1.repositories;

import com.example.ForexApp_v1.model.Transac;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class TransacDAO implements IRepository<Transac>{
    private final SessionFactory sessionFactory = ForexAppSessionFactory.getSessionFactory();

    public TransacDAO() {
    }

    @Override
    public void createOrUpdate(Transac transac) {
        Transaction transaction = null;
        try {
            Session session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.merge(transac);
            transaction.commit();
            session.close();
        }catch (Exception e){
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    @Override
    public void delete(Transac transac) {
        Transaction transaction = null;

        try {
            Session s = sessionFactory.openSession();
            Transaction t = s.beginTransaction();
            s.remove(transac);
            t.commit();
            s.close();
        }catch (Exception e){
            e.printStackTrace();

        }
    }
    @Override
    public Transac findById(Long id) {
        Session session = sessionFactory.openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Transac> transacQuery = cb.createQuery(Transac.class);
        Root<Transac> root = transacQuery.from(Transac.class);
        transacQuery.select(root).where(cb.equal(root.get("id"), id));
        return session.createQuery(transacQuery).getSingleResultOrNull();
    }
    @Override
    public List<Transac> findAll() {
        Session session = sessionFactory.openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Transac> transacQuery = cb.createQuery(Transac.class);
        Root<Transac> root = transacQuery.from(Transac.class);
        transacQuery.select(root);
        return session.createQuery(transacQuery).getResultList();
    }
}
