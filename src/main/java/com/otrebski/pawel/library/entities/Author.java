/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.otrebski.pawel.library.entities;

import com.otrebski.pawel.library.interfaces.EntityInterface;
import com.otrebski.pawel.library.interfaces.Person;
import java.util.HashMap;
import java.util.HashSet;

/**
 *
 * @author pawel
 */
public class Author extends Person implements EntityInterface {
    
    HashMap<Long,Book> written;
    
    public Author(){
        super();
        this.written = new HashMap<>();
    }
    
    @Override
    public String toString(){
        String format = " id: %s\n name: %s";
        return String.format(format,this.id,this.name);
    }
    
    @Override
    public boolean equals(Object o){
        
        Author author = (Author)o;
        try{
            if(author.getName().equals(this.name)) return true;
            else return false;
        }catch(Exception e){
            return false;
        }
        
        
    }
    
    public static void main(String[] args){
        HashSet<Author> hs = new HashSet<>();
        Author one = new Author();
        one.setName("pawel otrebski");
        Author two = new Author();
        two.setName("krzys otrebski");
        
        hs.add(one);
        hs.add(two);
        
        System.out.println(hs.contains(two));
    }
    
}
