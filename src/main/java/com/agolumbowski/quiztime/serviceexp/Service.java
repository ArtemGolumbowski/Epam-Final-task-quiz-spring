/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agolumbowski.quiztime.serviceexp;


public interface Service {
//    public <T> T save(T t);
    public <T> T read(long id);
    public void delete(long id);
}
