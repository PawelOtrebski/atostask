/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.otrebski.pawel.library.db;

import com.otrebski.pawel.library.entities.Author;
import com.otrebski.pawel.library.entities.Book;
import com.otrebski.pawel.library.entities.Client;
import com.otrebski.pawel.library.enums.Status;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
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
    
    

    /**
     * Test of generateId method, of class BooksRepo.
     */
    @Test
    public void testGenerateId() {
        System.out.println("generateId");
        BooksRepo instance = new BooksRepo();
        Long expResult = 1L;
        Long result = instance.generateId();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of create method, of class BooksRepo.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        String title = "one";
        String authorName = "test";
        Author author = new Author();
        author.setId(1L);
        author.setName(authorName);
        Integer year = 2001;
        BooksRepo instance = new BooksRepo();
        Book expResult = new Book();
        expResult.setAuthor(author);
        expResult.setTitle(title);
        expResult.setYear(year);
        Book result = instance.create(title, author, year);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of update method, of class BooksRepo.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        
        BooksRepo instance = new BooksRepo();
        AuthorRepo ar = new AuthorRepo();
        ClientRepo cr = new ClientRepo();
        Client c = cr.create("krzys");
        Book b = instance.create("one", ar.create("pawel"), 2001);
        b.setCurrentStatus(Status.OUT);
        b.setClient(c);
        instance.update(b.getId(), b);
        assertEquals(b,instance.findById(b.getId()));
    }

    /**
     * Test of delete method, of class BooksRepo.
     */
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        Long bookId = null;
        BooksRepo instance = new BooksRepo();
        AuthorRepo ar = new AuthorRepo();
        Author a = ar.create("test");
        Book b = instance.create("test", a, 2001);
        Book c = instance.create("test2",a,2001);
        instance.delete(b.getId());
        Collection<Book> values = instance.findAll();
        
        if(values.contains(b)){
            fail("Book was not deleted");
        }
        
    }

    /**
     * Test of findById method, of class BooksRepo.
     */
    @Test
    public void testFindById() throws Exception {
        System.out.println("findById");
        Long id = null;
        BooksRepo instance = new BooksRepo();
        AuthorRepo ar = new AuthorRepo();
        Author author = ar.create("test");
        Book b = instance.create("test", author, 2001);
        Book expResult = b;
        Book result = instance.findById(b.getId());
        assertEquals(expResult, result);
        
    }
    
    /**
     * Test of findByName method, of class BooksRepo.
     */
    @Test
    public void testFindByName() throws Exception {
        System.out.println("findByName");
        String name = "test";
        BooksRepo instance = new BooksRepo();
        AuthorRepo ar = new AuthorRepo();
        Author author = ar.create("test");
        Book book = instance.create(name, author, 2001);
        List<Book> expResult = new ArrayList<Book>();
        expResult.add(book);
        List<Book> result = instance.findByName(name);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of findByAuthor method, of class BooksRepo.
     */
    @Test
    public void testFindByAuthor() throws Exception {
        System.out.println("findByAuthor");
        AuthorRepo ar = new AuthorRepo();
        Author author = ar.create("test");
        BooksRepo instance = new BooksRepo();
        Book book = instance.create("test", author, 2001);
        List<Book> expResult = new ArrayList<>();
        expResult.add(book);
        List<Book> result = instance.findByAuthor(author);
        assertEquals(expResult, result);
        
    }
    
    /**
     * Test of findAll method, of class BooksRepo.
     */
    @Test
    public void testFindAll() throws Exception {
        System.out.println("findAll");
        BooksRepo instance = new BooksRepo();
        AuthorRepo ar = new AuthorRepo();
        Author author = ar.create("test");
        HashSet<Book> bs = new HashSet();
        Book book = instance.create("test", author, 2001);
        bs.add(book);
       
        Collection<Book> result = instance.findAll();
        assertEquals(true, result.containsAll(bs));
       
    }
    
        
}
