package com.agolumbowski.quiztime.service;

import com.agolumbowski.quiztime.entity.UserTestBean;
import com.agolumbowski.quiztime.repos.UTBRepository;
import com.agolumbowski.quiztime.serviceexp.QuizService;
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
