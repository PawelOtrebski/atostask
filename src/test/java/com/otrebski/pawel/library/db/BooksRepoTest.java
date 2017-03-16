/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.otrebski.pawel.library.db;

import com.otrebski.pawel.library.entities.Author;
import com.otrebski.pawel.library.entities.Book;
import com.otrebski.pawel.library.enums.Status;
import com.otrebski.pawel.library.exceptions.BookNotFoundException;
import com.otrebski.pawel.library.factories.AuthorFactory;
import com.otrebski.pawel.library.factories.BookFactory;
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

    /**
     * Test of create method, of class BooksRepo.
     */
    @Test
    public void testCreate() throws BookNotFoundException {
        System.out.println("create");
        Author author = AuthorFactory.produceAuthor();
        Book book = BookFactory.produceBook();
        BooksRepo instance = new BooksRepo();
        author.setId("test_author");
        author.setName("test_author");
        book.setAuthor(author);
        book.setTitle("test_title");
        book.setYear(2001);
        book = instance.create(book);
        assertEquals(book,instance.findById(book.getId()));
    }

    /**
     * Test of update method, of class BooksRepo.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        Long bookId = 1L;
        BooksRepo instance = new BooksRepo();
        AuthorRepo authorInstance = new AuthorRepo();
        Author author = AuthorFactory.produceAuthor();
        author.setId("test_author");
        author.setName("test_author");
        Book book = BookFactory.produceBook();
        book.setAuthor(author);
        book.setTitle("test_title");
        book.setYear(2001);
        
        author = authorInstance.create(author);
        book = instance.create(book);
        
        book.setTitle("test_title_two");
        Book result = instance.update(book.getId(), book);
        
        assertEquals(result,book);
        
        
    }

    /**
     * Test of delete method, of class BooksRepo.
     */
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        Long bookId = 1L;
        AuthorRepo authorInstance = new AuthorRepo();
        BooksRepo instance = new BooksRepo();
        Author author = AuthorFactory.produceAuthor();
        Book book = BookFactory.produceBook();
        
        author.setId("test_author");
        author.setName("test_author");
        book.setAuthor(author);
        book.setTitle("test_title");
        book.setYear(2001);
        
        authorInstance.create(author);
        instance.create(book);
        
        Book result = instance.delete(book.getId());
        assertEquals(result,book);
        
        try{
            result = instance.findById(1L);
            fail("delete failed");
        }catch(Exception e){
            
        }
    }

    /**
     * Test of findById method, of class BooksRepo.
     */
    @Test
    public void testFindById() throws Exception {
        System.out.println("findById");
        Long id = 1L;
        BooksRepo instance = new BooksRepo();
        AuthorRepo authorInstance = new AuthorRepo();
        
        Author author = AuthorFactory.produceAuthor();
        Book book = BookFactory.produceBook();
        author.setId("test_author");
        author.setName("test_author");
        book.setAuthor(author);
        book.setTitle("test_title");
        book.setYear(2001);
        
        authorInstance.create(author);
        book = instance.create(book);
        
        Book result = instance.findById(book.getId());
        assertEquals(book, result);
        
    }

    /**
     * Test of findByName method, of class BooksRepo.
     */
    @Test
    public void testFindByName() throws Exception {
        System.out.println("findByName");
        BooksRepo instance = new BooksRepo();
        AuthorRepo authorInstance = new AuthorRepo();
        Author author = AuthorFactory.produceAuthor();
        author.setId("test_author");
        author.setName("test_author");
        
        author = authorInstance.create(author);
        
        Book book = BookFactory.produceBook();
        book.setAuthor(author);
        book.setTitle("test_title");
        book.setYear(2001);
        
        book = instance.create(book);
        
        List<Book> books = instance.findByName("test_title");
        assert(books.contains(book));
        
    }

    /**
     * Test of findByAuthor method, of class BooksRepo.
     */
    @Test
    public void testFindByAuthor() throws Exception {
        System.out.println("findByAuthor");
        Author author = AuthorFactory.produceAuthor();
        Book book = BookFactory.produceBook();
        
        BooksRepo instance = new BooksRepo();
        AuthorRepo authorInstance = new AuthorRepo();
        
        author.setId("test_author");
        author.setName("test_author");
        
        author = authorInstance.create(author);
        book.setAuthor(author);
        book.setTitle("test_title");
        book.setYear(2001);
        
        book = instance.create(book);
        
        List<Book> books = instance.findByAuthor(author);
        assert(books.contains(book));
    }

    /**
     * Test of findAll method, of class BooksRepo.
     */
    @Test
    public void testFindAll() throws Exception {
        System.out.println("findAll");
        BooksRepo instance = new BooksRepo();
        AuthorRepo authorInstance = new AuthorRepo();
        Author author = AuthorFactory.produceAuthor();
        Book book = BookFactory.produceBook();
        
        author.setId("test_author");
        author.setName("test_author");
        
        author = authorInstance.create(author);
        
        book.setAuthor(author);
        book.setTitle("test_title");
        book.setYear(2001);
        
        book = instance.create(book);
        
        Collection<Book> expResult = instance.findAll();
        assert(expResult.contains(book));
    }

    

    /**
     * Test of getAllStats method, of class BooksRepo.
     *
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
     *
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        BooksRepo.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

*/
}
