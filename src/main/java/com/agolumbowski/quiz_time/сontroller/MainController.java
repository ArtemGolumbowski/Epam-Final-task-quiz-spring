/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agolumbowski.quiz_time.сontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author agolu
 */
@Controller
public class MainController {
    
    
   @RequestMapping("/")
    public String home(){
        
        return "redirect:/tests";
    }
    
   
    
}
