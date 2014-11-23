/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medicalCalculator.database.operation;

public class BSA {
    private String email;
    private double wt;
    private double ht;
    private double result;

    public BSA() {
        
    }

    public BSA(String email, double wt, double ht, double result) {    
        this.email = email;
        this.wt = wt;
        this.ht =ht;
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

    public double getWt() {
        return wt;
    }

    public void setWt(double wt) {
        this.wt = wt;
    }

    public double getHt() {
        return ht;
    }

    public void setHt(double ht) {
        this.ht = ht;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }   
}
