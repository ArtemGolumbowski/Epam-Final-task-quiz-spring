/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.agolumbowski.quiztime.service;

import com.agolumbowski.quiztime.entity.Question;
import com.agolumbowski.quiztime.repos.QuestionRepository;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

/**
 *
 * @author agolu
 */
@SpringBootTest
public class QuestionServiceImplTest {

    public QuestionServiceImplTest() {
    }
    @Mock
    QuestionRepository questionRepository;

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getAll method, of class QuestionServiceImpl.
     */
    @Test
    public void testGetAll() {
        System.out.println("getAll");
        long testId = 5L;
        List<Question> questions = new ArrayList<>();
        questions.add(new Question());
        List<Question> expResult = questions;
        QuestionServiceImpl instance = new QuestionServiceImpl(questionRepository);
        Mockito.when(questionRepository.findAllByTestIdOrderById(testId)).thenReturn(expResult);
        List<Question> result = instance.getAll(testId);
        assertEquals(expResult, result);

    }

    /**
     * Test of save method, of class QuestionServiceImpl.
     */
    @Test
    public void testSave() {
        System.out.println("save");
        Question question = new Question();
        question.setDescription("description");
        QuestionServiceImpl instance = new QuestionServiceImpl(questionRepository);
        Question expResult = question;
        Question result = instance.save(question);
        assertEquals(expResult, result);
       
    }

    /**
     * Test of read method, of class QuestionServiceImpl.
     */
    @Test
    public void testRead() {
        System.out.println("read");
        long questionId = 0L;
        QuestionServiceImpl instance = null;
        Question expResult = null;
        Question result = instance.read(questionId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class QuestionServiceImpl.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        long id = 0L;
        QuestionServiceImpl instance = null;
        instance.delete(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
