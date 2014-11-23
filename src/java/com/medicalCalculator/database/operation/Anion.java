/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medicalCalculator.database.operation;

public class Anion {
    private String email;
    private double na;
    private double cl;
    private double bicarb;
    private double result;

    public Anion() {
        
    }

    public Anion(String email, double na, double cl, double bicarb, double result) {    
        this.email = email;
        this.na = na;
        this.cl = cl;
        this.bicarb = bicarb;
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

    public double getNa() {
        return na;
    }

    public void setNa(double na) {
        this.na = na;
    }

    public double getCl() {
        return cl;
    }

    public void setCl(double cl) {
        this.cl = cl;
    }

    public double getBicarb() {
        return bicarb;
    }

    public void setMl(double bicarb) {
        this.bicarb = bicarb;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }
   
}
