/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agolumbowski.quiztime.сontroller;

import com.agolumbowski.quiztime.entity.User;
import com.agolumbowski.quiztime.service.UserService;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author agolu
 */
@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String getTestsPage(Model model, @RequestParam(defaultValue = "0") int page) {
        Page userPage = userService.getAllUsers(page);
        model.addAttribute("users", userPage);

        return "users";
    }

    @PostMapping("/deleteuser")
    public String deleteUser(long userId) {
        userService.delete(userId);
        return "redirect:/users";
    }

    @GetMapping("/edituser")
    public String editUser(long userId, Model model) {
        User user = userService.read(userId);
        model.addAttribute("user", user);
        return "edituser";
    }

    @PostMapping("/edituser")
    public String editUser(User user) {
        userService.save(user);
        return "redirect:/users";
    }

}
