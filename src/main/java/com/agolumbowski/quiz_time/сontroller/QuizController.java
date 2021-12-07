/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agolumbowski.quiz_time.сontroller;

import com.agolumbowski.quiz_time.entity.Answer;
import com.agolumbowski.quiz_time.entity.Question;
import com.agolumbowski.quiz_time.entity.Test;
import com.agolumbowski.quiz_time.service.TestService;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import utils.TestingUtils;

/**
 *
 * @author agolu
 */
@Controller
public class QuizController {
    @Autowired
    private TestService testService;
    @Autowired
    private HttpSession httpSession;
    @GetMapping("/startQuiz")
    public String startQuiz(@RequestParam long testId) {
        
        httpSession.setAttribute("testId", testId);
        httpSession.setAttribute("rightAnswerCount", 0);
        httpSession.setAttribute("currentQuestion", 0);
        return "redirect:/quiz";
    }
    @GetMapping("/quiz")
    public String quiz(Model model) {
        long testId=(Long)httpSession.getAttribute("testId");
        Test test = testService.getTestById(testId);
        int currentQuestion = (Integer)httpSession.getAttribute("currentQuestion");
        System.out.println(currentQuestion);
        Question question=test.getQuestions().get(currentQuestion);
        model.addAttribute("question", question);
        return "quizAnswers";
    }
    @PostMapping("/quiz")
    public String quizCheck(String finish, String[] userAnswer) {
        long testId=(Long)httpSession.getAttribute("testId");
        Test test = testService.getTestById(testId);
        int currentQuestion = (Integer)httpSession.getAttribute("currentQuestion");
        int size = test.getQuestions().size();
        int rightAnswerCount = (Integer)httpSession.getAttribute("rightAnswerCount");
        List<Answer>answers=test.getQuestions().get(currentQuestion).getAnswers();
        rightAnswerCount+=TestingUtils.checkAnswer(userAnswer, answers);
        if(finish!=null||currentQuestion + 1 == size){
           
        }else{
            currentQuestion++;
            System.out.println(currentQuestion);
            httpSession.setAttribute("rightAnswerCount", rightAnswerCount);
        httpSession.setAttribute("currentQuestion", currentQuestion);
        }
        return "redirect:/quiz";
    }
}
