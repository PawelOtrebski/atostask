/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.otrebski.pawel.library.db;

import com.otrebski.pawel.library.entities.Author;
import com.otrebski.pawel.library.entities.Book;
import java.util.Collection;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pawel
 */
public class BooksRepoTest {
    
    public BooksRepoTest() {
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
     * Test of generateId method, of class BooksRepo.
     */
    @Test
    public void testGenerateId() {
        System.out.println("generateId");
        BooksRepo instance = new BooksRepo();
        Long expResult = null;
        Long result = instance.generateId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of create method, of class BooksRepo.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        String title = "";
        Author author = null;
        Integer year = null;
        BooksRepo instance = new BooksRepo();
        Book expResult = null;
        Book result = instance.create(title, author, year);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class BooksRepo.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        Long bookId = null;
        Book book = null;
        BooksRepo instance = new BooksRepo();
        instance.update(bookId, book);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class BooksRepo.
     */
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        Long bookId = null;
        BooksRepo instance = new BooksRepo();
        instance.delete(bookId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findById method, of class BooksRepo.
     */
    @Test
    public void testFindById() throws Exception {
        System.out.println("findById");
        Long id = null;
        BooksRepo instance = new BooksRepo();
        Book expResult = null;
        Book result = instance.findById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findByName method, of class BooksRepo.
     */
    @Test
    public void testFindByName() throws Exception {
        System.out.println("findByName");
        String name = "";
        BooksRepo instance = new BooksRepo();
        List<Book> expResult = null;
        List<Book> result = instance.findByName(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findByAuthor method, of class BooksRepo.
     */
    @Test
    public void testFindByAuthor() throws Exception {
        System.out.println("findByAuthor");
        Author author = null;
        BooksRepo instance = new BooksRepo();
        List<Book> expResult = null;
        List<Book> result = instance.findByAuthor(author);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findAll method, of class BooksRepo.
     */
    @Test
    public void testFindAll() {
        System.out.println("findAll");
        BooksRepo instance = new BooksRepo();
        Collection<Book> expResult = null;
        Collection<Book> result = instance.findAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllStats method, of class BooksRepo.
     */
    @Test
    public void testGetAllStats() {
        System.out.println("getAllStats");
        BooksRepo instance = new BooksRepo();
        String expResult = "";
        String result = instance.getAllStats();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class BooksRepo.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        BooksRepo.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
