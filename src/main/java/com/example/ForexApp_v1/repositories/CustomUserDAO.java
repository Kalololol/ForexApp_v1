package com.example.ForexApp_v1.repositories;

import com.example.ForexApp_v1.model.CustomUser;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomUserDAO {
    private final SessionFactory sessionFactory = ForexAppSessionFactory.getSessionFactory();
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public CustomUserDAO(){}
    public void createUser(CustomUser customUser) {
        Transaction t = null;
        try {
            Session session = sessionFactory.openSession();
            t = session.beginTransaction();
            customUser.setPassword(passwordEncoder.encode(customUser.getPassword()));
            session.merge(customUser);
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
    public void delete(CustomUser customUser) {
        Transaction transaction = null;

        try {
            Session s = sessionFactory.openSession();
            Transaction t = s.beginTransaction();
            s.remove(customUser);
            t.commit();
            s.close();
        }catch (Exception e){
            e.printStackTrace();

        }
    }
    public CustomUser findById(Long id) {
        Session session = sessionFactory.openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<CustomUser> userQuery = cb.createQuery(CustomUser.class);
        Root<CustomUser> root = userQuery.from(CustomUser.class);
        userQuery.select(root).where(cb.equal(root.get("id"), id));
        return session.createQuery(userQuery).getSingleResultOrNull();
    }
    public CustomUser findUserByEmail(String email) {
        Session session = sessionFactory.openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<CustomUser> userQuery = cb.createQuery(CustomUser.class);
        Root<CustomUser> root = userQuery.from(CustomUser.class);
        userQuery.select(root).where(cb.equal(root.get("email"), email));
        return session.createQuery(userQuery).getSingleResultOrNull();    }
    public List<CustomUser> findAll() {
        Session session = sessionFactory.openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<CustomUser> userQuery = cb.createQuery(CustomUser.class);
        Root<CustomUser> root = userQuery.from(CustomUser.class);
        userQuery.select(root);
        return session.createQuery(userQuery).getResultList();
    }
}
