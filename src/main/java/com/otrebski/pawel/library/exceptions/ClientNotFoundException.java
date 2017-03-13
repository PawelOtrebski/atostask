/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.otrebski.pawel.library.exceptions;

/**
 *
 * @author pawel
 */
public class ClientNotFoundException extends Exception{
   
    private String message;
    public ClientNotFoundException(String message){
        super();
        String format = "Client with name: %s not found";
        this.message = String.format(format,message);
    }
    
    public ClientNotFoundException(Long id){
        super();
        String format = "Client with id: %d not found";
        this.message = String.format(format,id);
    }
    /**
     * @return the message
     */
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
