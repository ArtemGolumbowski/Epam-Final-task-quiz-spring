/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agolumbowski.quiz_time.serviceexp;

import com.agolumbowski.quiz_time.entity.Subject;
import java.util.List;
import org.springframework.data.domain.Page;

/**
 *
 * @author agolu
 */
public interface SubjectService extends Service {

    public List<Subject> getAllSubjects();

    public Page getAllSubjectsPage(int page);

    public Subject save(Subject subject);
}
