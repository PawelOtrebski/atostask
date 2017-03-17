/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.otrebski.pawel.library.db;

import com.otrebski.pawel.library.entities.Client;
import com.otrebski.pawel.library.factories.ClientFactory;
import java.util.Collection;
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
        Client client = ClientFactory.produceClient();
        ClientRepo instance = new ClientRepo();
        
        client.setName("test_client");
        client.setId("test_client");
        Client result = instance.create(client);
        
        assertEquals(client, result);
        
        
        try{
            
            instance.create(client);
            fail("Exception for create not working");
        }catch(Exception e){}
        
    }

    /**
     * Test of findByName method, of class ClientRepo.
     */
    @Test
    public void testFindByName() throws Exception {
        System.out.println("findByName");
        String name = "test_client";
        ClientRepo instance = new ClientRepo();
        Client expResult = ClientFactory.produceClient();
        
        expResult.setId(name);
        expResult.setName(name);
        
        instance.create(expResult);
        Client result = instance.findByName(name);
        assertEquals(expResult, result);
        
        try{
            instance.findByName("test_name");
            fail("Find Exception not working");
        }catch(Exception e){
            
        }
    }

    /**
     * Test of find method, of class ClientRepo.
     */
    @Test
    public void testFind() throws Exception {
        System.out.println("find");
        ClientRepo instance = new ClientRepo();
        Client client = ClientFactory.produceClient();
        client.setId("test_client");
        client.setName("test_client");
        
        instance.create(client);
        
        Collection<Client> result = instance.find();
        if(!result.contains(client))
            fail("find all does not work");
        
    }

    /**
     * Test of update method, of class ClientRepo.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        String name = "test_name";
        Client client = ClientFactory.produceClient();
        ClientRepo instance = new ClientRepo();
        
        client.setId(name);
        client.setName(name);
        
        
        instance.create(client);
        
        client.setName("test_name_2");
        
        instance.update(name, client);
        
        Client result = instance.findByName(name);
        assertEquals(result,client);
        
        try{
            
            Client test = null;
            instance.update(null, test);
            fail("Creation of null not caught");
        }catch(Exception e){
        
        }
    
    }

    /**
     * Test of delete method, of class ClientRepo.
     */
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        String id = "test_client";
        ClientRepo instance = new ClientRepo();
        Client expResult = ClientFactory.produceClient();
        expResult.setId(id);
        expResult.setName(id);
        
        instance.create(expResult);
        
        
        Client result = instance.delete(id);
        assertEquals(expResult, result);
        
        try{
            instance.delete("test_client_two");
            fail("Exception during delete not thrown");
            
        }catch(Exception e){
            
        }
    }
    
    
}
