/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medicalCalculation.calculations;

/**
 *
 * @author imrul
 * 
 * This class contains methods the calculate the given equations...
 * @Game you should write here
 */
public class calculation {
    public static double getBMI(double weight, double height){
        double bmi = weight/((height/100)*(height/100));
        return bmi;
    }
    
}
