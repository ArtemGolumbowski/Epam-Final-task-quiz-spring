/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agolumbowski.quiz_time.сontroller;

import com.agolumbowski.quiz_time.entity.Answer;
import com.agolumbowski.quiz_time.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
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
public class AnswerController {
    @Autowired
    private AnswerService answerService;
     @GetMapping("/createanswer/{questionId}")
    public String getCreateAnswerPage(Model model, @PathVariable Long questionId) {               
        model.addAttribute("questionId", questionId);
        return "create_answer";
    }
     @PostMapping("/createanswer")
    public String createAnswer(Answer answer, Long questionId) {               
        answerService.createAnswer(answer, questionId);
        return "redirect:/answers/"+questionId;
    }
    
}
