
package com.agolumbowski.quiz_time.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.persistence.Table;

/**
 *
 * @author agolu
 */
@Entity
@Table(name = "questions")
public class Question implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    private String description;
    @ManyToOne
    private Test test;
    @OneToMany(cascade = CascadeType.ALL, mappedBy="question")
    private List <Answer> answers;

    public Question() {
    }

    public Question(String description, Test test, List<Answer> answers) {
        this.description = description;
        this.test = test;
        this.answers = answers;
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
     * @return the answers
     */
    public List <Answer> getAnswers() {
        return answers;
    }

    /**
     * @param answers the answers to set
     */
    public void setAnswers(List <Answer> answers) {
        this.answers = answers;
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

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    @Override
    public String toString() {
        return "Question{" + "id=" + id + ", description=" + description + ", test="+ ", answers=" + answers + '}';
    }
    
}
