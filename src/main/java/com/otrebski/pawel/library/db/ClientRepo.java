/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.otrebski.pawel.library.db;

import com.otrebski.pawel.library.entities.Client;
import com.otrebski.pawel.library.exceptions.ClientExistsException;
import com.otrebski.pawel.library.exceptions.ClientNotFoundException;
import java.util.Collection;
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
    private HashMap<String,Client> clients;
    
    
    public ClientRepo(){
        clients = new HashMap<>();
        this.numberCreated = 0;
    }
    /*
        Generate an ID
    */
    public Long generateId(){
        return ++this.numberCreated;
    }
    /*
        Create a new client with a given name or throw an exception if the 
        client exists or if the nameo the given client is null
    */
   public Client create(Client client) 
           throws ClientExistsException,NullPointerException{
           
       if(this.clients.containsKey(client.getName()))
           throw new ClientExistsException(client);
       
       this.clients.put(client.getName(), client);
       
       return client;
   }
   
   
   
   /*
        Find the given client by name
   */
   public Client findByName(String name) throws NullPointerException,
           ClientNotFoundException{
       
       if(name==null) throw new NullPointerException("name cannot be null");
       
       if(!clients.containsKey(name)) throw new ClientNotFoundException(name);
       
       
       return clients.get(name);
   }
   
   public Collection<Client> find() throws NullPointerException{
       
       if(this.clients.isEmpty()) throw new NullPointerException("No clients");
       
       return this.clients.values();
       
   }
  
   
   public void update(String name, Client client) throws ClientNotFoundException{
       if(!clients.containsKey(name)) throw new ClientNotFoundException(name);
       this.clients.replace(name, client);
   }
   
   public Client delete(Long id) throws Exception{
       Client client= this.clients.remove(id);
       if(client==null){
           throw new ClientNotFoundException(id);
       }
       return client;
   }
   
   public static void main(String[]args){
    
   }
}
