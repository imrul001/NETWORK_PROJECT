/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medicalCalculation.validation;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author imrul
 */
public class cookieUtilClass {
 
    public static myCookies getMyCookies(HttpServletRequest request){
        myCookies mycookies = new myCookies();
        Cookie[] cookies = request.getCookies();
        for(Cookie c : cookies){
            if(c.getName().equalsIgnoreCase("cookie_email")){
                mycookies.setCookie_name(c.getName());
                mycookies.setCookie_value(c.getValue());
            }
        }
        return mycookies;
    }
}
