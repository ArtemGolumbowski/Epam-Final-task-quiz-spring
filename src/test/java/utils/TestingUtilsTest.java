/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import com.agolumbowski.quiz_time.entity.Answer;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;

import org.junit.jupiter.api.Test;
/**
 *
 * @author agolu
 */

public class TestingUtilsTest {
    
    public TestingUtilsTest() {
    }
    
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
     * Test of checkAnswer method, of class TestingUtils.
     */
    @Test
    public void testCheckAnswer() {
        System.out.println("checkAnswer");
        String[] userAnswers = {"test1", "test2"};
        Answer answer1=new Answer("test1", true);
        Answer answer2=new Answer("test2", true);
        Answer answer3=new Answer("test3", false);
        Answer answer4=new Answer("test4", false);
        List<Answer> answers = new ArrayList<>();
        answers.add(answer1);
        answers.add(answer3);
        answers.add(answer4);
        answers.add(answer2);
        int expResult = 1;
        int result = TestingUtils.checkAnswer(userAnswers, answers);
        Assert.assertEquals(expResult, result);
        
    }
    
}
