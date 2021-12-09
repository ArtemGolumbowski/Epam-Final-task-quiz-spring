/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agolumbowski.quiz_time.service;

import com.agolumbowski.quiz_time.entity.Question;
import com.agolumbowski.quiz_time.entity.Test;
import com.agolumbowski.quiz_time.repos.QuestionRepository;
import com.agolumbowski.quiz_time.repos.TestRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author agolu
 */
@Service
public class QuestionService {
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private TestRepository testRepository;
    public List<Question> getQuestionsByTestId(long testId){
       return questionRepository.findAllByTestId(testId);
    }
    public List<Question> getQuestionsInOrder(long testId){
       return questionRepository.findAllByTestIdOrderById(testId);
    }
    public void createQuestion(Question question, long testId){
       Test test = testRepository.getById(testId);
       question.setTest(test);
       questionRepository.save(question);
    }
    public void editQuestion(Question question){     
       questionRepository.save(question);
    }
    public Question getQuestionById(long questionId){
        return questionRepository.getById(questionId);
    }
    
}
