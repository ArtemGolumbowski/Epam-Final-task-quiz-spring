/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agolumbowski.quiz_time.serviceexp;

import com.agolumbowski.quiz_time.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 *
 * @author agolu
 */
public interface UserService extends UserDetailsService {
    public Page getAllUsers(int page);
    public User save(User user);
    public User read(long id);
    public void delete(long id);
    public boolean checkUserIsExist(User user);
}
