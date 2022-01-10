package com.agolumbowski.quiz_time.service;

import com.agolumbowski.quiz_time.entity.Subject;
import com.agolumbowski.quiz_time.entity.Test;
import com.agolumbowski.quiz_time.repos.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 *
 * @author agolu
 */
@Service
public class TestService {

    @Autowired
    private SubjectService subjectService;
    @Autowired
    private TestRepository testRepository;

    public Page getAllTests(int page, String sort) {
        return testRepository.findAll(PageRequest.of(page, 2, Sort.by(sort)));
    }

    public Page getTestsBySubject(int page, String sort, String subject) {
        if (subject.equalsIgnoreCase("all")) {
            return testRepository.findAll(PageRequest.of(page, 2, Sort.by(sort)));
        } else {
            return testRepository.findBySubjectName(subject, PageRequest.of(page, 2, Sort.by(sort)));
        }
    }

    public void saveTest(Test test, long subjectId) {
        Subject subject = subjectService.getSubjectById(subjectId);
        test.setSubject(subject);
        testRepository.save(test);
    }

    public Test getTestById(long testId) {
        return testRepository.getById(testId);
    }

    public void deleteTest(long testId) {
        testRepository.deleteById(testId);
    }
}
