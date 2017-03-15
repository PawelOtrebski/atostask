/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.otrebski.pawel.library.entities;

import com.otrebski.pawel.library.interfaces.EntityInterface;
import com.otrebski.pawel.library.interfaces.Person;
import java.util.HashMap;

/**
 *
 * @author pawel
 */
public class Client extends Person implements EntityInterface {
    
    private HashMap<Long,Book>rented;
    
    
    public Client(){
        super();
        this.rented = new HashMap<>();
    }
    
    public Client(String name){
        super(name);
        this.rented = new HashMap<>();
    }


    @Override
    public String toString(){
        
        return String.format("name: %s", this.name);
    }
    
    public void addToRented(Book book){
        this.rented.put(book.getId(), book);
    }
    
    public void removeFromRented(Book book){
        this.rented.remove(book.getId(), book);
    }
    
    public HashMap<Long,Book> getRented(){
        return this.rented;
    }
    
    public static void main(String[] args){
        Client c = new Client("pawel otrebski");
        System.out.println(c);
    }
    
    
}
