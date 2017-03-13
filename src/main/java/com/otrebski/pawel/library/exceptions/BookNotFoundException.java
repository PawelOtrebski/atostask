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
public class BookNotFoundException extends Exception {

    private String message;
    
    public BookNotFoundException(String message){
        super();
        String format = "Book with title: %s was not found";
        this.message = String.format(format, message);
        
    }
    
    public BookNotFoundException(Long id){
        super();
        String format = "Book with id: %d not found";
        this.message = String.format(format,id);
    }
    
    public BookNotFoundException(Author author){
        super();
        String format = "Not books by author: %s(id: %d) were found";
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
