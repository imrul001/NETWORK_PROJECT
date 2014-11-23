/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medicalCalculator.database.operation;

import org.hibernate.*;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class ManageIV {

    private SessionFactory factory;
    private StandardServiceRegistry serviceRegistry;

    public static void main(String[] args) {
        System.out.println("testing database");
        ManageIV manageUser = new ManageIV();
        System.out.println(manageUser.addIV("armadillozz@hotmail.com",2,30,1,30));
    }

    public ManageIV() {
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

    public Integer addIV(String email, double dose, double mg, double ml, double result) {
        Session session = factory.openSession();
        Transaction tx = null;
        Integer IVid = null;
        try {
            tx = session.beginTransaction();
            IV iv = new IV(email,dose,mg,ml,result);
            IVid = (Integer) session.save(iv);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        return IVid;
    }

//    public boolean isloginUser(String email, String password) {
//        Session session = factory.openSession();
//        Transaction t = null;
//        boolean flag = false;
//        try {
//            t = session.beginTransaction();
//            String hql = "FROM Users u WHERE u.email='"+email+"'";
//            Query query = session.createQuery(hql);
//            List results = query.list();
//            if (results.size() == 1) {
//                flag = true;
//            } else {
//                flag = false;
//            }
//        } catch (HibernateException e) {
//            if (t != null) {
//                t.rollback();
//            }
//            e.printStackTrace();
//        }
//        return flag;
//    }
}