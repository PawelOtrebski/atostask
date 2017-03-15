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
import java.util.Objects;

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
            if(author.getName().equals(this.name)){
                if(author.getId().equals(this.id))
                    return true;
                else if(author.getId()==null && this.id==null)
                    return true;
                else 
                    return true;
            }
            else return false;
        }catch(Exception e){
            return false;
        }
        
        
    }
    
    public static void main(String[] args){
        
        Author one = new Author();
        one.setName("pawel otrebski");
        one.setId(1L);
        Author two = new Author();
        two.setName("krzys otrebski");
        two.setId(2L);
        
        HashSet<Author> authors = new HashSet<>();
        authors.add(one);
        authors.add(two);
        
        for(Author author : authors){
            System.out.println(author);
        }
        System.out.println(one.equals(one));
        
    }
    
}
