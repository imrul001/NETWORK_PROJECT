/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medicalCalculator.database.operation;

import java.sql.ResultSet;
import java.util.List;
import org.hibernate.*;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author imrul
 */
public class ManageUser {

    private SessionFactory factory;
    private StandardServiceRegistry serviceRegistry;

    public static void main(String[] args) {
        System.out.println("testing database");
        ManageUser manageUser = new ManageUser();
        System.out.println(manageUser.addUsers("tareq", "jahid", "tareq@gmail.com", "123456"));
    }

    public ManageUser() {
        try {
            Configuration configuration = new Configuration();
            configuration.configure("/resources/hibernate.cfg.xml");
            serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            factory = configuration.buildSessionFactory(serviceRegistry);
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public Integer addUsers(String firstName, String lastName, String email, String password) {
        Session session = factory.openSession();
        Transaction tx = null;
        Integer userId = null;
        try {
            tx = session.beginTransaction();
            Users user = new Users(firstName, lastName, email, password);
            userId = (Integer) session.save(user);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        return userId;
    }

    public boolean isloginUser(String email, String password) {
        Session session = factory.openSession();
        Transaction t = null;
        boolean flag = false;
        try {
            t = session.beginTransaction();
            String hql = "FROM Users u WHERE u.email='"+email+"'";
            Query query = session.createQuery(hql);
            List results = query.list();
            if (results.size() == 1) {
                flag = true;
            } else {
                flag = false;
            }
        } catch (HibernateException e) {
            if (t != null) {
                t.rollback();
            }
            e.printStackTrace();
        }
        return flag;
    }
}
