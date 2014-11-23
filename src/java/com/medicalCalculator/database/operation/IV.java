/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medicalCalculator.database.operation;

public class IV {
    private String email;
    private double dose;
    private double mg;
    private double ml;
    private double result;

    public IV() {
        
    }

    public IV(String email, double dose, double mg, double ml, double result) {    
        this.email = email;
        this.dose = dose;
        this.mg =mg;
        this.ml = ml;
        this.result = result;
    }
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getDose() {
        return dose;
    }

    public void setDose(double dose) {
        this.dose = dose;
    }

    public double getMg() {
        return mg;
    }

    public void setMg(double mg) {
        this.mg = mg;
    }

    public double getMl() {
        return ml;
    }

    public void setMl(double ml) {
        this.ml = ml;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }




    
    
    
}
