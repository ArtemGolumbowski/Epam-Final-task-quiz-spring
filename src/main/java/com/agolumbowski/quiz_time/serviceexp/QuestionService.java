/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agolumbowski.quiz_time.serviceexp;

import com.agolumbowski.quiz_time.entity.Question;
import java.util.List;

/**
 *
 * @author agolu
 */
public interface QuestionService extends Service {
    public List<Question> getAll(long testId);
    public Question save(Question question);
    
}
