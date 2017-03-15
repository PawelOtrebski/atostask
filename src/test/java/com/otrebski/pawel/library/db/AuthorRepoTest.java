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

    /**
     * Test of generateId method, of class AuthorRepo.
     */
    @Test
    public void testGenerateId() {
        System.out.println("generateId");
        AuthorRepo instance = new AuthorRepo();
        Long expResult = 1L;
        Long result = instance.generateId();
        assertEquals(expResult, result);
        
        Long nextExpResult = 2L;
        Long nextResult = instance.generateId();
        assertEquals(nextResult,nextExpResult);
       
        
        assertEquals(result,new Long(nextResult-1L));
        
    }

    /**
     * Test of create method, of class AuthorRepo.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        String name = "pawel";
        AuthorRepo instance = new AuthorRepo();
        Author expResult = new Author();
        expResult.setName(name);
        
        Author result = instance.create(name);
        assertEquals(expResult, result);
        
        String secondName = "krzys";
        Author second = new Author();
        second.setName(secondName);
        
        Author resultTwo = instance.create(secondName);
       
        assertNotEquals(result.getId(),second.getId());
        
    }
    
    /**
     * Test of findOrCreate method, of class AuthorRepo.
    */
    @Test
    public void testFindOrCreate() throws Exception{
        System.out.println("findOrCreate");
        String name = "pawel";
        AuthorRepo instance = new AuthorRepo();
        Author expResult = instance.create(name);
        
        Author result = instance.findOrCreate(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(expResult.getId(),result.getId());
    }

    /**
     * Test of find method, of class AuthorRepo.
     */
    @Test
    public void testFind() throws Exception {
        System.out.println("find");
        String name = "pawel";
        AuthorRepo instance = new AuthorRepo();
        Author expResult = instance.create(name);
        Author result = instance.find(name);
        assertEquals(expResult, result);
        
    }

}
