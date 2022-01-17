/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agolumbowski.quiztime.service;

import com.agolumbowski.quiztime.entity.Subject;
import com.agolumbowski.quiztime.repos.SubjectRepository;
import com.agolumbowski.quiztime.serviceexp.SubjectService;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 *
 * @author agolu
 */
@Service
public class SubjectServiceImpl implements SubjectService {

    private final SubjectRepository subjectRepository;

    public SubjectServiceImpl(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @Override
    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }

    @Override
    public Page getAllSubjectsPage(int page) {
        return subjectRepository.findAll(PageRequest.of(page, 2, Sort.by("id")));
    }

    @Override
    public Subject read(long subjectId) {
        return subjectRepository.getById(subjectId);
    }

    @Override
    public Subject save(Subject subject) {
        return subjectRepository.save(subject);
    }

    @Override
    public void delete(long id) {
        subjectRepository.deleteById(id);
    }
}
