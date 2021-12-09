/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agolumbowski.quiz_time.сontroller;

import com.agolumbowski.quiz_time.entity.Answer;
import com.agolumbowski.quiz_time.entity.Question;
import com.agolumbowski.quiz_time.entity.Test;
import com.agolumbowski.quiz_time.entity.User;
import com.agolumbowski.quiz_time.entity.UserTestBean;
import com.agolumbowski.quiz_time.service.QuestionService;
import com.agolumbowski.quiz_time.service.QuizService;
import com.agolumbowski.quiz_time.service.TestService;
import com.agolumbowski.quiz_time.service.UserService;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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
    private UserService userService;
    @Autowired
    private QuestionService questionService;
    @Autowired
    private TestService testService;
    @Autowired
    private HttpSession httpSession;
    @Autowired
    private QuizService quizService;

    @GetMapping("/startQuiz")
    public String startQuiz(@RequestParam long testId) {


        LocalDateTime start = LocalDateTime.now();
        httpSession.setAttribute("start", start);
        httpSession.setAttribute("testId", testId);
        httpSession.setAttribute("rightAnswerCount", 0);
        httpSession.setAttribute("currentQuestion", 0);
        return "redirect:/quiz";
    }

    @GetMapping("/quiz")
    public String quiz(Model model) {
        long testId = (Long) httpSession.getAttribute("testId");
        int currentQuestion = (Integer) httpSession.getAttribute("currentQuestion");
        Test test = testService.getTestById(testId);
        Question question = test.getQuestions().get(currentQuestion);
        model.addAttribute("question", question);
        return "quizAnswers";
    }

    @PostMapping("/quiz")
    public String quizCheck(String finish, String[] userAnswer, @AuthenticationPrincipal User user) {
        long testId = (Long) httpSession.getAttribute("testId");
        int currentQuestion = (Integer) httpSession.getAttribute("currentQuestion");

        Test test = testService.getTestById(testId);
        Question question = test.getQuestions().get(currentQuestion);
        int size = test.getQuestions().size();
        int rightAnswerCount = (Integer) httpSession.getAttribute("rightAnswerCount");
        List<Answer> answers = question.getAnswers();
        rightAnswerCount += TestingUtils.checkAnswer(userAnswer, answers);
        if (finish != null || currentQuestion + 1 == size) {
            int result = rightAnswerCount * 100 / size;
            LocalDateTime finishTime = LocalDateTime.now();
            LocalDateTime start = (LocalDateTime) httpSession.getAttribute("start");
            long userTime = Duration.between(start, finishTime).toMinutes();
            UserTestBean userTestBean=new UserTestBean( user,test,result,userTime,finishTime);            
            user.addUserTestBean(userTestBean);
            userService.saveUser(user);
           return "redirect:/results";
        } else {
            currentQuestion++;
            httpSession.setAttribute("rightAnswerCount", rightAnswerCount);
            httpSession.setAttribute("currentQuestion", currentQuestion);
        }
        return "redirect:/quiz";
    }
     @GetMapping("/results")
    public String quiz(Model model, @AuthenticationPrincipal User user) {

        model.addAttribute("userTests", user.getUserTestBeans());
        return "results";
    }
}
