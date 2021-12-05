/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agolumbowski.quiz_time.сontroller;

import com.agolumbowski.quiz_time.entity.Role;
import com.agolumbowski.quiz_time.entity.User;
import com.agolumbowski.quiz_time.repos.UserRepository;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author agolu
 */
@Controller
public class RegistrationController {
    @Autowired
    private UserRepository userRepository;
    @GetMapping("/registration")
    public String getRegistrationPage(){
        return "registration";
    }
    @PostMapping("/registration")
    public String addUser(User user, Model model){
        User userCheck = userRepository.findByUsername(user.getUsername());
        if(userCheck!=null){
            model.addAttribute("message", "this user is exist");
            return "registration";
        }
        Set<Role>roles=Set.of(Role.ADMIN);
       
        user.setEnabled(true);
        user.setRoles(roles);
        userRepository.save(user);
        return "redirect:/login";
    }
}
