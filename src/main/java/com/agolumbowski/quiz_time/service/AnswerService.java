/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agolumbowski.quiz_time.service;

import com.agolumbowski.quiz_time.entity.Answer;
import com.agolumbowski.quiz_time.entity.Question;
import com.agolumbowski.quiz_time.repos.AnswerRepository;
import com.agolumbowski.quiz_time.repos.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author agolu
 */
@Service
public class AnswerService {
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private AnswerRepository answerRepository;
     public void createAnswer(Answer answer, long questionId){
       Question question = questionRepository.getById(questionId);
       answer.setQuestion(question);
       answerRepository.save(answer);
    }
    public void editAnswer(Answer answer){     
       answerRepository.save(answer);
    }
    public Answer getAnswerById(long answerId){
        return answerRepository.getById(answerId);
    }
}
