/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agolumbowski.quiztime.repos;

import com.agolumbowski.quiztime.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author agolu
 */
public interface AnswerRepository extends JpaRepository<Answer, Long> {
    
}
