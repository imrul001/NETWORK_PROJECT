/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medicalCalculator.database.operation;

import org.hibernate.*;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author imrul
 */
public class ManageeGFR {

    private SessionFactory factory;
    private StandardServiceRegistry serviceRegistry;

    public static void main(String[] args) {
        System.out.println("testing database");
        ManageeGFR manageUser = new ManageeGFR();
        System.out.println(manageUser.addeGFR("armadillozz@hotmail.com",1,1,1,false,1));
    }
    
    
    public ManageeGFR() {
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

    public Integer addeGFR(String email, double sCr, double age, int sex, boolean black, double result) {
        Session session = factory.openSession();
        Transaction tx = null;
        Integer eGFRId = null;
        try {
            tx = session.beginTransaction();
            eGFR eGFR = new eGFR(email,sCr,age,sex,black,result);
            eGFRId = (Integer) session.save(eGFR);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        return eGFRId;
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
