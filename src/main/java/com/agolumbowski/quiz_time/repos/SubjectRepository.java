/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agolumbowski.quiz_time.repos;

import com.agolumbowski.quiz_time.entity.Subject;
import javax.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author agolu
 */
public interface SubjectRepository extends JpaRepository<Subject, Long> {
    
}
