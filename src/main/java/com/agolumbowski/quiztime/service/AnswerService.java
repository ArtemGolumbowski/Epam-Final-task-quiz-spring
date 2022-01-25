/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agolumbowski.quiztime.service;

import com.agolumbowski.quiztime.entity.Answer;
import com.agolumbowski.quiztime.entity.Question;
import com.agolumbowski.quiztime.repos.AnswerRepository;
import com.agolumbowski.quiztime.repos.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author agolu
 */
@Service
public class AnswerService {

    public AnswerService(QuestionRepository questionRepository, AnswerRepository answerRepository) {
        this.questionRepository = questionRepository;
        this.answerRepository = answerRepository;
    }

    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;

    public void createAnswer(Answer answer, long questionId) {
        Question question = questionRepository.getById(questionId);
        answer.setQuestion(question);
        answerRepository.save(answer);
    }

    public void editAnswer(Answer answer) {
        answerRepository.save(answer);
    }

    public Answer getAnswerById(long answerId) {
        return answerRepository.getById(answerId);
    }
}
