/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agolumbowski.quiztime.repos;

import com.agolumbowski.quiztime.entity.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author agolu
 */
public interface TestRepository extends JpaRepository<Test, Long> {
    Page findBySubjectName(String subject, Pageable pageable);

}
