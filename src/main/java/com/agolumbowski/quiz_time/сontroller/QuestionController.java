/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agolumbowski.quiz_time.сontroller;

import com.agolumbowski.quiz_time.entity.Question;
import com.agolumbowski.quiz_time.entity.Test;
import com.agolumbowski.quiz_time.serviceexp.QuestionService;

import com.agolumbowski.quiz_time.serviceexp.TestService;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author agolu
 */
@Controller
//@RequestMapping("/admin")
public class QuestionController {

    private final QuestionService questionService;
    private final TestService testService;

    public QuestionController(QuestionService questionService, TestService testService) {
        this.questionService = questionService;
        this.testService = testService;
    }

    @GetMapping("/questions/{testId}")
    public String getQuestionsPage(Model model, @PathVariable Long testId) {
        List<Question> questions;
        questions = questionService.getAll(testId);
        model.addAttribute("questions", questions);
        model.addAttribute("testId", testId);
        return "questions";
    }

    @GetMapping("/createquestion/{testId}")
    public String getCreateQuestionPage(Model model, @PathVariable Long testId) {
        Test test = testService.read(testId);
        Question question = new Question();
        question.setTest(test);
        model.addAttribute("question", question);
        return "create_question";
    }

    @PostMapping("/createquestion")
    public String createQuestion(Question question) {
        questionService.save(question);
        long testId = question.getTest().getId();
        return "redirect:/questions/" + testId;
    }

    @PostMapping("/editquestion")
    public String editQuestion(Question question) {
        questionService.save(question);
        long testId = question.getTest().getId();
        return "redirect:/questions/" + testId;
    }

    @GetMapping("/editquestion")
    public String getEditQuestionPage(Model model, long questionId) {
        Question question = questionService.read(questionId);
        model.addAttribute("question", question);
        return "editquestion";
    }

    @GetMapping("/answers/{questionId}")
    public String getAnswers(Model model, @PathVariable Long questionId) {
        Question question = questionService.read(questionId);
        model.addAttribute("question", question);
        return "answers";
    }
}
