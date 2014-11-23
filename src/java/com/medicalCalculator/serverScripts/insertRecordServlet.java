/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medicalCalculator.serverScripts;

import com.google.gson.Gson;
import com.medicalCalculation.calculations.calculation;
import com.medicalCalculation.calculations.resultObject;
import com.medicalCalculator.database.operation.ManageeGFR;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
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
        resultObject object = new resultObject();
        Map map = new HashMap();
        
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
            try {
                if (session.getAttribute("email") != null) {

    //                object.setOutput(result +" ");
    //                map.put("title",object.getTitle());
    //                map.put("input", object.getInput());
    //                map.put("output", object.getOutput());
    //                map.put("unit", object.getUnit());
                    ManageeGFR manageeGFR = new ManageeGFR();
                    Integer userid = manageeGFR.addeGFR(email, sCr, age, sex,bBlack,result);
                    if(userid != null){
                        out.println("200".toString());
                    }else{
                        out.println("500".toString());
                    }
                } else {
                    out.println("sessionFailed");
                }
            } finally {
                out.close();
            }
         
        }
    }
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
    
    private void write(HttpServletResponse response, Map<String, Object> map) throws IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(new Gson().toJson(map)); //this is how simple GSON works
    }
}
