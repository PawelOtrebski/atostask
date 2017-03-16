/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.otrebski.pawel.library.exceptions;

import com.otrebski.pawel.library.entities.Author;

/**
 *
 * @author pawel
 */
public class AuthorExistsException extends Exception {
    
    private String message;
    public AuthorExistsException(String message) {
        super(message);
    }
    
    public AuthorExistsException(Object id){
        super();
        String format ="Author with id: %d already exists";
        this.message = String.format(format, id);
        
    }
    
    public AuthorExistsException(Author author){
        super();
        String format = "Author with name: %s exists with id: %d";
        this.message = String.format(format,author.getName(),author.getId());
    }

    /**
     * @return the message
     */
    @Override
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }
    
}
