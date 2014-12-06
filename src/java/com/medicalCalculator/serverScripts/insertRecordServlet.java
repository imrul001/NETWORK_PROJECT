/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medicalCalculator.serverScripts;

import com.google.gson.Gson;
import com.medicalCalculation.calculations.calculation;
import com.medicalCalculation.calculations.resultObject;
import com.medicalCalculator.database.operation.ManageAnion;
import com.medicalCalculator.database.operation.ManageBMI;
import com.medicalCalculator.database.operation.ManageBSA;
import com.medicalCalculator.database.operation.ManageIV;
import com.medicalCalculator.database.operation.ManageeGFR;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author imrul
 */
@WebServlet(name = "insertRecordServlet", urlPatterns = {"/insertRecordServlet"})
public class insertRecordServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        HttpSession session = request.getSession(false);
        String method = request.getParameter("method").trim();
        String email = request.getParameter("email");
        Integer userid= null;
        if (session.getAttribute("email") != null) {
            try {
                if (method.equalsIgnoreCase("eGFR")) {
                    double sCr = Double.valueOf(request.getParameter("sCr"));
                    double age = Double.valueOf(request.getParameter("age"));
                    int sex = Integer.valueOf(request.getParameter("sex"));
                    String black = String.valueOf(request.getParameter("black"));
                    double result = Double.valueOf(request.getParameter("result"));
                    boolean bBlack;
                    if("NO".equals(black)){
                        bBlack=true;
                    } else{
                        bBlack=false;
                    }
                    ManageeGFR manageeGFR = new ManageeGFR();
                    userid = manageeGFR.addeGFR(email, sCr, age, sex,bBlack,result);
                    write(response,manageeGFR.listResult(email),userid);                 
                }
            
                if (method.equalsIgnoreCase("IV")) {
                    double dose = Double.valueOf(request.getParameter("dose"));
                    double mg = Double.valueOf(request.getParameter("mg"));
                    double mL = Double.valueOf(request.getParameter("ml"));
                    double result = Double.valueOf(request.getParameter("result"));
                    ManageIV manageIv = new ManageIV();
                    userid = manageIv.addIV(email, dose, mg,mL,result);
                     write(response,manageIv.listResult(email),userid);      
                }

                if (method.equalsIgnoreCase("anion")) {
                    double na = Double.valueOf(request.getParameter("Sodium"));
                    double cl = Double.valueOf(request.getParameter("Chloride"));
                    double bicarb = Double.valueOf(request.getParameter("Bicarb"));
                    double result = Double.valueOf(request.getParameter("result"));
                    ManageAnion manageAnion = new ManageAnion();
                    userid = manageAnion.addAnion(email, na, cl, bicarb,result);
                     write(response,manageAnion.listResult(email),userid);      
                }

                if (method.equalsIgnoreCase("BMI")) {
                    double wt = Double.valueOf(request.getParameter("wt"));
                    double ht = Double.valueOf(request.getParameter("ht"));
                    double result = Double.valueOf(request.getParameter("result"));
                    ManageBMI manageBMI = new ManageBMI();
                    userid = manageBMI.addBMI(email, wt, ht,result);
                     write(response,manageBMI.listResult(email),userid);      
                }

                if (method.equalsIgnoreCase("BSA")) {
                    double wt = Double.valueOf(request.getParameter("wt"));
                    double ht = Double.valueOf(request.getParameter("ht"));
                    double result = Double.valueOf(request.getParameter("result"));
                    ManageBSA manageBSA = new ManageBSA();
                    userid = manageBSA.addBSA(email, wt, ht,result);
                     write(response,manageBSA.listResult(email),userid);      
                }
            } finally {
                out.close();
            }
        }      
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
    private void write(HttpServletResponse response, List results,Integer userId) throws IOException {
//        if(userId !=null){
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(new Gson().toJson(results)); //this is how simple GSON works
//        }else{
//            response.setContentType("text/html;charset=UTF-8");
//            response.getWriter().println("500".toString());
//        }
  
    }
}
