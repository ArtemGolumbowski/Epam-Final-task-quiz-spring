/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agolumbowski.quiz_time.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author agolu
 */
@Entity
@Table
public class UserTestBean implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @ManyToOne
    private User user;
    @ManyToOne
    private Test test;
    private int score;
    private long userQuizTime;
    private LocalDateTime userPassDate;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

   

    /**
     * @return the score
     */
    public int getScore() {
        return score;
    }

    /**
     * @param score the score to set
     */
    public void setScore(int score) {
        this.score = score;
    }


    public long getUserQuizTime() {
        return userQuizTime;
    }

    public void setUserQuizTime(long userQuizTime) {
        this.userQuizTime = userQuizTime;
    }

    public LocalDateTime getUserPassDate() {
        return userPassDate;
    }

    public void setUserPassDate(LocalDateTime userPassDate) {
        this.userPassDate = userPassDate;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
