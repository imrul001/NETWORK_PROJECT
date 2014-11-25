/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medicalCalculator.database.operation;

import com.google.gson.Gson;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
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
//        System.out.println(manageUser.addeGFR("armadillozz@hotmail.com",1,1,1,false,1));
        System.out.println(manageUser.listResult("armadillozz@hotmail.com").get(5));
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
/* Method to  READ all the employees */
   public List<String> listResult(String email){
      Session session = factory.openSession();
      Transaction tx = null;
      Map map = new HashMap();
      List<String> resultList = new ArrayList();
      try{
         tx = session.beginTransaction();
//         List employees = session.createQuery("FROM eGFR e WHERE e.email=").list(); 
         String hql = "FROM eGFR e WHERE e.email='"+email+"'";
         Query query = session.createQuery(hql);
         List results = query.list();

            for (Iterator iterator = results.iterator(); iterator.hasNext();){
               eGFR gfr = (eGFR) iterator.next();            
               String black="No";
               String sex ="Male";
               if(gfr.isBlack()){
                   black="Yes";
               }
               if(gfr.getSex()==2){
                   sex="Female";
               }
               resultList.add("<td>" + gfr.getId() + "</td>"
                               +"<td>" + gfr.getsCr() + "</td>"
                               +"<td>" + gfr.getAge() + "</td>"
                               +"<td>" + sex + "</td>"
                               +"<td>" + black + "</td>"
                               +"<td>" + gfr.getResult() + "</td>");
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
