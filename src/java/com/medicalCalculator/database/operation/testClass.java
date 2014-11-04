/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medicalCalculator.database.operation;

/**
 *
 * @author imrul
 */
public class testClass {
    public static void main(String[] args){
        ManageUser user = new ManageUser();
        System.out.println("user id"+user.addUsers("anuva", "bhowmic", "anuva@gmail.com", "anuva123")+" is inserted");
    }
    
}
