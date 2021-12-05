/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agolumbowski.quiz_time.repos;

import com.agolumbowski.quiz_time.entity.Question;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author agolu
 */
public interface QuestionRepository extends JpaRepository<Question, Long> {
    public List<Question> findAllByTestId(long testId);
   
}
