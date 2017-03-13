/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.otrebski.pawel.library.db;

import com.otrebski.pawel.library.entities.Client;
import com.otrebski.pawel.library.exceptions.ClientExistsException;
import com.otrebski.pawel.library.exceptions.ClientNotFoundException;
import java.util.HashMap;

/**
 *
 * @author pawel
 */
/*
    Repository for all clients.
    The assumption, as with authors is that a clients name is unique
*/
public class ClientRepo {
    private long numberCreated;
    private HashMap<Long,Client> clients;
    
    
    public ClientRepo(){
        clients = new HashMap<>();
        this.numberCreated = 0;
    }
    /*
        Generate an ID
    */
    private Long generateId(){
        return ++this.numberCreated;
    }
    /*
        Create a new client with a given name or throw an exception if the 
        client exists or if the nameo the given client is null
    */
   public Client create(String name) 
           throws ClientExistsException,NullPointerException{
       
       for(Client client : clients.values()){
           if(client.getName().equalsIgnoreCase(name)){
               throw new ClientExistsException(name+"exists: "+client);
           }
       }
       
       name = name.replaceAll("\\s+", " ").trim().toLowerCase();
       Client client = new Client();
       client.setName(name);
       client.setId(this.generateId());
       
       clients.put(client.getId(), client);
       return client;
   }
   
   /*
        Find the given client by name
   */
   public Client findByName(String name) throws NullPointerException,
           ClientNotFoundException{
       
       Client client = null;
       name = name.replaceAll("\\s+", " ").trim().toLowerCase();
       for(Client c : clients.values()){
           
           if(c.getName().equals(name)){
               client = c;
               break;
           }
           
       }
       
       if(client==null) throw new ClientNotFoundException(name+" not found");
       
       return client;
   }
   
   public void update(Long id, Client client) throws ClientNotFoundException{
       if(!clients.containsKey(id)) throw new ClientNotFoundException("Client not found");
       this.clients.replace(id, client);
   }
}
