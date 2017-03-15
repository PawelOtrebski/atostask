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
        if(o==null) return false;
        Author author = (Author)o;
        
        if(this.getName().equals(author.getName())){
            return true;
        }else{
            return false;
        }
        
        
    }
    
    public static void main(String[] args){
        
        
    }
    
}
