/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agolumbowski.quiz_time.serviceexp;

import com.agolumbowski.quiz_time.entity.Test;
import org.springframework.data.domain.Page;

/**
 *
 * @author agolu
 */
public interface TestService extends Service{
    public Page getTestsBySubject(int page, String sort, String subject);
    public Test save(Test test);
}