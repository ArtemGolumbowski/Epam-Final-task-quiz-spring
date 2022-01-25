/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agolumbowski.quiztime.serviceexp;

import com.agolumbowski.quiztime.entity.Question;
import java.util.List;

/**
 *
 * @author agolu
 */
public interface QuestionService extends Service<Question> {
    public List<Question> getAll(long testId);
    
}
