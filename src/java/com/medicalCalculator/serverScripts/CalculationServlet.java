/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medicalCalculator.serverScripts;

import com.google.gson.Gson;
import com.medicalCalculation.calculations.calculation;
import com.medicalCalculation.calculations.resultObject;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author imrul
 */
public class CalculationServlet extends HttpServlet {

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
//        double wt = 0.0;
//        double ht = 0.0;
        double result = 0.0;

//        String unit = "";
        resultObject object = new resultObject();
        Map map = new HashMap();
        
        //@Game
        // This is the example...you should look at
        
//        if (method.equalsIgnoreCase("BMI")) {
//            weight = Double.valueOf(request.getParameter("wt"));
//            height = Double.valueOf(request.getParameter("ht"));
//            object.setTitle("Body Mass Index: BMI");
//            object.setInput("Weight =" + weight + " kg, Height=" + height);
//            object.setUnit("Unit");
//        } 
        //@Game
        // You should write your here....(for all four/five calculations)
        
        if (method.equalsIgnoreCase("BMI")) {
            double wt = Double.valueOf(request.getParameter("wt"));
            double ht = Double.valueOf(request.getParameter("ht"));
            object.setTitle("Body Mass Index: BMI");
            object.setInput("Weight =" + wt + "<br>" + " kg, Height=" + ht + " cm");
            object.setUnit("");
            result = calculation.calBMI(wt, ht);
        } 

        if (method.equalsIgnoreCase("BSA")) {
            double wt = Double.valueOf(request.getParameter("wt"));
            double ht = Double.valueOf(request.getParameter("ht"));
            object.setTitle("Body Serface Area: BSA");
            object.setInput("Weight =" + wt + "<br>" + " kg, Height=" + ht + " cm");
            object.setUnit("m<sup>2</sup>");
            result = calculation.calBSA(wt, ht);
        }
        
        if (method.equalsIgnoreCase("anion")) {
            double Na;
            double Cl;
            double bicarb;
            Na = Double.valueOf(request.getParameter("Sodium"));
            Cl = Double.valueOf(request.getParameter("Chloride"));
            bicarb = Double.valueOf(request.getParameter("Bicarb"));
            object.setTitle("Anion-Gap");
            object.setInput("Na = " + Na + " mEq/L" +"<br>"
                            + "Cl = " + Cl + " mEq/L" +"<br>"
                            + "Bicarb = " + bicarb + " mEq/L");
            object.setUnit("mEq/L");
            result = calculation.calAnionGap(Na,Cl,bicarb);
        }
        
        if (method.equalsIgnoreCase("IV")) {
            double dose;
            double mg;
            double mL;
            dose = Double.valueOf(request.getParameter("Dose"));
            mg = Double.valueOf(request.getParameter("mg"));
            mL = Double.valueOf(request.getParameter("mL"));
            object.setTitle("Intravenous Infusion Rate");
            object.setInput("Dose = " + dose + " mg/hr" +"<br>"
                            + "Drug in solution = " + mg + " mg" +"<br>"
                            + "Total Volume = " + mL + " mL");
            object.setUnit("mL/hr");
            result = calculation.calIV(dose,mg,mL);
        }
        
        if (method.equalsIgnoreCase("eGFR")) {
            double sCr;
            double age;
            int sex;
            String black="";
            boolean bBlack=false;
            String sSex = "";
            String sBlack ="";
           
                
            sCr = Double.valueOf(request.getParameter("sCr"));
            age = Double.valueOf(request.getParameter("age"));
            sex = Integer.valueOf(request.getParameter("sex"));
            black = String.valueOf(request.getParameter("black"));
            
            if("YES".equals(black)){
                bBlack=true;
                sBlack="African-American";
            } else{
                bBlack=false;
            }
            
            if(sex==1){
                sSex="male";
            }else{
                sSex ="female";
            }

            object.setTitle("estimated Glomerular Filtration Rate: eGFR");
            object.setInput("serum creatinine = " + sCr + " mg/dL" +"<br>"
                            + "age = " + age + " years" +"<br>"
                            + "sex = " + sSex +"<br>"
                            + sBlack);
            object.setUnit("mL/min/1.73<sup>2</sup>");
            result = calculation.calGFR(sCr,age,sex,bBlack);
        }
        
        try {
            if (session.getAttribute("email") != null) {
                
                object.setOutput(result +" "+object.getUnit());
                map.put("title",object.getTitle());
                map.put("input", object.getInput());
                map.put("output", object.getOutput());
                write(response, map);

            } else {
                out.println("sessionFailed");
            }
        } finally {
            out.close();
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

    private void write(HttpServletResponse response, Map<String, Object> map) throws IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(new Gson().toJson(map)); //this is how simple GSON works
    }
}
