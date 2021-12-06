/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agolumbowski.quiz_time.сontroller;

import com.agolumbowski.quiz_time.entity.Subject;
import com.agolumbowski.quiz_time.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author agolu
 */
@Controller
public class SubjectController {
    @Autowired
    private SubjectService subjectService;
   @GetMapping("/subjects")
    public String getTestsPage(Model model,@RequestParam(defaultValue="0")int page) {
        Page subjectPage = subjectService.getAllSubjects(page);
        model.addAttribute("subjects", subjectPage);
 
        return "subjects";
    }
    @GetMapping("/createsubject")
    public String getCreatePage(Model model){
        Subject subject = new Subject();
        model.addAttribute("subject", subject);
        return "create_subject";
        
    }
    @GetMapping("/editsubject")
    public String getEditPage(Model model, long subjectId){
        Subject subject = subjectService.getSubjectById(subjectId);
        model.addAttribute("subject", subject);
        return "editsubject";
    }
    @PostMapping("/editsubject")
    public String editSubject(Subject subject){
        subjectService.saveSubject(subject);
        return "redirect:/subjects";
    }
}