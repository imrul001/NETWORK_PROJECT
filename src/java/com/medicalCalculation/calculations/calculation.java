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
    
    public calculation(){
        
    }
        
    public static double getBMI(double weight, double height){
        double bmi = weight/((height/100)*(height/100));
        return bmi;
    }
    
    public static double calBMI(double wt, double ht){
        //no unit
        return  Math.round(wt/(Math.pow(ht/100, 2))*10)/10.0 ;
    }
    
    public static double calBSA(double wt, double ht){
        //BSA = (weight)0.425 x (height)0.725 x 0.007184
 
        double cWt = Math.pow(wt, 0.425);
        double cHt = Math.pow(ht,0.725);
        return  Math.round((cWt*cHt*0.007184)*100)/100.0;

    }
    
    public static double calAnionGap(double Na,double Cl, double bicarb) {
        //Anion gap = sodium - (chloride + bicarbonate)
        return  Na-(Cl+bicarb);
    }
    
    public static double calIV(double dose,double mg,double mL) {
        
        return  Math.round(dose*mL/mg)*10/10.0;
        
    }
    
    public static double calGFR(double sCr, double age, int sex,boolean black) {
//        GFR = 141 X min(Scr/κ,1)α X max(Scr/κ,1)-1.209 X 0.993Age X 1.018 [if female] X 1.159 [if black]
//Where Scr is serum creatinine (mg/dL)
//κ is 0.7 for females and 0.9 for males
//α is –0.329 for females and –0.411 for males
//min indicates the minimum of Scr/κ or 1
//max indicates the maximum of Scr/κ or 1

        
        double GFR;
        double k,alpha,female,cBlack;
        if(sex==1){
            k=0.9;
            alpha= -0.411;
            female = 1;
        }else{
            k=0.7;
            alpha = -0.329;
            female = 1.018;
        }
        
        if(black){
            cBlack=1.159;
        }else{
            cBlack=1;
        }
        GFR = 141 * Math.pow(Math.min((sCr/k), 1),alpha) * Math.pow(Math.max(sCr/k, 1),-1.209) * Math.pow(0.993, age) *female*cBlack;
        
        return Math.round(GFR*10)/10.0;
    }
    
}
