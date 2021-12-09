/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agolumbowski.quiz_time.сontroller;

import com.agolumbowski.quiz_time.entity.Role;
import com.agolumbowski.quiz_time.entity.User;
import com.agolumbowski.quiz_time.service.UserService;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
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
    private UserService userService;
    @Autowired
    PasswordEncoder passwordEncoder;

    @GetMapping("/registration")
    public String getRegistrationPage() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, String role, Model model) {
        if (userService.checkUserIsExist(user)) {
            model.addAttribute("message", "this user is exist");
            return "registration";
        }
        Role userRole = Role.valueOf(role.toUpperCase());
        Set<Role> roles = Set.of(userRole);
        user.setRoles(roles);
        String hashPass = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashPass);
        user.setEnabled(true);
        userService.addUser(user);

        return "redirect:/login";
    }
}
