/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agolumbowski.quiztime.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author agolu
 */
@Entity
@Table(name = "subjects")
public class Subject implements Serializable{

    private String name;
    private String description;
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    public Subject() {
    }
     

    public Subject(String name, String description) {
        this.name = name;
        this.description = description;
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

    @Override
    public String toString() {
        return "Subject{" + "name=" + name + ", description=" + description + ", id=" + id + '}';
    }
    
}
