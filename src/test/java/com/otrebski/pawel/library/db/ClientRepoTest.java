/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.otrebski.pawel.library.db;

import com.otrebski.pawel.library.entities.Client;
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
public class ClientRepoTest {
    
    public ClientRepoTest() {
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
     * Test of create method, of class ClientRepo.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        String name = "";
        ClientRepo instance = new ClientRepo();
        Client expResult = null;
        Client result = instance.create(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findByName method, of class ClientRepo.
     */
    @Test
    public void testFindByName() throws Exception {
        System.out.println("findByName");
        String name = "";
        ClientRepo instance = new ClientRepo();
        Client expResult = null;
        Client result = instance.findByName(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class ClientRepo.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        Long id = null;
        Client client = null;
        ClientRepo instance = new ClientRepo();
        instance.update(id, client);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class ClientRepo.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        ClientRepo.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
