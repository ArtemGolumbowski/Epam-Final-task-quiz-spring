/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agolumbowski.quiz_time.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.*;

/**
 *
 * @author agolu
 */

@Table(name = "test")
@Entity()
public class Test implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
@Column
    private String name;
@Column
    private String description;
@Column
    private String level;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="test")
    @OrderBy("id")
    private List<Question> questions;

    @OneToOne
    private Subject subject;
@Column
    private long popularity;
@Column
    private long duration;

    /**
     *
     * @return the popularity
     */
    public long getPopularity() {
        return popularity;
    }

    /**
     *
     * @param popularity to set
     */
    public void setPopularity(long popularity) {
        this.popularity = popularity;
    }

    @Override
    public String toString() {
        return "Test{" + "id=" + id + ", name=" + name + ", description=" + description + ", level=" + level + ", questions=" + questions + ", subject=" + subject + '}';
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the questions
     */
    public List<Question> getQuestions() {
        return questions;
    }

    /**
     * @param questions the questions to set
     */
    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    /**
     * @return the level
     */
    public String getLevel() {
        return level;
    }

    /**
     * @param level the level to set
     */
    public void setLevel(String level) {
        this.level = level;
    }

    /**
     * @return the subject
     */
    public Subject getSubject() {
        return subject;
    }

    /**
     * @param subject the subject to set
     */
    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

}
