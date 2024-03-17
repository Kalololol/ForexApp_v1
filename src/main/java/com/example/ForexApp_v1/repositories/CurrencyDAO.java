package com.example.ForexApp_v1.repositories;

import com.example.ForexApp_v1.model.Currency;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class CurrencyDAO implements IRepository<Currency> {
    private final SessionFactory sessionFactory = ForexAppSessionFactory.getSessionFactory();

    public CurrencyDAO() {
    }

    @Override
    public void createOrUpdate(Currency currency){
        Transaction transaction = null;
        try {
            Session session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.merge(currency);
            transaction.commit();
            session.close();
        }catch (Exception e){
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    //    @Override
//    public void edit(Currency currency) {
//        Transaction transaction = null;
//
//        try {
//            Session s = sessionFactory.openSession();
//            Transaction t = s.beginTransaction();
//            s.merge(currency);
//            t.commit();
//            s.close();
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }
    @Override
    public void delete(Currency currency){
        Transaction transaction = null;

        try {
            Session s = sessionFactory.openSession();
            Transaction t = s.beginTransaction();
            s.remove(currency);
            t.commit();
            s.close();
        }catch (Exception e){
            e.printStackTrace();

        }
    }
    @Override
    public List<Currency> findAll() {
        Session session = sessionFactory.openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Currency> currencyQuery = cb.createQuery(Currency.class);
        Root<Currency> root = currencyQuery.from(Currency.class);
        currencyQuery.select(root);
        return session.createQuery(currencyQuery).getResultList();
    }

    @Override
    public Currency findById(Long id) {
        Session session = sessionFactory.openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Currency> currencyQuery = cb.createQuery(Currency.class);
        Root<Currency> root = currencyQuery.from(Currency.class);
        currencyQuery.select(root).where(cb.equal(root.get("id"), id));
        return session.createQuery(currencyQuery).getSingleResultOrNull();
    }
}
