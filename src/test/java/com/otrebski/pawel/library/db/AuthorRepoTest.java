/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.otrebski.pawel.library.db;

import com.otrebski.pawel.library.entities.Author;
import com.otrebski.pawel.library.exceptions.AuthorExistsException;
import com.otrebski.pawel.library.factories.AuthorFactory;
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
     * Test of create method, of class AuthorRepo.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        Author author = AuthorFactory.produceAuthor();
        AuthorRepo instance = new AuthorRepo();
        author.setId("test_author");
        author.setName("test_author");
        
        Author result = instance.create(author);
        assertEquals(author, result);
        
        System.out.println("create exception handling");
        try{
            author = instance.create(author);
            fail("Exception failed in create");
        }catch(Exception e){
            
        }
       
    }

    /**
     * Test of findOrCreate method, of class AuthorRepo.
     */
    @Test
    public void testFindOrCreate() throws Exception {
        System.out.println("findOrCreate");
        
        AuthorRepo instance = new AuthorRepo();
        
        Author expResult = instance.findOrCreate("test_author");
        Author result = instance.findOrCreate("test_author");
        assertEquals(expResult,result);
        
    }

    /**
     * Test of find method, of class AuthorRepo.
     */
    @Test
    public void testFind() throws Exception {
        System.out.println("find");
        
        AuthorRepo instance = new AuthorRepo();
        Author expResult = AuthorFactory.produceAuthor();
        expResult.setId("test_author");
        expResult.setName("test_author");
        
        expResult = instance.create(expResult);
        
        Author result = instance.find("test_author");
        assertEquals(expResult, result);
        
        try{
            instance.find(null);
            fail("null exception failed in method find");
        }catch(Exception e){
            
        }
        
        try{
            instance.find("test_author_2");
            fail("search exception not working");
        }catch(Exception e){
            
        }
    }

    /**
     * Test of updated method, of class AuthorRepo.
     */
    @Test
    public void testUpdated() throws Exception {
        System.out.println("updated");
        
        Author author = AuthorFactory.produceAuthor();
        AuthorRepo instance = new AuthorRepo();
        
        author.setId("test_author");
        author.setName("test_author");
        
        Author result = instance.create(author);
        
        author.setName("test_author_2");
        
        Author expResult = instance.updated("test_author", author);
        assertEquals(expResult, author);
        
        try{
            instance.updated("test_author_2", author);
            fail("Exception handler not working for update");
        }catch(Exception e){
            
        }
    }

    /**
     * Test of delete method, of class AuthorRepo.
     */
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        
        AuthorRepo instance = new AuthorRepo();
        Author author = AuthorFactory.produceAuthor();
       
        author.setId("test_author");
        author.setName("test_author");
        
        author = instance.create(author);
        
        Author result = instance.delete(author.getId());
        
        assertEquals(result,author);
        
        try{
            instance.create(author);
            
        }catch(AuthorExistsException e){
           fail("Delete did not work, Exception for Exisitng worker tested");
        }
        try{
            instance.delete(null);
            fail("Delete not working on null value");
        }catch(Exception e){
            
        }
    }

   
    
}
