/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agolumbowski.quiztime.сontroller;

import com.agolumbowski.quiztime.entity.Subject;
import com.agolumbowski.quiztime.entity.Test;
import com.agolumbowski.quiztime.service.TestServiceImpl;
import com.agolumbowski.quiztime.serviceexp.SubjectService;
import java.util.List;
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

    public TestController(TestServiceImpl testService, SubjectService subjectService) {
        this.testService = testService;
        this.subjectService = subjectService;
    }
    
    private final TestServiceImpl testService;
    private final SubjectService subjectService;

    @GetMapping("/tests")
    public String getTestsPage(Model model, @RequestParam(defaultValue = "0") int page,
             @RequestParam(defaultValue = "all") String currentSubject,
             @RequestParam(defaultValue = "id") String sort) {
        Page testPage = testService.getTestsBySubject(page, sort, currentSubject);
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
        Test test = new Test();
        model.addAttribute("subjects", subjects);
        model.addAttribute("test", test);
        return "create_test";
    }

    @PostMapping("/createtest")
    public String createTest(Test test) {
        testService.save(test);
        return "redirect:/tests";
    }

    @GetMapping("/edittest")
    public String editTestPage(Model model, long testId) {
        Test test = testService.read(testId);
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
        testService.delete(testId);
        return "redirect:/tests";
    }
}
