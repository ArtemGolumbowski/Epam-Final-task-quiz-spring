/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agolumbowski.quiz_time.service;

import com.agolumbowski.quiz_time.entity.User;
import com.agolumbowski.quiz_time.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author agolu
 */
@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
   

    public Page getAllUsers(int page) {
        return userRepository.findAll(PageRequest.of(page, 2, Sort.by("id")));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return (UserDetails) userRepository.findByUsername(username);
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }
public void addUser(User user) {
        
        userRepository.save(user);
    }
    public boolean checkUserIsExist(User user) {
        User userCheck = userRepository.findByUsername(user.getUsername());
      return userCheck!=null;
    }
}
