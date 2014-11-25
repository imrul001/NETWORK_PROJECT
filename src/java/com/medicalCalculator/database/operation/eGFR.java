/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medicalCalculator.database.operation;

public class eGFR {
    private int id;
    private String email;
    private double sCr;
    private double age;
    private int sex;
    private boolean black;
    private double result;

    public eGFR() {
        
    }

    public eGFR(String email, double sCr, double age, int sex, boolean black, double result) {
              
        this.email = email;
        this.sCr = sCr;
        this.age =age;
        this.sex = sex;
        this.black = black;
        this.result = result;
        
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the age
     */
    public double getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(double age) {
        this.age = age;
    }

    /**
     * @return the sCr
     */
    public double getsCr() {
        return sCr;
    }

    /**
     * @param sCr the sCr to set
     */
    public void setsCr(double sCr) {
        this.sCr = sCr;
    }

    /**
     * @return the sex
     */
    public int getSex() {
        return sex;
    }

    /**
     * @param sex the sex to set
     */
    public void setSex(int sex) {
        this.sex = sex;
    }

    /**
     * @return the black
     */
    public boolean isBlack() {
        return black;
    }

    /**
     * @param black the black to set
     */
    public void setBlack(boolean black) {
        this.black = black;
    }

    /**
     * @return the result
     */
    public double getResult() {
        return result;
    }

    /**
     * @param result the result to set
     */
    public void setResult(double result) {
        this.result = result;
    }

    
    
    
}
