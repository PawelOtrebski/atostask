/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.otrebski.pawel.library.db;

import com.otrebski.pawel.library.entities.Book;
import com.otrebski.pawel.library.entities.Client;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
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
    

    /**
     * Test of create method, of class ClientRepo.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        String name = "pawel";
        ClientRepo instance = new ClientRepo();
        Client expResult = new Client();
        expResult.setName(name);
        expResult.setId(1L);
        Client result = instance.create(name);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of findByName method, of class ClientRepo.
     */
    @Test
    public void testFindByName() throws Exception {
        System.out.println("findByName");
        String name = "pawel";
        ClientRepo instance = new ClientRepo();
        Client expResult = instance.create(name);
        Client result = instance.findByName(name);
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of find method, of class ClientRepo.
     */
    @Test
    public void testFind() throws Exception {
        System.out.println("find");
        
        ClientRepo instance = new ClientRepo();
        Client client = instance.create("one");
        Client client2 = instance.create("two");
        HashSet<Client> hs = new HashSet();
        hs.add(client);
        hs.add(client2);
        Collection<Client> expResult = null;
        Collection<Client> result = instance.find();
        assertEquals(result.containsAll(hs),true);
        
    }

    /**
     * Test of update method, of class ClientRepo.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        String name = "pawel";
        Book book = new Book();
        book.setId(1L);
        ClientRepo instance = new ClientRepo();
        Client client = instance.create(name);
        client.addToRented(book);
        instance.update(name, client);
        Client t = instance.findByName(name);
        assertEquals(t.getRented().containsKey(1L),client.getRented().containsKey(1L));
    }

    /**
     * Test of main method, of class ClientRepo.
     */
    
    
}
