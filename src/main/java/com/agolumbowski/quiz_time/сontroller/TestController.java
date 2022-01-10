/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agolumbowski.quiz_time.сontroller;

import com.agolumbowski.quiz_time.entity.Subject;
import com.agolumbowski.quiz_time.entity.Test;
import com.agolumbowski.quiz_time.service.SubjectService;
import com.agolumbowski.quiz_time.service.TestService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author agolu
 */
@Controller
public class TestController {

    @Autowired
    private TestService testService;
    @Autowired
    private SubjectService subjectService;

    @GetMapping("/tests")
    public String getTestsPage(Model model,@RequestParam(defaultValue="0")int page
                                , @RequestParam(defaultValue="all")String currentSubject
                                , @RequestParam(defaultValue="id")String sort) {
        Page testPage = testService.getTestsBySubject(page, sort, currentSubject);
//        Page testPage = testService.getAllTests(page, sort);
        List<Subject> subjects = subjectService.getAllSubjects();
        model.addAttribute("subjects", subjects);
      
        model.addAttribute("tests", testPage);
        model.addAttribute("currentSubject", currentSubject);
        model.addAttribute("sort", sort);
        return "tests";
    }

    @GetMapping("/createtest")
    public String createTestPage(Model model) {
        List<Subject> subjects = subjectService.getAllSubjects();
        model.addAttribute("subjects", subjects);
        return "create_test";
    }

    @PostMapping("/createtest")
    public String createTest(Test test, long subjectId) {
        testService.saveTest(test, subjectId);
        return "redirect:/tests";
    }

    @GetMapping("/edittest")
    public String editTestPage(Model model, long testId) {
        Test test = testService.getTestById(testId);
        List<Subject> subjects = subjectService.getAllSubjects();
        model.addAttribute("subjects", subjects);
        model.addAttribute("test", test);
        return "edittest";
    }

    @ExceptionHandler({Exception.class})
    public String databaseError() {
        return "error-view-name";
    }

    @GetMapping("/deletetest")
    public String deleteTest(long testId) {
        testService.deleteTest(testId);
        return "redirect:/tests";
    }
}
