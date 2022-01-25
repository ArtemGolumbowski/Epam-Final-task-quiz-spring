/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.agolumbowski.quiztime.service;

import com.agolumbowski.quiztime.repos.TestRepository;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author agolu
 */
@SpringBootTest
public class TestServiceImplTest {

    @Mock
    TestRepository testRepository;

    public TestServiceImplTest() {
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
     * Test of getTestsBySubject method, of class TestServiceImpl.
     */
    @Test
    public void testGetTestsBySubject() {
        System.out.println("getTestsBySubject");
        int page = 2;
        String sort = "level";
        String subject = "Physics";
        TestServiceImpl instance = new TestServiceImpl(testRepository);
        Page<com.agolumbowski.quiztime.entity.Test> expResult = Mockito.mock(Page.class);
        Page<com.agolumbowski.quiztime.entity.Test> expResult2 = Mockito.mock(Page.class);
        Mockito.when(testRepository.findBySubjectName(Mockito.anyString(), Mockito.any(Pageable.class))).thenReturn(expResult);
        Mockito.when(testRepository.findAll(Mockito.any(Pageable.class))).thenReturn(expResult2);
        Page result = instance.getTestsBySubject(page, sort, subject);
        assertEquals(expResult, result);
        subject = "all";
        result = instance.getTestsBySubject(page, sort, subject);
        assertEquals(expResult2, result);
    }

    /**
     * Test of save method, of class TestServiceImpl.
     */
    @Test
    public void testSave() {
        System.out.println("save");
        com.agolumbowski.quiztime.entity.Test test = new com.agolumbowski.quiztime.entity.Test();
        test.setName("Petr");
        TestServiceImpl instance = new TestServiceImpl(testRepository);
        Mockito.when(testRepository.save(test)).thenReturn(test);
        com.agolumbowski.quiztime.entity.Test expResult = test;
        com.agolumbowski.quiztime.entity.Test result = instance.save(test);
        assertNotNull(result.getName());
        assertEquals(expResult.getName(), result.getName());
        assertEquals(expResult, result);

    }

    /**
     * Test of read method, of class TestServiceImpl.
     */
    @Test
    public void testRead() {
        System.out.println("read");
        long testId = 4L;
        com.agolumbowski.quiztime.entity.Test test = new com.agolumbowski.quiztime.entity.Test();
        test.setId(testId);
        TestServiceImpl instance = new TestServiceImpl(testRepository);
        Mockito.when(testRepository.getById(4L)).thenReturn(test);
        com.agolumbowski.quiztime.entity.Test expResult = test;
        com.agolumbowski.quiztime.entity.Test result = instance.read(testId);
        assertEquals(expResult.getId(), result.getId());
        assertEquals(expResult, result);
        
    }

    /**
     * Test of delete method, of class TestServiceImpl.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        long testId = 5L;
        TestServiceImpl instance = new TestServiceImpl(testRepository);
        instance.delete(testId);
        Mockito.verify(testRepository).deleteById(testId);
    }

}
