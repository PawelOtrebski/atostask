/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.otrebski.pawel.library.db;

import com.otrebski.pawel.library.entities.Author;
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
public class AuthorRepoTest {
    
    public AuthorRepoTest() {
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
     * Test of generateId method, of class AuthorRepo.
     */
    @Test
    public void testGenerateId() {
        System.out.println("generateId");
        AuthorRepo instance = new AuthorRepo();
        Long expResult = null;
        Long result = instance.generateId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of create method, of class AuthorRepo.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        String name = "";
        AuthorRepo instance = new AuthorRepo();
        Author expResult = null;
        Author result = instance.create(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findOrCreate method, of class AuthorRepo.
     */
    @Test
    public void testFindOrCreate() {
        System.out.println("findOrCreate");
        String name = "";
        AuthorRepo instance = new AuthorRepo();
        Author expResult = null;
        Author result = instance.findOrCreate(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of find method, of class AuthorRepo.
     */
    @Test
    public void testFind() throws Exception {
        System.out.println("find");
        String name = "";
        AuthorRepo instance = new AuthorRepo();
        Author expResult = null;
        Author result = instance.find(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class AuthorRepo.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        AuthorRepo.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
