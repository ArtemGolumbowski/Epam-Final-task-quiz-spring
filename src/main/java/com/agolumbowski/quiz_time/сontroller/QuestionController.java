/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agolumbowski.quiz_time.сontroller;

import com.agolumbowski.quiz_time.entity.Question;
import com.agolumbowski.quiz_time.repos.TestRepository;
import com.agolumbowski.quiz_time.service.QuestionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

/**
 *
 * @author agolu
 */
@Controller
public class QuestionController {
    @Autowired
    private QuestionService questionService;

   @GetMapping("/questions/{testId}")
    public String getQuestionsPage(Model model, @PathVariable Long testId) {
        List<Question> questions;
        questions = questionService.getQuestionsByTestId(testId);
        model.addAttribute("questions", questions);
        model.addAttribute("testId", testId);
        return "questions";
    }
    @GetMapping("/createquestion/{testId}")
    public String getCreateQuestionPage(Model model, @PathVariable Long testId) {               
        model.addAttribute("testId", testId);
        return "create_question";
    }
     @PostMapping("/createquestion")
    public String createTest(Question question, Long testId) {               
        questionService.createQuestion(question, testId);
        return "redirect:/questions/"+testId;
    }
    @PostMapping("/editquestion")
    public String editQuestion(Question question, Long testId) {               
        questionService.createQuestion(question, testId);
        return "redirect:/questions/"+testId;
    }
    @GetMapping("/editquestion")
    public String getEditQuestionPage(Model model, long questionId) {               
        Question question = questionService.getQuestionById(questionId);
        model.addAttribute("question", question);
        return "editquestion";
    }
    @GetMapping("/answers/{questionId}")
    public String getAnswers(Model model, @PathVariable Long questionId) {
        Question question = questionService.getQuestionById(questionId);
        model.addAttribute("question", question);    
        return "answers";
}
}
