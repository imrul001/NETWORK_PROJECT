/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medicalCalculator.serverScripts;

import com.google.gson.Gson;
import com.medicalCalculation.calculations.calculation;
import com.medicalCalculation.calculations.resultObject;
import com.medicalCalculation.validation.cookieUtilClass;
import com.medicalCalculation.validation.myCookies;
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
@WebServlet(name = "fetchServlet", urlPatterns = {"/fetchServlet"})
public class fetchServlet extends HttpServlet {

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
        myCookies cookie = cookieUtilClass.getMyCookies(request);
        String sessionEmail = (String) session.getAttribute("email");

        if (session.getAttribute("email") != null && sessionEmail.equalsIgnoreCase(cookie.getCookie_value())) {
            try {
                if (method.equalsIgnoreCase("eGFR")) {
                    ManageeGFR fetchData = new ManageeGFR();
                   write(response,fetchData.listResult(email));
                }
                if (method.equalsIgnoreCase("IV")) {
                    ManageIV fetchData = new ManageIV();
                   write(response,fetchData.listResult(email));
                }
                if (method.equalsIgnoreCase("anion")) {
                    ManageAnion fetchData = new ManageAnion();
                  write(response,fetchData.listResult(email));
                }
                if (method.equalsIgnoreCase("BSA")) {
                    ManageBSA fetchData = new ManageBSA();
                    write(response,fetchData.listResult(email));
                }
                if (method.equalsIgnoreCase("BMI")) {
                    ManageBMI fetchData = new ManageBMI();  
                    write(response,fetchData.listResult(email));
                }
   
            } finally {
                out.close();
            }
        }else{
           
            out.println("500");
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
    
    private void write(HttpServletResponse response, List results) throws IOException {
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
