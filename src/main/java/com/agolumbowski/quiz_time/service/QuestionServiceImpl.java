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
import com.agolumbowski.quiz_time.serviceexp.QuestionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author agolu
 */
@Service
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;

    public QuestionServiceImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public List<Question> getAll(long testId) {
        return questionRepository.findAllByTestIdOrderById(testId);
    }

    @Override
    public Question save(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public Question read(long questionId) {
        return questionRepository.getById(questionId);
    }

    @Override
    public void delete(long id) {
        questionRepository.deleteById(id);
    }

}
