
package com.xiker.conceptOauth.controllers;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Xiker
 */
@Controller
public class miController {
    
    @GetMapping("/")
    public String inicio(@AuthenticationPrincipal OAuth2User principal){
        if(principal!=null){
            String nombre= principal.getAttribute("login");
            System.out.println(nombre);
            System.out.println(principal);
        }
        
        return "index.html";
    }
    
    
    @GetMapping("/internal")
    public String internal(){
        return "internal";
    }
    
    @GetMapping("/external")
    public String external(){
        return "external";
    }
    
    
    
    @GetMapping("/error")
    public String error(){
        return "error.html";
    }
}
