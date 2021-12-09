
package com.agolumbowski.quiz_time.service;

import com.agolumbowski.quiz_time.entity.UserTestBean;
import com.agolumbowski.quiz_time.repos.UTBRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author agolu
 */
@Service
public class QuizService {
    @Autowired
    private UTBRepository utbRepository;
    public void saveUserData(UserTestBean utb){
        utbRepository.save(utb);
    }
}
