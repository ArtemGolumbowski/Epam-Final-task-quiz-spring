package com.agolumbowski.quiz_time.service;

import com.agolumbowski.quiz_time.entity.UserTestBean;
import com.agolumbowski.quiz_time.repos.UTBRepository;
import com.agolumbowski.quiz_time.serviceexp.QuizService;
import org.springframework.stereotype.Service;

/**
 *
 * @author agolu
 */
@Service
public class QuizServiceImpl {

    private final UTBRepository utbRepository;

    public QuizServiceImpl(UTBRepository utbRepository) {
        this.utbRepository = utbRepository;
    }

//    @Override
//    public void save(UserTestBean utb) {
//        utbRepository.save(utb);
//    }

}
