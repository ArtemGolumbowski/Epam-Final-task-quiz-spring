/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agolumbowski.quiz_time.service;

import com.agolumbowski.quiz_time.entity.Subject;
import com.agolumbowski.quiz_time.repos.SubjectRepository;
import java.util.List;
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
public class SubjectService {
    @Autowired
    private SubjectRepository subjectRepository;
    
    public List<Subject> getAllSubjects(){
        return subjectRepository.findAll();
    }
    public Page getAllSubjects(int page){
        return subjectRepository.findAll(PageRequest.of(page, 2, Sort.by("id")));
    }
    public Subject getSubjectById(long subjectId){
        return subjectRepository.getById(subjectId);
    }
    public void saveSubject(Subject subject){
        subjectRepository.save(subject);
    }
}
