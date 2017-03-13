/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.otrebski.pawel.library.db;

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
public class DatabaseTest {
    
    public DatabaseTest() {
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
     * Test of getInstance method, of class Database.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        Database expResult = null;
        Database result = Database.getInstance();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addNewBook method, of class Database.
     */
    @Test
    public void testAddNewBook() {
        System.out.println("addNewBook");
        String title = "";
        String author = "";
        Integer year = null;
        Database instance = null;
        instance.addNewBook(title, author, year);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addNewClient method, of class Database.
     */
    @Test
    public void testAddNewClient() {
        System.out.println("addNewClient");
        String name = "";
        Database instance = null;
        instance.addNewClient(name);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of lendBook method, of class Database.
     */
    @Test
    public void testLendBook() {
        System.out.println("lendBook");
        Long bookId = null;
        String name = "";
        Database instance = null;
        instance.lendBook(bookId, name);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteBook method, of class Database.
     */
    @Test
    public void testDeleteBook() {
        System.out.println("deleteBook");
        Long bookId = null;
        Database instance = null;
        instance.deleteBook(bookId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of returnBook method, of class Database.
     */
    @Test
    public void testReturnBook() {
        System.out.println("returnBook");
        Long id = null;
        String name = "";
        Database instance = null;
        instance.returnBook(id, name);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listAllBooks method, of class Database.
     */
    @Test
    public void testListAllBooks() {
        System.out.println("listAllBooks");
        Database instance = null;
        instance.listAllBooks();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listBookById method, of class Database.
     */
    @Test
    public void testListBookById() {
        System.out.println("listBookById");
        Long bookId = null;
        Database instance = null;
        instance.listBookById(bookId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listBooksByTitle method, of class Database.
     */
    @Test
    public void testListBooksByTitle() {
        System.out.println("listBooksByTitle");
        String title = "";
        Database instance = null;
        instance.listBooksByTitle(title);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listBooksByAuthorYear method, of class Database.
     */
    @Test
    public void testListBooksByAuthorYear() {
        System.out.println("listBooksByAuthorYear");
        String name = "";
        Integer year = null;
        Database instance = null;
        instance.listBooksByAuthorYear(name, year);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listBooksByAuthorTitle method, of class Database.
     */
    @Test
    public void testListBooksByAuthorTitle() {
        System.out.println("listBooksByAuthorTitle");
        String name = "";
        String title = "";
        Database instance = null;
        instance.listBooksByAuthorTitle(name, title);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listBooksByTitleYear method, of class Database.
     */
    @Test
    public void testListBooksByTitleYear() {
        System.out.println("listBooksByTitleYear");
        String title = "";
        int year = 0;
        Database instance = null;
        instance.listBooksByTitleYear(title, year);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class Database.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        Database.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
