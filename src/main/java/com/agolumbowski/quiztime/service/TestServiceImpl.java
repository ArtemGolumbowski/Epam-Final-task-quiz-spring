package com.agolumbowski.quiztime.service;

import com.agolumbowski.quiztime.entity.Test;
import com.agolumbowski.quiztime.repos.TestRepository;
import com.agolumbowski.quiztime.serviceexp.TestService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 *
 * @author agolu
 */
@Service
public class TestServiceImpl implements TestService {

    final TestRepository testRepository;

    public TestServiceImpl(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

//    public Page getAllTests(int page, String sort) {
//        return testRepository.findAll(PageRequest.of(page, 2, Sort.by(sort)));
//    }

    @Override
    public Page getTestsBySubject(int page, String sort, String subject) {
        if (subject.equalsIgnoreCase("all")) {
            return testRepository.findAll(PageRequest.of(page, 2, Sort.by(sort)));
        } else {
            return testRepository.findBySubjectName(subject, PageRequest.of(page, 2, Sort.by(sort)));
        }
    }

    @Override
    public Test save(Test test) {
        return testRepository.save(test);
    }

//    public void saveTest(Test test, long subjectId) {
//        Subject subject = subjectService.getSubjectById(subjectId);
//        test.setSubject(subject);
//        testRepository.save(test);
//    }

    @Override
    public Test read(long testId) {
        return testRepository.getById(testId);
    }

    @Override
    public void delete(long testId) {
        testRepository.deleteById(testId);
    }

}
