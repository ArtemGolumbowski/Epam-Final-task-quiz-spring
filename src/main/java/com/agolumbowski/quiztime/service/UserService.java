/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agolumbowski.quiztime.service;

import com.agolumbowski.quiztime.entity.User;
import com.agolumbowski.quiztime.repos.UserRepository;
//import com.agolumbowski.quiztime.serviceexp.UserService;
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

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

//    @Override
    public Page getAllUsers(int page) {
        return userRepository.findAll(PageRequest.of(page, 2, Sort.by("id")));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return (UserDetails) userRepository.findByUsername(username);
    }

//    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    public void addUser(User user) {

        userRepository.save(user);
    }

//    @Override
    public boolean checkUserIsExist(User user) {
        User userCheck = userRepository.findByUsername(user.getUsername());
        return userCheck != null;

    }

//    @Override
    public void delete(long userId) {
        userRepository.deleteById(userId);
    }

//    @Override
    public User read(long userId) {
        return userRepository.getById(userId);
    }

}
