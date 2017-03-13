/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.otrebski.pawel.library.exceptions;

import com.otrebski.pawel.library.entities.Client;

/**
 *
 * @author pawel
 */
public class ClientExistsException extends Exception {
    
    private String message;
    
    public ClientExistsException(String message){
        super(message);
    }
    
    public ClientExistsException(Client client){
        super();
        String format = "Client with id: %d already exists as %s";
        this.message = String.format(format,client.getId(),client.getName());
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
