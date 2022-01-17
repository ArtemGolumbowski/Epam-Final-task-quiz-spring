/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agolumbowski.quiztime.entity;

import java.io.Serializable;
import org.springframework.security.core.GrantedAuthority;

/**
 *
 * @author agolu
 */



public enum Role implements Serializable, GrantedAuthority{
 
    USER, 
 
    ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }
   
}
