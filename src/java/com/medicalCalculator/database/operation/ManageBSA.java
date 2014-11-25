/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medicalCalculator.database.operation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.hibernate.*;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class ManageBSA {

    private SessionFactory factory;
    private StandardServiceRegistry serviceRegistry;

    public static void main(String[] args) {
        System.out.println("testing database");
        ManageBSA manageUser = new ManageBSA();
        System.out.println(manageUser.addBSA("armadillozz@hotmail.com",2,1,30));
    }

    public ManageBSA() {
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

    public Integer addBSA(String email, double wt, double ht, double result) {
        Session session = factory.openSession();
        Transaction tx = null;
        Integer bsaId = null;
        try {
            tx = session.beginTransaction();
            BSA bsa = new BSA(email,wt,ht,result);
            bsaId = (Integer) session.save(bsa);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        return bsaId;
    }
    public List<String> listResult(String email){
      Session session = factory.openSession();
      Transaction tx = null;
      List<String> resultList = new ArrayList();
      try{
         tx = session.beginTransaction();
//         List employees = session.createQuery("FROM eGFR e WHERE e.email=").list(); 
         String hql = "FROM BSA e WHERE e.email='"+email+"'";
         Query query = session.createQuery(hql);
         List results = query.list();

            for (Iterator iterator = results.iterator(); iterator.hasNext();){
               BSA bsa = (BSA) iterator.next();            

               resultList.add("<td>" + bsa.getId() + "</td>"
                               +"<td>" + bsa.getWt()+ "</td>"
                               +"<td>" + bsa.getHt()+ "</td>"
                               +"<td>" + bsa.getResult() + "</td>");
            }
            tx.commit();
         }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace(); 
         }finally {
            session.close(); 
         }
//      return resultList;
      return resultList;
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
