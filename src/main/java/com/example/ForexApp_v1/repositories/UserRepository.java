package com.example.ForexApp_v1.repositories;

import com.example.ForexApp_v1.model.User;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository implements IRepository<User>{
    private final SessionFactory sessionFactory = ForexAppSessionFactory.getSessionFactory();
    public UserRepository(){}
    @Override
    public void createOrUpdate(User user) {
        Transaction t = null;
        try {
            Session session = sessionFactory.openSession();
            t = session.beginTransaction();
            session.merge(user);
            t.commit();
            session.close();
        }catch (Exception e){
            if (t != null) {
                t.rollback();
            }
            e.printStackTrace();
        }
    }
//    @Override
//    public void edit(User user) {
//        try {
//            Session s = sessionFactory.openSession();
//            Transaction t = s.beginTransaction();
//            s.merge(user);
//            t.commit();
//            s.close();
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }
    @Override
    public void delete(User user) {
        Transaction transaction = null;

        try {
            Session s = sessionFactory.openSession();
            Transaction t = s.beginTransaction();
            s.remove(user);
            t.commit();
            s.close();
        }catch (Exception e){
            e.printStackTrace();

        }
    }
    @Override
    public User findById(Long id) {
        Session session = sessionFactory.openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<User> userQuery = cb.createQuery(User.class);
        Root<User> root = userQuery.from(User.class);
        userQuery.select(root).where(cb.equal(root.get("id"), id));
        return session.createQuery(userQuery).getSingleResultOrNull();
    }
    public User findUserByEmail(String email) {
        Session session = sessionFactory.openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<User> userQuery = cb.createQuery(User.class);
        Root<User> root = userQuery.from(User.class);
        userQuery.select(root).where(cb.equal(root.get("email"), email));
        return session.createQuery(userQuery).getSingleResultOrNull();    }
    @Override
    public List<User> findAll() {
        Session session = sessionFactory.openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<User> userQuery = cb.createQuery(User.class);
        Root<User> root = userQuery.from(User.class);
        userQuery.select(root);
        return session.createQuery(userQuery).getResultList();
    }
}
